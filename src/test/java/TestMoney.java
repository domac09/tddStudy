import org.junit.Test;
import tdd.money.Bank;
import tdd.money.Expression;
import tdd.money.Money;
import tdd.money.Sum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestMoney {

    @Test
    public void testEquality(){
        assertTrue(new Money(5, "USD").equals(new Money(5, "USD")));
        assertFalse(new Money(5, "USD").equals(new Money(6, "USD")));
        assertFalse(new Money(5, "USD").equals(new Money(5, "CHF")));
    }

    @Test
    public void testPrivateAmount(){
        Money five = Money.dollar(5);
        assertEquals(new Money(10, "USD"), five.times(2));
        assertEquals(new Money (15, "USD"), five.times(3));

        Money four = Money.franc(5);
        assertEquals(new Money(10, "CHF"), four.times(2));
        assertEquals(new Money(15, "CHF"), four.times(3));
    }


    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition(){
//        Money sum = Money.dollar(5).plus(Money.dollar(5));


        Money five = Money.dollar(5);
        Expression sum = five.plus(five);

        System.out.println(sum);

        Bank bank = new Bank();
        Money reduceed = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduceed);
    }

    @Test
    public void testPlusReturnSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(Money.dollar(5));
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(7));
        Bank bank =  new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), result);
    }


    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }


}
