package com.social.dev.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.social.dev.model.dto.LoginDTO;
import com.social.dev.model.dto.RegisterDTO;
import com.social.dev.model.entity.UmsUser;
import com.social.dev.model.vo.ProfileVO;


public interface UserService extends IService<UmsUser> {

    /**
     * Registration function
     *
     * @param dto
     * @return Registration object
     */
    UmsUser executeRegister(RegisterDTO dto);
    /**
     * get user info
     *
     * @param username
     * @return dbUser
     */
    UmsUser getUserByUsername(String username);
    /**
     * user login
     *
     * @param dto
     * @return JWT token
     */
    String executeLogin(LoginDTO dto);
    /**
     * get user info
     *
     * @param id user ID
     * @return
     */
    ProfileVO getUserProfile(String id);
}
