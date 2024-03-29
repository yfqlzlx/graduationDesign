package org.yf.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.yf.common.entity.User;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yf
 * @since 2019-04-09
 */
public interface IUserService extends IService<User> {

    /**
     * 添加用户
     * @param user 用户
     * @return 添加结果
     */
    boolean addUser(User user);

    /**
     * 判断用户是否存在
     * @param user 判断的用户
     * @return 判断结果
     */
    boolean isExist(User user);

    /**
     * 登录
     * @param user 用户
     * @return response
     */
    User login(User user);
}
