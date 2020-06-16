package com.sjiag.Beans;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String userName;
    private String userPwd;
    private String pwdSalt;

}
