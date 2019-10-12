package com;

public enum CtlFlagEnum {
    CTL_F(0,1,"第一个控制位"),
    CTL_G(1,2,"第2个控制位");


    private int index;
    private int code;
    private String name;

    CtlFlagEnum(int index, int code, String name) {
        this.index = index;
        this.code = code;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
