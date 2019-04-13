package org.yf.manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.DigestUtils;
import org.yf.common.entity.User;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;
import org.yf.manage.mapper.UserMapper;
import org.yf.manage.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
        user.setInsertTime(LocalDateTime.now());
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean isExist(User user) {
        User dbUser = userMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        return dbUser != null;
    }

    @Override
    public Response getAllUser(int pageNo,int pageSize) {
        IPage page = new Page(pageNo,pageSize);
        IPage dbData = userMapper.selectPage(page, new QueryWrapper<User>().orderByDesc("insert_time"));
        return new Response(200,dbData.getRecords()).setTotalSize(dbData.getTotal());
    }

    @Override
    public Response queryUser(PageParam param) {
        User user = JSON.parseObject(param.getParam().toString()).toJavaObject(User.class);
        IPage<User> page = new Page<>(param.getPage(),param.getLimit());
        IPage<User> queryUser = userMapper.queryUser(page, user);
        return new Response(200,queryUser.getRecords()).setTotalSize(queryUser.getTotal());
    }

    @Override
    public boolean delUserById(int id) {
        return userMapper.deleteById(id) > 0;
    }


    /**
     * 加密字符串
     * @param password 明文
     * @return 密文
     */
    private String encodeString(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
