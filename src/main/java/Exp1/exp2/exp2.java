package Exp1.exp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exp2 {
    public static void main(String[] args) {
        List<Double> coins = new ArrayList<Double>();
        System.out.print("请输入硬币个数 : ");
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        System.out.print("请输入各硬币的质量 : ");
        double weight;
        for (int i = 0; i < nums; i++) {
            weight = in.nextDouble();
            coins.add(weight);
        }
        System.out.print("假币所在的序号为(序号从0开始) : ");
        counterfeitMoney(coins, 0, coins.size() - 1);
    }

    public static void counterfeitMoney(List<Double> coins, int begin, int end) {
        int mediumNum = begin + (end - begin) / 2;
        int length = end + 1 - begin;
        int vacancy = 0;
        if (length % 2 == 0) {
            if (length == 2) {
                if (coins.get(begin) > coins.get(end)) {
                    System.out.println(end + vacancy);
                } else {
                    System.out.println(begin + vacancy);
                }
            } else {
                double coins1Weight = calcWeight(coins, begin, mediumNum);
                double coins2Weight = calcWeight(coins, mediumNum + 1, end);
                if (coins1Weight > coins2Weight) {
                    counterfeitMoney(coins, mediumNum + 1, end);
                } else {
                    counterfeitMoney(coins, begin, mediumNum);
                }
            }
        } else {
            if (length == 1) {
                System.out.println(begin + vacancy);
            } else {
                coins.remove(mediumNum);
                vacancy++;
                double coins1Weight = calcWeight(coins, begin, mediumNum - 1);
                double coins2Weight = calcWeight(coins, mediumNum, end - 1);
                if (coins1Weight == coins2Weight) {
                    System.out.println(mediumNum);
                }
                if (coins1Weight < coins2Weight) {
                    counterfeitMoney(coins, begin, mediumNum - 1);
                }
                if (coins1Weight > coins2Weight) {
                    counterfeitMoney(coins, mediumNum, end - 1);
                }
            }
        }
    }

    public static double calcWeight(List<Double> coins, int begin, int end) {
        int result = 0;
        for (int i = begin; i <= end; i++) {
            result += coins.get(i);
        }
        return result;
    }
}
