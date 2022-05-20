import javax.swing.*;
import java.awt.*;

public class TileView extends JButton {

    private final Tile model;

    TileView(Tile m, Icon icon)
    {
        super(icon);

        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        setMargin(new Insets(0,0,0,0));

        model = m;
    }

    public Tile getTile() { return this.model; }
}
