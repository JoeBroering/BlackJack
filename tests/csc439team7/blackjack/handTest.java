package csc439team7.blackjack;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class handTest {

    @Test
    public void addCard() {
        card mycard = new card(3,10);
        hand myhand = new hand();
        myhand.addCard(mycard);
        assertEquals(1 ,myhand.size());
    }
    @Test
    public void addCard2() {
        card mycard = new card(1,7);
        card mycard2 = new card(3, 6);
        hand myhand = new hand();
        myhand.addCard(mycard);
        myhand.addCard(mycard2);
        assertEquals(2 ,myhand.size());
    }

    @Test
    public void getCards() {
        card mycard = new card(1, 5);
        hand myhand = new hand();
        myhand.addCard(mycard);
        assertNotNull(myhand.getCards());
    }

    @Test
    public void getCards2() {
        card mycard = new card(3, 11);
        hand myhand = new hand();
        myhand.addCard(mycard);
        card mycard2 = new card(2, 4);
        myhand.addCard(mycard2);
        assertNotNull(myhand.getCards());
    }


    @Test
    public void size() {
        hand myhand= new hand();
        assertEquals(0, myhand.size());
    }

    @Test
    public void listCards() {
        card mycard = new card(3,11);
        hand myhand = new hand();
        ArrayList<card> phand = myhand.listCards();
    }
}