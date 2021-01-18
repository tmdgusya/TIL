package Week3;

import java.util.*;

public class ClassifierAlpha extends Alpha{

    private int number;

    public ClassifierAlpha(int number) {
        super(number);
    }

    static public int sum(Set<Integer> factors) {
        return factors.stream().reduce(0, Integer::sum);
    }

    public boolean isPerfect() {
        return sum(factors()) - number == number;
    }

    public boolean isAbundant() {
        return sum(factors()) - number > number;
    }

    public boolean isDeficient() {
        return sum(factors()) - number < number;
    }

    public static void main(String[] args) {
        ClassifierAlpha alpha1 = new ClassifierAlpha(10);
        ClassifierAlpha alpha2 = new ClassifierAlpha(6);

        System.out.println(alpha1.isPerfect());
        System.out.println(alpha2.isPerfect());
    }
}