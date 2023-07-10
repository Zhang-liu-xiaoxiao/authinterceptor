package com.example.demo.enums;

public enum AuthLevel {
    ALL(0, "all auth"), ADMIN(1, "admin auth"), ROOT(2, "root auth");

    final int authLevel;
    final String msg;

    AuthLevel(int authLevel, String msg) {
        this.authLevel = authLevel;
        this.msg = msg;
    }

    public int getAuthLevel() {
        return authLevel;
    }

    public String getMsg() {
        return msg;
    }
}
