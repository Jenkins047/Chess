import javax.swing.*;
import java.util.Set;

/**
*   Klasa nadrzędna, w której modyfikowany jest stan gry,
 *   metody te są wywoływane przez automat stanów zaimplementowany
 *   w ChessController
 */

public class Chess implements Runnable {
    private JFrame view;
    private final Board board;
    private Figure pickedFigure;
    private Set<Move> legalMoves;
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

    //TODO implement
    private boolean isCheckMate()
    {
        return false;
    }

    private void clearMoves() { legalMoves = Set.of(); }

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

    /*TODO display end screen popup after end GameEndException is thrown
      TODO end screen contains info: which player won, buttons to start new game and to go back to menu
     */
    private void endGame() {
    }

    public void chooseFigure(Tile target) {
        pickedFigure = board.getBoardState().get(target);
        legalMoves = pickedFigure.getMoves();
    }

    public void moveFigure(Move move) {
        if(pickedFigure.getMoves().contains(move)) {
            board.move(move, pickedFigure);
            clearMoves();
            pickedFigure = null;
        }

    }

    public Set<Tile> getTiles()
    {
        return board.getBoardState().keySet();
    }
    public Figure getFigureOnTile(Tile t) { return board.getBoardState().get(t); }

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

    public ActivePlayer getActivePlayer() { return this.activePlayer; }

    public Set<Move> getLegalMoves() {
        if(legalMoves != null)
            return legalMoves;
        else
            return Set.of();
    }
}
