package com.ucm.ucmempire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
//Pour générer la documentation, il faut placer l'annotation  @EnableSwagger2  dans la classe contenant avec la méthode Main
@EnableSwagger2
public class UcmempireApplication {

    public static void main(String[] args) {

        SpringApplication.run(UcmempireApplication.class, args);
        
    }
}
