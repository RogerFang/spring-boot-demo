package com.roger.dao;

import com.roger.model.security.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Roger on 2016/12/5.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);
}
