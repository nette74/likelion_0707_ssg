import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //영속성,DB 금지,파일 사용 가능
        //JSON 형식 추천
        //run();
        System.out.println("===명언 SSG==");

        Scanner sc = new Scanner(System.in);

        ArrayList<QuoteData> psudoDB = new ArrayList<>();
        int index = 0; //꼼수


        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            switch (cmd) {
                case "등록":
                    //register();
                    System.out.print("명언을 입력하세요 :");
                    String cmd2 = sc.nextLine().trim();
                    System.out.print("작가를 입력하세요 :");
                    String cmd3 = sc.nextLine().trim();

                    psudoDB.add(new QuoteData(cmd2,cmd3,++index));
                    break;
                case "목록":
                    //listup();
                    for(QuoteData el : psudoDB){
                        el.print();
                    }
                    System.out.println("목록출력");

                    break;
                case "수정":
                    System.out.println("수정합니다");
                    break;
                case "삭제":
                    System.out.println("삭제합니다");
                    break;
                case "종료":
                    System.out.println("종료합니다");
                    break outer;
            }
        }
        sc.close();
    }
}
class QuoteData{
    String quote;
    String name;
    int index;
    QuoteData(String q, String n,int i){
        quote=q;
        name=n;
        index=i;
    }
    void print()
    {
        System.out.println("---------------------------------");
        System.out.println("번호 : "+ Integer.toString(index));
        System.out.println("명언 : "+ quote);
        System.out.println("작가 : "+ name);

    }
}