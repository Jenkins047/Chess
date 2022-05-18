import javax.swing.*;
import java.util.Set;

/*
*   Klasa nadrzędna, model gry w szachy jako całość, powiązana relacją
*   kompozytu z klasami Board i Player.
 */

public class Chess implements Runnable {
    private JFrame view;
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private GameState state;
    private Player activePlayer;
    private final int frame_duration_ms;

    Chess()
    {
        board = new Board();

        whitePlayer = new Player();
        blackPlayer = new Player();
        activePlayer = whitePlayer;

        frame_duration_ms = 25;
    }

    private boolean isCheckMate()
    {
        return false;
    }


    public void setView(JFrame v) { view = v; }

    public GameState getState() { return state; }

    public void goToNextState() {
        switch(state)
        {
            case WHITE_PLAYER_CHOOSE_FIGURE:
                state = GameState.WHITE_PLAYER_MOVE_FIGURE;
                break;

            case WHITE_PLAYER_MOVE_FIGURE:
                state = GameState.BLACK_PLAYER_CHOOSE_FIGURE;
                break;

            case BLACK_PLAYER_CHOOSE_FIGURE:
                state = GameState.BLACK_PLAYER_MOVE_FIGURE;
                break;

            case BLACK_PLAYER_MOVE_FIGURE:
                state = GameState.WHITE_PLAYER_CHOOSE_FIGURE;
                break;

            case BLACK_SAYS_CHECK:
                if(isCheckMate())
                    state = GameState.CHECK_MATE;
                else
                    state = GameState.WHITE_PLAYER_CHOOSE_FIGURE;

                break;

            case WHITE_SAYS_CHECK:
                if(isCheckMate())
                    state = GameState.CHECK_MATE;
                else
                    state = GameState.BLACK_PLAYER_CHOOSE_FIGURE;

                break;

            default: state = state;
        }
    }

    public void PickFigure(TileView target) {
    }

    public void moveFigure(TileView target) {
    }

    public void endGame() {
    }

    public void setBoardView(BoardView v) { board.setView(v); }

    public Set<Tile> getTiles()
    {
        return board.getBoardState().keySet();
    }

    public void run() {
        while(!isCheckMate())
        {
            try {
                Thread.sleep(frame_duration_ms);
            } catch (InterruptedException ie) {
                System.out.println("Wystąpiło przerwanie");
            }

            view.repaint();
        }
    }
}
