package com.thoughtworks.fam;

import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * User: Zhang Shen
 * Date: 4/26/15
 * Time: 11:45 PM
 */
public abstract class IntegrationTest{
    protected RestTemplate restTemplate;

    @Before
    public void initRestTemplate() throws Exception {
        restTemplate = new TestRestTemplate();
    }

    protected String endpoint(String path) {
        if (path.charAt(0) == '/') {
            path = path.substring(1);
        }
        return "http://localhost:8080/" + path;
    }

    protected Object jsonPath(String json, String jsonPath) {
        return JsonPath.read(json, jsonPath);
    }
}
