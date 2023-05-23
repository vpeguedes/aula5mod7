package br.com.mentorama.jpaapi;

import br.com.mentorama.jpaapi.ProductEntity;
import br.com.mentorama.jpaapi.controllers.ProductController;
import br.com.mentorama.jpaapi.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpaApiApplicationTests {

	@Autowired
	private ProductController productController;

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void shouldFindAll() {
		productRepository.deleteAll();

		productRepository.save(aProductEntity());
		productRepository.save(aProductEntity());

		List<ProductEntity> products = productController.findAll();
		Assertions.assertThat(products).hasSize(2);
	}

	private ProductEntity aProductEntity() {
		final ProductEntity product = new ProductEntity();
		product.setDescription("Description");
		product.setValue(10.0);
		return product;
	}
}
