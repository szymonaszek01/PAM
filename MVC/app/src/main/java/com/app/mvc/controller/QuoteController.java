package com.app.mvc.controller;

import com.app.mvc.MainActivity;
import com.app.mvc.model.Quote;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class QuoteController {

    private final List<Quote> quoteList;

    private final MainActivity view;

    public QuoteController(MainActivity view) {
        this.view = view;
        this.quoteList = Arrays.asList(
                new Quote(1, "Quote1", "Author1"),
                new Quote(2, "Quote2", "Author2"),
                new Quote(3, "Quote3", "Author3"),
                new Quote(4, "Quote4", "Author4"),
                new Quote(5, "Quote5", "Author5"),
                new Quote(6, "Quote6", "Author6"),
                new Quote(7, "Quote7", "Author7"),
                new Quote(8, "Quote8", "Author8"),
                new Quote(9, "Quote9", "Author9"),
                new Quote(10, "Quote10", "Author10")
        );
    }

    public void fetchQuote() {
        Random random = new Random();
        long quoteId = random.nextInt(10) + 1;
        findQuoteById(quoteId).ifPresent(view::displayQuote);
    }

    private Optional<Quote> findQuoteById(long quoteId) {
        return quoteList
                .stream()
                .filter(quote -> quote.getId() == quoteId)
                .findAny();
    }
}
