import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ChessController {
    private final Chess model;
    private BoardView view;
    private FiguresView figView;

    ChessController(Chess model)
    {
        this.model = model;
    }

    public void updateModel(Point target)
    {
        switch (model.getState()) {
            case PLAYER_CHOOSE_FIGURE -> {
                if (!Objects.equals(model.getFigureOnTile(target), Board.free) &&
                        model.getFigureOnTile(target).getColor() ==  model.getActivePlayer().getColor()) {
                    model.chooseFigure(target);
                    model.goToNextState();
                }
                displayMoves();
            }
            case PLAYER_MOVE_FIGURE -> {
                FigureView currentFigureView = model.getChosenFigure().getView();
                TileView targetView = model.getBoard().getTiles().get(target).getView();
                FigureView targetFigureView = model.getBoard().getFigures().get(target).getView();
                if(model.getLegalMoves().containsKey(target)) {
                    model.moveFigure(model.getLegalMoves().get(target));
                    hideMoves();
                    model.clearMoves();
                    targetView.remove(targetFigureView);
                    displayFigure(model.getBoard().getTiles().get(target).getView(),
                            currentFigureView);
                    model.goToNextState();
                }

            }
        }
    }

    private void hideMoves() {
        for(Move m: model.getLegalMoves().values())
        {
            Tile activeTile = model.getBoard().getTiles().get(m.destination);
            activeTile.setMarkerColor(model.getBoard().getTiles().get(m.destination).getColor());
            activeTile.getView().repaint();
        }
    }

    private void displayMoves() {
        for(Move m: model.getLegalMoves().values())
        {
            Tile activeTile = model.getBoard().getTiles().get(m.destination);
            activeTile.setMarkerColor(m.getMoveType().toColor());
            activeTile.getView().repaint();
        }
    }

    public void displayFigure(TileView target, FigureView fig)
    {
        model.getBoard().getTiles().get(fig.getFigure().getPosition()).getView().remove(fig);
        target.add(fig);
    }

    public void initView(BoardView board_view, FiguresView v) {
        view = board_view;
        figView = v;
        TileView handler;
        for(Point pt: model.getBoard().getTiles().keySet())
        {
            handler = new TileView(model.getBoard().getTiles().get(pt));
            view.add(handler);
            model.getBoard().getTiles().get(pt).setView(handler);
            handler.addActionListener(view);
            FigureView fig = new FigureView(model.getFigureOnTile(pt));
            model.getBoard().getFigures().get(pt).setView(fig);
            handler.add(fig);
            fig.setVisible(true);
            }
        }

    }
