package com.xsx.data.clean.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author BKGin
 * @Email xushengxing@gmail.com
 * @Date 2023-02-20
 */
@Data
public class CommonBean implements Serializable {

    private Integer labelLine;

    private List<CommonValueBean> values;

}
