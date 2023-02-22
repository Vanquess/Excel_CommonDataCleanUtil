package com.xsx.data.clean.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author BKGin
 * @Email libra14xu@gmail.com
 * @Date 2023-02-20
 */
@Data
public class CommonValueBean implements Serializable {

    private String name;

    private String source;

    private String target;
}
