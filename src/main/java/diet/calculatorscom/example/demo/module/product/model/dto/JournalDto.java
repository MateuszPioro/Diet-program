package diet.calculatorscom.example.demo.module.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalDto {

    private ProductDto product;
    private int weight;



    public int getWeight() {
        return weight;
    }

    public double getTotalProtein(){
        return  (product.getProteinAmount()*(weight/100.0));
    }


    public double getTotalFat(){
        return product.getFatAmount()*(weight/100.0);
    }

    public double getTotalCarb(){
        return product.getCarbAmount()*(weight/100.0);
    }

    public double getTotalCalories(){
        return getTotalFat()*9 + getTotalCarb()*4 + getTotalProtein()*4;
    }
}
