import java.awt.*;

public class Tile{
    final private Point position;
    final private Color color;
    private TileView view;

    public Tile(Point position) {

        this.position = position;

        if(this.position.x % 2 == this.position.y % 2)
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
