package org.yf.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.yf.common.entity.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yf
 * @since 2019-04-09
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过条件查询用户
     * @param user 条件
     * @return 满足条件的结果
     */
    IPage<User> queryUser(IPage page,@Param("user") User user);
}
