package diet.calculatorscom.example.demo.module.product.model;

public enum  Macronutrients {

    FAT(9),
    PROTEIN(4),
    CARBOHYDRATES(4);



   private final int valueCalorie;


     Macronutrients(int valueCalorie) {
       this.valueCalorie=valueCalorie;
    }

    public int getCalories(){
         return valueCalorie;
    }
}
