package com.zomb.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HistoryActivity extends AppCompatActivity {
    // Initialize the text view
    TextView history;

    // Since there isn't any data that needs to be stored, I did not save instance state. It reads whatever is in the txt file anyway.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        history = findViewById(R.id.historyView);

        // reads the text in the history file
        try {
            history.setText(readFromInternalFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // reads the text from the history file and displays it in the text view
    private String readFromInternalFile() throws IOException {
        FileInputStream inputStream = openFileInput("history");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder = new StringBuilder();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
        } finally {
            reader.close();
        }

        return stringBuilder.toString();
    }

    // Clears the history file and sets the text to ""
    private void writeToInternalFile() throws IOException {
        FileOutputStream outputStream = openFileOutput("history", Context.MODE_PRIVATE);
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println("");
        writer.close();
    }

    // button that clears the history file and reloads the text view
    public void clearHistory(View view) {
        try {
            writeToInternalFile();
            history.setText(readFromInternalFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}