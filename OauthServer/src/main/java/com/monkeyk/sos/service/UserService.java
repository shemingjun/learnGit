package com.monkeyk.sos.service;

import com.monkeyk.sos.service.dto.UserFormDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.monkeyk.sos.service.dto.UserJsonDto;
import com.monkeyk.sos.service.dto.UserOverviewDto;

/**
 * @author Shengzhao Li
 */
public interface UserService extends UserDetailsService {

    UserJsonDto loadCurrentUserJsonDto();

    UserOverviewDto loadUserOverviewDto(UserOverviewDto overviewDto);

    boolean isExistedUsername(String username);

    String saveUser(UserFormDto formDto);
}