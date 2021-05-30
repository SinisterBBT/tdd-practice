package com.stringconcat.tdd

import java.math.BigDecimal

open class Money(
    val amount: BigDecimal,
    val currency: Currency,
    val rates: Map<Currency, BigDecimal>
) {


    companion object {
        fun dollar(amount: BigDecimal) = Money(amount, Currency.USD,
            mapOf(Currency.USD to BigDecimal.valueOf(1), Currency.CHF to BigDecimal.valueOf(2), Currency.EUR to BigDecimal(0.5)))
        fun franc(amount: BigDecimal) = Money(amount, Currency.CHF,
            mapOf(Currency.USD to BigDecimal.valueOf(0.5), Currency.CHF to BigDecimal.valueOf(1), Currency.EUR to BigDecimal(0.25)))
        fun euro(amount: BigDecimal) = Money(amount, Currency.EUR,
            mapOf(Currency.CHF to BigDecimal.valueOf(4), Currency.USD to BigDecimal(2), Currency.EUR to BigDecimal.valueOf(1)))
    }

    operator fun plus(other: Money): Wallet {
        return if (this.currency != other.currency) {
            Wallet(this, other)
        } else {
            Wallet(Money(this.amount + other.amount, this.currency, this.rates))
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Money) return false
        return this.amount == other.amount && this.currency == other.currency
    }

    operator fun times(multiplier: Int): Money {
        return Money(amount * BigDecimal.valueOf(multiplier.toLong()), currency, this.rates)
    }

    override fun toString(): String {
        return "Money(amount=$amount, currency=$currency)"
    }

    enum class Currency {
        USD, CHF, EUR
    }
}