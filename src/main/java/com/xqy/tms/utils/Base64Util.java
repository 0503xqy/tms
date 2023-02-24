package com.xqy.tms.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Util {

    /**
     * 编码
     *
     * @param str 原始字符串
     * @return 编码后的字符串
     */
    public static String encode(String str) {
        byte[] encodedBytes = Base64.getEncoder().encode(str.getBytes(StandardCharsets.UTF_8));
        return new String(encodedBytes, StandardCharsets.UTF_8);
    }

    /**
     * 解码
     *
     * @param str 编码后的字符串
     * @return 原始字符串
     */
    public static String decode(String str) {
        byte[] decodedBytes = Base64.getDecoder().decode(str.getBytes(StandardCharsets.UTF_8));
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}
