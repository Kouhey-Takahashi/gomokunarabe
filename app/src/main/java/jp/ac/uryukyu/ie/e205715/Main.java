/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jp.ac.uryukyu.ie.e205715;

import java.util.Random;
import java.util.Scanner;
public class Main{
    static String[][] masterBord = { { "・", "・", "・", "・", "・" }, { "・", "・", "・", "・", "・" },
            { "・", "・", "・", "・", "・" }, { "・", "・", "・", "・", "・" }, { "・", "・", "・", "・", "・" } };

    static boolean isGameEnd = false;
    static boolean bordCheck = false;
    static boolean enemyBordCheck = false;
    static boolean isVictory = false;

    static String[] victoryBord = { "○", "○", "○", "○", "○" };
  
    public static void bordOut() {
        for (int i = 0; i < 5; i++) {
            for (int e = 0; e<5; e++){ 
                System.out.print(masterBord[i][e]); 
            }
            System.out.println();
        }
    }
    
    public static void judge(){
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

    public static void player(){
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
    public static void enemy(){
        enemyBordCheck = false;
        while(enemyBordCheck == false){
            Random enemy = new Random();
            int enemyHandA = enemy.nextInt(5);
            int enemyHandB = enemy.nextInt(5);
            if (masterBord[enemyHandA][enemyHandB]== "・"){
                masterBord[enemyHandA][enemyHandB] = "●";
                enemyBordCheck = true;
            }
        }
        System.out.println("敵のターン");

    }
    public static void main(String[]args){
        bordOut();

        while(isGameEnd == false){
            player();
            bordOut();
            enemy();
            bordOut();
            judge(); 
        }
        if(isVictory == true){
            System.out.println("あなたの勝利です。");
        }
        System.out.println("ゲームを終了します。");
    
    }
}