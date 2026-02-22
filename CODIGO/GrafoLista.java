import java.util.*;

public class GrafoLista {

    private HashMap<String, List<String>> grafo;

    public GrafoLista() {
        grafo = new HashMap<>();
    }

    public void agregarVertice(String v) {
        grafo.putIfAbsent(v, new ArrayList<>());
    }

    public void agregarArista(String v1, String v2) {
        grafo.get(v1).add(v2);
        grafo.get(v2).add(v1);
    }

    public void mostrarGrafo() {
        for (String v : grafo.keySet()) {
            System.out.println(v + " -> " + grafo.get(v));
        }
    }

    public static void main(String[] args) {

        GrafoLista g = new GrafoLista();

        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");

        g.agregarArista("A", "B");
        g.agregarArista("A", "C");
        g.agregarArista("B", "D");

        g.mostrarGrafo();
    }
}