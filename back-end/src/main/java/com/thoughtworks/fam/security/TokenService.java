package com.thoughtworks.fam.security;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.security.core.Authentication;

import java.util.UUID;

public class TokenService {
    private static final Cache CACHE = CacheManager.getInstance().getCache("apiAuthCache");

    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    public void store(String token, Authentication authentication) {
        CACHE.put(new Element(token, authentication));
    }

    public Authentication retrieve(String token) {
        return (Authentication) CACHE.get(token).getObjectValue();
    }
}
