package pl.sda.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String accountNumber;

    @Column
    private BigDecimal state;

    @OneToOne(mappedBy = "account")
    private PersonEntity person;
}
