import java.util.*;;

public class GrafoListaDfs {

    private HashMap<String, List<String>> grafo = new HashMap<>();

    public void agregarVertice(String v) {
        grafo.putIfAbsent(v, new ArrayList<>());
    }

    public void agregarArista(String v1, String v2) {
        agregarVertice(v1);
        agregarVertice(v2);

        grafo.get(v1).add(v2);
        grafo.get(v2).add(v1);
    }

    public void mostrarGrafo() {
        for (String v : grafo.keySet()) {
            System.out.println(v + " -> " + grafo.get(v));
        }
    }

    public void DFS(String inicio) {
        Set<String> visitados = new HashSet<>();
        dfsRec(inicio, visitados);
        System.out.println();
    }

    private void dfsRec(String v, Set<String> visitados) {
        if (!grafo.containsKey(v) || visitados.contains(v)) return;

        System.out.print(v + " ");
        visitados.add(v);

        for (String vecino : grafo.get(v)) {
            dfsRec(vecino, visitados);
        }
    }

    public static void main(String[] args) {

        GrafoListaDfs g = new GrafoListaDfs();

        g.agregarArista("A", "B");
        g.agregarArista("A", "C");
        g.agregarArista("B", "D");

        g.mostrarGrafo();

        System.out.print("DFS desde A: ");
        g.DFS("A");
    }
}