package jp.ac.uryukyu.ie.e205715;

import java.util.Random;
import java.util.Scanner;
/**
 * Gameクラス
 * ゲームの処理の本体
 */
public class Game {
    static String[][] masterBord = { { "・", "・", "・", "・", "・" }, { "・", "・", "・", "・", "・" },
            { "・", "・", "・", "・", "・" }, { "・", "・", "・", "・", "・" }, { "・", "・", "・", "・", "・" } };

    boolean isGameEnd = false;
    static boolean bordCheck = false;
    static boolean enemyBordCheck = false;
    boolean isVictory = false;
    boolean isDefeat= false;
    /**
     * bordOutメソッド
     * ボードを出力する
     */
    public void bordOut() {
        for (int i = 0; i < 5; i++) {
            for (int e = 0; e<5; e++){ 
                System.out.print(masterBord[i][e]); 
            }
            System.out.println();
        }
    }
    /**
     * judgeメソッド
     * 自分のコマが五目並んだかを判定する
     */
    public void judge(){
        int countYoko = 0;
        int countTate = 0;
        int countNaname1 = 0;
        int countNaname2 = 0;
        for (int i = 0; i < 5; i++) {
            for (int e = 0; e<5; e++){
                if (masterBord[i][e] == "○" ) {
                    countYoko += 1;
                }
                if (countYoko == 5){
                    isGameEnd = true;
                    isVictory = true;
                }
            }
            countYoko = 0;
        }
        for (int i = 0; i<5; i++){
            for (int e = 0; e<5; e++){
                if (masterBord[e][i] == "○" ) {
                    countTate += 1;
                }
                if (countTate == 5){
                    isGameEnd = true;
                    isVictory = true;
                }
            }
            countTate = 0;
        }
        for (int i = 0; i<5; i++){
            if (masterBord[i][i] == "○"){
                countNaname1 += 1;
            }
            if (countNaname1 == 5){
                isGameEnd = true;
                isVictory = true;
            }
        }
        for(int i=0,e=4; i<5; i++,e--){
            if (masterBord[i][e] == "○"){
                countNaname2 += 1;
            }
            if (countNaname2 == 5){
                isGameEnd = true;
                isVictory = true;
            }
        }  
    }
    /**
     * enemyJudgeメソッド
     * 敵の駒が五目並んだかどうかを判定する
     */
    public void enemyJudge(){
        int eCountYoko = 0;
        int eCountTate = 0;
        int eCountNaname1 = 0;
        int eCountNaname2 = 0;
        for (int i = 0; i < 5; i++) {
            for (int e = 0; e<5; e++){
                if (masterBord[i][e] == "●" ) {
                    eCountYoko += 1;
                }
                if (eCountYoko == 5){
                    isGameEnd = true;
                    isDefeat = true;
                }
            }
            eCountYoko = 0;
        }
        for (int i = 0; i<5; i++){
            for (int e = 0; e<5; e++){
                if (masterBord[e][i] == "●" ) {
                    eCountTate += 1;
                }
                if (eCountTate == 5){
                    isGameEnd = true;
                    isDefeat = true;
                }
            }
            eCountTate = 0;
        }
        for (int i = 0; i<5; i++){
            if (masterBord[i][i] == "●"){
                eCountNaname1 += 1;
            }
            if (eCountNaname1 == 5){
                isGameEnd = true;
                isDefeat = true;
            }
        }
        for(int i=0,e=4; i<5; i++,e--){
            if (masterBord[i][e] == "●"){
                eCountNaname2 += 1;
            }
            if (eCountNaname2 == 5){
                isGameEnd = true;
                isDefeat = true;
            }
        }  
    }
    /**
     * playerメソッド
     * プレーヤーが座標を指定し、座標をボードに反映させる
     */
    public void player(){
        Scanner scanYoko = new Scanner(System.in);
        Scanner scanTate = new Scanner(System.in);
        bordCheck = false;
        while (bordCheck == false){
            System.out.println("行数を入力してください");
            
            int yoko = scanYoko.nextInt();
            System.out.println("列数を入力してください");
            
            int tate = scanTate.nextInt();
            if (masterBord[yoko - 1][tate - 1] == "・" ) {
                masterBord[yoko-1][tate-1] ="○";
                bordCheck = true;
            }
            else{
                System.out.println("そこには他の駒が置いておあります。");
                System.out.println("他の場所を選択してください。");
            }  
        } 
        if (isGameEnd == true){

            scanYoko.close();
            scanTate.close();     
        }
    }
    /**
     * enemyメソッド
     * 敵が自身やプレーヤーと被らない位置にコマを置く
     */
    public void enemy(){
        enemyBordCheck = false;
        if (isDefeat == false){
            while(enemyBordCheck == false){
                Random enemy = new Random();
                int enemyHandA = enemy.nextInt(5);
                int enemyHandB = enemy.nextInt(5);
                if (masterBord[enemyHandA][enemyHandB]== "・"){
                    masterBord[enemyHandA][enemyHandB] = "●";
                    enemyBordCheck = true;
                }
            }
        }
        System.out.println("敵のターン");

    }
    /**
     * fillDefeatメソッド
     * ボードの全体が埋まって、それでも勝者が出なかった場合に敗北する
     */
    public void fillDefeat(){
        int fill = 0;
            for (int i = 0; i<5; i++){
                for(int e = 0; e<5; e++){
                    if (masterBord[i][e] != "・"){
                        fill += 1;
                    }
                    if (fill == 25){
                        isGameEnd = true;
                        isDefeat = true;
                    }
                }
            }
    }
}
