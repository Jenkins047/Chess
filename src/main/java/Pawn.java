import java.awt.*;
import java.util.*;

public class Pawn extends Figure{
    Pawn(Color color, Point p) { super(color, p); }

    @Override
    public Stack<Stack<Point>> getMovesToCheck() {
        Stack<Point> ptToCheck = new Stack<>();


        if(getColor() == Color.BLACK) {
            if (this.getPosition().x + 1 <= 7 && this.getPosition().y + 1 <= 7)
                ptToCheck.push(new Point(this.getPosition().x + 1, this.getPosition().y + 1));

            if (this.getPosition().x - 1 >= 0 && this.getPosition().y <= 7)
                ptToCheck.push(new Point(this.getPosition().x - 1, this.getPosition().y + 1));

            if (this.getPosition().y + 1 <= 7)
                ptToCheck.push(new Point(this.getPosition().x, this.getPosition().y + 1));

            if (this.getPosition().y == 1)
                ptToCheck.push(new Point(this.getPosition().x, this.getPosition().y + 2));
        }
        else
        {
            if (this.getPosition().x + 1 <= 7 && this.getPosition().y - 1 > 0)
                ptToCheck.push(new Point(this.getPosition().x + 1, this.getPosition().y - 1));

            if (this.getPosition().x - 1 >= 0 && this.getPosition().y > 0)
                ptToCheck.push(new Point(this.getPosition().x - 1, this.getPosition().y - 1));

            if (this.getPosition().y - 1 > 0)
                ptToCheck.push(new Point(this.getPosition().x, this.getPosition().y - 1));

            if (this.getPosition().y == 6)
                ptToCheck.push(new Point(this.getPosition().x, this.getPosition().y - 2));
        }

        Stack<Stack<Point>> ans = new Stack<>();
        ans.push(ptToCheck);
        return ans;
    }
}
