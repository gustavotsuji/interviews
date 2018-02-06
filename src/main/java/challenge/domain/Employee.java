package challenge.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -231065376013320721L;
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String gender;
	private String email;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	private String cpf;
	private String jobTitle;
	private String seed;
	
	public Employee() {
		
	}
	
	public Employee(String name, String gender, String email, String cpf, String jobTitle, String seed) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.cpf = cpf;
		this.jobTitle = jobTitle;
		this.seed = seed;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getSeed() {
		return seed;
	}

	public void setSeed(String seed) {
		this.seed = seed;
	}
}
