import java.awt.*;
import java.util.*;

public class King extends Figure{
    King(Color color, Point p) { super(color, p); }

    @Override
    public Stack<Stack<Point>> getMovesToCheck() {

            Stack<Point> negY = new Stack<>();
            if(this.getPosition().y + 1 <= 7)
                negY.push(new Point(this.getPosition().x, this.getPosition().y + 1));

            Stack<Point> posY = new Stack<>();
            if(this.getPosition().y - 1 >= 0)
                posY.push(new Point(this.getPosition().x, this.getPosition().y - 1));

            Stack<Point> posX = new Stack<>();
            if(this.getPosition().x + 1 <= 7)
                posX.push(new Point(this.getPosition().x + 1, this.getPosition().y));

            Stack<Point> negX = new Stack<>();
            if(this.getPosition().x - 1 >= 0)
                negX.push(new Point(this.getPosition().x - 1, this.getPosition().y));

            Stack<Point> posXnegY = new Stack<>();
            if(this.getPosition().x + 1 <= 7 && this.getPosition().y + 1 <= 7)
                posXnegY.push(new Point(this.getPosition().x + 1, this.getPosition().y + 1));

            Stack<Point> negXnegY = new Stack<>();
            if(this.getPosition().x - 1 >= 0 && this.getPosition().y + 1 <= 7)
                negXnegY.push(new Point(this.getPosition().x - 1, this.getPosition().y + 1));

            Stack<Point> posXposY = new Stack<>();
            if(this.getPosition().x + 1 <= 7 && this.getPosition().y - 1 >= 0)
                posXposY.push(new Point(this.getPosition().x + 1, this.getPosition().y - 1));

            Stack<Point> negXposY = new Stack<>();
            if(this.getPosition().x - 1 >= 0 && this.getPosition().y - 1 >= 0)
                negXposY.push(new Point(this.getPosition().x - 1, this.getPosition().y - 1));

        Stack<Stack<Point>> pointsToCheck = new Stack<>();
        pointsToCheck.push(posX);
        pointsToCheck.push(posXnegY);
        pointsToCheck.push(posXposY);
        pointsToCheck.push(negX);
        pointsToCheck.push(negXposY);
        pointsToCheck.push(negXnegY);
        pointsToCheck.push(posY);
        pointsToCheck.push(negY);

        return pointsToCheck;
    }
}
