package wow.cool.candidateregisrationproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import wow.cool.candidateregisrationproject.service.ActivePositionService;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "wow.cool.candidateregisrationproject.entity")
@ComponentScan(basePackages = "wow.cool.candidateregisrationproject")
public class CandidateregisrationprojectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CandidateregisrationprojectApplication.class, args);
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
