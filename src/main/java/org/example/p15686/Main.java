package org.example.p15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    home.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chicken.size()];
        backTracking(0, 0);
        System.out.println(result);
    }

    private static void backTracking(int start, int count) {
        if (count == M) {
            int res = 0;

            for (int i = 0; i < home.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int dist = Math.abs(home.get(i)[0] - chicken.get(j)[0]) + Math.abs(home.get(i)[1] - chicken.get(j)[1]);
                        tmp = Math.min(tmp, dist);
                    }
                }

                res += tmp;
            }

            result = Math.min(result, res);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            backTracking(i + 1, count + 1);
            visited[i] = false;
        }
    }
}
