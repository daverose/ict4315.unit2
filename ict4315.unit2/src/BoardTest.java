import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by daverose on 4/9/16.
 */
public class BoardTest {
    Board Board = new Board();

    @Test
    public void testLegalMove() throws Exception {
        boolean result;
        result = Board.legalMove(0,0);
        assertTrue(result);
        result = Board.legalMove(15,100);
        assertFalse(result);
    }
    @Test
    public void  testIllegalMove() throws Exception {
        boolean result;
        result = Board.legalMove(15,100);
        assertFalse(result);

    }
}