package com.app.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.mvp.model.Quote;
import com.app.mvp.presenter.QuotePresenter;
import com.app.mvp.view.QuoteView;

public class MainActivity extends AppCompatActivity implements QuoteView {

    private QuotePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new QuotePresenter(this);

        Button button = findViewById(R.id.randomButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.fetchQuote();
            }
        });
    }

    @Override
    public void displayQuote(Quote quote) {
        TextView quoteTextView = findViewById(R.id.quoteTextView);
        quoteTextView.setText(quote.getText() + "\n" + quote.getAuthor());
    }
}