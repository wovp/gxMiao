package com.gx.gxmiao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ClassName: RedPacket
 * Package: com.gx.gxmiao.model
 * Description:
 * Author: gx
 * Creat: 2024/2/15 17:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "red_packet")
public class RedPacket {
    @TableId // 指定id为主键
    private Long id; // 红包ID

    @TableField("title") // 指定字段与数据库表中字段的映射关系
    private String title; // 红包标题

    @TableField("winners") // 指定字段与数据库表中字段的映射关系
    private int winners; // 中奖人数

    @TableField("total_participants") // 指定字段与数据库表中字段的映射关系
    private int totalParticipants; // 总参与人数

    @TableField("start_time") // 指定字段与数据库表中字段的映射关系
    private LocalDateTime startTime; // 开始时间

    @TableField("publish_time") // 指定字段与数据库表中字段的映射关系
    private LocalDateTime publishTime; // 发布时间

    @TableField("total_amount") // 指定字段与数据库表中字段的映射关系
    private BigDecimal totalAmount; // 总金额
    @TableField("publisher_id")
    private Long publisherId; // 发布者id



    public RedPacket(long snowflakeNextId, int people, long snowflakeNextId1, BigDecimal money, long publisherId) {
        this.id = snowflakeNextId;
        this.publisherId = publisherId;
        this.publishTime = LocalDateTime.now();
        this.startTime = LocalDateTime.now();
        this.totalAmount = money;
        this.totalParticipants = people;
        this.winners = people;
        this.title = "恭喜发财";
    }
}
