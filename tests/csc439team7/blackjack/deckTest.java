package csc439team7.blackjack;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class deckTest {

    @Test
    public void pick(){
        deck mydeck = new deck();
        card pick = mydeck.pick();
        assertNotNull(pick);
    }

    @Test (expected = NoSuchElementException.class)
    public void pick2() {
        deck mydeck = new deck();
        for(int i = 52; i > 0; i--)
        {
            mydeck.pick();
        }
        mydeck.pick();
    }

    @Test
    public void size() {
        deck mydeck = new deck();
        assertEquals(52, mydeck.size());
        mydeck.pick();
        assertEquals(51, mydeck.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void getCard() {
        deck mydeck = new deck();
        mydeck.getCard(52);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getCard2() {
        deck mydeck = new deck();
        mydeck.getCard(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getCard3() {
        deck mydeck = new deck();
        mydeck.pick();
        mydeck.getCard(51);
    }

    @Test
    public void getCard4() {
        deck mydeck = new deck();
        card card = mydeck.getCard(1);
        assertEquals(card.getNumber(), 2);
        assertEquals(card.getSuit(), 0);
    }
}