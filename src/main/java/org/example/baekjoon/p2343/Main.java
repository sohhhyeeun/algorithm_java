package org.example.baekjoon.p2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]); //블루레이 최소 크기 = 가장 긴 강의
            right += arr[i]; //블루레이 최대 크기 = 모든 강의 길이의 합
        }

        int result = binarySearch(arr, M, left, right);

        System.out.println(result);
    }

    private static int binarySearch(int[] arr, int M, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 1;
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if (sum + arr[i] > mid) {
                    sum = arr[i];
                    count++;
                } else {
                    sum += arr[i];
                }
            }

            if (count > M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
