package com.zomb.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HistoryActivity extends AppCompatActivity {

    private static final String TAG = "HistoryActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

//        try {
//            writeToInternalFile();
//            String fileContents = readFromInternalFile();
//            Log.d(TAG, "File contents = " + fileContents);
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    private String readFromInternalFile() throws IOException {
        FileInputStream inputStream = openFileInput("history");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder = new StringBuilder();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
        }
        finally {
            reader.close();
        }

        return stringBuilder.toString();
    }
}