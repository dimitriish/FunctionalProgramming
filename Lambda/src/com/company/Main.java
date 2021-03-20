package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(final String... args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        // число = сумма индекса и модификатора;
        int[] arr1 = getFilledArray(10, input, Integer::sum);
        System.out.println(Arrays.toString(arr1));

        // число = произведение индекса и модификатора;
        int[] arr2 = getFilledArray(10, input, (i, modifier) -> i * modifier);
        System.out.println(Arrays.toString(arr2));


        // число = для чётного индекса <(разделить на 2) плюс модификатор>,
        // для нечётного <(квадрат индекса) минус модификатор>
        int[] arr3 = getFilledArray(10, input, ((i, modifier) -> {
            if (i % 2 == 0) {
                return i / 2 + modifier;
            } else {
                return  i * i - modifier;
            }
        }));
        System.out.println(Arrays.toString(arr3));

        // число = модификатор в степени индекса
        int[] arr4 = getFilledArray(10, input, (i, modifier) -> (int) Math.pow(modifier, i));
        System.out.println(Arrays.toString(arr4));

        // число = модификатор * sin (индекс * pi/2)
        int[] arr5 = getFilledArray(10, input, (i, modifier) -> (int) (modifier * Math.sin(i * Math.PI / 2)));
        System.out.println(Arrays.toString(arr5));

        in.close();
    }

    static int[] getFilledArray(final int size, final int modifier, final Processable p) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = p.process(i, modifier);
        }
        return res;
    }
}