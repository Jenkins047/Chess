import java.awt.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public abstract class Figure {

    private Color color;
    protected HashMap<Tile, Figure> boardState;
    protected Set<Move> legalMoves;
    private Point position;
    private FigureView view;

   Figure(Point p){
       position = p;
   }

    Figure(Color color, Point p)
    {
        this.boardState = boardState;
        this.color = color;
        position = p;
    }

    public Color getColor() { return color; }

    //TODO implement PawnTest
    //TODO implement TowerTest
    //TODO implement BishopTest
    //TODO implement QueenTest
    //TODO implement KingTest
    //TODO implement KnightTest
    public abstract Stack<Stack<Point>> getMovesToCheck();

    protected boolean isFree(Tile tile)
    {
        return Objects.equals(boardState.get(tile), new EmptySpot(tile.getPosition()));
    }

    protected void addMove(Point p, MoveType type)
    {
        for(Tile tile: boardState.keySet())
            if (tile.getPosition() == p)
                if(boardState.get(tile) == Board.free)
                    legalMoves.add(new Move(type, p));
                else if(type == MoveType.OFFENSIVE)
                    legalMoves.add(new Move(type, p));

    }

    public Point getPosition() {
        return position;
    }
    public FigureView getView() { return view; }
    public void setView(FigureView v) { view = v; }

    public void setPosition(Point destination) { position = destination;
    }
}
