package com.ll.wiseSaying.controller;

import com.ll.Request;
import com.ll.wiseSaying.entity.WiseSaying;
import com.ll.wiseSaying.service.WiseSayingService;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc = new Scanner(System.in);
    private final WiseSayingService wiseSayingService = new WiseSayingService();

    public void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        int id = wiseSayingService.write(content, author);
        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언 / 작성일 / 수정일");
        System.out.println("----------------------");

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 H시 mm분 ss초");
        List<WiseSaying> wiseSayings = wiseSayingService.findAll();
        for (WiseSaying ws : wiseSayings.reversed()) {
            System.out.println(ws.getId() + " / " + ws.getAuthor() + " / " + ws.getContent()
                    + " / " + ws.getCreateDate().format(formatter) + " / " + ws.getModifyDate().format(formatter));
        }
    }

    public void actionDelete(Request request) {
        int id = request.getParamAsInt("id", -1);

        if (id == -1) {
            System.out.println("id를 올바르게 입력해주세요.");
            return;
        }

        boolean result = wiseSayingService.delete(id);
        if (!result) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.println(id + "번의 명언이 삭제되었습니다");

    }

    public void actionModify(Request request) {
        int id = request.getParamAsInt("id", -1);

        if (id == -1) {
            System.out.println("id를 올바르게 입력해주세요.");
            return;
        }

        WiseSaying ws = wiseSayingService.findById(id);

        if (ws == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println("명언(기존) : " + ws.getContent());
            System.out.print("명언 : ");
            String content = sc.nextLine();

            System.out.println("작가(기존) : " + ws.getAuthor());
            System.out.print("작가 : ");
            String author = sc.nextLine();
            wiseSayingService.modify(ws, content, author);
            System.out.println(id + "번 명언이 수정되었습니다.");
        }
    }
}
