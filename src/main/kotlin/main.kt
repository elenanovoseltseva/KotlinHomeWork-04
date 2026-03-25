import kotlin.math.max

const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2

fun main() {
    println(commission("Visa", 1000, 0))
}

fun commission(typeCard: String, amount: Int, previous: Int): Int {
    val monthTransfer = 600_000
    val dayTransfer = 150_000

    val monthTransferVK = 40_000
    val dayTransferVK = 15_000

    val totalTransfer = amount + previous

    if (typeCard != "VKPay") {
        if (amount > dayTransfer || totalTransfer > monthTransfer)
            return ERROR_LIMIT
    }
    else if (amount > dayTransferVK || totalTransfer > monthTransferVK)
        return ERROR_LIMIT

    return when(typeCard) {

        "Mastercard", "Maestro" -> {
            val freeLimit = 75_000
            if (totalTransfer > freeLimit)
                ((totalTransfer - freeLimit) * 0.006 + 20).toInt()
            else 0
        }

        "Visa", "Mir" -> max(35, (amount * 0.0075).toInt())

        "VKPay" -> 0

        else -> ERROR_TYPE
    }
}