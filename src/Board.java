import java.awt.*;
import java.util.HashMap;

public class Board{
    private BoardView view;
    private HashMap<Tile, Figure> boardState;

    Board()
    {
        boardState = new HashMap<>();

        for(int y = 0; y < 8; y++)
        {
            for(int x = 0; x < 8; x++)
            {
                boardState.put(new Tile(new Point(x, y)), new TestFigure());
            }
        }
    }

    public void setView(BoardView v) { view = v; }

    public HashMap<Tile, Figure> getBoardState(){ return boardState; }
}
