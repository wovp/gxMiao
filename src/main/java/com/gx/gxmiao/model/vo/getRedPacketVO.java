package com.gx.gxmiao.model.vo;

import com.gx.gxmiao.model.RedPacket;
import com.gx.gxmiao.model.getRedPacket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * ClassName: getRedPacketVO
 * Package: com.gx.gxmiao.model.vo
 * Description:
 * Author: gx
 * Creat: 2024/2/15 23:36
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Repository
public class getRedPacketVO {
    private Long userId;
    private String userNickName;
    private Long redPacketId;
    private String redPacketTitle;
    private Long publisherId;
    private Double getMoney;
    private BigDecimal sumMoney;

}
