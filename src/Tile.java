import java.awt.*;

public class Tile{
    final private Point position;
    final private Color color;
    private TileView view;

    public Tile(Point position) {

        this.position = position;

        if(position.x % 8 == position.y % 8)
            color = Color.BLACK;
        else
            color = Color.WHITE;
    }

    public Color getColor()
    {
        return color;
    }

    public void setView(TileView view) {
        this.view = view;
    }

}
