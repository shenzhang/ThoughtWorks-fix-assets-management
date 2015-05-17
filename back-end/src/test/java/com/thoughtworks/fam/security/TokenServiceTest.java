package com.thoughtworks.fam.security;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.core.Authentication;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class TokenServiceTest {

    private TokenService tokenService = new TokenService();

    @Ignore
    @Test
    public void should_generate_random_token() throws Exception {
        String token = tokenService.generateToken();
        assertThat(token, not(nullValue()));
    }

    @Ignore
    @Test
    public void should_store_and_retrieve_authentication() throws Exception {
        String token = tokenService.generateToken();
        Authentication authentication = mock(Authentication.class);
        tokenService.store(token, authentication);
        assertThat(tokenService.retrieve(token), is(authentication));
    }
}