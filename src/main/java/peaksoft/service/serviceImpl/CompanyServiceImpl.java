package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import peaksoft.repository.CompanyRepository;
import peaksoft.service.CompanyService;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository ;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void save(Company company) {
     companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.getCompanyById(id);
    }

    @Override
    public void deleteCompany(Long id) {
   companyRepository.deleteCompany(id);
    }

    @Override
    public void updateCompany(Long id, Company updatedCompany) {
    companyRepository.updateCompany(id,updatedCompany);
    }
}
