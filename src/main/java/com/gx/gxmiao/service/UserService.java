package com.gx.gxmiao.service;

import com.gx.gxmiao.model.vo.gxUserVO;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserService
 * Package: com.gx.gxmiao.service
 * Description:
 * Author: gx
 * Creat: 2024/2/15 17:36
 * @author 11
 */

public interface UserService {
    public gxUserVO getUserVOById(Long userId);
}
