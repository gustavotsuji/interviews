package challenge.validator;

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
	
	
	/*@RequestMapping(value="/companies", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Company> createCompanies(@RequestBody Company company) {
		try {
			Company newCompany = repository.save(company);
			return new ResponseEntity<Company>(newCompany, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Company>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	/*@RequestMapping(value="/companies", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Company> getCompanies() {
		try {
			Pdv pdv = repository.findAll();
			return new ResponseEntity<Company>(pdv, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Company>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	/* @RequestMapping(value="/companies", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pdv> getCompanyByName(@PathVariable(value = "name") String name) {
		try {
			Pdv pdv = repository.findByName(name);
			return new ResponseEntity<Pdv>(pdv, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Pdv>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Pdv>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/companies", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pdv> getCompanyByIndustry(@PathVariable(value = "industry") String industry) {
		try {
			Pdv pdv = repository.findByIndustry(industry);
			return new ResponseEntity<Pdv>(pdv, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Pdv>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Pdv>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/companies", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pdv> getCompanyById(@PathVariable(value = "id") String id) {
		try {
			Pdv pdv = repository.findById(id);
			return new ResponseEntity<Pdv>(pdv, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Pdv>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Pdv>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/companies/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pdv> getEmployeesByCompany(@PathVariable(value = "id") String id) {
		try {
			Pdv pdv = repository.findById(id);
			return new ResponseEntity<Pdv>(pdv, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Pdv>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Pdv>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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
	}
	
	@RequestMapping(value="/employees", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pdv> createEmployee(@RequestBody Map<String, Object> payload) {
		try {
			Pdv pdv = repository.insert(builder.build(payload));
			return new ResponseEntity<Pdv>(pdv, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Pdv>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Pdv>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pdv> getEmployees() {
		try {
			Pdv pdv = repository.findAll();
			return new ResponseEntity<Pdv>(pdv, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Pdv>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Pdv>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pdv> getEmployeeByJobTitle(@PathVariable(value = "jobTitle") String name) {
		try {
			Pdv pdv = repository.findByJobTitle(name);
			return new ResponseEntity<Pdv>(pdv, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Pdv>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Pdv>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pdv> getEmployeeById(@PathVariable(value = "id") String id) {
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
