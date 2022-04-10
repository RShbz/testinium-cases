/**
 * 
 */
package com.testinium.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Remzi ŞAHBAZ
 *
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration {

	   @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).select()
	                .apis(RequestHandlerSelectors.basePackage("com.testinium"))
	                .paths(PathSelectors.regex("/.*"))
	                .build().apiInfo(apiEndPointsInfo());

	    }
	    private ApiInfo apiEndPointsInfo() {
	        return new ApiInfoBuilder().title("Spring Boot Swagger Examples")
	                .description("Student-Course Api Dokümantasyonu")
	                .contact(null)
	                .license("Apache 2.0")
	                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	                .version("1.12.3")
	                .build();
	    }


}
