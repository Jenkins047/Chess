import java.awt.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public abstract class Figure {

    private Color color;
    protected HashMap<Tile, Figure> boardState;
    protected Set<Move> legalMoves;

   Figure(){}

    Figure(Color color, HashMap<Tile, Figure> boardState)
    {
        this.boardState = boardState;
        this.color = color;
    }

    public Color getColor() { return color; }

    //TODO implement PawnTest
    //TODO implement TowerTest
    //TODO implement BishopTest
    //TODO implement QueenTest
    //TODO implement KingTest
    //TODO implement KnightTest
    public abstract Set<Move> getMoves();

    protected boolean isFree(Tile tile)
    {
        return Objects.equals(boardState.get(tile), Board.free);
    }
}
