package Position;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position p1;
    Position p2;
    Position p3;
    char c;

    @BeforeEach
    void setUp() {
        p1 = new Position(2,2);
        p2 = new Position(2, 2);
        p3 = new Position(2, 1);
    }


    @Test
    void compareTo() {
        assertEquals(p1.compareTo(p2), 0);
    }


}