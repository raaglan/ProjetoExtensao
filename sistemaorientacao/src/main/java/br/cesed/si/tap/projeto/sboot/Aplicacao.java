package br.cesed.si.tap.projeto.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


@SpringBootApplication
public class Aplicacao extends SpringBootServletInitializer{

	public static void main(final String [] args){
		 SpringApplication.run(Aplicacao.class, args);
	}
	
	@Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder aplicacao) {
        return aplicacao.sources(Aplicacao.class);
    }
}