package com.techelevator.change;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

public class MakeChange {
    private static final Coin[] coins = new Coin[] {new Quarter(), new Dime(), new Nickel()};
    LinkedHashMap<Coin, Integer> change = new LinkedHashMap<Coin, Integer>();

    public double change(double amount) {
        double changeAmount = 0.0;
        amount *= 100;
        for (Coin coin : coins) {
            if (amount <= 0) {
                break;
            }
            int count = (int) amount / coin.getValue();
            if (count > 0) {
                amount = amount % (coin.getValue() * count);
                changeAmount += ((coin.getValue() * count));
            }
        }
        return (changeAmount /= 100);
    }
}
