package challenge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import challenge.repository.ICompanyRepository;
import challenge.repository.IEmployeeRepository;
import challenge.util.CompanyFactory;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(IEmployeeRepository employeeRepository, ICompanyRepository companyRepository) {
		return (args) -> {
			//employeeRepository.save(EmployeeFactory.build());
			companyRepository.save(CompanyFactory.build());
		};
	}
}
