package org.example.programmers.p42839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static HashSet<Integer> numCombi = new HashSet<>(); //HashSet: 중복 허용 X, 순서 X
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        int answer = 0;
        visited = new boolean[numbers.length()];

        permutation("", numbers);

        for (int num: numCombi) {
            if (isPrime(num)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void permutation(String current, String numbers) {
        if (!current.equals("")) { //공백이 아닌 경우
            numCombi.add(Integer.parseInt(current)); //Integer.parseInt(): String TO int, 문자열 앞자리의 0 자동 무시
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(current + numbers.charAt(i), numbers);
                visited[i] = false; //backtracking
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
