package com.cn.lx.merchants.service.Impl;

import com.alibaba.fastjson.JSON;
import com.cn.lx.merchants.vo.CreateMerchantsRequest;
import com.cn.lx.merchants.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MerchantsServImplTest {

    @Autowired
    private MerchantsServImpl merchantsServ;

    @Test
    public void createMerchants() {

        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("luxin1");
        request.setLogoUrl("www.imooc.com");
        request.setBusinessLicenseUrl("www.imooc.com");
        request.setPhone("1234567890");
        request.setAddress("北京市");

       System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    /**
     * {"data":{"address":"???",
     * "phone":"1234567890",
     * "businessLicenseUrl":"www.imooc.com",
     * "isAudit":false,"name":"luxin1","
     * id":20,
     * "logoUrl":"www.imooc.com"},
     * "errorCode":0,"errorMsg":""}
     * */
    @Test
    public void buildMerchantsInfoById() {

        System.out.println(JSON.toJSON(merchantsServ.buildMerchantsInfoById(20)));
    }

    @Test
    public void dropPassTemplate() {

        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(17);
        passTemplate.setTitle("无锡");
        passTemplate.setSummary("简介: 无锡好");
        passTemplate.setDesc("详情: 无锡好");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));

        System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));
    }
}
