package org.yf.common.response;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yfqlzlx
 * @date 2019/4/10 20:41
 *
 * 带分页参数的对象
 */
@Data
@Accessors(chain = true)
public class PageParam {
    /**
     * 当前页
     */
    private int page;
    /**
     * 分页大小
     */
    private int limit;
    /**
     * 其他参数
     */
    private Object param;
}
