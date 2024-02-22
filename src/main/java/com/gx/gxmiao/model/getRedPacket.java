package com.gx.gxmiao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * ClassName: getRedPacket
 * Package: com.gx.gxmiao.model
 * Description:
 * Author: gx
 * Creat: 2024/2/15 23:28
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Repository
public class getRedPacket {
    private Long userId;
    private Long redPacketId;
    private Double getMoney;
}
