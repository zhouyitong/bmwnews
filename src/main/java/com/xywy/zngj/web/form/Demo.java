package com.xywy.zngj.web.form;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Author: lyp
 * Create Date: 2018/1/27
 * Description:
 */
public class Demo implements Serializable {
    private static final long serialVersionUID = 2239854431926360720L;

    @NotBlank
    private String id;
}
