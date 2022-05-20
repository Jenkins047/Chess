import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardView extends JPanel implements ActionListener {

    private final ChessControler controller;

    BoardView(ChessControler controller, GridLayout gridLayout)
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
