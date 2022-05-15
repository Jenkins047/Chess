import javax.swing.*;
import java.awt.*;

public class BoardView extends JPanel {
    private Board board;
    private final int tileSize = 50;
    private final int margin = 100;

    BoardView(Board model)
    {
        super();
        board = model;
        setPreferredSize(new Dimension(8*tileSize + tileSize*2 + margin, 8*tileSize + tileSize*2 + margin));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        // Odświeżanie wykresu zaczynamy od wypełnienia całości kolorem tła.
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        for(Tile tile: board.getState().keySet())
        {
            g2d.setColor(tile.getColor());
            g2d.fillRect(50*tile.getPosition().x, 50*tile.getPosition().y, tileSize, tileSize);
        }
    }

}
