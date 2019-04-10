package org.yf.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.yf.common.entity.User;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;

import java.util.List;

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
     * 获取所有的用户
     * @return 用户list
     */
    Response getAllUser(int pageNo, int pageSize);

    /**
     * 条件查询用户
     * @param param 查询条件和分页信息
     * @return 满足条件的用户
     */
    List<User> queryUser(PageParam param);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    boolean delUserById(int id);
}
