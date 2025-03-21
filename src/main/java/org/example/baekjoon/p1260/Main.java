package org.example.baekjoon.p1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1; //양방향 간선
        }

        visited = new boolean[N + 1];
        DFS(V);

        visited = new boolean[N + 1];
        BFS(V);
    }

    public static void DFS(int start) {
        visited[start] = true;
        System.out.println(start + " ");

        for(int i = 1; i < graph.length ; i++) {
            if(graph[start][i] == 1 && visited[i] == false)
                DFS(i);
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        System.out.println(start + " ");

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 1; i < graph.length; i++) {
                if (graph[node][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.println(i + " ");
                }
            }
        }
    }
}
