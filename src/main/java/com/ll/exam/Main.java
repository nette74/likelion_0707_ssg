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
        //array 에 저장


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
        App.run();
    }

}

