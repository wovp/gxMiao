package com.gx.gxmiao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * ClassName: gxUser
 * Package: com.gx.gxmiao.dao
 * Description:
 * Author: gx
 * Creat: 2024/2/15 15:52
 */
@Data
@NoArgsConstructor
@Repository
@TableName(value = "gxuser")
@AllArgsConstructor
public class gxUser {
    private Long id;
    private String account;
    private String password;
    private String nickname;
    @TableField(value = "role_id")
    private Long roleId;
    @TableField(value = "is_muted")
    private Boolean isMuted;
    @TableField(value = "money")
    private Double money; // 假设这是存放用户金钱的字段

    public gxUser(HashMap<String, Object> user) {
        this.id = (Long) user.get("id");
        this.account = (String) user.get("account");
        this.password = (String) user.get("password");
        this.nickname = (String) user.get("nickname");
        this.roleId = (Long) user.get("roleId");
        this.isMuted = (Boolean) user.get("isMuted");
        this.money = (Double) user.get("money");
    }
}
