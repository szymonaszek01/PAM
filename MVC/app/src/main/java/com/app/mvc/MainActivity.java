package com.app.mvc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.mvc.controller.QuoteController;
import com.app.mvc.model.Quote;

public class MainActivity extends AppCompatActivity {
    private QuoteController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new QuoteController(this);

        Button button = findViewById(R.id.randomButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.fetchQuote();
            }
        });
    }

    public void displayQuote(Quote quote) {
        TextView quoteTextView = findViewById(R.id.quoteTextView);
        quoteTextView.setText(quote.getText() + "\n" + quote.getAuthor());
    }
}