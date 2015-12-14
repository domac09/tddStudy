package tdd.money;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public Money times(int multiplire){
        return new Money(amount * multiplire, currency);
    }

    public boolean equals(Object object){
        Money money = (Money)object;
        return amount == money.amount && currency().equals(money.currency());
    }

    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    public static Money franc (int amount){
        return new Money(amount, "CHF");
    }

    public String currency() {
        return currency;
    }

    public String toString(){
        return amount + " " + currency;
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to){
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
