import javax.swing.*;
import java.awt.*;
import java.util.Objects;

//TODO make it extend JPanel
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

    public void updateImage(Icon icon) { super.setIcon(icon); }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(model.getColor());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(model.getMarkerColor());
        g2d.fillOval(0,0, getWidth(), getHeight());
    }

}
