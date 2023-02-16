package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.service.CompanyService;

/**
 * Shabdanov Ilim
 **/
@Controller
@RequestMapping("/companies")
public class CompanyApi {
    private final CompanyService companyService;

    @Autowired
    public CompanyApi(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String getAllCompanies(Model model) {
   model.addAttribute("companies",companyService.getAllCompanies());
        return "mainPage";
    }

    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("newCompany",new Company());
        return "newCompany";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newCompany")Company company){
        companyService.save(company);
        return "redirect:/companies";
    }

    @DeleteMapping("{companyId}/delete")
    public String deleteCompany(@PathVariable("companyId")Long id){
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }

    @GetMapping("/{companyId}/edit")
    public String edit(Model model,@PathVariable("companyId") Long id){
        model.addAttribute("company",companyService.getCompanyById(id));
        return "edit";
    }

    @PutMapping("/{companyId}/update")
    public String updateCompany(@PathVariable("companyId")Long id,@ModelAttribute("company")Company company){
        companyService.updateCompany(id,company);
        return "redirect:/companies";

    }

    @GetMapping("/{companyId}")
    public String getById(Model model,@PathVariable("companyId")Long id){
        model.addAttribute("company",companyService.getCompanyById(id));
        return "byId";
    }

}
