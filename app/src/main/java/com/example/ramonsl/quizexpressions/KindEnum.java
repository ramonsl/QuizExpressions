package com.example.ramonsl.quizexpressions;

/**
 * Created by ramonsl on 29/03/2018.
 */

public enum KindEnum {

    OBJECTIVE(1) , MULTIBLE_CHOICE(2), TEXT(3);
    public int kind;
    KindEnum(int value){
        kind=value;
    }
}
