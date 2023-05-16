package wow.cool.candidateregistrationproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "wow.cool.candidateregistrationproject.entity")
@ComponentScan(basePackages = "wow.cool.candidateregistrationproject")
public class CandidateregistrationprojectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CandidateregistrationprojectApplication.class, args);
	}

	@Bean
	public ViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("WEB-INF/jsp/");
		bean.setSuffix(".jsp");
		bean.setViewClass(JstlView.class);
		return bean;
	}

}
