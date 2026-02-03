import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int lastId = 0;
    private final List<WiseSaying> wiseSayings = new ArrayList<>();

    public int save(String content, String author) {
        lastId++;
        WiseSaying ws = new WiseSaying(lastId, content, author);
        wiseSayings.add(ws);
        return lastId;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying findById(int id) {
        for (WiseSaying ws : wiseSayings) {
            if (ws.getId() == id) {
                return ws;
            }
        }
        return null;
        /*//스트림
        return wiseSayings.stream()
                .filter(ws -> ws.getId() == id)
                .findFirst()
                .orElse(null);*/
    }

    public void remove(WiseSaying ws) {
        wiseSayings.remove(ws);
    }
}