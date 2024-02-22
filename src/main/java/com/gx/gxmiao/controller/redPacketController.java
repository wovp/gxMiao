package com.gx.gxmiao.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.gx.gxmiao.dao.gxUserMapper;
import com.gx.gxmiao.model.gxUser;
import com.gx.gxmiao.service.RedPacketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * ClassName: redPacketController
 * Package: com.gx.gxmiao.controller
 * Description:
 * Author: gx
 * Creat: 2024/2/21 14:59
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/red/")
@Slf4j
public class redPacketController {
    private final RedPacketService redPacketService;
    private final gxUserMapper gxUserMapper;
    @SaCheckLogin
    @RequestMapping("create")
    // http://localhost:8081/red/create?people=10&money=100
    public SaResult createRedPacket(@RequestParam Integer people, @RequestParam BigDecimal money) {
        Long loginId = Long.valueOf(StpUtil.getLoginId().toString());
        gxUser publisher = gxUserMapper.selectById(loginId);
        log.info("接收参数 people: " + people + " money: " + money + " 创建者：" + loginId.toString());
        redPacketService.publishRedPacket(people, money, loginId);
        return SaResult.ok("创建红包成功");
    }
}
