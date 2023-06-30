package org.example;

import java.util.Hashtable;

/**
 * @author qiuwenke
 */
public class Bank {
    private Hashtable rates = new Hashtable();


    public Money reduce(Expression source, String to) {
        return source.reduce(to);
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from,to),new Integer(rate));
    }

    int rate(String from, String to) {
        return (int) rates.get(new Pair(from,to));
    }


}
