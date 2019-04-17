package org.yf.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author yfqlzlx
 * @date 2019/4/17 14:55
 */
@Data
@Accessors(chain = true)
public class GoodsDto {
    private Goods goods;
    private String imgUrl;
    private List<String> imgUrls;
}
