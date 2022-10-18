package Exp2.exp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exp1 {
    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        System.out.print("请输入挂钩数量 : ");
        int n = in.nextInt();
        if (n <= 0) System.out.println("数量有误，请重新输入");
        else {
            System.out.print("请输入钩码质量 : ");
            for (int i = 0; i < n; i++) {
                int t = in.nextInt();
                weights.add(t);
            }
            int m = 0;
            for (int i = 0; i < n; i++) {
                m += weights.get(i);
            }
            m /= 2;
            int[] h = new int[m + 1];
            h[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = m; j >= 1; j--) {
                    if (weights.get(i) <= j) {
                        h[j] = h[j] + h[j - weights.get(i)];
                    }
                }
            }
            for (int i = 0; i < h.length; i++) {
                System.out.print(h[i] + " ");
            }
        }
    }
}
