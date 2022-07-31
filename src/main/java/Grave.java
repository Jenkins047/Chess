import java.util.HashMap;

public class Grave {
    private HashMap<String, Figure> figures;

    Grave()
    {
        figures = new HashMap<>();
    }

    public void bury(String id, Figure fig) { figures.put(id, fig); }
    public Figure resurect(String id) {
        Figure ref = figures.get(id);
        figures.remove(id);
        return ref;
    }

    public int getPopulation()
    {
        return figures.size();
    }
}
