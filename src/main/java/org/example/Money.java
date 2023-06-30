package org.example;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    String currency() {
        return currency;
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount && currency().equals(money.currency());
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    @Override
    public String toString() {

        return amount + " " + currency;
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }


    @Override
    public Money reduce(String to) {
        int rate = (currency.equals("CHF") && to.equals("USD")) ? 2 : 1;
        return new Money(amount / rate, to);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }

}
