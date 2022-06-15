import java.awt.Point;
import java.util.Stack;

public class EmptySpot extends Figure{
    public EmptySpot(Point p) {
        super(p);
    }

    @Override
    public Stack<Stack<Point>> getMovesToCheck() {
        return new Stack<>();
    }
}
