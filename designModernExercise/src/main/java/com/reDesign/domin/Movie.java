package com.reDesign.domin;

import lombok.Data;

@Data
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_BALANCE =1;

    private String _title ;
    private int _priceCode;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

}
