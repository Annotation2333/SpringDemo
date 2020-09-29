package com.example.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("2.X版本")
                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.spring.web.rest"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring演示-后台API列表")
                .description("服务相关接口")
                //.termsOfServiceUrl("http://www.xx.com/")
                .version("1.0")
                .build();
    }
}
