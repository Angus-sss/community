package com.insedesign.communitybuildingapi.common.resp;

/**
 * @Author: NALHOUG
 * @Time: 2019/11/7 19:39
 * @Explain:
 */
public class UserCookie {
    private String sessionId;
    private String username;

    public UserCookie(String sessionId, String username) {
        this.sessionId = sessionId;
        this.username = username;
    }
}
