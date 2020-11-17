package ru.mail.servertry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.*;
import java.net.Socket;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static int number=11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textField);
//        View.OnClickListener listener = new ClickListener(textView);
//        Button button1 = findViewById(R.id.button1);
//        button1.setOnClickListener(listener);
//        Button button2 = findViewById(R.id.button2);
//        button2.setOnClickListener(listener);
//        Button button3 = findViewById(R.id.button3);
//        button3.setOnClickListener(listener);
//        Button button4 = findViewById(R.id.button4);
//        button4.setOnClickListener(listener);
//        Button button5 = findViewById(R.id.button5);
//        button5.setOnClickListener(listener);
//        Button button6 = findViewById(R.id.button6);
//        button6.setOnClickListener(listener);
//        Button button7 = findViewById(R.id.button7);
//        button7.setOnClickListener(listener);
//        Button button8 = findViewById(R.id.button8);
//        button8.setOnClickListener(listener);
//        Button button9 = findViewById(R.id.button9);
//        button9.setOnClickListener(listener);
//        Button button0 = findViewById(R.id.button0);
//        button0.setOnClickListener(listener);
//        Button buttonC = findViewById(R.id.buttonC);
//        buttonC.setOnClickListener(listener);
//        Button buttonEven = findViewById(R.id.buttonEven);
//        buttonEven.setOnClickListener(listener);
        MyTread myTread = new MyTread();
        Thread newThread = new Thread(myTread);
        newThread.start();
        textView.setText(myTread.wordRet);
    }
    private static class MyTread implements Runnable{
        String wordRet;

        private static Socket clientSocket;
        private static BufferedReader in;
        private static BufferedWriter out;

        @Override
        public void run() {
            try {
                try {
                    System.out.println(number);
                    clientSocket = new Socket("192.168.0.102", 6667);
                    System.out.println(number);
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    System.out.println(number);
                    String word = String.valueOf(number);
                    out.write(word + "\n"); // отправляем сообщение на сервер
                    out.flush();
                    wordRet = in.readLine(); // ждём, что скажет сервер
                } finally {
                    System.out.println("Клиент был закрыт");
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        public String getWordRet(){
            return wordRet;
        }
    }

}