import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ChessController {
    private final Chess model;
    private BoardView view;

    ChessController(Chess model)
    {
        this.model = model;
    }

    public void updateModel(Tile target)
    {
        switch (model.getState()) {
            case PLAYER_CHOOSE_FIGURE -> {
                if (!Objects.equals(model.getFigureOnTile(target), new EmptySpot()))
                    model.chooseFigure(target);
                updateView();
            }
            case PLAYER_MOVE_FIGURE -> {
                if (Objects.equals(model.getFigureOnTile(target), new EmptySpot()) ||
                        model.getFigureOnTile(target).getColor() != model.getChosenFigure().getColor()
                )
                    //FIXME react accordingly to MoVeType
                    model.moveFigure(new Move(MoveType.NORMAL, target));
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
