package org.yf.common.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yf
 * @since 2019-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;


    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 商品单价
     */
    private Double goodsPrice;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 收货地址id
     */
    private Integer addressId;

    /**
     * 收货地址
     */
    private String addressName;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 订单创建时间
     */
    private LocalDateTime insertTime;

    /**
     * 用户留言
     */
    private String leaveMsg;


}
