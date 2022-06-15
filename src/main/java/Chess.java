import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Stack;

/**
*   Klasa nadrzędna, w której modyfikowany jest stan gry,
 *   metody te są wywoływane przez automat stanów zaimplementowany
 *   w ChessController
 */

public class Chess implements Runnable {
    private JFrame view;
    private final Board board;

    private final Grave grave;
    private Figure pickedFigure;
    private HashMap<Point, Move> legalMoves = new HashMap<>();
    private GameState state;
    private ActivePlayer activePlayer;
    private final int frame_duration_ms;

    Chess()
    {
        board = new Board();
        grave = new Grave();

        activePlayer = ActivePlayer.WHITE;
        state = GameState.PLAYER_CHOOSE_FIGURE;

        frame_duration_ms = 25;
    }

    //TODO implement
    private boolean isCheckMate()
    {
        return false;
    }

    public void clearMoves() { legalMoves.clear(); }

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

    public void chooseFigure(Point target) {
        pickedFigure = board.getFigures().get(target);
        computeLegalMoves();
    }

    public void moveFigure(Move move) {
        switch(move.moveType) {
            case NORMAL:
                board.move(move, pickedFigure);
                pickedFigure = null;
                break;

            case OFFENSIVE:
                grave.bury(board.getFigures().get(move.destination).toString(), board.getFigures().get(move.destination));
                board.getFigures().remove(move.destination);
                board.move(move, pickedFigure);
                pickedFigure = null;
                System.out.println("Ilość figur na planszy: " + board.getFigures().size());
                System.out.println("Ilość figur w grobie: " + grave.getPopulation());
                break;
            case SPECIAL:
                //TODO roszada, wskrzeszanie pionkiem i chyba cos jeszcze
                break;

        }
    }

    public Figure getFigureOnTile(Point t) { return board.getFigures().get(t); }

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

    public Board getBoard() { return board; }

    public ActivePlayer getActivePlayer() { return this.activePlayer; }

    private void computeLegalMoves() {
        Stack<Stack<Point>> movesToCheck = pickedFigure.getMovesToCheck();


        if(pickedFigure instanceof Pawn)
        {
            if(pickedFigure.getPosition().y == 1){
                if (board.getFigures().get(movesToCheck.peek().peek()) == Board.free) {
                    legalMoves.put(movesToCheck.peek().peek(), new Move(MoveType.NORMAL, movesToCheck.peek().peek()));

                }movesToCheck.peek().pop();
            }

            if (    !movesToCheck.peek().empty() &&
                    board.getFigures().get(movesToCheck.peek().peek()) == Board.free) {
                legalMoves.put(movesToCheck.peek().peek(), new Move(MoveType.NORMAL, movesToCheck.peek().peek()));

            }
            if(!movesToCheck.peek().empty())
                movesToCheck.peek().pop();

            if (    !movesToCheck.peek().empty() &&
                    board.getFigures().get(movesToCheck.peek().peek()) != Board.free &&
                    board.getFigures().get(movesToCheck.peek().peek()).getColor() != pickedFigure.getColor()) {
                legalMoves.put(movesToCheck.peek().peek(), new Move(MoveType.OFFENSIVE, movesToCheck.peek().peek()));

            }
            if(!movesToCheck.peek().empty())
                movesToCheck.peek().pop();

            if (    !movesToCheck.peek().empty() &&
                    board.getFigures().get(movesToCheck.peek().peek()) != Board.free &&
                    board.getFigures().get(movesToCheck.peek().peek()).getColor() != pickedFigure.getColor()) {
                legalMoves.put(movesToCheck.peek().peek(), new Move(MoveType.OFFENSIVE, movesToCheck.peek().peek()));

            }
            if(!movesToCheck.peek().empty())
                movesToCheck.peek().pop();

        }
        else {
            for (Stack<Point> stack : movesToCheck) {
                for(Point pt: stack) {
                    if (board.getFigures().get(pt) instanceof EmptySpot)
                        legalMoves.put(pt, new Move(MoveType.NORMAL, pt));
                    else if (board.getFigures().get(pt).getColor() != pickedFigure.getColor()) {
                        legalMoves.put(pt, new Move(MoveType.OFFENSIVE, pt));
                        break;
                    }
                    else if(!(pickedFigure instanceof Knight))
                        break;
                }
            }
        }
    }

    public HashMap<Point, Move> getLegalMoves() {
        return legalMoves;
    }
}
