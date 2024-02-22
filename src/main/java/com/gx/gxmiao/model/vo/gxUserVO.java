package com.gx.gxmiao.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * ClassName: gxUserVO
 * Package: com.gx.gxmiao.model.vo
 * Description:
 * Author: gx
 * Creat: 2024/2/21 1:21
 */
@Data
@NoArgsConstructor
@Repository
@AllArgsConstructor
public class gxUserVO {
    private Long id;
    private String account;
    private String nickname;
    private Long roleId;
    private Boolean isMuted;
    private Double money; // 假设这是存放用户金钱的字段
}
