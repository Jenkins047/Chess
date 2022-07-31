import java.awt.*;
import java.util.Objects;

public class Move {
    public MoveType moveType;
    public Point destination;

    Move(MoveType moveType, Point destination)
    {
        this.moveType = moveType;
        this.destination = destination;
    }

    public MoveType getMoveType() { return moveType; }
    public Point getDestination() { return destination; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return moveType == move.moveType && Objects.equals(destination, move.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveType, destination);
    }
}
