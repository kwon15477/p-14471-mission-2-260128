package com.ll.global;

import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;
import com.ll.wiseSaying.repository.WiseSayingRepository;
import com.ll.wiseSaying.service.WiseSayingService;

public class AppContext {
    public static final WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    public static final WiseSayingService wiseSayingService = new WiseSayingService();
    public static final WiseSayingController wiseSayingController = new WiseSayingController();
    public static final SystemController systemController = new SystemController();


}
