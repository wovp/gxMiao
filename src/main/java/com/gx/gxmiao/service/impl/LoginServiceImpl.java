package com.gx.gxmiao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gx.gxmiao.dao.gxUserMapper;
import com.gx.gxmiao.model.gxUser;
import com.gx.gxmiao.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * ClassName: LoginServiceImpl
 * Package: com.gx.gxmiao.service.impl
 * Description:
 * Author: gx
 * Creat: 2024/2/15 16:54
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final gxUserMapper userMapper;
    @Override
    public gxUser verifyLogin(String username, String password) {
        QueryWrapper<gxUser> qw = new QueryWrapper<>();
        qw.eq("account", username);
        gxUser gxUser = userMapper.selectOne(qw);
        if(gxUser == null) {
            return null;
        }
        if (Objects.equals(gxUser.getPassword(), password)){
            return gxUser;
        }
        return null;
    }

    @Override
    public gxUser getUserById(Long id) {
        return userMapper.selectById(id);
    }
}
