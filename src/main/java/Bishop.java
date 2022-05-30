import java.awt.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

public class Bishop extends Figure{

    Bishop(Color color, HashMap<Tile, Figure> boardState){ super(color, boardState); }
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
        //check up-right diagonal
        for(int x = position.x, y = position.y; x < 7 && y >= 0; x++, y--)
        {
            if (Objects.equals(boardState.get(new Tile(new Point(position.x + x, position.y + y))), Board.free))
                moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x + x, position.y + y))));

            if (Objects.equals(boardState.get(new Tile(new Point(position.x + x, position.y + y))),
                    boardState.get(new Tile(new Point(position.x + x, position.y + y))).getColor() != this.getColor()))
                moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x + x, position.y + y))));
        }

        //check up-left diagonal
        for(int x = position.x, y = position.y; x >= 0 && y >= 0; x--, y--)
        {
            if (Objects.equals(boardState.get(new Tile(new Point(position.x + x, position.y + y))), Board.free))
                moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x + x, position.y + y))));

            if (Objects.equals(boardState.get(new Tile(new Point(position.x + x, position.y + y))),
                    boardState.get(new Tile(new Point(position.x + x, position.y + y))).getColor() != this.getColor()))
                moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x + x, position.y + y))));
        }

        //check down-right diagonal
        for(int x = position.x, y = position.y; x < 7 && y < 7; x++, y++)
        {
            if (Objects.equals(boardState.get(new Tile(new Point(position.x + x, position.y + y))), Board.free))
                moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x + x, position.y + y))));

            if (Objects.equals(boardState.get(new Tile(new Point(position.x + x, position.y + y))),
                    boardState.get(new Tile(new Point(position.x + x, position.y + y))).getColor() != this.getColor()))
                moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x + x, position.y + y))));
        }

        //check down-left diagonal
        for(int x = position.x, y = position.y; x >= 0 && y < 7; x--, y++)
        {
            if (Objects.equals(boardState.get(new Tile(new Point(position.x + x, position.y + y))), Board.free))
                moveList.add(new Move(MoveType.NORMAL, new Tile(new Point(position.x + x, position.y + y))));

            if (Objects.equals(boardState.get(new Tile(new Point(position.x + x, position.y + y))),
                    boardState.get(new Tile(new Point(position.x + x, position.y + y))).getColor() != this.getColor()))
                moveList.add(new Move(MoveType.OFFENSIVE, new Tile(new Point(position.x + x, position.y + y))));
        }


        return Set.copyOf(moveList);
    }
}