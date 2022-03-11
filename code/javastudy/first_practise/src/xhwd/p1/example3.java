package xhwd.p1;

import java.util.Random;
import java.util.Scanner;

/*
双色球
 */
public class example3 {
    public static void main(String[] args) {
        int[] luckyNumbers = creatLuckyNumbers();
        int[] userNumbers = userInputNumbers();
        System.out.println("中奖号码为：");
        print(luckyNumbers);
        System.out.println("您的号码为：");
        print(userNumbers);
        judgeNumbers(luckyNumbers, userNumbers);
    }


    //打印
    public static void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void judgeNumbers(int[] LuckyNumbers, int[] userNumbers) {
        int redHitNumber = 0;
        int blueHidNumber = 0;
        for (int i = 0; i < LuckyNumbers.length - 1; i++) {
            for (int j = 0; j < userNumbers.length - 1; j++) {
                if (LuckyNumbers[i] == userNumbers[j]) {
                    redHitNumber++;
                }
            }

        }
        blueHidNumber = LuckyNumbers[6] == userNumbers[6] ? 1 : 0;


        System.out.println("你的红球命中个数为：" + redHitNumber);
        System.out.println("你的蓝色球命中个数为：" + blueHidNumber);

        if (blueHidNumber == 1 && redHitNumber < 3) {
            System.out.println("恭喜你中了5元小奖！！！");
        } else if (redHitNumber == 3 && blueHidNumber == 1 || redHitNumber == 4 && blueHidNumber == 0) {
            System.out.println("恭喜你中了10元小奖！！！");
        } else if (redHitNumber == 4 && blueHidNumber == 1 || redHitNumber == 5 && blueHidNumber == 0) {
            System.out.println("恭喜你中了200元大奖！！！！！！");
        } else if (redHitNumber == 5 && blueHidNumber == 1) {
            System.out.println("恭喜你中了3000元大奖！！！！！");
        } else if (redHitNumber == 6 && blueHidNumber == 0) {
            System.out.println("恭喜你中了500万超级大奖！！！你可以浪了！！");
        } else if (redHitNumber == 6 && blueHidNumber == 1) {
            System.out.println("恭喜恭喜你中了1000万超级大奖！！！！！你可以飞了！！！");
        } else {
            System.out.println("感谢你为中国福利事业的贡献！");
        }

    }

    public static int[] userInputNumbers() {
        int[] userNumbers = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println("请输入第" + (i + 1) + "个红球号码(1-33):");
            userNumbers[i] = sc.nextInt();
        }
        System.out.println("请输入蓝色球号码(1-16):");
        userNumbers[6] = sc.nextInt();

        return userNumbers;
    }

    //生成双色球号码
    public static int[] creatLuckyNumbers() {
        int[] luckyNumbers = new int[7];
        Random ran = new Random();
        //随机6个不重复的数 red
        for (int i = 0; i < 6; i++) {

            while (true) {
                boolean flag = true;
                int data = ran.nextInt(33) + 1;
                for (int j = 0; j < i; j++) {
                    if (data == luckyNumbers[j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    luckyNumbers[i] = data;
                    break;
                }
            }
        }
        //随机生成一个blue
        luckyNumbers[6] = ran.nextInt(16) + 1;

        return luckyNumbers;
    }
}
