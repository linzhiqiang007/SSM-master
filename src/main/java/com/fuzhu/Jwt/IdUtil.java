package com.fuzhu.Jwt;

import java.util.Random;

public class IdUtil {
    public static String simpleUUID() {
        Random random = new Random();
        int i = random.nextInt(12);
        return String.valueOf(i);
    }
}
