
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

    }

    @Test
    public void getSuittest() {

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
    public void getNumberName() {

    }
}