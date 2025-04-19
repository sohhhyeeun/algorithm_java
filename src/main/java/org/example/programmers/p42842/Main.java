package org.example.programmers.p42842;

import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        int brown = 24;
        int yellow = 24;

        solution(brown, yellow);
    }

    public static int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int heightY = 1; heightY <= Math.sqrt(yellow); heightY++) {
            if (yellow % heightY == 0) {
                int widthY = yellow / heightY;

                int widthB = widthY + 2;
                int heightB = heightY + 2;

                if (widthB * heightB == total)
                    return new int[]{widthB, heightB};
            }
        }

        return new int[]{};
    }
}
