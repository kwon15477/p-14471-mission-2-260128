import java.util.List;
import java.util.Scanner;

public class AppControllerV2 {
    private final Scanner sc = new Scanner(System.in);
    private final WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public void run() {
        System.out.println("==명언 앱==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            Request request = new Request(cmd);

            if (request.getAction().equals("종료")) {
                break;
            } else if (request.getAction().equals("등록")) {
                actionWrite();
            } else if (request.getAction().equals("목록")) {
                actionList();
            } else if (request.getAction().equals("삭제")) {
                actionDelete(request);
            } else if (request.getAction().equals("수정")) {
                actionModify(request);
            } else {
                System.out.println("명령어가 잘못됐습니다");
            }
        }
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        int id = wiseSayingRepository.save(content, author);
        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();
        for (WiseSaying ws : wiseSayings.reversed()) {
            System.out.println(ws.getId() + " / " + ws.getAuthor() + " / " + ws.getContent());
        }
    }

    private void actionDelete(Request request) {
        int id = request.getId();
        if (id == -1) {
            System.out.println("id를 올바르게 입력해주세요.");
            return;
        }

        WiseSaying ws = wiseSayingRepository.findById(id);

        if (ws == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        } else {
            wiseSayingRepository.remove(ws);
            System.out.println(id + "번의 명언이 삭제되었습니다");
        }
    }

    private void actionModify(Request request) {
        int id = request.getId();
        if (id == -1) {
            System.out.println("id를 올바르게 입력해주세요.");
            return;
        }

        WiseSaying ws = wiseSayingRepository.findById(id);

        if (ws == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println("명언(기존) : " + ws.getContent());
            System.out.print("명언 : ");
            ws.setContent(sc.nextLine());

            System.out.println("작가(기존) : " + ws.getAuthor());
            System.out.print("작가 : ");
            ws.setAuthor(sc.nextLine());

            System.out.println(id + "번 명언이 수정되었습니다.");
        }
    }
}