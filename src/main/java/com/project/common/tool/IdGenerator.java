package com.project.common.tool;

import org.springframework.util.AlternativeJdkIdGenerator;

import java.util.Random;
import java.util.UUID;

public class IdGenerator {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static Long getKey() {
        Random rand = new Random();
        String key = "" + System.currentTimeMillis() + Math.abs(rand.nextInt(1000000));
        return Long.parseLong(key);
    }

    public static Long ids(){
        org.springframework.util.IdGenerator generator =new AlternativeJdkIdGenerator();
        UUID uuid = generator.generateId();
        return uuid.getMostSignificantBits();
    }

}
