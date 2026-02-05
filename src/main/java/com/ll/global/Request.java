package com.ll.global;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Request {
    private final String action;
    private int id = -1;
    private Map<String, String> paramMap;

    public Request(String cmd) {
        paramMap = new HashMap<>();
        String[] cmdBits = cmd.split("\\?", 2);
        this.action = cmdBits[0];

        String parmas = cmdBits.length > 1 ? cmdBits[1] : "";
        String[] paramsBits = parmas.split("&");
        //스트림
        this.paramMap = Arrays.stream(paramsBits)
                .map((param) -> param.split("=", 2))
                .filter((paramBits) -> paramBits.length == 2
                        && paramBits != null && paramBits[1] != null)
                .collect(Collectors.toMap(
                        bits -> bits[0],
                        bits -> bits[1]
                ));

        /*for (String param : paramsBits) {
            String[] paramBits = param.split("=", 2);
            String key = paramBits[0];
            String value = paramBits.length > 1 ? paramBits[1] : "";

            paraMap.put(key, value);
        }*/
    }

    public String getParam(String key, String defaultValue) {
        if (paramMap.containsKey(key)) {
            return paramMap.get(key);
        }
        return defaultValue;
    }

    public int getParamAsInt(String key, int defaultValue) {

        try {
            return Integer.parseInt(paramMap.get(key));
        } catch (NumberFormatException e) {
            return defaultValue;
        }

    }

    public String getAction() {
        return action;
    }

    public int getId() {
        return id;
    }
}