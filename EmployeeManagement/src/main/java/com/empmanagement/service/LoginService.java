/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.empmanagement.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    /*
     * @Autowired LoginDAO loginDao;
     */

    public boolean validateLogin(final String username, final String password) {

        String unameFromDb = "admin";
        String pwdFromDb = "admin123";

        if (username.equalsIgnoreCase(unameFromDb) && password.equalsIgnoreCase(pwdFromDb)) {
            return true;
        } else {
            return false;
        }
    }

}
