package q7033;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // 차량 수 입력
        int[] car = new int[num]; // 차량 속도를 저장할 배열
        int speed = sc.nextInt(); // 기준 속도 입력

        // 차량 속도 입력
        for (int i = 0; i < num; i++) {
            car[i] = sc.nextInt();
        }

        // 기준 속도를 초과하는 모든 차량의 인덱스를 출력
        boolean found = false;
        for (int i = 0; i < num; i++) {
            if (car[i] < (speed + 5)) {
                System.out.println(i + 1); // 인덱스는 1부터 시작
                found = true;
            }
        }

        // 해당하는 차량이 없는 경우
        if (!found) {
            System.out.println("No car exceeded the speed limit.");
        }

        sc.close();
    }
}
