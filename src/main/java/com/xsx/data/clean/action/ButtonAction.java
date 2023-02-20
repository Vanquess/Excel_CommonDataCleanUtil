package com.xsx.data.clean.action;

import cn.hutool.json.JSONUtil;
import com.xsx.data.clean.bean.CommonBean;
import com.xsx.data.clean.handle.ExcelHandle;
import com.xsx.data.clean.handle.TxtHandle;
import com.xsx.data.clean.jframe.MainForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author BKGin
 * @Email xushengxing@gmail.com
 * @Date 2023-02-20
 */
public class ButtonAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(MainForm.confirmButton)) {
            // 确定
            String templateFilePath = MainForm.templateFile.getText();
            String sourceFilePath = MainForm.sourceFile.getText();
            // 获取模板内容
            String templateFileDate = TxtHandle.readTxtDataHandle(templateFilePath);
            CommonBean commonBean = JSONUtil.toBean(templateFileDate, CommonBean.class);
            // 数据清洗
            ExcelHandle.readExcelDataHandle(sourceFilePath, commonBean.getLabelLine(), commonBean.getValues());
            // 清洗完毕弹框
            JOptionPane.showMessageDialog(MainForm.confirmButton, "清洗完成", "提示", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource().equals(MainForm.cancelButton)) {
            // 取消
            System.exit(0);
        }
    }
}
