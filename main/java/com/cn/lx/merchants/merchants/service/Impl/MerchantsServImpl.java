package com.cn.lx.merchants.merchants.service.Impl;

import com.alibaba.fastjson.JSON;
import com.cn.lx.merchants.merchants.constant.Constants;
import com.cn.lx.merchants.merchants.constant.ErrorCode;
import com.cn.lx.merchants.merchants.dao.MerchantsDao;
import com.cn.lx.merchants.merchants.entity.Merchants;
import com.cn.lx.merchants.merchants.service.IMerchantsServ;
import com.cn.lx.merchants.merchants.vo.CreateMerchantsRequest;
import com.cn.lx.merchants.merchants.vo.CreateMerchantsResponse;
import com.cn.lx.merchants.merchants.vo.PassTemplate;
import com.cn.lx.merchants.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author StevenLu
 * @date 2019/4/13
 */
@Service
@Slf4j
public class MerchantsServImpl implements IMerchantsServ {

    @Autowired
    private MerchantsDao merchantsDao;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Response createMerchants(CreateMerchantsRequest request) {

        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();

        ErrorCode errorCode = request.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS) {
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            Merchants merchants = merchantsDao.save(request.toMerchants());
            merchantsResponse.setId(merchants.getId());
        }

        response.setData(merchantsResponse);

        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {

        Response response = new Response();

        Merchants merchants = merchantsDao.findById(id);
        if(merchants == null){
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }

        response.setData(merchants);

        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {

        Response response = new Response();
        ErrorCode errorCode = template.validate(merchantsDao);

        if(errorCode != ErrorCode.SUCCESS){
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        }else {
            String passTemplate = JSON.toJSONString(template);
            //第一个是topic 第二个是key 第三个是value
            kafkaTemplate.send(
                    Constants.TEMPLATE_TOPIC,
                    Constants.TEMPLATE_TOPIC,
                    passTemplate
            );
            log.info("dropPassTemplate:{}",kafkaTemplate);
        }

        return response ;
    }
}
