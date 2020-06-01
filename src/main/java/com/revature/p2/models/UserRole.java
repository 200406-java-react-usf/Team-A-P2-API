package com.revature.p2.models;

public enum UserRole {

    ADMIN(1), DEV(2), BASIC_USER(3), LOCKED(4);

    private int roleId;

    UserRole(int id) {
        this.roleId = id;
    }

    public static UserRole getById(int id) {
        for (UserRole role : UserRole.values()) {
            if (role.roleId == id) {
                return role;
            }
        }
        return LOCKED;
    }



    public int getRoleId() {
        return this.roleId;
    }

}