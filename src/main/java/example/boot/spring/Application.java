package example.boot.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*Instead of using all three annotation, 
 * we can use only @SpringBootApplication annotation which is equivalent to using 
 * @Configuration, @EnableAutoConfiguration, and @ComponentScan 
 * with their default attributes, as shown in the following example.
*/

//@EnableAutoConfiguration
//@ComponentScan
//@Configuration
@SpringBootApplication
@EnableJpaAuditing //to enable auditing for audit tables.
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
	}

}
