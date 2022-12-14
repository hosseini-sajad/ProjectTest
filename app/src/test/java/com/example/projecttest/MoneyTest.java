package com.example.projecttest;

import static org.junit.Assert.assertEquals;

import static junitparams.JUnitParamsRunner.$;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class MoneyTest {

    private final static int VALID_AMOUNT = 5;
    private final static String VALID_CURRENCY = "USD";

    private static final Object[] getMoney() {
        return $(
          $(10, "USD"),
          $(20, "EUR")
        );
    }

    private static final Object[] getInvalidAmount() {
        return new Integer[][]{{-12387}, {-5}, {-1}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidAmount")
    public void constructorShouldThrowIAEForInvalidAmount(int inValidAmount) {
        new Money(inValidAmount, VALID_CURRENCY);
    }

    private static final Object[] getInvalidCurrency() {
        return new String[][]{{null}, {""}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidCurrency")
    public void constructorShouldThrowIAEForInvalidCurrency(
            String invalidCurrency) {
        new Money(VALID_AMOUNT, invalidCurrency);
    }

    @Test
    @Parameters(method = "getMoney")
    public void constructorShouldSetAmountAndCurrency(int amount, String currency) {
        Money money = new Money(amount, currency);

        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }
}
