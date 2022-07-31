import java.awt.*;
import java.util.Objects;

public class Tile{
    final private Point position;
    final private Color color;
    private TileView view;

    private Color markerColor;

    public Tile(Point position) {

        this.position = position;

        if(this.position.x % 2 == this.position.y % 2)
            color = Color.LIGHT_GRAY;
        else
            color = Color.WHITE;

        markerColor = color;
    }

    public Point getPosition() { return this.position; }

    public Color getColor()
    {
        return color;
    }

    public void setView(TileView view) {
        this.view = view;
    }

    public TileView getView() {
        if(view != null)
            return view;
        else
            return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return Objects.equals(position, tile.position) && Objects.equals(color, tile.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, color);
    }

    public Color getMarkerColor() {
        return markerColor;

    }

    public void setMarkerColor(Color c)
    {
        markerColor = c;
    }
}
