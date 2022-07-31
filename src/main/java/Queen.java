import java.awt.*;
import java.util.*;

public class Queen extends Figure{
    Queen(Color color, Point p) { super(color, p); }

    //TODO implement getMoves
    @Override
    public Stack<Stack<Point>> getMovesToCheck() {

        Stack<Point> upRight = new Stack<>();
        //check up-right diagonal
        for(int x = getPosition().x + 1, y = getPosition().y - 1; x < 7 && y > 0; x++, y--)
            upRight.push(new Point(x, y));

        Stack<Point> upLeft = new Stack<>();
        //check up-left diagonal
        for(int x = getPosition().x - 1, y = getPosition().y - 1; x > 0 && y > 0; x--, y--)
            upLeft.push(new Point(x, y));

        Stack<Point> downRight = new Stack<>();
        //check down-right diagonal
        for(int x = getPosition().x + 1, y = getPosition().y + 1; x <= 7 && y < 7; x++, y++)
            downRight.push(new Point(x, y));

        Stack<Point> downLeft = new Stack<>();
        //check down-left diagonal
        for(int x = getPosition().x - 1, y = getPosition().y + 1; x >= 0 && y < 7; x--, y++)
            downLeft.push(new Point(x, y));

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


        Stack<Stack<Point>> pointsToCheck = new Stack<>();
        pointsToCheck.push(upRight);
        pointsToCheck.push(upLeft);
        pointsToCheck.push(downRight);
        pointsToCheck.push(downLeft);
        pointsToCheck.push(posX);
        pointsToCheck.push(negX);
        pointsToCheck.push(posY);
        pointsToCheck.push(negY);

        return pointsToCheck;
    }
}
