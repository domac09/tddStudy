import org.junit.Test;
import tdd.money.Money;

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
        assertEquals(new Money(15, "USD"), five.times(3));

        Money four = Money.franc(5);
        assertEquals(new Money(10, "CHF"), four.times(2));
        assertEquals(new Money(15, "CHF"), four.times(3));
    }


    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }


}
