package peaksoft.repository;

import peaksoft.model.Company;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
public interface CompanyRepository {
    void save(Company company);

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

    void deleteCompany(Long id);

    void updateCompany( Long id,Company updatedCompany);
}
