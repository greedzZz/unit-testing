package greedzZz.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {
    Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void checkGetNervous() {
        assertFalse(person.isNervous());
        person.nervous();
        assertTrue(person.isNervous());
    }

    @Test
    void checkSeeStrangeThing() {
        assertEquals(100, person.getFaithInEyes());
        person.seeStrangeThing(new Thing());
        assertEquals(80, person.getFaithInEyes());
    }

    @Test
    void checkGetStunned() {
        person.stunned();
        assertFalse(person.isStunned());
        person.seeStrangeThing(new Thing());
        person.stunned();
        assertTrue(person.isStunned());
    }

    @Test
    void checkDropJaw() {
        for (int i = 0; i < 5; i++) {
            assertFalse(person.isDroppedJaw());
            person.seeStrangeThing(new Thing());
            person.dropJaw();
        }
        assertTrue(person.isDroppedJaw());
    }

    @Test
    void checkLieDownInAChair() {
        assertEquals(0, person.getSatisfaction());
        person.lieDownInAChair();
        assertEquals(30, person.getSatisfaction());
    }

    @Test
    void checkPutFeetOnTheControlPanel() {
        assertEquals(0, person.getSatisfaction());
        person.putFeetOnTheControlPanel();
        assertEquals(20, person.getSatisfaction());
    }

    @Test
    void checkPickOnesTeeth() {
        assertEquals(0, person.getSatisfaction());
        person.pickOnesTeeth();
        assertEquals(50, person.getSatisfaction());
    }

    @Test
    void checkSmile() {
        person.smile();
        assertFalse(person.isSmile());
        person.lieDownInAChair();
        person.smile();
        assertFalse(person.isSmile());
        person.putFeetOnTheControlPanel();
        person.smile();
        assertFalse(person.isSmile());
        person.pickOnesTeeth();
        person.smile();
        assertTrue(person.isSmile());
    }
}
