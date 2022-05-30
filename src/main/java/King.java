import java.awt.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

public class King extends Figure{
    King(Color color, HashMap<Tile, Figure> boardState) { super(color, boardState); }

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

        if (Objects.equals(boardState.get(new Tile(new Point(position.x, position.y + 1))), Board.free))
            moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x, position.y + 1))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x, position.y - 1))), Board.free))
            moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x, position.y - 1))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x + 1, position.y))), Board.free))
            moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x + 1, position.y))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x - 1, position.y))), Board.free))
            moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x - 1, position.y))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x + 1, position.y + 1))), Board.free))
            moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x + 1, position.y + 1))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x - 1, position.y + 1))), Board.free))
            moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x - 1, position.y + 1))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x + 1, position.y - 1))), Board.free))
            moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x + 1, position.y - 1))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x - 1, position.y - 1))), Board.free))
            moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x - 1, position.y - 1))));


        if (Objects.equals(boardState.get(new Tile(new Point(position.x, position.y + 1))),
                boardState.get(new Tile(new Point(position.x, position.y + 1))).getColor() != this.getColor()))
            moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x, position.y + 1))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x, position.y - 1))),
                boardState.get(new Tile(new Point(position.x, position.y - 1))).getColor() != this.getColor()))
            moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x, position.y - 1))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x + 1, position.y))),
                boardState.get(new Tile(new Point(position.x + 1, position.y))).getColor() != this.getColor()))
            moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x + 1, position.y))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x - 1, position.y))),
                boardState.get(new Tile(new Point(position.x - 1, position.y))).getColor() != this.getColor()))
            moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x - 1, position.y))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x + 1, position.y + 1))),
                boardState.get(new Tile(new Point(position.x + 1, position.y + 1))).getColor() != this.getColor()))
            moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x + 1, position.y + 1))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x - 1, position.y + 1))),
                boardState.get(new Tile(new Point(position.x - 1, position.y + 1))).getColor() != this.getColor()))
            moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x - 1, position.y + 1))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x + 1, position.y - 1))),
                boardState.get(new Tile(new Point(position.x + 1, position.y - 1 ))).getColor() != this.getColor()))
            moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x + 1, position.y - 1))));

        if (Objects.equals(boardState.get(new Tile(new Point(position.x - 1, position.y - 1))),
                boardState.get(new Tile(new Point(position.x - 1, position.y - 1))).getColor() != this.getColor()))
            moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x - 1, position.y - 1))));

        return Set.copyOf(moveList);
    }
}
