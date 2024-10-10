package com.andres.springboot.di.app.springboot_di;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//import com.andres.springboot.di.app.springboot_di.repositories.ProductRepository;
//import com.andres.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
//@PropertySource("classpath:values.properties")
@PropertySources({
	@PropertySource(value="classpath:config.properties", encoding = "UTF-8")
})

public class AppConfig {

	/*
	@Bean
	//@Primary
	public  ProductRepository productRepositoryJson() {
		return new ProductRepositoryJson();
	}
		 */

}
