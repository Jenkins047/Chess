import java.awt.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

public class Pawn extends Figure{
    Pawn(Color color, HashMap<Tile, Figure> boardState) { super(color, boardState); }

    //TODO implement getMoves
    @Override
    public Set<Move> getMoves() {

        //find chosen tile
        Point position = null;
        for(Tile element: boardState.keySet())
            if(boardState.get(element) == this) {
                position = element.getPosition();
                break;
            }

        Vector<Move> moveList = new Vector<>();
        
        //Check for forward motion
        if(position.y == 1) {
            if (Objects.equals(boardState.get(new Tile(new Point(position.x, position.y + 1))), Board.free))
                moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x, position.y + 1))));

            if (Objects.equals(boardState.get(new Tile(new Point(position.x, position.y + 2))), Board.free))
                moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x, position.y + 2))));
        }
        else if (Objects.equals(boardState.get(new Tile(new Point(position.x, position.y + 1))), Board.free) &&
                position.y != 7)
                moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x, position.y + 1))));
        else if (Objects.equals(boardState.get(new Tile(new Point(position.x, position.y + 1))), Board.free))
                moveList.add(new Move(MoveType.SPECIAL, new Tile(new Point(position.x, position.y + 1))));
        
        //Check for offensive moves
        if (!Objects.equals(boardState.get(new Tile(new Point(position.x + 1, position.y + 1))), Board.free))
            moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x, position.y + 1))));

        if (!Objects.equals(boardState.get(new Tile(new Point(position.x - 1, position.y + 1))), Board.free))
            moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x, position.y + 1))));

        return Set.copyOf(moveList);
    }
}
