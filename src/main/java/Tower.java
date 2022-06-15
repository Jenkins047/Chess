import java.awt.*;
import java.util.*;

public class Tower extends Figure{
    Tower(Color color, Point p) { super(color, p); }

    //TODO implement getMoves
    @Override
    public Stack<Stack<Point>> getMovesToCheck() {
        
        Stack<Point> posX = new Stack<>();
        //check +x coordinate
        for(int x = getPosition().x + 1; x <= 7; x++)
            posX.push(new Point(x, getPosition().y));

        Stack<Point> negX = new Stack<>();
        //check -x coordinate
        for(int x = getPosition().x - 1; x >= 0; x--)
            negX.push(new Point(x, getPosition().y));

        Stack<Point> posY = new Stack<>();
        //check +y coordinate
        for(int y = getPosition().y - 1; y >= 0; y--)
            posY.push(new Point(getPosition().x, y));

        Stack<Point> negY = new Stack<>();
        //check -y coordinate
        for(int y = getPosition().y + 1; y <= 7; y++)
            negY.push(new Point(getPosition().x, y));

        Stack<Stack<Point>> movesToCheck = new Stack<>();
        movesToCheck.push(posX);
        movesToCheck.push(negX);
        movesToCheck.push(posY);
        movesToCheck.push(negY);
        
        return movesToCheck;
    }
}
