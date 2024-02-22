package com.gx.gxmiao.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson2.JSON;
import com.gx.gxmiao.dao.redPacketMapper;
import com.gx.gxmiao.model.RedPacket;
import com.gx.gxmiao.model.vo.getRedPacketVO;
import com.gx.gxmiao.service.RedPacketService;
import com.gx.gxmiao.utils.RedPackageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName: RedPacketServiceImpl
 * Package: com.gx.gxmiao.service.impl
 * Description:
 * Author: gx
 * Creat: 2024/2/21 14:11
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RedPacketServiceImpl implements RedPacketService {
    private final redPacketMapper redPacketMapper;
    private final RedisTemplate<String, Object> redisTemplate;
    @Override
    public RedPacket publishRedPacket(int people, BigDecimal money, long publisherId) {
        BigDecimal[] redPackages = RedPackageUtil.splitRedPackageAlgorithm(money, people);
        long snowflakeNextId = IdUtil.getSnowflakeNextId();
        RedPacket packet = new RedPacket(snowflakeNextId, people, snowflakeNextId, money, publisherId);
        log.info("拆红包: {}", JSON.toJSONString(redPackages));
        int insert = redPacketMapper.insert(packet);
        if(insert == 0){
            throw new RuntimeException("红包系统异常");
        }
        redisTemplate.opsForList().leftPushAll(snowflakeNextId + packet.getStartTime().toString(), redPackages);
        BigDecimal[] o = (BigDecimal[]) redisTemplate.opsForList().rightPop(snowflakeNextId + packet.getStartTime().toString());
        for (BigDecimal o1 : o){
            log.info("数字 " + o1.toString());
        }
        return packet;
    }

    @Override
    public RedPacket publishRedPacketOnTime(LocalDateTime publishTime) {
        return null;
    }

    @Override
    public Integer getRedPacket(Long id, String redPacketName) {
        return null;
    }

    @Override
    public List<getRedPacketVO> recordRedList(Long redPacketId) {
        return null;
    }
}
