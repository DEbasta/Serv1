package ru.mail.servertry;

import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

class ClickListener implements View.OnClickListener {
    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private TextView textView;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<String> listActions = new ArrayList<>();
    static int number;


    ClickListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1)
            concatination(textView,"1");
        if (v.getId() == R.id.button2)
            concatination(textView,"2");
        if (v.getId() == R.id.button3)
            concatination(textView,"3");
        if (v.getId() == R.id.button4)
            concatination(textView,"4");
        if (v.getId() == R.id.button5)
            concatination(textView,"5");
        if (v.getId() == R.id.button6)
            concatination(textView,"6");
        if (v.getId() == R.id.button7)
            concatination(textView,"7");
        if (v.getId() == R.id.button8)
            concatination(textView,"8");
        if (v.getId() == R.id.button9)
            concatination(textView,"9");
        if (v.getId() == R.id.button0)
            concatination(textView,"0");
        if (v.getId() == R.id.buttonC)
            textView.setText("");
        if (v.getId() == R.id.buttonEven)
            even(textView);
    }
    private void concatination(TextView toConc, String s){
        String fin = toConc.getText().toString();
        toConc.setText(fin.concat(s));
    }
    private void even(TextView toEven){

    }




}
