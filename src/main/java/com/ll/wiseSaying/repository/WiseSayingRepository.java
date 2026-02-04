package com.ll.wiseSaying.repository;

import com.ll.wiseSaying.entity.WiseSaying;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int lastId = 0;
    private final List<WiseSaying> wiseSayings = new ArrayList<>();

    public int save(WiseSaying ws) {

        if (ws.getId() == 0) {
            lastId++;
            ws.setId(lastId);
            wiseSayings.add(ws);
            ws.setCreateDate(LocalDateTime.now());
            ws.setModifyDate(LocalDateTime.now());
        } else {
            ws.setModifyDate(LocalDateTime.now());
        }

        return ws.getId();
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying findById(int id) {
        /*for (com.ll.wiseSaying.entity.WiseSaying ws : wiseSayings) {
            if (ws.getId() == id) {
                return ws;
            }
        }
        return null;*/
        //스트림
        return wiseSayings.stream()
                .filter(ws -> ws.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void remove(WiseSaying ws) {
        wiseSayings.remove(ws);
    }
}