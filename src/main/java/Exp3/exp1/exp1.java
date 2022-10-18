package Exp3.exp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exp1 {
    public static void main(String[] args) {
        List<Integer> card = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        System.out.print("一共几堆纸牌 : ");
        int heaps = in.nextInt();
        if (heaps <= 0) System.out.println("堆数不能小于0");
        else {
            System.out.print("请分别输入" + heaps + "堆纸牌的个数 : ");
            int sum = 0;
            for (int i = 0; i < heaps; i++) {
                int t = in.nextInt();
                card.add(t);
                sum += t;
            }
            if (sum % heaps == 0) {
                int cardAverage = sum / heaps;
                if (heaps == 1) System.out.println("只有一堆纸牌，纸牌已均分。");
                else {
                    if (card.get(0) > cardAverage) {
                        System.out.println("1--->2:" + (card.get(0) - cardAverage) + "张");
                        card.set(1, card.get(1) + card.get(0) - cardAverage);
                        card.set(0, cardAverage);
                    } else {
                        System.out.println("2--->1:" + (cardAverage - card.get(0)) + "张");
                        card.set(1, card.get(1) - cardAverage + card.get(0));
                        card.set(0, cardAverage);
                    }
                    for (int i = 1; i < heaps - 1; i++) {
                        int difference = card.get(i) - cardAverage;
                        if (difference < 0) {
                            System.out.println((i + 2) + "--->" + (i + 1) + ":" + Math.abs(difference) + "张");
                            card.set(i + 1, card.get(i + 1) + card.get(i) - cardAverage);
                            card.set(i, cardAverage);
                            continue;
                        }
                        if (difference > 0) {
                            System.out.println((i + 1) + "--->" + (i + 2) + ":" + Math.abs(difference) + "张");
                            card.set(i + 1, card.get(i + 1) + cardAverage - card.get(i));
                            card.set(i, cardAverage);
                        }
                    }
                }
            } else System.out.println("纸牌数量不对，不是堆数n的倍数");
        }
    }
}
