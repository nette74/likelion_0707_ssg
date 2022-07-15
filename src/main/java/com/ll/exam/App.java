package com.ll.exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void run() throws IOException {
        System.out.println("===명언 SSG==");
        //전역 선언부

        ArrayList<QuoteData> pseudoDB = new ArrayList<>(); // 지워야함.
        QuotesController controller = new QuotesController();


        //loadAndParsing();

        //String rawdata = FileIO.readFile();
        //System.out.println(rawdata);


        //int index = 1; //꼼수 , 가장 마지막 명언글의 번호

        //입력 루프
        controller.load();
        Scanner sc = new Scanner(System.in);
        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            switch (cmd) {
                case "등록":
                    controller.register();
                    break;

                case "목록":
                    controller.listing();
                    break;
                case "수정":
                    //edit();
                    controller.edit();
                    break;

                case "삭제":
                    //delete();
                    controller.delete();
                    break;

                case "빌드":
                    //build();, data.json 만들기
                   /*
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
                    break;
                    */
                    controller.build();
                    break;

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
