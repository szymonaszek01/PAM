package com.app.mvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.app.mvvm.model.Quote;
import com.app.mvvm.viewmodel.QuoteViewModel;

public class MainActivity extends AppCompatActivity {

    private QuoteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(QuoteViewModel.class);

        TextView quoteTextView = findViewById(R.id.quoteTextView);
        viewModel.getQuoteLiveData().observe(this, new Observer<Quote>() {
            @Override
            public void onChanged(Quote quote) {
                quoteTextView.setText(quote.getText() + "\n" + quote.getAuthor());
            }
        });

        Button button = findViewById(R.id.randomButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.fetchQuote();
            }
        });
    }
}