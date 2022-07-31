import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ChessControllerTest {

    @Test
    void StateMachineShouldReachAllStates() {
        Chess model = new Chess();
        ChessController ctrl = new ChessController(model);
        BoardView testView = new BoardView(ctrl, new GridLayout(8, 8));
        FiguresView figuresView = new FiguresView();
        ctrl.initView(testView, figuresView);

        Stack<GameState> reachedStates = new Stack<>();
        reachedStates.push(model.getState());

        testView.actionPerformed( new ActionEvent(testView.getComponents()[0], 0, ""));
        reachedStates.push(model.getState());

        testView.actionPerformed( new ActionEvent(testView.getComponents()[1], 0, ""));
        reachedStates.push(model.getState());


        Stack<GameState> expectedStates = new Stack<>();
        GameState state = GameState.PLAYER_CHOOSE_FIGURE;

        for(int i = 0; i < 3; i++)
        {
            expectedStates.push(state);
            try {
                state = state.next();
            } catch (GameEndException e) {
                e.printStackTrace();
            }
        }

        assertEquals(expectedStates, reachedStates);


    }
}