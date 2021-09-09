package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SuitTest {

    @Test
    public void heartsAreRed() throws Exception {
        assertThat(Suit.HEARTS.isRed())
                .isTrue();
    }

    @Test
    public void diamondsAreRed() throws Exception {
        assertThat(Suit.DIAMONDS.isRed())
                .isTrue();
    }

    @Test
    public void clubsAreNotRed() throws Exception {
        assertThat(Suit.CLUBS.isRed())
                .isFalse();
    }

    @Test
    public void spadesAreNotRed() throws Exception {
        assertThat(Suit.SPADES.isRed())
                .isFalse();
    }

}