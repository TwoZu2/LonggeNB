package com.sjiag.Dao;

import java.util.Set;

public interface RoleDao {
    public Set<String> queryRoleNamesByUsername(String username);
}
