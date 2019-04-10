package org.yf.common.response;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yfqlzlx
 * @date 2019/4/9 20:37
 *
 * 通用的返回类型
 */
@Data
@Accessors(chain = true)
public class Response {
    /**
     * 状态码
     */
    private int code;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private Object data;
    /**
     * 数据总数
     */
    private long totalSize;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(int code) {
        this.code = code;
    }

    public Response(int code, Object data) {
        this.code = code;
        this.data = data;
    }
}
