package org.yf.common.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yf
 * @since 2019-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private int id;
    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 商品分类
     */
    private Integer goodsType;

    /**
     * 上架状态
     */
    private String status;

    /**
     * 商品库存
     */
    private Integer goodsNum;

    /**
     * 商品单价
     */
    private Double goodsPrice;

    /**
     * 商品计量单位
     */
    private String goodsTally;

    /**
     * 初次上架时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime insertTime;

    /**
     * 商品标头
     */
    private String goodsTitle;

    /**
     * 商品详情
     */
    private String goodsDesc;


}
