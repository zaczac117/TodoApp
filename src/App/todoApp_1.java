package App;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Scanner;

public class todoApp_1 {

    /*タスクを保存するリストを用意*/
    static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {

        /*Scannerクラス生成*/
        Scanner scanner = new Scanner(System.in);

        while (true) {
            /*メニュー表示*/
            displayMenu();

            try {
                /*入力した番号を格納する変数を定義*/
                int choiceNumber = scanner.nextInt();
                scanner.nextLine(); //改行コード(\n)の削除

                switch (choiceNumber) {
                    case 1:
                        /*追加処理の場合*/
                        add(scanner);
                        break;
                    case 2:
                        /*一覧処理の場合*/
                        views();
                        break;
                    case 3:
                        /*削除処理の場合*/
                        delete(scanner);
                        break;
                    case 4:
                        /*終了処理の場合*/
                        System.out.println("アプリは終了しました");
                        scanner.close();    //リソースリーク対策
                        return;
                    /*上記処理の場合*/
                    default:
                        System.out.println("再度番号を入力して下さい");
                }

            } catch (Exception e) {
                System.out.println("無効な入力です。再入力してください");
                scanner.nextLine(); //改行コード(\n)の削除
            }
        }
    }

    /*メニュー表示*/
    public static void displayMenu() {
        System.out.println("\n*** Todoアプリ  ***");
        System.out.println("======================");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Delete Task");
        System.out.println("4. Exit");
        System.out.println("======================");
        System.out.print("番号を入力してください：");
    }

    /*追加メソッド処理*/
    public static void add(Scanner scanner) {
        System.out.println("タスクの内容を入力してください");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("タスクを追加しました");
    }

    /*一覧メソッド処理*/
    public static void views() {
        if (tasks.isEmpty()) {
            System.out.println("表示するタスクがありません");
        } else {
//            for(String str : tasks){
//                System.out.println(str);  //拡張for
//            }
//              for(int i = 0; i < tasks.size(); i++){
//                System.out.println(tasks.get(i));
//              }
//            tasks.forEach( str -> System.out.println(str)); //③ラムダ
            tasks.forEach(System.out::println); //④メソッド参照
        }
    }

    /*タスクを削除する*/
    public static void delete(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("タスクが一つも追加されていないため、削除できません");
        } else {
            views();
            System.out.println("削除するタスクの番号を入力してください");
            int num = scanner.nextInt();
            scanner.nextLine();
            if (num > 0 && num <= tasks.size()) {
                tasks.remove(num - 1);
                System.out.println("タスクを削除しました");
            } else {
                System.out.println("無効な数字です。再度お試しください");
            }
        }
    }
}
