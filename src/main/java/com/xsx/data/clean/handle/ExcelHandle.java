package com.xsx.data.clean.handle;

import cn.hutool.core.util.StrUtil;
import com.xsx.data.clean.bean.CommonValueBean;
import com.xsx.data.clean.util.LetterToNumUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @Author BKGin
 * @Email libra14xu@gmail.com
 * @Date 2023-02-20
 */
public class ExcelHandle {

    public static void readExcelDataHandle(String fileName, Integer startRowNum, List<CommonValueBean> values) {
        File source = new File(fileName);
        String suffix = StrUtil.split(source.getName(), ".").get(1);

        XSSFWorkbook outWorkbook = new XSSFWorkbook();
        XSSFSheet outSheet = outWorkbook.createSheet();
        XSSFRow outRow = outSheet.createRow(0);
        for (CommonValueBean bean : values) {
            outRow.createCell(LetterToNumUtil.calcLetterToNum(bean.getTarget())).setCellValue(bean.getName());
        }
        try {
            if ("xls".equals(suffix)) {
                HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(source));
                HSSFSheet sheet = workbook.getSheetAt(0);
                int lastRowNum = sheet.getLastRowNum();
                for (int i = startRowNum + 1; i < lastRowNum; i++) {
                    HSSFRow row = sheet.getRow(i);
                    XSSFRow outRow_ = outSheet.createRow(i - startRowNum);
                    for (CommonValueBean bean : values) {
                        String cellValue = MathCalculateHandle.HSSFCellCalculate(bean.getSource(), row);
                        outRow_.createCell(LetterToNumUtil.calcLetterToNum(bean.getTarget())).setCellValue(cellValue);
                    }
                }
            } else if ("xlsx".equals(suffix)) {
                XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(source));
                XSSFSheet sheet = workbook.getSheetAt(0);
                int lastRowNum = sheet.getLastRowNum();
                for (int i = startRowNum + 1; i < lastRowNum; i++) {
                    XSSFRow row = sheet.getRow(i);
                    XSSFRow outRow_ = outSheet.createRow(i - startRowNum);
                    for (CommonValueBean bean : values) {
                        String cellValue = MathCalculateHandle.XSSFCellCalculate(bean.getSource(), row);
                        outRow_.createCell(LetterToNumUtil.calcLetterToNum(bean.getTarget())).setCellValue(cellValue);
                    }
                }
            }
            // 文件输出
            FileOutputStream fos = new FileOutputStream(fileName.replace("." + suffix, "_" + System.currentTimeMillis() + ".xlsx"));
            outWorkbook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
