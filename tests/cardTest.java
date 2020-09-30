
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class cardTest {

    @Test
    public void getNumberTest() {
        card myCard = new card(0, 10);
        assertEquals(10, myCard.getNumber());

    }

    @Test
    public void setNumber() {
        card mycard = new card(3,5);
        mycard.setNumber(10);
        assertEquals(10, mycard.getNumber());
    }

    @Test
    public void getSuittest() {
        card mycard = new card(1,5);
        assertEquals(1, mycard.getSuit());
    }

    @Test
    public void setSuit() {

    }

    @Test
    public void getSuitName() {
    card mycard = new card(0,3);
    assertEquals("hearts", mycard.getSuitName(0));
    }


    @Test
    public void getCardName() {
        card mycard = new card(3,11);
        assertEquals("jack", mycard.getCardName(mycard.getNumber()));
    }

    @Test
    public void getSuit() {
    }
}