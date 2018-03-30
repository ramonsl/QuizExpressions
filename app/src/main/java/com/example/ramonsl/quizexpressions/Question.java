package com.example.ramonsl.quizexpressions;

import com.example.ramonsl.quizexpressions.KindEnum;

import java.util.ArrayList;

/**
 * Created by ramonsl on 29/03/2018.
 */

public class Question {
    private int number;
    private String question;
    private KindEnum kindQuestion;
    private ArrayList<Alternatives> alternatives;
    private ArrayList<String> answersUser;
    private int qtdAwnser;

    public int getNumber() {
        return number;
    }

    public String getQuestion() {
        return question;
    }

    public int getQtdAwnser() {
        return qtdAwnser;
    }

    public KindEnum getKindQuestion() {
        return kindQuestion;
    }

    public ArrayList<Alternatives> getAlternatives() {
        return alternatives;
    }


    public ArrayList<String > getAnswersUser() {
        return answersUser;
    }

    public Question(int number, String question, KindEnum kindQuestion, ArrayList<Alternatives> alternatives) {
        this.number = number;
        this.question = question;
        this.kindQuestion = kindQuestion;
        this.alternatives = alternatives;
        for (Alternatives a:this.getAlternatives()) {
            if(a.isCorretly()){
                qtdAwnser++;
            }
        }
    }

    public void setAnswersUser(String alt) {
        this.answersUser.add(alt);

    }

    public String getObjCorretAlt(){
        for (Alternatives a: alternatives) {
            if (a.isCorretly()){
                return a.getAlternative();
            }
        }
        return "err";
    }
}
