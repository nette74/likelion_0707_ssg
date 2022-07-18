package com.ll.exam;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class QuotesController {
    QuotesRepository repo = new QuotesRepository();
    void register(){
        Scanner sc = new Scanner(System.in);
        System.out.print("명언을 입력하세요 :");
        String cmdQuote = sc.nextLine().trim();
        System.out.print("작가를 입력하세요 :");
        String cmdName = sc.nextLine().trim();
        repo.add(cmdQuote,cmdName);

    }
    void listing(){
        repo.listing();
    }
    int search(){
        //search() 레포에 있어야 할 것 같은데.
        Scanner sc = new Scanner(System.in);
        System.out.print("?id = ");
        String idQuote = sc.nextLine().trim();
        // rq 로 나누면 좋지만 일단 진행.


        return Integer.parseInt(idQuote);

    }

    void edit(){
        int id = search();
        repo.edit(id);
    }
    void delete(){
        int id = search();
        repo.delete(id);
    }
    void build(){
        repo.saveAllToFile();
    }
    void load(){
        ArrayList<Map> tempDatum = repo.loadAllFromFile();
        repo.mapToDB(tempDatum);
        //파일 불러오는 코드.
    }

}
