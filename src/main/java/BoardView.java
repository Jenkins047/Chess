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

    BoardView(ChessController controller, GridLayout gridLayout)
    {
        super(gridLayout);
        this.controller = controller;
        controller.initView(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        controller.updateModel(((TileView) e.getSource()).getTile());
    }
}
