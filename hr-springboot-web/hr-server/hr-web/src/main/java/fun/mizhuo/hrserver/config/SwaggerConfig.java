package fun.mizhuo.hrserver.config;

import org.springframework.beans.factory.annotation.Value;
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
 * @author: Mizhuo
 * @time: 2020/10/13 3:24 下午
 * @description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean swaggerEnable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnable)
                .select()
                .apis(RequestHandlerSelectors.basePackage("fun.mizhuo.hrserver.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("微人事接口文档")
                        .description("仅用于开发使用!")
                        .version("V1.0")
                        .contact(new Contact("迷浊丶","www.mizhuo.fun","wulibin0809@gmail.com"))
                        .license("The Apache License")
                        .build());
    }
}
