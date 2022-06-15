import java.awt.*;
import java.util.Stack;

public class Knight extends Figure {
    public Knight(Color color, Point p) { super(color, p); }

    @Override
    public Stack<Stack<Point>> getMovesToCheck() {
        Stack<Point> PointsToCheck = new Stack<>();
        if(this.getPosition().x + 1 <= 7 && this.getPosition().y <= 7)
            PointsToCheck.push(new Point(this.getPosition().x + 1, this.getPosition().y + 2));

        if(this.getPosition().x + 2 <= 7 && this.getPosition().y + 1 <= 7)
            PointsToCheck.push(new Point(this.getPosition().x + 2, this.getPosition().y + 1));

        if(this.getPosition().x + 1 <= 7 && this.getPosition().y >= 0)
            PointsToCheck.push(new Point(this.getPosition().x + 1, this.getPosition().y - 2));

        if(this.getPosition().x + 2 <= 7 && this.getPosition().y - 1 >= 0)
            PointsToCheck.push(new Point(this.getPosition().x + 2, this.getPosition().y - 1));

        if(this.getPosition().x - 1 >= 0 && this.getPosition().y + 2 <= 7)
            PointsToCheck.push(new Point(this.getPosition().x - 1, this.getPosition().y + 2));

        if(this.getPosition().x - 2 >= 0 && this.getPosition().y + 1 <= 7)
            PointsToCheck.push(new Point(this.getPosition().x - 2, this.getPosition().y + 1));

        if(this.getPosition().x - 1 >= 0 && this.getPosition().y - 2 >= 0)
            PointsToCheck.push(new Point(this.getPosition().x - 1, this.getPosition().y - 2));

        if(this.getPosition().x - 2 >= 0 && this.getPosition().y - 1 >= 0)
            PointsToCheck.push(new Point(this.getPosition().x - 2, this.getPosition().y - 1));

        Stack<Stack<Point>> ans = new Stack<>();
        ans.push(PointsToCheck);
        return ans;
    }
}
