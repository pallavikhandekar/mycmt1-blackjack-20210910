package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandTest {

    private static final Suit DUMMY_SUIT = Suit.HEARTS;

    @Test
    public void handWithValueOf21IsNotBusted() throws Exception {
        Hand hand = createHand("8", "3", "10");

        assertThat(hand.isBusted())
                .isFalse();
    }

    @Test
    public void handWithValueOf22IsBusted() throws Exception {
        Hand hand = createHand("8", "4", "10");

        assertThat(hand.isBusted())
                .isTrue();
    }

    private Hand createHand(String... ranks) {
        List<Card> cards = new ArrayList<>();

        for (String rank : ranks) {
            cards.add(new Card(DUMMY_SUIT, rank));
        }

        return new Hand(cards);
    }
}
