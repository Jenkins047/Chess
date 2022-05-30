import java.awt.*;
import java.util.LinkedHashMap;

/**
 * Przechowuje stan gry
 */

public class Board{
    private final LinkedHashMap<Tile, Figure> boardState;
    public static final Figure free = new EmptySpot();

    Board()
    {
        boardState = new LinkedHashMap<>();

        boardState.put(new Tile(new Point(0, 0)), new Tower(Color.BLACK, boardState));
        boardState.put(new Tile(new Point(1, 0)), new Knight(Color.BLACK, boardState));
        boardState.put(new Tile(new Point(2, 0)), new Bishop(Color.BLACK, boardState));
        boardState.put(new Tile(new Point(3, 0)), new Queen(Color.BLACK, boardState));
        boardState.put(new Tile(new Point(4, 0)), new King(Color.BLACK, boardState));
        boardState.put(new Tile(new Point(2, 0)), new Bishop(Color.BLACK, boardState));
        boardState.put(new Tile(new Point(1, 0)), new Knight(Color.BLACK, boardState));
        boardState.put(new Tile(new Point(0, 0)), new Tower(Color.BLACK, boardState));
        for(int x = 0; x < 8; x++)
            boardState.put(new Tile(new Point(x, 1)), new Pawn(Color.BLACK, boardState));

        for(int x = 0; x < 8; x++)
        {
            for(int y = 2; y < 5; y++)
            {
                boardState.put(new Tile(new Point(x, y)), free);
            }
        }

        boardState.put(new Tile(new Point(0, 7)), new Tower(Color.WHITE, boardState));
        boardState.put(new Tile(new Point(1, 7)), new Knight(Color.WHITE, boardState));
        boardState.put(new Tile(new Point(2, 7)), new Bishop(Color.WHITE, boardState));
        boardState.put(new Tile(new Point(3, 7)), new Queen(Color.WHITE, boardState));
        boardState.put(new Tile(new Point(4, 7)), new King(Color.WHITE, boardState));
        boardState.put(new Tile(new Point(2, 7)), new Bishop(Color.WHITE, boardState));
        boardState.put(new Tile(new Point(1, 7)), new Knight(Color.WHITE, boardState));
        boardState.put(new Tile(new Point(0, 7)), new Tower(Color.WHITE, boardState));
        for(int x = 0; x < 8; x++)
            boardState.put(new Tile(new Point(x, 7)), new Pawn(Color.WHITE, boardState));
    }

    public void move(Move target, Figure figure)
    {
        for(Tile key: boardState.keySet())
            if(boardState.get(key) == figure)
                boardState.replace(key, free);

        boardState.replace(target.destination, figure);

    }

    public LinkedHashMap<Tile, Figure> getBoardState(){ return boardState; }
}
