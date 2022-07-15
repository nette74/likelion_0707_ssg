package com.ll.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QuotesRepository {
    ArrayList<QuoteData> pseudoDB = new ArrayList<>();
    int lastIndex =1;
    void firsrLoad(){}

    void add(String quote,String name){
        pseudoDB.add(new QuoteData(quote,name, lastIndex++));

    }
    void listing(){
        for(QuoteData el : pseudoDB){
            el.print();
        }
    }
    void edit(int index) {

        QuoteData target = searchByIndex(index);
        System.out.println("수정전 명언 : "+target.quote);
        System.out.print("명언을 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        String newQuote = sc.nextLine().trim();
        target.quote = newQuote;
        System.out.println("수정후 명언 : "+target.quote);

        return;
    }
    void delete(int index){
        QuoteData target = searchByIndex(index);
        pseudoDB.remove(target);
        return;
    }
    QuoteData searchByIndex(int index)
    {
        QuoteData target = null;
        for (QuoteData el : pseudoDB) {
            if (el.index == index) {
                target = el;
                break;
            }
        }
        if(target == null) {
            System.out.println("id가 잘못 입력되었습니다.");
            return null;
        }
        return target;
    }
    //전부 저장하기.
    void saveAllToFile(){
        Util.file.mkdir("data");
        for (QuoteData el : pseudoDB) {
            Util.file.saveToFile("data/" +el.index+".json" , el.toJson());
            System.out.println(":: data/" +el.index+".json" + " 이 생성되었습니다.");
        }
    }
    //큰 data.json 생성
    void buildTotalFile(){


    }

    //파일을 훑어서 맵을 반환.
    ArrayList<Map> loadAllFromFile(){
        ArrayList<Map> loadedData = new ArrayList<>();
        List<String> fileNames = Util.file.getFileNamesFromDir("data");
        for(String eachPath : fileNames) {
            loadedData.add( Util.json.jsonToMapFromFile(eachPath));
            //if(lastIndex< loadedData.set(loadedData.size()-1, ))
            //lastindex 수를 늘려줘야 함.

        }
        return null;
    }
    void mapToDB(){

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
    static String pathOfFile="data.json";
    static void writeFile(String data){
        try{
            Path path = Paths.get(pathOfFile);
            Files.write(path, data.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    static String readFile()throws IOException{

        Path path = Paths.get(pathOfFile);
        List<String> lines = Files.readAllLines(path);
        String s = "";
        for (String line : lines) {
            s += line + "\n";
        }


        return s;
    }
}