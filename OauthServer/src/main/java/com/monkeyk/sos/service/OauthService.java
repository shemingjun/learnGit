package com.monkeyk.sos.service;

import com.monkeyk.sos.domain.oauth.OauthClientDetails;
import com.monkeyk.sos.service.dto.OauthClientDetailsDto;

import java.util.List;

/**
 * @author Shengzhao Li
 */

public interface OauthService {

    OauthClientDetails loadOauthClientDetails(String clientId);

    List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos();

    void archiveOauthClientDetails(String clientId);

    OauthClientDetailsDto loadOauthClientDetailsDto(String clientId);

    void registerClientDetails(OauthClientDetailsDto formDto);
}