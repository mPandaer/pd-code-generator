package com.pandaer;

import java.util.Scanner;

/**
 * 给定数的和
 * @Author pandaer
 */
public class AcmTemplate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            // 读取长度
            int len = sc.nextInt();
            // 读取数字到数组中
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                int num = sc.nextInt();
                arr[i] = num;
            }
            // 计算和
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += arr[i];
            }
            System.out.println("xixi(有循环): " + sum);


    }
}
