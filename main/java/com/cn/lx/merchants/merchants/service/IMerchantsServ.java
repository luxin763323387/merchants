package com.cn.lx.merchants.merchants.service;

import com.cn.lx.merchants.merchants.vo.CreateMerchantsRequest;
import com.cn.lx.merchants.merchants.vo.PassTemplate;
import com.cn.lx.merchants.merchants.vo.Response;

/**
 * @author StevenLu
 * @date 2019/4/13
 */
public interface IMerchantsServ {

    /**
     * <h2>创建商户服务</h2>
     * @param request {@link CreateMerchantsRequest} 创建商户请求
     * @return {@link Response}
     * */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * <h2>根据 id 构造商户信息</h2>
     * @param id 商户 id
     * @return {@link Response}
     * */
    Response buildMerchantsInfoById(Integer id);

    /**
     * <h2>投放优惠券</h2>
     * @param template {@link PassTemplate} 优惠券对象
     * @return {@link Response}
     * */
    Response dropPassTemplate(PassTemplate template);
}
