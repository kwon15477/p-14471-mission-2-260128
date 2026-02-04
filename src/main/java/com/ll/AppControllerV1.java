package com.ll;

import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppControllerV1 {
    Scanner sc = new Scanner(System.in);
    int lastId = 1;
    List<WiseSaying> wiseSayings = new ArrayList<>();

    public void run() {
        System.out.println("==명언 앱==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                System.out.println(lastId + "번 명언이 등록되었습니다.");

                WiseSaying ws = new WiseSaying(lastId, content, author);
                wiseSayings.add(ws);
                lastId++;
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (WiseSaying ws : wiseSayings.reversed()) {
                    System.out.println(ws.getId() + " / " + ws.getAuthor() + " / " + ws.getContent());
                }
            } else if (cmd.startsWith("삭제?id=")) {
                int id = Integer.parseInt(cmd.split("=")[1]);
                WiseSaying targetWiseSaying = null;

                for (WiseSaying ws : wiseSayings) {
                    if (ws.getId() == id) {
                        targetWiseSaying = ws;
                        break;
                    }
                }
                if (targetWiseSaying == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                } else {
                    wiseSayings.remove(targetWiseSaying);
                    System.out.println(id + "번의 명언이 삭제되었습니다");
                }


            } else if (cmd.startsWith("수정?id=")) {
                int id = Integer.parseInt(cmd.split("=")[1]);
                System.out.println("수정");
                WiseSaying targetWiseSaying = null;

                for (WiseSaying ws : wiseSayings) {
                    if (ws.getId() == id) {
                        targetWiseSaying = ws;
                        break;
                    }
                }
                if (targetWiseSaying == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                } else {
                    System.out.println("명언(기존) : " + targetWiseSaying.getContent());
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.println("작가(기존) : " + targetWiseSaying.getAuthor());
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    System.out.println(id + "번 명언이 수정되었습니다.");

                    targetWiseSaying.setContent(content);
                    targetWiseSaying.setAuthor(author);
                }

            } else {
                System.out.println("명령어가 잘못됐습니다");
            }
        }
    }
}