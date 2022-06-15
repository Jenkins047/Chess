import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class FigureView extends JLabel {

    private Figure model;
    private ImageIcon look;
    private final int TILE_SIZE = 50;

    FigureView(Figure m)
    {
        super();
        model = m;
        look = new ImageIcon(getFilePath());
        super.setIcon(look);
        super.setLocation(TILE_SIZE*model.getPosition().x, TILE_SIZE*model.getPosition().y);
    }

    public Figure getFigure() { return this.model; }

    public String getFilePath()
    {
        String root = "src/main/resources/img/";
        String imageName = (model.getColor() == Color.BLACK ? "black" : "white") + "_" + model.toString().replaceFirst("@.*", "").toLowerCase() + ".png";
        return root + imageName;
    }

}
