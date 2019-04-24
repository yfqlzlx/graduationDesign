package org.yf.common.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author yfqlzlx
 * @date 2019/4/15 17:01
 *
 * 登录vo
 */
@Data
@Accessors(chain = true)
public class LoginVo {

    private String username;
    private String password;
    private String vaildCode;
}
