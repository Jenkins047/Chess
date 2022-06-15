import javax.swing.*;
import java.awt.*;

public class MoveView extends JLabel{
    private Move model;
    private ImageIcon look;
    private final int TILE_SIZE = 50;

    MoveView(Move m) {
        super();
        model = m;
        look = new ImageIcon("src/main/resources/img/normal_move_marker.png");
        super.setIcon(look);
        super.setLocation(TILE_SIZE * model.destination.x, TILE_SIZE * model.destination.y);
    }

    public String getFilePath()
    {
        String root = "src/main/resources/img/";
        String imageName = model.moveType.toString() + "_move_marker.png";
        return root + imageName;
    }
}
