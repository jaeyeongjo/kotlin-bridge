package bridge.util

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidationUtilTest {

    private val validationUtil = ValidationUtil()

    @Test
    fun `validateSize should not throw exception for valid size`() {
        assertThatCode { validationUtil.validateSize("5") }
            .doesNotThrowAnyException()
    }

    @Test
    fun `validateSize should throw exception for invalid size`() {
        assertThatThrownBy { validationUtil.validateSize("2") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
    }

    @Test
    fun `validateUserMoving should not throw exception for valid move`() {
        assertThatCode { validationUtil.validateUserMoving("U") }
            .doesNotThrowAnyException()
        assertThatCode { validationUtil.validateUserMoving("D") }
            .doesNotThrowAnyException()
    }

    @Test
    fun `validateUserMoving should throw exception for invalid move`() {
        assertThatThrownBy { validationUtil.validateUserMoving("X") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 이동할 칸은 U와 D중에 입력해야 합니다.")
    }

    @Test
    fun `validateCommand should not throw exception for valid command`() {
        assertThatCode { validationUtil.validateCommand("R") }
            .doesNotThrowAnyException()
        assertThatCode { validationUtil.validateCommand("Q") }
            .doesNotThrowAnyException()
    }

    @Test
    fun `validateCommand should throw exception for invalid command`() {
        assertThatThrownBy { validationUtil.validateCommand("A") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 다시 시도할지 여부는 R와 Q중에 입력해야 합니다.")
    }
}
