package p800;

import java.util.Arrays;
import java.util.Scanner;

public class B1538 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        int n = sc.nextInt();
        int[] a = read(n, sc);
        double sum = Arrays.stream(a).sum();
        double md = sum / n;
        double floor = Math.floor(md);

        if (floor != md) {
            System.out.println(-1);
            return;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > md) ans++;

        }

        System.out.println(ans);
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
