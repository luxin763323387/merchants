package com.cn.lx.merchants.merchants.service.Impl;

import com.alibaba.fastjson.JSON;
import com.cn.lx.merchants.merchants.vo.CreateMerchantsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void buildMerchantsInfoById() {
    }

    @Test
    public void dropPassTemplate() {
    }
}
