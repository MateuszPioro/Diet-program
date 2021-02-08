package diet.calculatorscom.example.demo.module.mapper;

import diet.calculator.com.example.diet_calculator.module.product.model.dto.ProductDto;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.ProductEntity;

public class ProductMapper {


    public static ProductEntity maptoEntity(ProductDto productDto){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDto.getId());
        productEntity.setName(productDto.getName());
        productEntity.setCarbAmount(productDto.getCarbAmount());
        productEntity.setFatAmount(productDto.getFatAmount());
        productEntity.setProteinAmount(productDto.getProteinAmount());
        return productEntity;

    }



    public static ProductDto maptoDTO(ProductEntity productEntity){
        ProductDto productDto = new ProductDto();
        productDto.setId(productEntity.getId());
        productDto.setName(productEntity.getName());
        productDto.setCarbAmount(productEntity.getCarbAmount());
        productDto.setFatAmount(productEntity.getFatAmount());
        productDto.setProteinAmount(productEntity.getProteinAmount());
        return productDto;
    }
}
