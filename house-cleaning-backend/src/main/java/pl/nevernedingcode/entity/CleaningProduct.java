package pl.nevernedingcode.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "V_CLEANING_PRODUCTS")
public class CleaningProduct {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLEANING_PRODUCT_ID_SEQ")
    @SequenceGenerator(name = "CLEANING_PRODUCT_ID_SEQ", sequenceName = "CLEANING_PRODUCT_ID_SEQ", allocationSize = 1)
    private Long id;

    @CreationTimestamp
    @Column(name = "DATE_OF_PURCHASE", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateOfPurchase;

    @NotBlank
    @Column(name = "PRODUCT_NAME")
    private String productName;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CleaningProduct that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDateOfPurchase(), that.getDateOfPurchase())
                && Objects.equals(getProductName(), that.getProductName()) && Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateOfPurchase(), getProductName(), getUser());
    }
}
