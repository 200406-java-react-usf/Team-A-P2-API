package com.revature.p2.models;

public enum UserRole {

    ADMIN(1), USER(2), LOCKED(3);

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