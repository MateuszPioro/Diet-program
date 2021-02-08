package diet.calculatorscom.example.demo.module.mapper;

 ;
 import diet.calculatorscom.example.demo.module.product.model.dto.JournalDto;
 import diet.calculatorscom.example.demo.module.product.model.entity.JournalEntryEntity;

public class JournalMapper {

    public static JournalEntryEntity mapToEntity(JournalDto journalDto) {
        JournalEntryEntity journalEntity = new JournalEntryEntity();
        journalEntity.setProduct(ProductMapper.maptoEntity(journalDto.getProduct()));
        journalEntity.setWeight(journalDto.getWeight());
        return journalEntity;
    }


    public static JournalDto mapToDto(JournalEntryEntity journalEntryEntity) {
        JournalDto journalDto = new JournalDto();
        journalDto.setWeight(journalEntryEntity.getWeight());
        journalDto.setProduct(ProductMapper.maptoDTO(journalEntryEntity.getProduct()));
        return journalDto;
    }
}
