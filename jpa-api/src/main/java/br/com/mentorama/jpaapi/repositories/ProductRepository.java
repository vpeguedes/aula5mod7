package br.com.mentorama.jpaapi.repositories;

import br.com.mentorama.jpaapi.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByDescriptionContaining(String description);
}
