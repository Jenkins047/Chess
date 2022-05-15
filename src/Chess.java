import javax.swing.*;

//Główny widok
public class Chess extends JFrame {
    private Board board;
    private BoardView view;
    Chess(String title)
    {
        super(title);
        board = new Board();
        board.setView(this);

        view = new BoardView(board);

        add(view);

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

        new Thread(board).start();
    }
}
