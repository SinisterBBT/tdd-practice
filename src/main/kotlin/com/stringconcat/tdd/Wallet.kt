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

    operator fun plus(money: Money): Money {
        return (asDollars() + money).asDollars()
    }

    fun asDollars(): Money {
        return Money.dollar(convertTo(Money.Currency.USD))
    }

    fun asEuros(): Money {
        return Money.euro(convertTo(Money.Currency.EUR))
    }

    fun asFrancs(): Money {
        return Money.franc(convertTo(Money.Currency.CHF))
    }

    private fun convertTo(currency : Money.Currency): BigDecimal {
        var sum = BigDecimal.ZERO
        for (moneyElem in money) {
            sum += moneyElem.amount.multiply(moneyElem.rates[currency])
        }
        return sum
    }

}
