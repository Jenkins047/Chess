import java.awt.*;

public abstract class Figure {
    private Color color;
    private boolean onBoard;
    private FigureView view;
    public abstract Moves getMoves();
    public abstract void move();

    public Figure()
    {
        this.onBoard = true;
    }

    public void setView(FigureView v) { view = v; }
}
