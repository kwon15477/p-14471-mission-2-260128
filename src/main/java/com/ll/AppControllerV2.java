package com.ll;

import com.ll.global.AppContext;
import com.ll.global.Request;
import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class AppControllerV2 {
    private final Scanner sc = new Scanner(System.in);
    private SystemController systemController = AppContext.systemController;
    private WiseSayingController wiseSayingController = AppContext.wiseSayingController;

    public void run() {
        System.out.println("==명언 앱==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            Request request = new Request(cmd);

            if (request.getAction().equals("종료")) {
                systemController.exit();
                break;
            } else if (request.getAction().equals("등록")) {
                wiseSayingController.actionWrite();
            } else if (request.getAction().equals("목록")) {
                wiseSayingController.actionList();
            } else if (request.getAction().equals("삭제")) {
                wiseSayingController.actionDelete(request);
            } else if (request.getAction().equals("수정")) {
                wiseSayingController.actionModify(request);
            } else {
                System.out.println("명령어가 잘못됐습니다");
            }
        }
    }


}