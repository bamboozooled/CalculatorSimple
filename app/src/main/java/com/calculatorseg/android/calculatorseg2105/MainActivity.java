package com.calculatorseg.android.calculatorseg2105;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.button;
import static android.R.attr.left;
import static android.media.CamcorderProfile.get;
import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView answerView;
    ArrayList<String> elems;
    boolean stop = false;
    boolean money = false;
    ArrayList<String> temp;
    boolean domath = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        elems = new ArrayList<>();
        temp = new ArrayList<>();
    }

    public void analyze(View view){
        textView = (TextView) findViewById(R.id.ViewNumber);
        answerView = (TextView) findViewById(R.id.ViewAnswer);
        String left ="";
        String right = "";
        String opr = "";
        Button button = (Button) view;
        String opg ="";

        if(button.getText().toString().equals("DEL") && elems.size() > 0){
            elems.remove(elems.size()-1);
        }

        if( !(button.getText().toString().equals("DEL")) ){
            String buttnt = button.getText().toString();

            if (elems.size()> 1){
                if ( ((elems.get(elems.size()-1).equals("*")) || (elems.get(elems.size()-1).equals("-")) || (elems.get(elems.size()-1).equals("/")) || elems.get(elems.size()-1).equals("+") ) ){
                    stop = true;
                    opr = elems.get((elems.size()-1));
                }
            }

            if(!stop){
                elems.add(buttnt);
            }
            else{
                if (!buttnt.equals("*") && !buttnt.equals("-") && !buttnt.equals("/") && !buttnt.equals("+") && !buttnt.equals("=")){
                    temp.add(buttnt);
                }

                if (/*buttnt.equals("*") || buttnt.equals("-") || buttnt.equals("/") || buttnt.equals("+") ||*/ buttnt.equals("=")){
                    domath = true;
                    if(!buttnt.equals("=")){
                        opg=buttnt;
                    }
                }
            }

            if (domath){

                for (int i = 0; i<temp.size(); i++){
                    right = right + temp.get(i);
                }

                for (int j = 0; j<elems.size()-1; j++){
                    left = left+elems.get(j);
                }

                if(opr.equals("*")){
                    Double lf = Double.parseDouble(left);
                    Double rf = Double.parseDouble(right);
                    Double answer = lf*rf;
                    String finals = String.valueOf(answer);

                    answerView.setText(finals);

                    domath = false;
                    temp.clear();
                    stop = false;
                    elems.clear();
                    elems.add(finals);
                }

                else if(opr.equals("-")){
                    Double lf = Double.parseDouble(left);
                    Double rf = Double.parseDouble(right);
                    Double answer = lf-rf;
                    String finals = String.valueOf(answer);

                    answerView.setText(finals);

                    domath = false;
                    temp.clear();
                    stop = false;
                    elems.clear();
                    elems.add(finals);
                }

                else if(opr.equals("/")){
                    Double lf = Double.parseDouble(left);
                    Double rf = Double.parseDouble(right);
                    Double answer = lf/rf;
                    String finals = String.valueOf(answer);

                    answerView.setText(finals);

                    domath = false;
                    temp.clear();
                    stop = false;
                    elems.clear();
                    elems.add(finals);
                }

                else if(opr.equals("+")){
                    Double lf = Double.parseDouble(left);
                    Double rf = Double.parseDouble(right);
                    Double answer = lf+rf;
                    String finals = String.valueOf(answer);

                    answerView.setText(finals);

                    domath = false;
                    temp.clear();
                    stop = false;
                    elems.clear();
                    elems.add(finals);
                }
            }



            }




        String theOne = "";

        if (stop == false){
            for (int i = 0; i<elems.size(); i++){
                theOne = theOne + elems.get(i);
            }

            textView.setText(theOne);
        }

        else{
            for (int i = 0; i<elems.size(); i++){
                theOne = theOne + elems.get(i);
            }

            for (int i = 0; i<temp.size(); i++){
                theOne = theOne + temp.get(i);
            }
            theOne = theOne+opg;
            opg = "";

            textView.setText(theOne);
        }

    }
}
