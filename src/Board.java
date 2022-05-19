import java.awt.*;
import java.util.LinkedHashMap;

public class Board{
    private BoardView view;
    private LinkedHashMap<Tile, Figure> boardState;

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

    public void setView(BoardView v) { view = v; }

    public LinkedHashMap<Tile, Figure> getBoardState(){ return boardState; }
}
