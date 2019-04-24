package org.yf.common.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.yf.common.entity.Goods;

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
