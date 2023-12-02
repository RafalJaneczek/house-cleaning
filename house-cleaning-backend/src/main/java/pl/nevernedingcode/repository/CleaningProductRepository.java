package pl.nevernedingcode.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.nevernedingcode.entity.CleaningProduct;

@Repository
public interface CleaningProductRepository extends JpaRepository<CleaningProduct, Long>, PagingAndSortingRepository<CleaningProduct, Long> {
    Page<CleaningProduct> findByProductName(final String productName, final Pageable pageable);
}
