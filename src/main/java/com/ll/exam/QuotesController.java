package com.ll.exam;

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
        Scanner sc = new Scanner(System.in);
        repo.listing();

    }
    int search(){
        Scanner sc = new Scanner(System.in);
        System.out.print("?id = ");
        String idQuote = sc.nextLine().trim();

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

    }
}
