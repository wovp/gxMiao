package com.gx.gxmiao.utils;

import com.gx.gxmiao.dao.gxUserMapper;
import com.gx.gxmiao.dao.redPacketMapper;
import com.gx.gxmiao.model.RedPacket;
import com.gx.gxmiao.model.getRedPacket;
import com.gx.gxmiao.model.gxUser;
import com.gx.gxmiao.model.vo.getRedPacketVO;
import com.gx.gxmiao.model.vo.gxUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * ClassName: modelToVo
 * Package: com.gx.gxmiao.utils
 * Description:
 * Author: gx
 * Creat: 2024/2/15 23:39
 * @author 11
 */
@Component
public class modelToVo {
    private redPacketMapper redMapper;
    private gxUserMapper gxUserMapper;
    public getRedPacketVO getRedPackageVO(getRedPacket g){
        getRedPacketVO ns = new getRedPacketVO();
        Long redPacketId = g.getRedPacketId();
        RedPacket redPacket = redMapper.selectById(redPacketId);
        gxUser gxUser = gxUserMapper.selectById(g.getUserId());
        String userNickName = gxUser.getNickname();

        ns.setRedPacketId(redPacket.getId());
        ns.setGetMoney(g.getGetMoney());
        ns.setRedPacketTitle(redPacket.getTitle());
        ns.setPublisherId(redPacket.getPublisherId());
        ns.setSumMoney(redPacket.getTotalAmount());
        ns.setUserId(g.getUserId());
        ns.setUserNickName(userNickName);
        return ns;
    }
    public gxUserVO getgxUserVO(gxUser gxUser) {
        gxUserVO gxUserVO = new gxUserVO();
        gxUserVO.setAccount(gxUser.getAccount());
        gxUserVO.setId(gxUser.getId());
        gxUserVO.setMoney(gxUser.getMoney());
        gxUserVO.setNickname(gxUser.getNickname());
        gxUserVO.setIsMuted(gxUser.getIsMuted());
        gxUserVO.setRoleId(gxUser.getRoleId());
        return gxUserVO;
    }
}
