package com.example.ramonsl.quizexpressions;

/**
 * Created by ramonsl on 29/03/2018.
 */

public class Alternatives {
    private boolean corretly;
    private String alternative;

    public Alternatives(String alternative, boolean corretly) {
        this.alternative = alternative;
        this.corretly = corretly;
    }

    public boolean isCorretly() {
        return corretly;
    }

    public String getAlternative() {
        return alternative;
    }
}
