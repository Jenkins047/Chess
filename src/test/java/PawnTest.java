import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

class PawnTest {

    @Test
    void shouldGetTwoMovesAtTheStartingPosition() {
        Chess model = new Chess();

        for(Tile element: model.getTiles())
            if(element.getPosition().x == 3 && element.getPosition().y == 1)
                model.chooseFigure(element);

        Vector<Move> expectedMoves = new Vector<>();
        for(Tile element: model.getTiles())
            if(element.getPosition().x == 3 && element.getPosition().y == 2){
                expectedMoves.add(new Move(MoveType.NORMAL, element));
                break;
            }

        for(Tile element: model.getTiles())
            if(element.getPosition().x == 3 && element.getPosition().y == 3){
                expectedMoves.add(new Move(MoveType.NORMAL, element));
                break;
            }

        Set<Move> actualMoves = model.getLegalMoves();
        assertEquals(Set.copyOf(expectedMoves), actualMoves);

    }

    @Test
    void shouldGetOneMove()
    {
        Chess model = new Chess();

        for(Tile element: model.getTiles())
            if(element.getPosition().x == 3 && element.getPosition().y == 1)
                model.chooseFigure(element);

        Set<Move> moves = model.getLegalMoves();
        for(var move: moves)
        {
            if(Objects.equals(move, new Move(MoveType.NORMAL, new Tile(new Point(3, 2)))))
                model.moveFigure(move);
        }

        for(Tile element: model.getTiles())
            if(element.getPosition().x == 3 && element.getPosition().y == 2)
                model.chooseFigure(element);

        Vector<Move> expectedMoves = new Vector<>();
        for(Tile element: model.getTiles())
            if(element.getPosition().x == 3 && element.getPosition().y == 3){
                expectedMoves.add(new Move(MoveType.NORMAL, element));
                break;
            }

        Set<Move> actualMoves = model.getLegalMoves();
        assertEquals(Set.copyOf(expectedMoves), actualMoves);
    }

}