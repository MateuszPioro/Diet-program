package diet.calculatorscom.example.demo.repository;


import diet.calculatorscom.example.demo.module.product.model.entity.JournalEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<JournalEntryEntity,Long> {



}
