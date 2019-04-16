package org.yf.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

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
 * @since 2019-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品类型id
     */
    @TableId(value = "type_id", type = IdType.AUTO)
    private Integer typeId;

    /**
     * 商品类型名称
     */
    private String typeName;

    /**
     * 商品类型的排序，越小越在前
     */
    private Integer sort;

    /**
     * 是否在用
     */
    private String validity;

    /**
     * 商品分类的父级，0代表顶级
     */
    private Integer parentId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 新增时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime insertTime;


}
