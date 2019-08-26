package com.zhongzhou.swaggerapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger配置类
 * @author: yumeng
 */
@Configuration //标记配置类
@EnableSwagger2 //开启在线接口文档
public class SwaggerConfig {
    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("标题：江苏中州科技_接口文档")
                        .description("描述：111")
                        .contact(new Contact("一只袜子", null, null))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhongzhou.controller.*"))
                .paths(PathSelectors.any())
                .build();
    }

}
