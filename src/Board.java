import java.awt.*;
import java.util.LinkedHashMap;

public class Board{
    private final LinkedHashMap<Tile, Figure> boardState;
    private final Figure free = new EmptySpot();

    Board()
    {
        boardState = new LinkedHashMap<>();

        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                boardState.put(new Tile(new Point(x, y)), new TestFigure());
            }
        }
    }

    public void move(Tile target, Figure figure)
    {
        for(Tile key: boardState.keySet())
            if(boardState.get(key) == figure)
                boardState.replace(key, free);

        boardState.replace(target, figure);

    }

    public LinkedHashMap<Tile, Figure> getBoardState(){ return boardState; }
}
