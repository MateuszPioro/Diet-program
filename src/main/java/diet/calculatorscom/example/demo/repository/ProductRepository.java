package diet.calculatorscom.example.demo.repository;


import diet.calculatorscom.example.demo.module.product.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {



}
