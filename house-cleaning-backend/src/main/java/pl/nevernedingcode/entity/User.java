package pl.nevernedingcode.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Setter
@Getter
@Entity
@Table(name = "V_USERS")
@NoArgsConstructor
public class User {

    @Id
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ")
    @SequenceGenerator(name = "USER_ID_SEQ", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    private Long id;

    @NotBlank
    @Column(name = "FIRST_NAME")
    private String firstName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Cleaning> cleanings = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getFirstName(), user.getFirstName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName());
    }
}
