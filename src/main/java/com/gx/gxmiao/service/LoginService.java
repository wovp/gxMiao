package com.gx.gxmiao.service;

import com.gx.gxmiao.model.gxUser;
import org.springframework.stereotype.Service;

/**
 * ClassName: LoginService
 * Package: com.gx.gxmiao.service
 * Description:
 * Author: gx
 * Creat: 2024/2/15 16:42
 */

public interface LoginService {
    // 验证传入的账号和密码是否正确，返回对象
    public gxUser verifyLogin(String username, String password);

    public gxUser getUserById(Long id);
}
