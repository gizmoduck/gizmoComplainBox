package example.boot.spring.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * Spring MVC provides Controllers which accepts HTTP requests and responses to those. 
 * Here, we are going to add some spring MVC features to our spring boot application. 
 * By using spring-boot-starter-web project, we can integrate some basic MVC features to our spring boot application 
 * so that we can write simple Controller class which responses client’s HTTP requests.
 */
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employees")
	@ResponseBody
	public Iterable<Employee> getAllEMployee() {
		return employeeService.findAll();
	}

}
