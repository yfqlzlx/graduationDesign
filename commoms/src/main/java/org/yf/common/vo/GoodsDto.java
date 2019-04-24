package org.yf.common.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.yf.common.entity.Goods;

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
