import java.awt.*;

public class Tile {
    private Point position;
    private Color color;
    public Tile(Point position)
    {
        this.position = position;
        if(this.position.x % 2 == this.position.y % 2)
            color = Color.WHITE;
        else
            color = Color.BLACK;
    }

    Point getPosition() { return this.position; }
    Color getColor() { return this.color; }
}
