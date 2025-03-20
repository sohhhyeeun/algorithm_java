package org.example.baekjoon.p1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int side = Math.min(N, M);
        while (side > 1) {
            for (int i = 0; i <= N - side; i++) {
                for (int j = 0; j <= M - side; j++) {
                    int num = map[i][j];
                    if(num == map[i][j + side - 1] && num == map[i + side - 1][j] && num == map[i + side - 1][j + side - 1]) {
                        System.out.println(side * side);
                        return;
                    }
                }
            }

            side--;
        }

        System.out.println(side * side);
    }
}
