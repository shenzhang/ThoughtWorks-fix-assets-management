package com.thoughtworks.fam.configuration;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * User: Zhang Shen
 * Date: 4/25/15
 * Time: 12:36 PM
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE + 10)
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class CustomerWebMvcConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerWebMvcConfig.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String externalResource = System.getProperty("externalResource");
        if (!Strings.isNullOrEmpty(externalResource)) {
            if (!externalResource.endsWith("/")) {
                externalResource += "/";
            }

            LOG.info("Install external resource: {}", externalResource);
            registry.addResourceHandler("/**").addResourceLocations(String.format("file://%s", externalResource));
        }

        super.addResourceHandlers(registry);
    }
}
