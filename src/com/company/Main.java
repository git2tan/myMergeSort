package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{7,8,6,3,5,4,100,2,1};
        SortUnsorted(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    /*
    * принимает ссылку на массив и индекс верхней и нижней границы для диапазона
    * */
    private static void SortUnsorted(int[] a, int lo, int hi) {

        if (hi <= lo)       //если верхняя граница меньше или совпала с нижней
            return;         //выходим из метода т.к. мы разбили до одного массива
        int mid = lo + (hi - lo) / 2;   //середина = нижняя граница + половина от этих границ
        SortUnsorted(a, lo, mid);       //рекурсинво вызываем метод для диапазона от нижней границы до середины
        SortUnsorted(a,(mid+1),hi);     //рекурсивно вызываем метод для диапазона от середины до верхней границы


        int[] buf = Arrays.copyOf(a, a.length); //заводим буфер для хранения

        for (int k = lo; k <= hi; k++)
            buf[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
    }

}
