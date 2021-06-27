package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ACCOUNT")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
