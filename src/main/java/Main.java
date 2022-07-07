import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //run();
        System.out.println("===명언 SSG==");
        Scanner sc = new Scanner(System.in);

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            switch (cmd) {
                case "등록":

                case "목록":

                case "수정":

                case "삭제":

                case "종료":

                    break outer;
            }
        }
        sc.close();
    }
}