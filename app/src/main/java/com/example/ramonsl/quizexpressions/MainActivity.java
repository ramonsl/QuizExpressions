package com.example.ramonsl.quizexpressions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtQ1) TextView txtQ1;
    @BindView(R.id.txtQ2)
    TextView txtQ2;
    @BindView(R.id.txtQ3)
    TextView txtQ3;
    @BindView(R.id.txtQ4)
    TextView txtQ4;
    @BindView(R.id.txtQ5)
    TextView txtQ5;
    @BindView(R.id.imgQ1)
    ImageView imgQ1;
    @BindView(R.id.imgQ2)
    ImageView imgQ2;
    @BindView(R.id.imgQ3)
    ImageView imgQ3;
    @BindView(R.id.imgQ4)
    ImageView imgQ4;
    @BindView(R.id.imgQ5)
    ImageView imgQ5;
    @BindView(R.id.btnFinish)
    Button btnEnviar;
    @BindView(R.id.rgQ1)
    RadioGroup rgQ1;
    @BindView(R.id.rgQ1a)
    RadioButton rgQ1a;
    @BindView(R.id.rgQ1b)
    RadioButton rgQ1b;
    @BindView(R.id.rgQ1c)
    RadioButton rgQ1c;
    @BindView(R.id.edQ04)
    EditText edQ04;
    @BindView(R.id.edQ05)
    EditText edQ05;
    @BindView(R.id.rgQ2)
    RadioGroup rgQ2;
    @BindView(R.id.rgQ2a)
    RadioButton rgQ2a;
    @BindView(R.id.rgQ2b)
    RadioButton rgQ2b;
    @BindView(R.id.rgQ2c)
    RadioButton rgQ2c;
    @BindView(R.id.cbxQa)
    CheckBox cbxQa;
    @BindView(R.id.cbxQb)
    CheckBox cbxQb;
    @BindView(R.id.cbxQc)
    CheckBox cbxQc;
    @BindView(R.id.rgQ3)
    RadioGroup rgQ3;


    //TODO Criar uma classe Quizw
    public int points;
    public ArrayList<Question> questions = new ArrayList<>();

    Question q1;
    Question q2;
    Question q3;
    Question q4;
    Question q5;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        generate();


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //questão 1



                if(editTextVazio(edQ04)&& editTextVazio(edQ05)  &&    radioTextVazio(rgQ1) &&    radioTextVazio(rgQ2) &&    checkTextVazio(cbxQa,cbxQb,cbxQc,rgQ3)) {
                    correct();
                }else{
                    Toast.makeText(getApplicationContext(),getText(R.string.app__valida),Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public void generate() {
        //TODO melhorar a forma de gerar questoes!

        //question_01   para expressar pelo amor de deus... R for goodnees sake
        ArrayList<Alternatives> q1_alternatives = new ArrayList<>();
        q1_alternatives.add(new Alternatives(this.getString(R.string.question1_A), true));
        q1_alternatives.add(new Alternatives(this.getString(R.string.question1_B), false));
        q1_alternatives.add(new Alternatives(this.getString(R.string.question1_C), false));
        q1 = new Question(1, this.getString(R.string.question_1), KindEnum.OBJECTIVE, q1_alternatives);
        txtQ1.setText(R.string.question_1);
        rgQ1a.setText(R.string.question1_A);
        rgQ1b.setText(R.string.question1_B);
        rgQ1c.setText(R.string.question1_C);

        //question_02   para expressar  Não ter a menor ideia R for cue
        ArrayList<Alternatives> q2_alternatives = new ArrayList<>();
        q2_alternatives.add(new Alternatives(this.getString(R.string.question2_A), true));
        q2_alternatives.add(new Alternatives(this.getString(R.string.question2_B), false));
        q2_alternatives.add(new Alternatives(this.getString(R.string.question2_C), false));
        q2 = new Question(1, this.getString(R.string.question_2), KindEnum.OBJECTIVE, q2_alternatives);
        txtQ2.setText(R.string.question_2);
        rgQ2a.setText(R.string.question2_A);
        rgQ2b.setText(R.string.question2_B);
        rgQ2c.setText(R.string.question2_C);


        //question_03
        ArrayList<Alternatives> q3_alternatives = new ArrayList<>();
        q3_alternatives.add(new Alternatives(this.getString(R.string.question3_A), true));
        q3_alternatives.add(new Alternatives(this.getString(R.string.question3_B), true));
        q3_alternatives.add(new Alternatives(this.getString(R.string.question3_C), false));
        q3 = new Question(1, this.getString(R.string.question_3), KindEnum.MULTIBLE_CHOICE, q1_alternatives);
        txtQ3.setText(R.string.question_3);
        cbxQa.setText(R.string.question3_A);
        cbxQb.setText(R.string.question3_B);
        cbxQc.setText(R.string.question3_C);


        //question_04
        ArrayList<Alternatives> q4_alternatives = new ArrayList<>();
        q4_alternatives.add(new Alternatives(this.getString(R.string.question4_A), true));
        q4 = new Question(1, this.getString(R.string.question_4), KindEnum.TEXT, q4_alternatives);
        txtQ4.setText(R.string.question_4);


        //question_05
        ArrayList<Alternatives> q5_alternatives = new ArrayList<>();
        q5_alternatives.add(new Alternatives(this.getString(R.string.question5_A), true));
        q5 = new Question(1, this.getString(R.string.question_5), KindEnum.TEXT, q5_alternatives);
        txtQ5.setText(R.string.question_5);

    }

    public boolean editTextVazio(EditText ed) {
        if (ed.getText().length() == 0) {
            ed.setBackgroundColor(getResources().getColor(R.color.error));
            return false;
        } else {
            ed.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            return true;
        }
    }

    public boolean radioTextVazio(RadioGroup ed) {

        int a =   ed.getCheckedRadioButtonId();
        if(a!=-1){
            ed.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            return true;
        }else{
            ed.setBackgroundColor(getResources().getColor(R.color.error));
            return false;
        }

    }


    public boolean checkTextVazio(CheckBox c,CheckBox b,CheckBox a, RadioGroup ed) {

      if (c.isChecked()||b.isChecked()||a.isChecked()){
          ed.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
          return true;
      }else {
          ed.setBackgroundColor(getResources().getColor(R.color.error));
          return false;
      }

    }


    public void correct() {
        //TODO aprimorar o metodo. Mover ele para classe Question

        ///1 Questao 1 q1
        if (rgQ1a.isChecked()) {
            imgQ1.setImageResource(R.drawable.ic_check);
            imgQ1.setContentDescription(this.getResources().getString(R.string.app_certo));
            points++;
        } else {
            imgQ1.setImageResource(R.drawable.ic_error);
            imgQ2.setContentDescription(this.getResources().getString(R.string.app__errado));
        }
        ///2 Questao 1 q2
        if (rgQ2c.isChecked()) {
            imgQ2.setImageResource(R.drawable.ic_check);
            imgQ2.setContentDescription(this.getResources().getString(R.string.app_certo));
            points++;
        } else {
            imgQ2.setImageResource(R.drawable.ic_error);
            imgQ2.setContentDescription(this.getResources().getString(R.string.app__errado));
        }

        ///3 quesuar
        if (cbxQa.isChecked() && cbxQb.isChecked() && (!cbxQc.isChecked())) {
            imgQ3.setImageResource(R.drawable.ic_check);
            imgQ3.setContentDescription(this.getResources().getString(R.string.app_certo));
            points++;
        } else {
            imgQ3.setImageResource(R.drawable.ic_error);
            imgQ3.setContentDescription(this.getResources().getString(R.string.app__errado));
        }
        //questao 04

        if (q4.getObjCorretAlt().equalsIgnoreCase(edQ04.getText().toString())) {
            imgQ4.setImageResource(R.drawable.ic_check);
            imgQ4.setContentDescription(this.getResources().getString(R.string.app_certo));
            points++;
        } else {
            imgQ4.setImageResource(R.drawable.ic_error);
            imgQ4.setContentDescription(this.getResources().getString(R.string.app__errado));
        }

        //questao 05

        if (q5.getObjCorretAlt().equalsIgnoreCase(edQ05.getText().toString())) {
            imgQ5.setImageResource(R.drawable.ic_check);
            imgQ5.setContentDescription(this.getResources().getString(R.string.app_certo));
            points++;
        } else {
            imgQ5.setImageResource(R.drawable.ic_error);
            imgQ5.setContentDescription(this.getResources().getString(R.string.app__errado));
        }

        String msg;
        if(points<3){
            msg=this.getResources().getString(R.string.score1)+" "+points+" "+this.getResources().getString(R.string.score1a);
        }else if(points==3){
              msg=this.getResources().getString(R.string.score2)+" "+points+"  "+this.getResources().getString(R.string.score2a);
        }else{
            msg=this.getResources().getString(R.string.score1)+" "+points+" "+this.getResources().getString(R.string.score3a);

        }

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

        points = 0;
    }


}
