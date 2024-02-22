package com.gx.gxmiao.controller;

/**
 * ClassName: LoginController
 * Package: com.gx.gxmiao.controller
 * Description:
 * Author: gx
 * Creat: 2024/2/15 2:19
 */

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.gx.gxmiao.model.gxUser;
import com.gx.gxmiao.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录测试
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/acc/")
public class LoginController {
    private final LoginService loginService;
    // 测试登录  ---- http://localhost:8081/acc/doLogin?name=gx&pwd=123456
    @RequestMapping("doLogin")
    public SaResult doLogin(String name, String pwd) {
        gxUser gxUser = loginService.verifyLogin(name, pwd);
        if (gxUser == null) {
            return SaResult.error("登录失败");
        }
        StpUtil.login(gxUser.getId());
        return SaResult.ok("登录成功");
    }

    // 查询登录状态  ---- http://localhost:8081/acc/isLogin
    @RequestMapping("isLogin")
    public SaResult isLogin() {
    return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    // 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
    return SaResult.data(StpUtil.getTokenInfo());
    }

    // 测试注销  ---- http://localhost:8081/acc/logout
    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

}

