package challenge.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import challenge.domain.Employee;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	List<Employee> findByJobTitle(@Param("jobTitle") String jobTitle);
}