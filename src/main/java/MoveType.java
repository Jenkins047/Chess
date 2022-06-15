import java.awt.*;

public enum MoveType {
    NORMAL,
    OFFENSIVE,
    SPECIAL;

    public String toString()
    {
        return switch (this) {
            case NORMAL -> "normal";
            case OFFENSIVE -> "offensive";
            case SPECIAL -> "special";
        };
    }

    public Color toColor()
    {
        return switch (this) {
            case NORMAL -> Color.BLUE;
            case OFFENSIVE -> Color.RED;
            case SPECIAL -> Color.GREEN;
        };
    }
}
