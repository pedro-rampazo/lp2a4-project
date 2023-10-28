package br.edu.ifsp.spo.juntos_somos_mais.customer;

import br.edu.ifsp.spo.juntos_somos_mais.location.Location;
import br.edu.ifsp.spo.juntos_somos_mais.mobile_number.MobileNumber;
import br.edu.ifsp.spo.juntos_somos_mais.name.Name;
import br.edu.ifsp.spo.juntos_somos_mais.picture.Picture;
import br.edu.ifsp.spo.juntos_somos_mais.telephone_number.TelephoneNumber;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Customer {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(length = 100)
    private String type;

    @Column(length = 1)
    private String gender;

    @Column
    private String email;

    @Column
    private String birthday;

    @Column
    private String registered;

    @Column(length = 2)
    private String nacionality;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_id", unique = true)
    private Name name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", unique = true)
    private Location location;

    @OneToMany(mappedBy = "customer")
    private Set<TelephoneNumber> telephoneNumber;

    @OneToMany(mappedBy = "customer")
    private Set<MobileNumber> mobileNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture_id", unique = true)
    private Picture picture;

}
