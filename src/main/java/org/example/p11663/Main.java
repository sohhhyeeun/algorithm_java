package org.example.p11663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int lower = lowerBinarySearch(arr, start);
            int upper = upperBinarySearch(arr, end);

            sb.append(upper - lower).append("\n");
        }

        System.out.println(sb);
    }

    private static int lowerBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private static int upperBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}
