package diet.calculatorscom.example.demo.module.product.service;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.model.Serving;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;
import diet.calculator.com.example.diet_calculator.module.product.model.entity.ProductEntity;
import diet.calculator.com.example.diet_calculator.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
@Log4j2
public class FoodNutritionService {

    private final ProductRepository productRepository;

    private FatsecretService fatsecretService = new FatsecretService("d746c8374aeb47eab8fff6f63cff92e7",
            "3e37b607893c47208f42dc4c4397767c");


    public void downloadFoodByIdAndSaveProductToDb(Long fatSecretFoodId) {
        final Food food = fatsecretService.getFood(fatSecretFoodId);
        if (food == null) {
            log.warn("Product id could not be found " + fatSecretFoodId + " in FatSecret API!");
            return;
        }
        final Serving serving = food.getServings().get(0);
        final BigDecimal multiplier = BigDecimal.valueOf(100.0).divide(serving.getMetricServingAmount(), RoundingMode.HALF_UP);
        final String name = food.getName();
        final double carbsPer100g = serving.getCarbohydrate().multiply(multiplier).doubleValue();
        final double proteinPer100g = serving.getProtein().multiply(multiplier).doubleValue();
        final double fatPer100g = serving.getFat().multiply(multiplier).doubleValue();


        final ProductEntity productEntity = new ProductEntity(null, name, proteinPer100g, fatPer100g, carbsPer100g);

        productRepository.save(productEntity);
        log.info("I have saved the product to the database" + productEntity.getName());
    }

    /**
     * Ta metoda pozwala nam zapisać "maxResults" produktów do naszej bazy danych, wyszukując je
     * w FatSecret API za pomocą nazwy "productName"
     * @param productName nazwa szukanych produktów, np. "chicken"
     * @param maxResults maksymalna liczba wyników dla podanego hasła, jaką chcemy zapisać do bazy, np. 5
     */
    public void downloadFoodsByNameAndSaveProductToDb(String productName, int maxResults) {

        final Response<CompactFood> productSearchResult = fatsecretService.searchFoods(productName);

        int alreadySavedProducts = 0;
        for (CompactFood singleSearchResult : productSearchResult.getResults()) {
            downloadFoodByIdAndSaveProductToDb(singleSearchResult.getId());
            alreadySavedProducts++;
            if (alreadySavedProducts >= maxResults) {
                return;
            }
        }
    }
}