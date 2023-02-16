package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.repository.CompanyRepository;

import java.util.List;

/**
 * Shabdanov Ilim
 **/
@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Company company) {
        entityManager.persist(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return entityManager.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public Company getCompanyById(Long id) {
        return entityManager.find(Company.class,id);
    }

    @Override
    public void deleteCompany(Long id) {
    entityManager.remove(entityManager.find(Company.class,id));
    }

    @Override
    public void updateCompany(Long id, Company updatedCompany) {
        Company oldCompany = entityManager.find(Company.class, id);
        oldCompany.setName(updatedCompany.getName());
        oldCompany.setCountry(updatedCompany.getCountry());
        oldCompany.setImage(updatedCompany.getImage());
        oldCompany.setDescription(updatedCompany.getDescription());
        oldCompany.setPrice(updatedCompany.getPrice());

    }
}
