package Alpha;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.lang.Integer;

public class Mission2 {

    static BiFunction<Integer, Integer, Boolean> isFactor = (number, potentialFactor) -> {
        return number % potentialFactor == 0;
    };

    static Function<Integer, Set<Integer>> factors = (number) -> {
      HashSet<Integer> factors = new HashSet<>();
      IntStream range = IntStream.rangeClosed(1, (int) Math.sqrt(number));
      range.forEach(ele -> {if(isFactor.apply(number, ele)){factors.add(ele); factors.add(number / ele);}});
      return factors;
    };

    static public boolean isPerfect(Function<Integer, Set<Integer>> factors, int number) {
        return sum(factors.apply(number)) - number == number;
    }


    static public boolean isAbundant(Function<Integer, Set<Integer>> factors, int number) {
        return sum(factors.apply(number)) - number > number;
    }

    static public boolean isDeficient(Function<Integer, Set<Integer>> factors, int number) {
        return sum(factors.apply(number)) - number < number;
    }

    static public int sum(Set<Integer> factors) {
        return factors.stream().reduce(0, Integer::sum);
    }

    static public boolean isPrime(Function<Integer, Set<Integer>> factors, int number) {
        return number > 1 && factors.apply(number).equals(new HashSet<Integer>(){ {add(1); add(number);}});
    }

    static public void whatNumberTheory(int number){
        StringBuilder typeMessage = new StringBuilder();
        typeMessage.append(number).append(" : "); // default Message
        if(isPrime(factors, number)){
            typeMessage.append(" prime");
        }
        if(isPerfect(factors, number)){
            typeMessage.append(" perfect");
        }
        if(isAbundant(factors, number)){
            typeMessage.append(" abundant");
        }
        if (isDeficient(factors, number)) {
            typeMessage.append(" deficient");
        }
        System.out.println(typeMessage);
    }
}
