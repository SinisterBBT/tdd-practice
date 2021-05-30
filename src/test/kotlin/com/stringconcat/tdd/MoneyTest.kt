package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class MoneyTest {

    //USD

    @Test
    fun `5 USD is 5 USD`() {
        Money.dollar(BigDecimal.valueOf(5)) shouldBe Money.dollar(BigDecimal.valueOf(5))
    }

    @Test
    fun `5 USD is NOT 2 USD`() {
        Money.dollar(BigDecimal.valueOf(5)) shouldNotBe Money.dollar(BigDecimal.valueOf(2))
    }

    @Test
    fun `5 USD * 2 is 10 USD`() {
        Money.dollar(BigDecimal.valueOf(5)) * 2 shouldBe Money.dollar(BigDecimal.valueOf(10))
    }

    @Test
    fun `5 USD * 3 is 15 USD`() {
        Money.dollar(BigDecimal.valueOf(5)) * 3 shouldBe Money.dollar(BigDecimal.valueOf(15))
    }

    @Test
    fun `5 USD + 5 USD is 10 USD`() {
        Money.dollar(BigDecimal.valueOf(5)) +
                Money.dollar(BigDecimal.valueOf(5)) shouldBe Wallet(Money.dollar(BigDecimal.valueOf(10)))
    }

    //CHF

    @Test
    fun `5 CHF is 5 CHF`() {
        Money.franc(BigDecimal.valueOf(5)) shouldBe Money.franc(BigDecimal.valueOf(5))
    }

    @Test
    fun `5 CHF is NOT 2 CHF`() {
        Money.franc(BigDecimal.valueOf(5)) shouldNotBe Money.franc(BigDecimal.valueOf(2))
    }

    @Test
    fun `5 CHF * 2 is 10 CHF`() {
        Money.franc(BigDecimal.valueOf(5)) * 2 shouldBe Money.franc(BigDecimal.valueOf(10))
    }

    @Test
    fun `5 CHF * 3 is 15 CHF`() {
        Money.franc(BigDecimal.valueOf(5)) * 3 shouldBe Money.franc(BigDecimal.valueOf(15))
    }

    @Test
    fun `5 CHF + 5 CHF is 10 CHF`() {
        Money.franc(BigDecimal.valueOf(5)) +
                Money.franc(BigDecimal.valueOf(5)) shouldBe Wallet(Money.franc(BigDecimal.valueOf(10)))
    }

    //EUR

    @Test
    fun `5 EUR is 5 EUR`() {
        Money.euro(BigDecimal.valueOf(5)) shouldBe Money.euro(BigDecimal.valueOf(5))
    }

    @Test
    fun `5 EUR is NOT 2 EUR`() {
        Money.euro(BigDecimal.valueOf(5)) shouldNotBe Money.euro(BigDecimal.valueOf(2))
    }

    @Test
    fun `5 EUR * 2 is 10 EUR`() {
        Money.euro(BigDecimal.valueOf(5)) * 2 shouldBe Money.euro(BigDecimal.valueOf(10))
    }

    @Test
    fun `5 EUR * 3 is 15 EUR`() {
        Money.euro(BigDecimal.valueOf(5)) * 3 shouldBe Money.euro(BigDecimal.valueOf(15))
    }

    @Test
    fun `5 EUR + 5 EUR is 10 EUR`() {
        Money.euro(BigDecimal.valueOf(5)) +
                Money.euro(BigDecimal.valueOf(5)) shouldBe Wallet(Money.euro(BigDecimal.valueOf(10)))
    }

    //Combinations

    @Test
    fun `5 USD is not 5 CHF`() {
        Money.dollar(BigDecimal.valueOf(5)) shouldNotBe Money.franc(BigDecimal.valueOf(5))
    }

    @Test
    fun `5 EUR is not 5 CHF`() {
        Money.euro(BigDecimal.valueOf(5)) shouldNotBe Money.franc(BigDecimal.valueOf(5))
    }

    @Test
    fun `2 CHF + 4 USD is wallet that contains 2 CHF and 4 USD`() {
        Money.franc(BigDecimal.valueOf(2)) +
                Money.dollar(BigDecimal.valueOf(4)) shouldBe
                Wallet(Money.franc(BigDecimal.valueOf(2)),
                    Money.dollar(BigDecimal.valueOf(4)) )
    }

    @Test
    fun `2 CHF + 4 EUR is wallet that contains 2 CHF and 4 EUR`() {
        Money.franc(BigDecimal.valueOf(2)) +
                Money.euro(BigDecimal.valueOf(4)) shouldBe
                Wallet(Money.franc(BigDecimal.valueOf(2)),
                    Money.euro(BigDecimal.valueOf(4)) )
    }

}