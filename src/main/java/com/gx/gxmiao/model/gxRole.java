package com.gx.gxmiao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * ClassName: gxRole
 * Package: com.gx.hmanage.model
 * Description:
 * Author: gx
 * Creat: 2024/1/11 10:25
 */
@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "roles")
public class gxRole {
    @TableField(value = "id")
    private Long id;
    @TableField(value = "role_name")
    private String roleName;
    @TableField(value = "permission_id")
    private Long permissionId;
}
