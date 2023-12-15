package bridge.domain

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {

    private var map = Pair("[", "[")
    private var attempts = 1
    private var userPos = 0

    fun getBridge(): List<String> {
        return bridge
    }

    fun getUserPos(): Int {
        return userPos
    }

    fun getMap(): Pair<String, String> {
        return map
    }

    fun getAttempts(): Int {
        return attempts
    }

    fun increaseUserPos() {
        userPos += 1
    }

    fun move(userMove: String) {
        val moveChar = if (bridge[userPos] == userMove) " O " else " X "
        val (upper, lower) = getBridgeSegment(moveChar, userMove)
        map = Pair(map.first + upper, map.second + lower)
    }

    private fun getBridgeSegment(moveChar: String, userMove: String): Pair<String, String> {
        val separator = if (userPos > 0) "|" else ""
        return when (userMove) {
            "U" -> Pair(separator + moveChar, separator + "   ")
            else -> Pair(separator + "   ", separator + moveChar)
        }
    }

    fun retry() {
        attempts += 1
        userPos = 0
        map = Pair("[", "[")

    }
}
