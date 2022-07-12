package com.ll.exam;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {

    static void Load()
    {
        //Json 읽어서 파싱해서
        //array에 저장




    }
    public static void main(String[] args) throws IOException {

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

        //TODO
        //com.ll.exam.Rq 클래스 도입
        //프로그램 시작시 Json 에서 Load();

        //run();
        System.out.println("===명언 SSG==");
        //전역 선언부
        Scanner sc = new Scanner(System.in);
        ArrayList<QuoteData> pseudoDB = new ArrayList<>();


        //loadParsing();
        String rawdata = FileIO.readFile();



        System.out.println(rawdata);



        int index = 1; //꼼수 , 가장 마지막 명언글의 번호
        //이거 어떻게 함? 이것때문에 해시맵으로 바꿔야 할까..

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
                    pseudoDB.add(new QuoteData(cmdQuote,cmdName,index++));
                    break;

                case "목록":
                    //listed();
                    for(QuoteData el : pseudoDB){
                        el.print();
                    }
                    break;

                case "수정":
                    //edit();
                    System.out.print("?id = ");
                    String idQuote1 = sc.nextLine().trim();
                    //search();
                    QuoteData target=null;
                    for(QuoteData el : pseudoDB){
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
                    target.quote = idQuote1;
                    System.out.println("수정후 명언 : "+target.quote);
                    break;

                case "삭제":
                    //delete();
                    boolean deleteDone = false;
                    System.out.print("?id = ");
                    String idQuote2 = sc.nextLine().trim();
                    for(QuoteData el : pseudoDB){
                        if(el.index == Integer.parseInt(idQuote2))
                        {
                            System.out.println(el.index + "번 명언을 삭제합니다.");
                            pseudoDB.remove(el);
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
                    String jsonData="";
                    jsonData=jsonData+"["+System.lineSeparator();
                    for(QuoteData el: pseudoDB){
                        jsonData=jsonData+el.toJson();
                        jsonData=jsonData+","+System.lineSeparator();
                    }
                    jsonData = jsonData.substring(0, jsonData.length()-3);
                    jsonData = jsonData+System.lineSeparator()+"]";

                    System.out.println(jsonData);
                    FileIO.writeFile(jsonData);


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
        return "com.ll.exam.QuoteData{" +
                "quote='" + quote + '\'' +
                ", name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
    public String toJson(){
        return "{" + System.lineSeparator() +
                "\"id\":"+index+","+System.lineSeparator() +
                "\"content\":"+"\""+quote+"\""+","+System.lineSeparator() +
                "\"author\":"+"\""+name+"\""+System.lineSeparator() +
                "}"
                ;
    }

}

class FileIO{
    static void writeFile(String data){
        try{
            Path path = Paths.get("data.json");
            Files.write(path, data.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    static String readFile()throws IOException{

        Path path = Paths.get("data.json");
        List<String> lines = Files.readAllLines(path);
        String s = "";
        for (String line : lines) {
            s += line + "\n";
        }


        return s;
    }
}