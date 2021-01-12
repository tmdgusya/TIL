package Item02;

public class NutritionFactsBuilder {


    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // 필수 매개변수
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 => 기본값으로 초기화 해줘야함.
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories){
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat){
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium){
            if(sodium < 0){
                throw new IllegalArgumentException();
            }
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate){
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFactsBuilder build(){
            return new NutritionFactsBuilder(this);
        }
    }

    public NutritionFactsBuilder(Builder builder){
        servings = builder.servingSize;
        servingSize = builder.servingSize;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
