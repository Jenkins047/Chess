import javax.swing.*;
import java.util.Set;

/*
*   Klasa nadrzędna, model gry w szachy jako całość, powiązana relacją
*   kompozytu z klasami Board i Player.
 */

public class Chess implements Runnable {
    private JFrame view;
    private final Board board;
    private Figure pickedFigure;
    private GameState state;
    private ActivePlayer activePlayer;
    private final int frame_duration_ms;

    Chess()
    {
        board = new Board();

        activePlayer = ActivePlayer.WHITE;
        state = GameState.PLAYER_CHOOSE_FIGURE;

        frame_duration_ms = 25;
    }

    private boolean isCheckMate()
    {
        return false;
    }


    public void setView(JFrame v) { view = v; }

    public GameState getState() { return state; }

    public void goToNextState() {

        try {
            if(state.next() == GameState.PLAYER_CHOOSE_FIGURE)
                activePlayer = activePlayer.next();

            state = state.next();
        }
        catch(GameEndException e)
        {
            endGame();
        }
    }

    private void endGame() {
    }

    public void chooseFigure(Tile target) {
        pickedFigure = board.getBoardState().get(target);
        pickedFigure.getMoves(board.getBoardState());
    }

    public void moveFigure(Tile target) {
        if(board.getBoardState().get(target) == pickedFigure)
        {
            pickedFigure.clearMoves();
            state = GameState.PLAYER_CHOOSE_FIGURE;
        }
        else
        {
            board.move(target, pickedFigure);
            pickedFigure.clearMoves();
            pickedFigure = null;
        }
    }

    public Set<Tile> getTiles()
    {
        return board.getBoardState().keySet();
    }
    public Figure getTileState(Tile t) { return board.getBoardState().get(t); }

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

    public Figure getChosenFigure() { return pickedFigure; }
}
