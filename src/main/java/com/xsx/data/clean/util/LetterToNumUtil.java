package com.xsx.data.clean.util;

import javax.annotation.Resource;

/**
 * @Author BKGin
 * @Email xushengxing@gmail.com
 * @Date 2023-02-20
 */
@Resource
public class LetterToNumUtil {

    public static int calcLetterToNum(String letter) {
        // 当为A-Z列时，由ASCII码减65即可，即 A - 65
        if (letter.length() == 1) {
            return letter.charAt(0) - 65;
        }
        // 当大于Z列时，为阶乘 (A - 64)*26^n!
        return (letter.charAt(0) - 64) * (int) Math.pow(26, letter.length() - 1) + calcLetterToNum(letter.substring(1));
    }
}
