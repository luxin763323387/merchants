package com.cn.lx.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author StevenLu
 * @date 2019/4/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {

    /** 商户 id: 创建失败则为 -1 */
    private Integer id;
}
