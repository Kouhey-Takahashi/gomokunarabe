/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jp.ac.uryukyu.ie.e205715;
/**
 * Mainクラス
 */
public class Main{
    /**
     * mainメソッド
     * @param args
     */
    public static void main(String[]args){
        Game game = new Game();
        game.bordOut();

        while(game.isGameEnd == false){
            game.player();
            game.bordOut();
            game.judge(); 
            game.fillDefeat();
            game.enemy();
            game.enemyJudge();
            game.bordOut(); 
        }
        if(game.isDefeat == true){
            System.out.println("あなたの敗北です。");
        }
        if(game.isVictory == true){
            System.out.println("あなたの勝利です。");
        }
        System.out.println("ゲームを終了します。");
    
    }

}


