import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ChessTest {

    @Test
    void moveFigure() {
        Chess model = new Chess();

        model.chooseFigure(new Point(3, 1));
        model.moveFigure(model.getLegalMoves().get(new Point(3, 2)));

        model.chooseFigure(new Point(3, 2));
        assertNotEquals(model.getChosenFigure(), Board.free);

        model.chooseFigure(new Point(3, 1));
        assertEquals(model.getChosenFigure(), Board.free);

    }
}