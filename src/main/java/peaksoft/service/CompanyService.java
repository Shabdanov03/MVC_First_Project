package peaksoft.service;

import peaksoft.model.Company;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
public interface CompanyService {
    void save(Company company);

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

    void deleteCompany(Long id);

    void updateCompany( Long id,Company updatedCompany);
}
