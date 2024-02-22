package com.gx.gxmiao.service.impl;

import com.gx.gxmiao.dao.gxUserMapper;
import com.gx.gxmiao.model.gxUser;
import com.gx.gxmiao.model.vo.gxUserVO;
import com.gx.gxmiao.service.UserService;
import com.gx.gxmiao.utils.modelToVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Package: com.gx.gxmiao.service.impl
 * Description:
 * Author: gx
 * Creat: 2024/2/21 1:25
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final gxUserMapper userMapper;
    private final modelToVo modelToVo;
    @Override
    public gxUserVO getUserVOById(Long userId) {
        gxUser gxUser = userMapper.selectById(userId);
        if (gxUser == null) {
            throw new RuntimeException("出现异常错误");
        }
        return modelToVo.getgxUserVO(gxUser);
    }
}
