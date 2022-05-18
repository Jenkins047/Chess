import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoardView extends JPanel {
    private final int xMax   = 400; // Szerokość planszy (piksele).
    private final int yMax   = 400; // Wysokość planszy (piksele).
    private final int margin =  30; // Margines wokół planszy (piksele).

    private Chess model;

    BoardView(Chess m, GridLayout gridLayout)
    {
        super(gridLayout);
        model = m;

        Icon whiteTile = new ImageIcon();
        Icon blackTile = new ImageIcon();
        for(Tile tile: model.getTiles())
        {
            if(tile.getColor() == Color.WHITE)
                add(new TileView(tile, whiteTile));
            else
                add(new TileView(tile, blackTile));
        }
    }

    public void actionPerformed(ActionEvent e) throws IllegalActionException
    {
        TileView target = (TileView) e.getSource();

        switch(model.getState())
        {
            case PLAYER_CHOOSE_FIGURE:
                model.PickFigure(target);
                break;

            case PLAYER_MOVE_FIGURE:
                model.moveFigure(target);
                break;

            case CHECK_MATE:
                model.endGame();
                break;

            default: //throw new IllegalActionException();


        }
        model.goToNextState();


    }
}
