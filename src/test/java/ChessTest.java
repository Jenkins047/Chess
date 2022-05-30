import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ChessTest {

    @Test
    void moveFigure() {
        Chess model = new Chess();

        for(Tile element: model.getTiles())
            if(element.getPosition().x == 3 && element.getPosition().y == 1)
                model.chooseFigure(element);

        for(Tile element: model.getTiles())
            if(element.getPosition().x == 3 && element.getPosition().y == 2)
                model.moveFigure(new Move(MoveType.NORMAL, element));

        for(Tile tile: model.getTiles())
            if( tile.getPosition().x == 3 && tile.getPosition().y == 2)
            {
                model.chooseFigure(tile);
                assertNotEquals(model.getChosenFigure(), Board.free);
            }

        for(Tile tile: model.getTiles())
            if( tile.getPosition().x == 3 && tile.getPosition().y == 1)
            {
                model.chooseFigure(tile);
                assertEquals(model.getChosenFigure(), Board.free);
            }

    }
}