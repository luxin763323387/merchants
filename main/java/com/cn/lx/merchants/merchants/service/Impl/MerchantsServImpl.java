package com.cn.lx.merchants.merchants.service.Impl;

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
        return null;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        return null;
    }
}
