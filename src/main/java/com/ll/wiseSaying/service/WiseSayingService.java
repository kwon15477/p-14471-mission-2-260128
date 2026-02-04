package com.ll.wiseSaying.service;

import com.ll.wiseSaying.entity.WiseSaying;
import com.ll.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public int write(String content, String author) {
        WiseSaying ws = new WiseSaying(0, content, author);
        return wiseSayingRepository.save(ws);
    }

    public boolean delete(int id) {
        WiseSaying ws = wiseSayingRepository.findById(id);
        if (ws == null) return false;

        wiseSayingRepository.remove(ws);
        return true;
    }

    public void modify(WiseSaying ws, String content, String author) {
        ws.setContent(content);
        ws.setAuthor(author);
        wiseSayingRepository.save(ws);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }
}