package Alpha;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Alpha {
    private final int number;

    public Alpha(int number){
        this.number = number;
    }

    public boolean isFactor(int potentialFactor) {
        return number % potentialFactor == 0;
    }

    public Set<Integer> factors() {
        HashSet<Integer> factors = new HashSet<>();
        IntStream range = IntStream.rangeClosed(1, (int) Math.sqrt(number));
        range.filter(this::isFactor).forEach(ele -> {factors.add(ele); factors.add(number / ele);});
        return factors;
    }


}
