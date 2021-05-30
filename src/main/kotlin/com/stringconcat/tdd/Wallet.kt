package com.stringconcat.tdd

import java.math.BigDecimal

class Wallet(vararg val money: Money) {


    override fun equals(other: Any?): Boolean {
        if (other !is Wallet) return false
        return this.money.contentEquals(other.money)
    }

    override fun toString(): String {
        return "Wallet(money=${money.contentToString()})"
    }

    fun asDollars(): Money {
        var sum = BigDecimal.ZERO
        for(moneyElem in money) {
            sum += moneyElem.amount.multiply(moneyElem.rates[Money.Currency.USD])
        }

        return Money.dollar(sum)
    }

    operator fun plus(money: Money): Money {
        return (asDollars() + money).asDollars()
    }

}
