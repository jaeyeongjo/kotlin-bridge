package bridge.util

class ValidationUtil {

    val sizeErrorMsg = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
    val userMovingErrorMsg = "[ERROR] 이동할 칸은 U와 D중에 입력해야 합니다."
    val commandErrorMsg = "[ERROR] 다시 시도할지 여부는 R와 Q중에 입력해야 합니다."

    fun validateSize(size: String) {
        val sizeInt = size.toIntOrNull() ?: throw IllegalArgumentException(sizeErrorMsg)
        if (sizeInt !in 3..20) {
            throw IllegalArgumentException(sizeErrorMsg)
        }
    }

    fun validateUserMoving(userMoving: String) {
        if (userMoving != "U" && userMoving != "D") {
            throw IllegalArgumentException(userMovingErrorMsg)
        }
    }

    fun validateCommand(command: String) {
        if (command != "R" && command != "Q") {
            throw IllegalArgumentException(commandErrorMsg)
        }
    }
}