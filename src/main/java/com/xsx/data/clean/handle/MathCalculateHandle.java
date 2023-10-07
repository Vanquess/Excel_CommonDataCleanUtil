package com.xsx.data.clean.handle;

import cn.hutool.core.util.StrUtil;
import com.xsx.data.clean.util.LetterToNumUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @Author BKGin
 * @Email libra14xu@gmail.com
 * @Date 2023-02-22
 */
public class MathCalculateHandle {

    public static String HSSFCellCalculate(String expression, HSSFRow row) {
        // 去除符号，以','替换
        String expression_ = expression.replaceAll(" |\\(|\\)|\\+|\\-|\\*|\\/", ",");
        Set<String> letterList = new HashSet<>(StrUtil.split(expression_, ','));
        for (String letter : letterList) {
            // 判断为空，不计算
            if (StrUtil.isNotEmpty(letter)) {
                // 获取当前格值
                HSSFCell cell = row.getCell(LetterToNumUtil.calcLetterToNum(letter));
                //设置单元格类型
                cell.setCellType(CellType.STRING);
                String cellValue = (cell != null && StrUtil.isNotEmpty(cell.getStringCellValue())) ? cell.getStringCellValue() : "";
                // 替换
                expression = expression.replace(letter, cellValue);
            }
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        if (pattern.matcher(expression.replaceAll(" |\\(|\\)|\\+|\\-|\\*|\\/|\\,|\\.", "")).matches()) {
            // 纯数字字符串
            // 计算
            ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
            try {
                return String.valueOf(scriptEngine.eval(expression));
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
        return expression;
    }

    public static String XSSFCellCalculate(String expression, XSSFRow row) {
        // 去除符号，以','替换
        String expression_ = expression.replaceAll(" |\\(|\\)|\\+|\\-|\\*|\\/", ",");
        Set<String> letterList = new HashSet<>(StrUtil.split(expression_, ','));
        for (String letter : letterList) {
            // 判断为空，不计算
            if (StrUtil.isNotEmpty(letter)) {
                // 获取当前格值
                XSSFCell cell = row.getCell(LetterToNumUtil.calcLetterToNum(letter));
                //设置单元格类型
                cell.setCellType(CellType.STRING);
                String cellValue = (cell != null && StrUtil.isNotEmpty(cell.getStringCellValue())) ? cell.getStringCellValue() : "";
                // 替换
                expression = expression.replace(letter, cellValue);
            }
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        if (pattern.matcher(expression.replaceAll(" |\\(|\\)|\\+|\\-|\\*|\\/|\\,|\\.", "")).matches()) {
            // 纯数字字符串
            // 计算
            ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
            try {
                return String.valueOf(scriptEngine.eval(expression));
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
        return expression;
    }

}
