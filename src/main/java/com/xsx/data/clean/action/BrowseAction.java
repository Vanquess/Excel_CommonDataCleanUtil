package com.xsx.data.clean.action;

import com.xsx.data.clean.jframe.MainForm;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author BKGin
 * @Email libra14xu@gmail.com
 * @Date 2023-02-20
 */
public class BrowseAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(MainForm.templateBrowseButton)) {
            // 文件选择器
            JFileChooser fcDlg = new JFileChooser();
            fcDlg.setDialogTitle("请选择清洗模板...");
            // 文件类型过滤
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "文本文件(*.txt)", "txt");
            fcDlg.setFileFilter(filter);
            int returnVal = fcDlg.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // 路径回填
                String filepath = fcDlg.getSelectedFile().getPath();
                MainForm.templateFile.setText(filepath);
            }
        } else if (e.getSource().equals(MainForm.sourceBrowseButton)) {
            JFileChooser fcDlg = new JFileChooser();
            fcDlg.setDialogTitle("请选择待清洗文件...");
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "excel文件(*.xls;*.xlsx)", "xls", "xlsx");
            fcDlg.setFileFilter(filter);
            int returnVal = fcDlg.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String filepath = fcDlg.getSelectedFile().getPath();
                MainForm.sourceFile.setText(filepath);
            }
        }
    }
}
