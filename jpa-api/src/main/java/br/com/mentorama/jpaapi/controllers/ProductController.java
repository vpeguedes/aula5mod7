package br.com.mentorama.jpaapi.controllers;

import br.com.mentorama.jpaapi.ProductEntity;
import br.com.mentorama.jpaapi.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> findAll() {
        return this.productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProductEntity findById(@PathVariable("id") final Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void createNew(@RequestBody final ProductEntity product) {
        this.productRepository.save(product);
    }

    @PutMapping
    public void update(@RequestBody final ProductEntity productEntity) {
        this.productRepository.save(productEntity);
    }

    @DeleteMapping
    public void delete(@PathVariable("id") final Long id) {
        this.productRepository.deleteById(id);
    }

    @GetMapping("/description/{description}")
    public List<ProductEntity> findByDescription(@PathVariable("description") String description) {
        return this.productRepository.findByDescriptionContaining(description);
    }
}
