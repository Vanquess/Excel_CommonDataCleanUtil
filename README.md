# Excel_CommonDataCleanUtil

通用数据清洗工具

通过模板设定，从原excel文件中，提取数据，并导出至对应列



#### 使用方法：

<img src="file:///C:/Users/BKGinn/AppData/Roaming/marktext/images/2023-10-07-18-01-51-image.png" title="" alt="" width="330">

1.编辑清洗模板

    1.1：清洗模板示例

`{
    "labelLine":1, #正式数据开始行（非标题）
    "values":[
        {
            "name":"Title_1", #清洗后首行标题名称
            "source":"P+P", #来源列，为数据所在列名称（例：A）；支持简易数学运算（+、-、*、/）
            "target":"A" #目标列，清洗后输出至对应列
        },
        {
            "name":"Title_2",
            "source":"B",
            "target":"B"
        },
        {
            "name":"Title_3",
            "source":"C",
            "target":"C"
        }
    ]
}`

2.选择清洗模板，选择所需清洗文件

3.点击确定，开始自动数据清洗

4.清洗完成后，文件输出至源文件目录下
