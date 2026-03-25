import org.junit.Test
import kotlin.test.assertEquals

class CommissionTest {

    @Test
    fun testCards(){
        val typeCard = "Visa"
        val amount = 1000
        val previous = 0

        val result = commission(typeCard, amount, previous)

        assertEquals(35, result)
    }

    @Test
    fun testErrorType(){
        val typeCard = "VisaP"
        val amount = 1000
        val previous = 0

        val result = commission(typeCard, amount, previous)

        assertEquals(ERROR_TYPE, result)
    }

    @Test
    fun testErrorLimit1(){
        val typeCard = "Visa"
        val amount = 1_000_000
        val previous = 0

        val result = commission(typeCard, amount, previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testErrorLimit2(){
        val typeCard = "Visa"
        val amount = 100_000
        val previous = 550_000

        val result = commission(typeCard, amount, previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testErrorLimit3(){
        val typeCard = "VKPay"
        val amount = 30_000
        val previous = 0

        val result = commission(typeCard, amount, previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testErrorLimit4(){
        val typeCard = "VKPay"
        val amount = 15_000
        val previous = 38_000

        val result = commission(typeCard, amount, previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testCardsVKPay(){
        val typeCard = "VKPay"
        val amount = 1000
        val previous = 0

        val result = commission(typeCard, amount, previous)

        assertEquals(0, result)
    }

    @Test
    fun testCardsMaster1(){
        val typeCard = "Mastercard"
        val amount = 10_000
        val previous = 0

        val result = commission(typeCard, amount, previous)

        assertEquals(0, result)
    }

    @Test
    fun testCardsMaster2(){
        val typeCard = "Maestro"
        val amount = 50_000
        val previous = 50_000

        val result = commission(typeCard, amount, previous)

        assertEquals(170, result)
    }

    @Test
    fun testMir(){
        val typeCard = "Mir"
        val amount = 10_000
        val previous = 0

        val result = commission(typeCard, amount, previous)

        assertEquals(75, result)
    }
}