package com.ucm.ucmempire.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//L'annotation  @Configuration  appliquée à la classe permet de remplacer un fichier de configuration classique en XML.
// Elle nous donne accès à plusieurs méthodes très intéressantes pour la personnalisation de Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    //la classe Docket gère toutes les configurations.
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                //select permet d'initialiser une classe du nom de ApiSelectorBuilder qui donne accès aux méthodes de personnalisation suivantes
                .select()
                //apis est la première méthode importante. Elle permet de filtrer la documentation à exposer selon les contrôleurs.
                //RequestHandlerSelectors est un prédicat (introduit depuis java 8) qui permet de retourner TRUE ou FALSE selon la conditions utilisée.
                //Nous utilisons la méthode basePackage du prédicat RequestHandlerSelectors afin de demander à Swagger de ne rien documenter en dehors du package
                .apis(RequestHandlerSelectors.basePackage("com.ucm.ucmempire"))
                //paths : cette méthode donne accès à une autre façon de filtrer : selon l'URI des requêtes.
                .paths(PathSelectors.any())
                .build();
    }
}