package com.tricentis.demowebshop.utilities;

import java.util.Random;

public class RandomUtil {

    private static final String ALPHANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final Random random;

    public RandomUtil() {
        random = new Random();
    }

    public String getRandomString(int stringLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(ALPHANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALPHANUMERICAL_ALL_CAPS.length())));
        }
        return stringBuilder.toString();
    }

    public int getRandomNumberInBorder(int max) {
        return random.nextInt(max);
    }
}
