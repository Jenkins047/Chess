import javax.swing.*;
import java.awt.*;

public class ChessFrame extends JFrame {


    ChessFrame(String title)
    {
        super(title);


        Chess model = new Chess();
        model.setView(this);

        ChessControler controller = new ChessControler(model);

        BoardView board_view = new BoardView(controller, new GridLayout(8, 8));



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
