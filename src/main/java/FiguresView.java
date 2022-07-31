import javax.swing.*;
import java.awt.*;

public class FiguresView extends JPanel {
    private ChessController controller;
    FiguresView()
    {
        super();
    }

    public void setController(ChessController controller) {
        this.controller = controller;
    }
}
