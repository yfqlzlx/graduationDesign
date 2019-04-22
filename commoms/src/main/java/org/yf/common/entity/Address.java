package org.yf.common.entity;

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
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private int id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 详细地址
     */
    private String addressName;

    /**
     * 收货人手机
     */
    private String phone;

    /**
     * 收货人姓名
     */
    private String userName;


}
