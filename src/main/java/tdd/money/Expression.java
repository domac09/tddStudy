package tdd.money;

/**
 * Created by iseongho on 2015. 12. 14..
 */
public interface Expression {
    Money reduce(Bank bank, String to);
}
