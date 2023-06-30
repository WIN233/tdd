package org.example;

public class Sum implements Expression {
    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.addend = addend;
        this.augend = augend;
    }

    @Override
    public Money reduce(String to) {
        int amount = addend.amount + augend.amount;
        return new Money(amount, to);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = addend.amount + augend.amount;
        return new Money(amount, to);
    }
}
