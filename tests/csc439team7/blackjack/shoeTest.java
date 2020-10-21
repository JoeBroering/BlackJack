package csc439team7.blackjack;

import org.junit.Test;
import static org.junit.Assert.*;

public class shoeTest {

    @Test (expected = IllegalArgumentException.class)
    public void getDeck() {
        shoe myshoe = new shoe(5);
        myshoe.getDeck(5);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getDeck2() {
        shoe myshoe = new shoe(5);
        myshoe.getDeck(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shoe() {
        shoe myshoe = new shoe(0);
    }

    @Test
    public void numDecks() {
        shoe myshoe = new shoe(6);
        assertEquals(6, myshoe.numDecks());
    }

    @Test
    public void pick() {
        shoe myshoe = new shoe(1);
        for(int i = 52; i > 0; i--)
        {
            myshoe.pick();
        } //after loop desk is empty
        assertEquals(0, myshoe.numDecks());
    }

    @Test
    public void pick2() {
        shoe myshoe = new shoe(1);
        card mycard = myshoe.pick();
        assertNotNull(mycard);
    }
}