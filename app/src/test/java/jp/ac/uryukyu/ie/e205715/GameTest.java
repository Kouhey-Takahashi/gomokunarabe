/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jp.ac.uryukyu.ie.e205715;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * GameTestクラス
 * ゲームにおいて、もし敵が勝利した場合、自身は敗北するかどうか調べる
 */
class GameTest {
    @Test void GameTest(){
        boolean testDefeat = true;
        Game gameTest = new Game();
        while(gameTest.isGameEnd == false){
            gameTest.enemy();
            gameTest.enemyJudge();
        }
        assertEquals(gameTest.isDefeat ,testDefeat);
    }
}
