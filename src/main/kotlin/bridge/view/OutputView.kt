package bridge.view

import bridge.domain.BridgeGame

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printStartMsg(){
        println("다리 건너기 게임을 시작합니다.\n")
    }

    fun printMap(userState : Pair<String,String>){
        println(userState.first+"]")
        println(userState.second+"]")
        println()
    }
    fun printResult(bridgeGame : BridgeGame,result : String) {
        println("최종 게임 결과")
        printMap(bridgeGame.getMap())
        println("게임 성공 여부: ${result}")
        println("총 시도한 횟수: ${bridgeGame.getAttempts()}")
    }
}
