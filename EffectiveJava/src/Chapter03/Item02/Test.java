package Chapter03.Item02;

public class Test {

    public static void main(String[] args) {
        NutritionFactsBuilder build = new NutritionFactsBuilder.Builder(20, 84)
                .calories(10).fat(20).carbohydrate(30).sodium(40).build();
    }
}
