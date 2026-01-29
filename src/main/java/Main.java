import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lastId = 1;
        List<WiseSaying> wiseSayings = new ArrayList<>();


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
                for (int i = 0; i < wiseSayings.size(); i++) {
                    WiseSaying ws = wiseSayings.get(i);
                    System.out.println(ws.id + " / " + ws.author + " / " + ws.content);
                }
            }
        }
    }
}
