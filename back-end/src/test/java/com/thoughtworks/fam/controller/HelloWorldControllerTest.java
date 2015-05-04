package com.thoughtworks.fam.controller;

import com.thoughtworks.fam.Application;
import com.thoughtworks.fam.IntegrationTest;
import com.thoughtworks.fam.dao.HelloWorldDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * User: Zhang Shen
 * Date: 4/26/15
 * Time: 8:13 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
@ActiveProfiles("stub")
public class HelloWorldControllerTest extends IntegrationTest {
    @Autowired
    private HelloWorldDao helloWorldDao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testHelloworld() throws Exception {
        when(helloWorldDao.getMessage()).thenReturn("hello world");

        String response = restTemplate.getForObject(endpoint("/helloworld"), String.class);
        assertThat((String) jsonPath(response, "$.message"), is("hello world"));

        verify(helloWorldDao, only()).getMessage();
    }
}