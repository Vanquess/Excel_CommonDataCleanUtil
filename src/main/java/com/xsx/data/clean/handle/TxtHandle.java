package com.xsx.data.clean.handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @Author BKGin
 * @Email libra14xu@gmail.com
 * @Date 2023-02-20
 */
public class TxtHandle {

    public static String readTxtDataHandle(String filePath) {
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = null;
            // 使用readLine方法，一次读一行
            while ((str = reader.readLine()) != null) {
                stringBuilder.append(System.lineSeparator() + str);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
