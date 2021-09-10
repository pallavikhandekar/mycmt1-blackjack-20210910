package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

    @Test
    public void newWalletIsEmpty() throws Exception {
        Wallet wallet = new Wallet();

        assertThat(wallet.isEmpty())
                .isTrue();
    }

    @Test
    public void newWalletWhenAddMoneyThenIsNotEmpty() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(1);

        assertThat(wallet.isEmpty())
                .isFalse();
    }

    @Test
    public void newWalletHasZeroBalance() throws Exception {
        Wallet wallet = new Wallet();

        assertThat(wallet.balance())
                .isZero();
    }

    @Test
    public void newWalletAdd15ThenBalanceIs15() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(15);

        assertThat(wallet.balance())
                .isEqualTo(15);
    }

    @Test
    public void newWalletAdd17AndAdd18BalanceIs35() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(17);
        wallet.addMoney(18);

        assertThat(wallet.balance())
                .isEqualTo(17 + 18);

    }

    @Test
    public void addMoneyOfZeroThrowsException() throws Exception {
        Wallet wallet = new Wallet();

        assertThatThrownBy(() -> {
            wallet.addMoney(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void addNegativeMoneyThrowsException() throws Exception {
        Wallet wallet = new Wallet();

        assertThatThrownBy(() -> {
            wallet.addMoney(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    // AAA = arrange, act, assert
    // GWT = given, when, then
    // SEV = setup, execute, verify (Meszaros)

}
