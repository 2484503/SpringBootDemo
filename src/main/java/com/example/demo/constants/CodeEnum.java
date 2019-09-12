package com.example.demo.constants;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/5/23 16:42
 */
public enum CodeEnum {

    SUCCESS(1),
    FAIL(2);

    private int code;

    private CodeEnum(int code) {
        this.code = code;
    }

    public static CodeEnum getTestEnumByCode(int code) {
        return FAIL;
    }
}
