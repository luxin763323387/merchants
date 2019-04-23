package com.cn.lx.merchants.merchants.controller;

import com.alibaba.fastjson.JSON;
import com.cn.lx.merchants.merchants.service.Impl.MerchantsServImpl;
import com.cn.lx.merchants.merchants.vo.CreateMerchantsRequest;
import com.cn.lx.merchants.merchants.vo.PassTemplate;
import com.cn.lx.merchants.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author StevenLu
 * @date 2019/4/23
 */
@Slf4j
@RestController
@RequestMapping("/merchants/")
public class MerchantsController {

    @Autowired
    private MerchantsServImpl merchantsServ;

    @PostMapping("create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest createMerchantsRequest){

        log.info("[MerchantsController]-create:{}", JSON.toJSONString(createMerchantsRequest));
        return merchantsServ.createMerchants(createMerchantsRequest);
    }

    @GetMapping("{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id ){

        log.info("[MerchantsController]-id:{}",id);
        return merchantsServ.buildMerchantsInfoById(id);
    }

    /**
     * {"background":1,"desc":"详情: 无锡好","end":1556861289441,"hasToken":false,"id":22,"limit":1000,"start":1555997289441,"summary":"简介: 无锡好","title":"无锡"}
     * */
    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate){

        log.info("[merchants]-drop:{}",JSON.toJSONString(passTemplate));
        return merchantsServ.dropPassTemplate(passTemplate);
    }

}
