package example.boot.spring.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * EmployeeRepository is injected to EmployeeServiceImpl class using @Autowired annotation.
 *  We did enable this by adding @ComponentScan annotation via @SpringBootApplication to our Application.java class 
 */


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
