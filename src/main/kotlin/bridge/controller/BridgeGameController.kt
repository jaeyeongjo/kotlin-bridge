package bridge.controller

import bridge.domain.BridgeMaker
import bridge.domain.BridgeGame
import bridge.domain.BridgeRandomNumberGenerator
import bridge.util.ValidationUtil
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val validationUtil = ValidationUtil()
    fun play() {
        outputView.printStartMsg()
        val bridge = generateBridge()
        val bridgeGame = BridgeGame(bridge)

        while (true) {
            val userMove = getValidUserMoving()
            bridgeGame.move(userMove)
            outputView.printMap(bridgeGame.getMap())
            if (!updateGameStatus(bridgeGame, userMove)) break
        }
    }


    private fun generateBridge(): List<String> {
        val size = getValidSize()
        return bridgeMaker.makeBridge(size)
    }


    private fun getValidSize(): Int {
        while (true) {
            try {
                val size = inputView.readBridgeSize()
                validationUtil.validateSize(size)
                return size.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidUserMoving(): String {
        while (true) {
            try {
                val userMove = inputView.readMoving()
                validationUtil.validateUserMoving(userMove)
                return userMove
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun updateGameStatus(bridgeGame: BridgeGame, userMove: String): Boolean {
        return if (bridgeGame.getBridge()[bridgeGame.getUserPos()] != userMove) {
            handleFailure(bridgeGame)
        } else {
            handleSuccess(bridgeGame)
        }
    }

    private fun handleFailure(bridgeGame: BridgeGame): Boolean {
        val command = getValidCommand()
        if (command != "R") {
            outputView.printResult(bridgeGame,"실패")
            return false
        }
        bridgeGame.retry()
        return true
    }

    private fun getValidCommand(): String {
        while (true) {
            try {
                val command = inputView.readGameCommand()
                validationUtil.validateCommand(command)
                return command
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun handleSuccess(bridgeGame:  BridgeGame): Boolean {
        bridgeGame.increaseUserPos()
        if (bridgeGame.getUserPos() == bridgeGame.getBridge().size) {
            outputView.printResult(bridgeGame,"성공")
            return false
        }
        return true
    }
}
