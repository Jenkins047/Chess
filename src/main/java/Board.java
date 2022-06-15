import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Przechowuje stan gry
 */

public class Board{
    private final HashMap<Point, Tile> tiles;
    private final HashMap<Point, Figure> figures;
    public static final Figure free = new EmptySpot(new Point(-1, -1));

    Board()
    {
        tiles = new LinkedHashMap<>();
        figures = new HashMap<>();

        for(int y = 0; y < 8; y++)
        {
            for(int x = 0; x < 8; x++)
                tiles.put(new Point(x, y), new Tile(new Point(x, y)));
        }

        figures.put((new Point(0, 0)), new Tower(Color.BLACK, new Point(0, 0)));
        figures.put((new Point(1, 0)), new Knight(Color.BLACK, new Point(1, 0)));
        figures.put((new Point(2, 0)), new Bishop(Color.BLACK, new Point(2, 0)));
        figures.put((new Point(3, 0)), new Queen(Color.BLACK, new Point(3, 0)));
        figures.put((new Point(4, 0)), new King(Color.BLACK, new Point(4, 0)));
        figures.put((new Point(5, 0)), new Bishop(Color.BLACK, new Point(5, 0)));
        figures.put((new Point(6, 0)), new Knight(Color.BLACK, new Point(6, 0)));
        figures.put((new Point(7, 0)), new Tower(Color.BLACK, new Point(7, 0)));
        for(int x = 0; x < 8; x++)
            figures.put((new Point(x, 1)), new Pawn(Color.BLACK, new Point(x, 1)));

        for(int y = 2; y < 6; y++)
        {
            for(int x = 0; x < 8; x++)
            {
                figures.put((new Point(x, y)), free);
            }
        }

        for(int x = 0; x < 8; x++)
            figures.put((new Point(x, 6)), new Pawn(Color.WHITE, new Point(x, 7)));

        figures.put((new Point(0, 7)), new Tower(Color.WHITE, new Point(0, 7)));
        figures.put((new Point(1, 7)), new Knight(Color.WHITE, new Point(1, 7)));
        figures.put((new Point(2, 7)), new Bishop(Color.WHITE, new Point(2, 7)));
        figures.put((new Point(3, 7)), new Queen(Color.WHITE, new Point(3, 7)));
        figures.put((new Point(4, 7)), new King(Color.WHITE, new Point(4, 7)));
        figures.put((new Point(5, 7)), new Bishop(Color.WHITE, new Point(5, 7)));
        figures.put((new Point(6, 7)), new Knight(Color.WHITE, new Point(6, 7)));
        figures.put((new Point(7, 7)), new Tower(Color.WHITE, new Point(7, 7)));
    }

    public void move(Move target, Figure figure)
    {

        figures.replace(figure.getPosition(), free);
        figures.replace(target.destination, figure);
        figure.setPosition(target.getDestination());
    }

    public HashMap<Point, Figure> getFigures(){ return figures; }

    public HashMap<Point, Tile> getTiles() { return tiles; }
}
