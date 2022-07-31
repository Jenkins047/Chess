import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FigureViewTest {

    @Test
    void getFilePath() {
        FigureView v = new FigureView(new Pawn(Color.BLACK, new Point(0, 0)));
        assertEquals("src/main/resources/img/black_pawn.png", v.getFilePath());
    }
}