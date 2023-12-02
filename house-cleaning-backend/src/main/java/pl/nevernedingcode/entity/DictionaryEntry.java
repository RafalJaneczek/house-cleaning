package pl.nevernedingcode.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "V_DICTIONARIES")
public class DictionaryEntry {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DICTIONARY_ENTRY_ID_SEQ")
    @SequenceGenerator(name = "DICTIONARY_ENTRY_ID_SEQ", sequenceName = "DICTIONARY_ENTRY_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "DICT_KEY")
    private String key;

    @Column(name = "DICT_VALUE")
    private String value;

    @Column(name = "DICT_NAME")
    private String dictionaryName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DictionaryEntry that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getKey(), that.getKey())
                && Objects.equals(getValue(), that.getValue()) && Objects.equals(getDictionaryName(), that.getDictionaryName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getKey(), getValue(), getDictionaryName());
    }
}
