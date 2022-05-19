import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardView extends JPanel implements ActionListener {
    private final int xMax   = 400; // Szerokość planszy (piksele).
    private final int yMax   = 400; // Wysokość planszy (piksele).
    private final int margin =  30; // Margines wokół planszy (piksele).

    private final Chess model;

    BoardView(Chess m, GridLayout gridLayout)
    {
        super(gridLayout);
        model = m;

        Icon whiteTile = new ImageIcon("img/white_tile.png");
        Icon blackTile = new ImageIcon("img/dark_tile.png");
        for(Tile tile: model.getTiles())
        {
            if(tile.getColor() == Color.WHITE)
                add(new TileView(tile, whiteTile));
            else if(tile.getColor() == Color.BLACK)
                add(new TileView(tile, blackTile));
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        TileView target = (TileView) e.getSource();

        switch (model.getState()) {
            case PLAYER_CHOOSE_FIGURE -> model.PickFigure(target);
            case PLAYER_MOVE_FIGURE -> model.moveFigure(target);
            case CHECK_MATE -> model.endGame();
            default -> {
            } //throw new IllegalActionException();


        }
        model.goToNextState();


    }
}
