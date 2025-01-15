package org.example.p1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long max = arr[K - 1];
        long min = 0;
        long mid = 0;

        while (min <= max) {
            long count = 0;
            mid = (max + min) / 2;

            for (int i = 0; i < K; i++) {
                count += (arr[i] / mid);
            }

            if(count < N)
                max = mid - 1;
            else
                min = mid + 1;
        }

        System.out.println(max);
    }
}
