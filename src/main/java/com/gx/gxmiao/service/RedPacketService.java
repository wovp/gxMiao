package com.gx.gxmiao.service;

import com.gx.gxmiao.model.RedPacket;
import com.gx.gxmiao.model.vo.getRedPacketVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName: RedPacketService
 * Package: com.gx.gxmiao.service
 * Description:
 * Author: gx
 * Creat: 2024/2/15 17:36
 */

public interface RedPacketService {

    // 发布红包
    public RedPacket publishRedPacket(int people, BigDecimal money, long publisherId);
    // 发布定时红包
    public RedPacket publishRedPacketOnTime(LocalDateTime publishTime);
    // 抢红包
    public Integer getRedPacket(Long id, String redPacketName);
    // 查看该红包的记录
    public List<getRedPacketVO> recordRedList(Long redPacketId);

}
