package org.yf.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author yfqlzlx
 * @date 2019/4/24 10:02
 */
@Data
@Accessors(chain = true)
public class OrderDto {
    private int orderId;
    private String goodsName;
    private int goodsNum;
    private double goodsPrice;
    private double totalPrice;
    private String addressName;
    private String username;
    private String leaveMsg;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime insertTime;
}
