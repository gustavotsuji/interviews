package challenge.util;

import challenge.domain.Company;

public class CompanyFactory {
	public static Company build() throws Exception {
		Company newCompany = new Company("Amazon", "80960903000153", "37438499", "www.amazon.com", "ecommerce");

		return newCompany;
	}
}
