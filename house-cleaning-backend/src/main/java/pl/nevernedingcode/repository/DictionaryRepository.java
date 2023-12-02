package pl.nevernedingcode.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nevernedingcode.entity.DictionaryEntry;

import java.util.List;

@Repository
public interface DictionaryRepository extends JpaRepository<DictionaryEntry, Long> {
    @NonNull List<DictionaryEntry> findAll();
}
