package com.xiaogch.maven.system.service.impl;

import com.xiaogch.maven.system.service.AuthService;
import org.springframework.stereotype.Service;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/11 15:17 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
@Service("authService")
public class AuthServiceImpl implements AuthService {

    @Override
    public boolean canVisit(String userName, String path) {
        return true;
    }
}
