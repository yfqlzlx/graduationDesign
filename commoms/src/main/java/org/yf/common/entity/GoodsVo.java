package org.yf.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author yfqlzlx
 * @date 2019/4/17 09:57
 */
@Data
@Accessors(chain = true)
public class GoodsVo {
    private Goods goods;
    private List<String> imgUrls;
}
