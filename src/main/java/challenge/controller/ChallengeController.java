package challenge.controller;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import challenge.domain.Company;
import challenge.domain.Employee;
import challenge.repository.ICompanyRepository;
import challenge.repository.IEmployeeRepository;
import challenge.util.EmployeeFactory;

@RestController
public class ChallengeController {

	@Autowired
	private ICompanyRepository companyRepository;
	
	@Autowired
	private IEmployeeRepository employeeRepository;

	
	@RequestMapping(value="/employee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@RequestBody Map<String, Object> payload) {
		try {
			Employee data = EmployeeFactory.build();
			
			data.setCpf(payload.get("cpf").toString());
			data.setJobTitle(payload.get("jobTitle").toString());
			
			Company company = companyRepository.findOne(Long.parseLong(payload.get("company").toString()));
			data.setCompany(company);
			
			Employee newEmployee = employeeRepository.save(data);
			return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/*
	@RequestMapping(value="/companies/industries", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pdv> getIndustries() {
		try {
			Pdv pdv = repository.findById(id);
			return new ResponseEntity<Pdv>(pdv, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Pdv>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Pdv>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
}
