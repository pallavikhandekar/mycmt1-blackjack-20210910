package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public Hand() {
    }

    public Hand(List<Card> cards) {
        this.cards.addAll(cards);
    }

    int value() {
        int handValue = rawValue();

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce() && handValue <= 11) {
            handValue += 10;
        }

        return handValue;
    }

    void drawCardFrom(Deck deck) {
        cards.add(deck.draw());
    }

    Card firstCard() {
        return cards.get(0);
    }

    void display() {
        System.out.println(cards.stream()
                                .map(Card::display)
                                .collect(Collectors.joining(
                                       ansi().cursorUp(6).cursorRight(1).toString())));
    }

    private int rawValue() {
        return cards
                .stream()
                .mapToInt(Card::rankValue)
                .sum();
    }

    private boolean hasAce() {
        return cards
                .stream()
                .anyMatch(card -> card.rankValue() == 1);
    }

    boolean isBusted() {
        return value() > 21;
    }

    boolean shouldDealerHit() {
        return value() <= 16;
    }

    boolean pushes(Hand hand) {
        return value() == hand.value();
    }

    boolean beats(Hand hand) {
        return hand.value() < value();
    }
}
