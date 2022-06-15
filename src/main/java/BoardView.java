import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Widok stanu gry, słuchacz zdarzeń z JButton-ów reprezentujących
 * pola gry w szachy
 */

public class BoardView extends JPanel implements ActionListener {

    private final ChessController controller;
    private final FiguresView figuresView = new FiguresView();

    BoardView(ChessController controller, GridLayout gridLayout)
    {
        super();
        setLayout(gridLayout);
        this.controller = controller;
        figuresView.setController(controller);
        controller.initView(this, figuresView);
    }

    public void actionPerformed(ActionEvent e)
    {
        controller.updateModel(((TileView) e.getSource()).getTile().getPosition());
    }
}
