package org.example.programmers.p389479;

import java.util.PriorityQueue;

//그리디
public class Main {
    public int main(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //서버 종료 시간 관리
        int server = 1;
        
        //PriorityQueue: 우선순위가 낮은 숫자 먼저 반환(작은 수)

        for (int time = 0; time < 24; time++) {
            int player = players[time];

            //pq에 종료된 서버가 존재하거나 서버의 종료 시간이 현재 시간보다 이전이거나 같은 경우
            while (!pq.isEmpty() && pq.peek() <= time) {
                server--; //종료된 서버 수 감소
                pq.poll(); // 종료된 서버 제거

                //poll(): pq의 첫번째 값 반환 후 제거, 비어있는 경우 null 반환
            }

            int remainder = player - (server * m);

//            if (remainder < 0) {
//                continue;
//            }

            while (remainder >= 0) {
                answer++;
                server++; // 서버 수 증가
                pq.add(time + k); //k시간 이후 서버 반납
                remainder -= m; //한대의 서버 추가, m명의 사람 처리
            }
        }

        return answer;
    }
}
