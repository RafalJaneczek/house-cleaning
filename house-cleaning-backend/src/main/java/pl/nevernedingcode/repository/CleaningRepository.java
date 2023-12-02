package pl.nevernedingcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.nevernedingcode.entity.Cleaning;

@Repository
public interface CleaningRepository extends JpaRepository<Cleaning, Long>, PagingAndSortingRepository<Cleaning, Long> {
}
