import java.awt.Color;

public class ActivePlayer {
    private Color color;

    ActivePlayer()
    {
        color = Color.WHITE;
    }
    public void updateActivePlayer()
    {
        if(color == Color.BLACK)
            color = Color.WHITE;
        else
            color = Color.BLACK;
    }

    public Color getColor()
    {
        return color;
    }
}
