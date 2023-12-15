package bridge.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BridgeGameTest {

    @Test
    fun `should update map correctly when user move is valid`() {
        val bridge = listOf("U", "D", "U")
        val bridgeGame = BridgeGame(bridge)

        bridgeGame.move("U")
        assertThat(bridgeGame.getMap().first).isEqualTo("[ O ")
        assertThat(bridgeGame.getMap().second).isEqualTo("[   ")
        bridgeGame.increaseUserPos()

        bridgeGame.move("D")
        assertThat(bridgeGame.getMap().first).isEqualTo("[ O |   ")
        assertThat(bridgeGame.getMap().second).isEqualTo("[   | O ")
    }

    @Test
    fun `should update map correctly when user move is invalid`() {
        val bridge = listOf("D", "U", "U")
        val bridgeGame = BridgeGame(bridge)


        bridgeGame.move("D")
        assertThat(bridgeGame.getMap().first).isEqualTo("[   ")
        assertThat(bridgeGame.getMap().second).isEqualTo("[ O ")
        bridgeGame.increaseUserPos()

        bridgeGame.move("U")
        assertThat(bridgeGame.getMap().first).isEqualTo("[   | O ")
        assertThat(bridgeGame.getMap().second).isEqualTo("[ O |   ")
        bridgeGame.increaseUserPos()

        bridgeGame.move("D")
        assertThat(bridgeGame.getMap().first).isEqualTo("[   | O |   ")
        assertThat(bridgeGame.getMap().second).isEqualTo("[ O |   | X ")
    }
}
