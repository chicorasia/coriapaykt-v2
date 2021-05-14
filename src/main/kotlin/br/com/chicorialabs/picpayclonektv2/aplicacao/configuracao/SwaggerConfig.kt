package br.com.chicorialabs.picpayclonektv2.aplicacao.configuracao

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@ComponentScan
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun createRestApi() : Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors
                .basePackage("br.com.chicorialabs.picpayclonektv2.aplicacao.resource"))
            .paths(PathSelectors.any())
            .build()

    }

}