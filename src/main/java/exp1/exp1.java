package exp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exp1 {
    public static void main(String[] args) {
        List<Double> arr = new ArrayList<Double>();
        System.out.print("请输入数组元素个数 : ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double temp;
        System.out.print("请输入元素(按照从小到大的顺序) : ");
        for (int t = 0; t < n; t++) {
            temp = in.nextDouble();
            arr.add(temp);
        }
        System.out.print("请输入查找目标 : ");
        double target = in.nextDouble();
        binarySearchRevision(target, arr, 0, arr.size() - 1);
    }

    public static void binarySearchRevision(double target, List<Double> arr,int begin, int end) {
        int medmum = (end - begin) / 2 + begin;
        if (target == arr.get(medmum)) {
            System.out.println("i = " + medmum);
            System.out.println("j = " + medmum);
        }
        if (begin == 0 && target < arr.get(begin)) {
            System.out.println("i不存在");
            System.out.println("j = " + begin);
            System.exit(0);
        }
        if (target < arr.get(begin) && target > arr.get(begin - 1)) {
            System.out.println("i = " + (begin - 1));
            System.out.println("j = " + begin);
            System.exit(0);
        }
        if (end == arr.size() - 1 && target > arr.get(end)) {
            System.out.println("i = " + end);
            System.out.println("j不存在");
            System.exit(0);
        }
        if (target > arr.get(end) && target < arr.get(end + 1)) {
            System.out.println("i = " + end);
            System.out.println("j = " + (end + 1));
            System.exit(0);
        }
        if (target < arr.get(medmum)) {
            binarySearchRevision(target, arr, begin, medmum - 1);
        }
        if (target > arr.get(medmum)) {
            binarySearchRevision(target, arr, medmum + 1, end);
        }
    }
}
