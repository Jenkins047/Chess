import java.awt.*;

public class ChessMain {
    public static void main(String args[])
    {
        EventQueue.invokeLater(() -> {
            new ChessFrame("Szachy PROO");
        });
    }
}
