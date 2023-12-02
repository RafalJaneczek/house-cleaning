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
@Table(name = "V_CLEANINGS")
public class Cleaning {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLEANING_ID_SEQ")
    @SequenceGenerator(name = "CLEANING_ID_SEQ", sequenceName = "CLEANING_ID_SEQ", allocationSize = 1)
    private Long id;

    @CreationTimestamp
    @Column(name = "CLEANING_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime cleaningDate;

    @NotBlank
    @Column(name = "ROOM_NAME")
    private String roomName;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cleaning cleaning)) return false;
        return Objects.equals(getId(), cleaning.getId()) && Objects.equals(getCleaningDate(), cleaning.getCleaningDate())
                && Objects.equals(roomName, cleaning.roomName) && Objects.equals(getUser(), cleaning.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCleaningDate(), roomName, getUser());
    }

}
