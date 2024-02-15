package com.gx.gxmiao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * ClassName: gxPermissions
 * Package: com.gx.hmanage.model
 * Description:
 * Author: gx
 * Creat: 2024/1/27 23:59
 */
@Data
@Component
@TableName(value = "permissions")
@AllArgsConstructor
@NoArgsConstructor
public class gxPermissions {
    private Long id;
    @TableField(value = "permission_name")
    private String permission_name;
}
