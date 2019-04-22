package org.yf.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.yf.common.entity.SystemCode;
import org.yf.common.entity.User;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;
import org.yf.user.mapper.UserMapper;
import org.yf.user.service.IUserService;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yf
 * @since 2019-04-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private UserMapper userMapper;
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public boolean addUser(User user) {
        user.setPassword(encodeString(user.getPassword()));
        user.setInsertTime(LocalDateTime.now()).setType(SystemCode.USER_CODE);
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean isExist(User user) {
        User dbUser = userMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        return dbUser != null;
    }

    @Override
    public User login(User user) {
        User dbUser = userMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if(dbUser == null){
            return null;
        }
        // 加密输入的密码
        String encodePassword = encodeString(user.getPassword());
        if(dbUser.getPassword().equals(encodePassword)){
            return dbUser;
        }
        return null;
    }

    /**
     * 加密字符串
     * @param password 明文
     * @return 密文
     */
    private String encodeString(String password) {
        if(password == null || "".equals(password)){
            return null;
        }
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
