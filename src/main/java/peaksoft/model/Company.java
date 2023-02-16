package peaksoft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Shabdanov Ilim
 **/
@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @SequenceGenerator(name = "company_gen",sequenceName = "company_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "company_gen")
    private Long id;
    private String name;
    private String country;
    @Column(length = 1000)
    private String image;
    private String description;
    private int price;

    public Company(String name, String country, String image,String description ,int price) {
        this.name = name;
        this.country = country;
        this.image = image;
        this.description = description;
        this.price = price;
    }
}
