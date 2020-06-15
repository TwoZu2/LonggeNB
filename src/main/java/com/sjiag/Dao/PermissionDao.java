package com.sjiag.Dao;

import java.util.Set;

public interface PermissionDao {
    public Set<String> queryPermissionByUsername(String username);
}
