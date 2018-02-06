package challenge.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import challenge.domain.Company;

@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface ICompanyRepository extends PagingAndSortingRepository<Company, Long> {

	List<Company> findByName(@Param("name") String name);

	List<Company> findByIndustry(@Param("industry") String industry);
}