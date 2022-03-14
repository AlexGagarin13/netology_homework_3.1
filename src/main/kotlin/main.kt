fun main() {
    print("Веедите количество секунд, которые человек был назад в сети: ")
    val timeFromSignOut = readLine()?.toUInt() ?: return
    fun calculateTextForMinutes(timeFromSignOut: UInt): String {
        val time = timeFromSignOut / 60U
        val minutesToPrint: String = when {
            time == 11U || time % 10U == 0U -> "$time минут"
            time % 10U == 1U && time != 11U -> "$time минуту"
            time % 10U in 5U..9U -> "$time минут"
            else -> "$time минуты"
        }
        return minutesToPrint
    }

    fun calculateTextForHours(timeFromSignOut: UInt): String {
        val hoursToPrint: String = when (val time = timeFromSignOut / 3600U) {
            21U, 1U -> "$time час"
            in 2U..4U, in 22U..24U -> "$time часа"
            else -> "$time часов"
        }
        return hoursToPrint
    }

    fun agoToText(timeFromSignOut: UInt): String {
        val textToPrint: String = when {
            (timeFromSignOut in 0U..60U) -> "только что "
            (61U <= timeFromSignOut && timeFromSignOut <= (3600U)) -> "в сети ${calculateTextForMinutes(timeFromSignOut)} назад "
            ((3601U) <= timeFromSignOut && timeFromSignOut <= (86400U)) -> "в сети ${
                calculateTextForHours(
                    timeFromSignOut
                )
            } назад "
            ((86400U) <= timeFromSignOut && timeFromSignOut <= (172800U)) -> "в сети сегодня "
            ((172800U) <= timeFromSignOut && timeFromSignOut <= (259200U)) -> "в сети вчера "
            else -> "в сети давно"
        }
        return textToPrint
    }
    print("был(а) ${agoToText(timeFromSignOut)}")
}