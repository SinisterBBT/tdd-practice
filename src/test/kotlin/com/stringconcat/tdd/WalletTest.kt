package com.stringconcat.tdd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class WalletTest {

    @Test
    fun `wallet containing 2 USD is another wallet containing 2 USD`() {
        Wallet(Money.dollar(BigDecimal.valueOf(2))) shouldBe Wallet(Money.dollar(BigDecimal.valueOf(2)))
    }

    @Test
    fun `wallet that contains 2 CHF returns 1 USD if rate 2 to 1`() {
        Wallet(Money.franc(BigDecimal.valueOf(2))).asDollars() shouldBe Money.dollar(BigDecimal.valueOf(1.0))
    }

    @Test
    fun `wallet that contains 2 EUR returns 4 USD if rate 1 to 2`() {
        Wallet(Money.euro(BigDecimal.valueOf(2))).asDollars() shouldBe Money.dollar(BigDecimal.valueOf(4))
    }

    @Test
    fun `wallet that contains 2 CHF and 1 USD returns 2 USD if rate 2 to 1`() {
        Wallet(Money.franc(BigDecimal.valueOf(2)), Money.dollar(BigDecimal.valueOf(1))).asDollars() shouldBe Money.dollar(BigDecimal.valueOf(2.0))
    }

    @Test
    fun `wallet that contains 2 EUR and 1 USD returns 5 USD if rate 1 to 2`() {
        Wallet(Money.euro(BigDecimal.valueOf(2)), Money.dollar(BigDecimal.valueOf(1))).asDollars() shouldBe Money.dollar(BigDecimal.valueOf(5))
    }

    @Test
    fun `wallet that contains 2 CHF and 2 USD and 3 CHF returns 4,5 USD if rate 2 to 1`() {
        Wallet(Money.franc(BigDecimal.valueOf(2)),
            Money.dollar(BigDecimal.valueOf(2)),
            Money.franc(BigDecimal.valueOf(3))).asDollars() shouldBe Money.dollar(BigDecimal.valueOf(4.5))
    }

    @Test
    fun `wallet that contains 2 CHF and 2 USD and 1,5 EUR returns 6 USD for rate CHF to USD 1 to 2 and EUR to USD 2 to 1`() {
        Wallet(Money.franc(BigDecimal.valueOf(2)),
            Money.dollar(BigDecimal.valueOf(2)),
            Money.euro(BigDecimal.valueOf(1.5))).asDollars() shouldBe Money.dollar(BigDecimal.valueOf(6.0))
    }

    @Test
    fun `wallet that contains (30 USD and 20 CHF) + 20 CHF return 50 USD`() {
        Wallet(Money.dollar(BigDecimal.valueOf(30)),
            Money.franc(BigDecimal.valueOf(20))) +
                Money.franc(BigDecimal.valueOf(20)) shouldBe Money.dollar(BigDecimal.valueOf(50.0))
    }

    @Test
    fun `wallet that contains (10 USD and 20 CHF) + 10 EUR return 40 USD`() {
        Wallet(Money.dollar(BigDecimal.valueOf(10)),
            Money.franc(BigDecimal.valueOf(20))) +
                Money.euro(BigDecimal.valueOf(10)) shouldBe Money.dollar(BigDecimal.valueOf(40.0))
    }
}