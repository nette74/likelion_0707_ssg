import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //영속성,DB 금지,파일 사용 가능
        //JSON 형식 추천
        //https://github.com/nette74/likelion_0707_ssg

        //https://wiken.io/ken/8069
        //https://wiken.io/ken/8112
        //https://github.com/jhs512/java_ssg_2022_07_07

        /*
        == 명언 SSG ==
        명령) 등록
        명언 : 현재를 사랑하라.
        작가 : 작자미상
        1번 명언이 등록되었습니다.
                명령) 등록
        명언 : 과거에 집착하지 마라.
                작가 : 작자미상
        2번 명언이 등록되었습니다.
                명령) 목록
        번호 / 작가 / 명언
                ----------------------
        2 / 작자미상 / 과거에 집착하지 마라.
        1 / 작자미상 / 현재를 사랑하라.
                명령) 삭제?id=1
        1번 명언이 삭제되었습니다.
                명령) 삭제?id=1
        1번 명언은 존재하지 않습니다.
        명령) 수정?id=2
        2번 명언을 수정합니다.
                기존 명언 : 과거에 집착하지 마라.
                새 명언 : 미래와 과거에 집착하지 마라.
        2번 명언이 수정되었습니다.
                명령) 목록
        번호 / 작가 / 명언
                ----------------------
        2 / 작자미상 / 미래와 과거에 집착하지 마라.
        */


        //Rq 클래스 도입

        //run();
        System.out.println("===명언 SSG==");
        //전역 선언부
        Scanner sc = new Scanner(System.in);
        ArrayList<QuoteData> psudoDB = new ArrayList<>();
        int index = 1; //꼼수 , 가장 마지막 명언글의 번호

        //입력 루프
        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            switch (cmd) {
                case "등록":
                    //register();
                    System.out.print("명언을 입력하세요 :");
                    String cmdQuote = sc.nextLine().trim();
                    System.out.print("작가를 입력하세요 :");
                    String cmdName = sc.nextLine().trim();
                    psudoDB.add(new QuoteData(cmdQuote,cmdName,index++));
                    break;

                case "목록":
                    //listed();
                    for(QuoteData el : psudoDB){
                        el.print();
                    }
                    break;

                case "수정":
                    //edit();
                    System.out.print("?id = ");
                    String idQuote1 = sc.nextLine().trim();
                    //search();
                    QuoteData target=null;
                    for(QuoteData el : psudoDB){
                        if(el.index == Integer.parseInt(idQuote1)) {
                            target = el;
                            break;
                        }
                    }
                    if(target == null) {
                        System.out.println("id가 잘못 입력되었습니다.");
                        break;
                    }
                    System.out.println("수정전 명언 : "+target.quote);
                    System.out.print("명언을 입력하세요 : ");
                    idQuote1 = sc.nextLine().trim();
                    target.edit(idQuote1);
                    System.out.println("수정후 명언 : "+target.quote);
                    break;

                case "삭제":
                    //delete();
                    boolean deleteDone = false;
                    System.out.print("?id = ");
                    String idQuote2 = sc.nextLine().trim();
                    for(QuoteData el : psudoDB){
                        if(el.index == Integer.parseInt(idQuote2))
                        {
                            System.out.println(el.index + "번 명언을 삭제합니다.");
                            psudoDB.remove(el);
                            deleteDone=true;
                            break;
                        }
                    }
                    if(deleteDone=false)
                        System.out.println(idQuote2+"번 명언은 존재하지 않습니다. ");

                    //수정과 삭제 방식 통일할 것..
                    break;

                case "빌드":
                    //build();, data.json 만들기
                    String JsonData="";
                    JsonData=JsonData+"["+System.lineSeparator();
                    for(QuoteData el: psudoDB){
                        JsonData=JsonData+el.toJson();
                        JsonData=JsonData+","+System.lineSeparator();
                    }
                    JsonData = JsonData.substring(0, JsonData.length()-2);
                    JsonData = JsonData+System.lineSeparator()+"]";
                    System.out.println(JsonData);


                case "종료":
                    //quit();
                    System.out.println("종료합니다");
                    break outer;
            }
        }
        // outer: block ends.
        sc.close();
    }
}

class QuoteData{
    String quote;
    private String name;
    int index;
    QuoteData(String q, String n,int i){
        quote=q;
        name=n;
        index=i;
    }

    public void print()
    {
        System.out.println("---------------------------------");
        System.out.println("번호 : "+ Integer.toString(index));
        System.out.println("명언 : "+ quote);
        System.out.println("작가 : "+ name);

    }
    public void print2()
    {
        System.out.println("---------------------------------");
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "QuoteData{" +
                "quote='" + quote + '\'' +
                ", name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
    public String toJson(){
        return "{" + System.lineSeparator() +
                "\"id\":"+index+","+System.lineSeparator() +
                "\"content\":"+"\""+quote+"\""+","+System.lineSeparator() +
                "\"author\":"+"\""+name+"\""+","+System.lineSeparator() +
                "}"
                ;
    }

    public void edit(String q, String n){
        quote=q;
        name=n;
    }
    public void edit(String q){
        quote=q;
    }

}