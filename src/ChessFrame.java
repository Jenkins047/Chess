import javax.swing.*;
import java.awt.*;

public class ChessFrame extends JFrame {
    private BoardView board_view;
    private Chess model;


    ChessFrame(String title)
    {
        super(title);

        model = new Chess();
        model.setView(this);

        board_view = new BoardView(model, new GridLayout(8, 8));
        model.setBoardView(board_view);
        add(board_view, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Rozmieszcza komponenty "optymalnie",
        // biorąc pod uwagę ich preferowane rozmiary.
        pack();
        // Uniemożliwia skalowania okna.
        setResizable(false);
        // Wyświetla okno na środku ekranu.
        setLocationRelativeTo(null);
        // Dopiero w tym momencie okno jest wyświetlane.
        setVisible(true);

        new Thread(model).start();
    }
}
