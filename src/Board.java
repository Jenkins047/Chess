import java.awt.*;
import java.util.HashMap;

//Model
public class Board implements Runnable{
    private HashMap<Tile, Figure> boardState;
    private Chess boardView = null;
    private final int frame_duration_ms;

    Board()
    {
        frame_duration_ms = 25;
        boardState = new HashMap<>();

        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                boardState.put(new Tile(new Point(x + 2,y + 2)), null);
            }
        }


    }

    public HashMap<Tile, Figure> getState() { return boardState; }

    public void setView(Chess v){ boardView = v; }

    public void run()
    {
        while(true)
        {
            try {
                Thread.sleep(frame_duration_ms);
            } catch (InterruptedException ie) {
                System.out.println("Wystąpiło przerwanie");
            }
            if(boardView != null)
                boardView.repaint();
        }
    }
}
