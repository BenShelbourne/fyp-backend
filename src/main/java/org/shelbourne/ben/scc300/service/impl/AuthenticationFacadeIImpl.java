package org.shelbourne.ben.scc300.service.impl;

import org.shelbourne.ben.scc300.service.AuthenticationFacade;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacadeIImpl implements AuthenticationFacade {


    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public String getUsername() {
        //return getAuthentication().getName();
        return "shelboub";
    }

}
