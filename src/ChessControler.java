import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ChessControler {
    private final Chess model;
    private BoardView view;

    ChessControler(Chess model)
    {
        this.model = model;
    }

    public void updateModel(Tile target)
    {
        switch (model.getState()) {
            case PLAYER_CHOOSE_FIGURE -> {
                if (!Objects.equals(model.getTileState(target), new EmptySpot()))
                    model.chooseFigure(target);
                updateView();
            }
            case PLAYER_MOVE_FIGURE -> {
                if (Objects.equals(model.getTileState(target), new EmptySpot()) ||
                        model.getTileState(target).getColor() != model.getChosenFigure().getColor()
                )
                    model.moveFigure(target);
                updateView();
            }
        }

        model.goToNextState();
    }

    public void updateView()
    {

    }

    public void initView(BoardView board_view) {
        view = board_view;
        Icon whiteTile = new ImageIcon("img/white_tile.png");
        Icon blackTile = new ImageIcon("img/dark_tile.png");
        TileView handler;
        for(Tile tile: model.getTiles())
        {
            if(tile.getColor() == Color.WHITE) {
                handler = new TileView(tile, whiteTile);
                view.add(handler);
                tile.setView(handler);
                handler.addActionListener(view);
            }
            else if(tile.getColor() == Color.BLACK){
                handler = new TileView(tile, blackTile);
                view.add(handler);
                tile.setView(handler);
                handler.addActionListener(view);
            }
        }

    }
}
