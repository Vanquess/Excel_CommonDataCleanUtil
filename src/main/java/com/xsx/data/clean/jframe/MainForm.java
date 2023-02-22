package com.xsx.data.clean.jframe;

import com.xsx.data.clean.action.BrowseAction;
import com.xsx.data.clean.action.ButtonAction;

import javax.swing.*;
import java.awt.*;

/**
 * @Author BKGin
 * @Email libra14xu@gmail.com
 * @Date 2023-02-20
 */
public class MainForm extends JFrame {

    /**
     * 主窗元素
     */
    public static JLabel templateLabel = new JLabel("请选择清洗模板：");
    public static JLabel sourceLabel = new JLabel("请选择待清洗文件：");
    public static JTextField templateFile = new JTextField();
    public static JTextField sourceFile = new JTextField();
    public static JButton templateBrowseButton = new JButton("浏览");
    public static JButton sourceBrowseButton = new JButton("浏览");
    public static JButton confirmButton = new JButton("确定");
    public static JButton cancelButton = new JButton("取消");

    public MainForm() {
        JFrame mainForm = new JFrame("Excel_通用数据清洗工具");
        Container container = mainForm.getContentPane();
        // 设置主窗体属性
        mainForm.setSize(400, 270);
        mainForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainForm.setLocationRelativeTo(null);
        mainForm.setResizable(false);
        mainForm.setLayout(null);
        mainForm.setVisible(true);
        // 设置各元素位置布局
        templateLabel.setBounds(30, 10, 300, 30);
        templateFile.setBounds(50, 50, 200, 30);
        templateBrowseButton.setBounds(270, 50, 60, 30);
        sourceLabel.setBounds(30, 90, 300, 30);
        sourceFile.setBounds(50, 130, 200, 30);
        sourceBrowseButton.setBounds(270, 130, 60, 30);
        confirmButton.setBounds(100, 180, 60, 30);
        cancelButton.setBounds(200, 180, 60, 30);
        // 为各元素绑定事件监听器
        templateBrowseButton.addActionListener(new BrowseAction());
        sourceBrowseButton.addActionListener(new BrowseAction());
        templateFile.setEditable(false);
        sourceFile.setEditable(false);
        confirmButton.addActionListener(new ButtonAction());
        cancelButton.addActionListener(new ButtonAction());
        // 元素添加至容器内
        container.add(templateLabel);
        container.add(sourceLabel);
        container.add(templateFile);
        container.add(sourceFile);
        container.add(templateBrowseButton);
        container.add(sourceBrowseButton);
        container.add(confirmButton);
        container.add(cancelButton);
    }

}
