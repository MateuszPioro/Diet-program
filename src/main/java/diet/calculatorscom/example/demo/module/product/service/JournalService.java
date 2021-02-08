package diet.calculatorscom.example.demo.module.product.service;


import diet.calculatorscom.example.demo.module.mapper.JournalMapper;
import diet.calculatorscom.example.demo.module.product.model.dto.JournalDto;
import diet.calculatorscom.example.demo.module.product.model.dto.JournalForm;
import diet.calculatorscom.example.demo.module.product.model.entity.JournalEntryEntity;
import diet.calculatorscom.example.demo.module.product.model.entity.ProductEntity;
import diet.calculatorscom.example.demo.repository.JournalRepository;
import diet.calculatorscom.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JournalService {


    private final ProductService productService;
    private final JournalRepository journalRepository;
    private final ProductRepository productRepository;


    public List<JournalDto> getJournal() {
        List<JournalEntryEntity> allJournalView = journalRepository.findAll();
        List<JournalDto> journalDtoList = new ArrayList<>();
        for (JournalEntryEntity journal : allJournalView) {
            JournalDto journalDto = JournalMapper.mapToDto(journal);

            journalDtoList.add(journalDto);
        }
        return journalDtoList;
    }



    public void delete(Long productId) {
        journalRepository.deleteById(productId);
    }


    public void addProductToJournal(JournalForm journalForm) {
        JournalEntryEntity journalEntryEntity = new JournalEntryEntity();
        journalEntryEntity.setWeight(journalForm.getWeight());
        Optional<ProductEntity> productById = productRepository.findById(journalForm.getProductId());
        journalEntryEntity.setProduct(productById.get());
        journalRepository.save(journalEntryEntity);
    }

    public void updateJournal(Long productId, JournalDto journalDto) {
        JournalEntryEntity journalEntryEntity = JournalMapper.mapToEntity(journalDto);
        journalEntryEntity.setId(productId);

    }



}
