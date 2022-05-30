import java.awt.*;
import java.util.Objects;

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

    public Point getPosition() { return this.position; }

    public Color getColor()
    {
        return color;
    }

    public void setView(TileView view) {
        this.view = view;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return Objects.equals(position, tile.position) && Objects.equals(color, tile.color) && Objects.equals(view, tile.view);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, color, view);
    }
}
