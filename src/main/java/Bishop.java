import java.awt.*;
import java.util.*;

public class Bishop extends Figure{

    Bishop(Color color, Point p){ super(color, p); }
    //TODO implement getMoves
    @Override
    public Stack<Stack<Point>> getMovesToCheck() {
        
        Stack<Point> upRight = new Stack<>();
        //check up-right diagonal
        for(int x = getPosition().x + 1, y = getPosition().y - 1; x <= 7 && y >= 0; x++, y--)
            upRight.push(new Point(x, y));

        Stack<Point> upLeft = new Stack<>();
        //check up-left diagonal
        for(int x = getPosition().x - 1, y = getPosition().y - 1; x >= 0 && y >= 0; x--, y--)
            upLeft.push(new Point(x, y));

        Stack<Point> downRight = new Stack<>();
        //check down-right diagonal
        for(int x = getPosition().x + 1, y = getPosition().y + 1; x <= 7 && y <= 7; x++, y++)
            downRight.push(new Point(x, y));

        Stack<Point> downLeft = new Stack<>();
        //check down-left diagonal
        for(int x = getPosition().x - 1, y = getPosition().y + 1; x >= 0 && y <= 7; x--, y++)
            downLeft.push(new Point(x, y));


        Stack<Stack<Point>> pointsToCheck = new Stack<>();
        pointsToCheck.push(upRight);
        pointsToCheck.push(upLeft);
        pointsToCheck.push(downRight);
        pointsToCheck.push(downLeft);

        return pointsToCheck;
    }
}
