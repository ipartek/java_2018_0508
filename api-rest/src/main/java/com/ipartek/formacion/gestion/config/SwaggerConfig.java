package com.ipartek.formacion.gestion.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Clase para poder documentar el swervicio REST atraves de la herramienta SWAGGER
 * @author andreaPerez
 *
 */
@Configuration
@ComponentScan
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
	
	private final static Logger LOG = Logger.getLogger(SwaggerConfig.class);

	@Bean
	public Docket api() {
		
		LOG.debug("DENTRO de SWAGGER");
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build().apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("gestion docentes", "", "1.0", "",
				new Contact("Andrea Perez", "http://edwin.baculsoft.con", "edwin@baculsoft.com"), "Apache License", "");
		return apiInfo;
	}
	
}
