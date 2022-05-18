import javax.swing.*;
import java.awt.*;

public class TileView extends JButton {

    private Tile model;

    TileView(Tile m, Icon icon)
    {
        super(icon);
        model = m;
    }
}
