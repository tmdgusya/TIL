package Week3;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashSet;
import java.util.stream.IntStream;

public class Mission2Test extends TestCase {

    public void testIsPerfect() {
        boolean resultTrue = Mission2.isPerfect(Mission2.factors, 6);
        boolean resultfalse = Mission2.isPerfect(Mission2.factors, 1);
        Assertions.assertThat(resultTrue).isEqualTo(true);
        Assertions.assertThat(resultfalse).isEqualTo(false);
    }

    public void testIsAbundant() {
        boolean resultTrue = Mission2.isAbundant(Mission2.factors, 66);
        boolean resultfalse = Mission2.isAbundant(Mission2.factors, 1);
        Assertions.assertThat(resultTrue).isEqualTo(true);
        Assertions.assertThat(resultfalse).isEqualTo(false);
    }

    public void testIsDeficient() {
        boolean resultTrue = Mission2.isDeficient(Mission2.factors, 2);
        boolean resultfalse = Mission2.isDeficient(Mission2.factors, 6);
        Assertions.assertThat(resultTrue).isEqualTo(true);
        Assertions.assertThat(resultfalse).isEqualTo(false);
    }

    public void testSum() {
        int sum = Mission2.sum(Mission2.factors.apply(10));
        Assertions.assertThat(sum).isEqualTo(18);
    }

    public void testIsPrime() {
        boolean resultTrue = Mission2.isPrime(Mission2.factors, 2);
        boolean resultfalse = Mission2.isPrime(Mission2.factors, 6);
        Assertions.assertThat(resultTrue).isEqualTo(true);
        Assertions.assertThat(resultfalse).isEqualTo(false);
    }

}