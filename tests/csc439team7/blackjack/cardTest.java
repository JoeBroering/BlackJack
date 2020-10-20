package csc439team7.blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

public class cardTest {

    @Test
    public void card() {
        card myCard = new card(0, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void card2() {
        card mycard = new card(-1,10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void card3() {
        card mycard = new card(1,15);
    }

    @Test (expected = IllegalArgumentException.class)
    public void card4() {
        card mycard = new card(-1,15);
    }

    @Test
    public void getNumber() {
        card myCard = new card(0, 10);
        assertEquals(10, myCard.getNumber());
    }

    @Test
    public void setNumber() {
        card mycard = new card(3,5);
        mycard.setNumber(10);
        assertEquals(10, mycard.getNumber());
    }

    @Test (expected = IllegalArgumentException.class)
    public void setBadNumber() {
        card mycard = new card(3,5);
        mycard.setNumber(15);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setBadNumber2() {
        card mycard = new card(3,5);
        mycard.setNumber(0);
    }

    @Test
    public void getNumberName() {
        card mycard = new card(3,11);
        assertEquals("jack", mycard.getNumberName(mycard.getNumber()));
    }

    @Test
    public void getNumberName2() {
        card mycard = new card(3,8);
        assertEquals("8", mycard.getNumberName(mycard.getNumber()));
    }

    @Test
    public void getNumberName3() {
        card mycard = new card(3,1);
        assertEquals("ace", mycard.getNumberName(mycard.getNumber()));

        card mycard2 = new card(3,14);
        assertEquals("ace", mycard.getNumberName(mycard.getNumber()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void getBadNumberName() {
        card mycard = new card(3,15);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getBadNumberName2() {
        card mycard = new card(3,0);
    }

    @Test
    public void getSuit() {
        card mycard = new card(3,3);
        assertEquals(3,mycard.getSuit());
    }

    @Test
    public void setSuit() {
        card mycard = new card(2,11);
        mycard.setSuit(3);
        assertEquals(3, mycard.getSuit());
    }

    @Test (expected = IllegalArgumentException.class)
    public void setBadSuit() {
        card mycard = new card(2,11);
        mycard.setSuit(4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setBadSuit2() {
        card mycard = new card(2,11);
        mycard.setSuit(-1);
    }

    @Test
    public void getSuitName() {
        card mycard = new card(1,8);
        assertEquals("spades",mycard.getSuitName(mycard.getSuit()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void getBadSuitName() {
        card mycard = new card(-1,3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getBadSuitName2() {
        card mycard = new card(4,3);
    }

}