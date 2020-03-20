package org.shelbourne.ben.scc300.service;


import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
    Authentication getAuthentication();

    String getUsername();
}
