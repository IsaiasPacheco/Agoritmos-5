import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Adrian on 11/06/2017.
 */
public class App {
    public static void main (String[] args) {

        ArrayList<VertexAlgorithm> vertices = new ArrayList<>();
        vertices.add( new VertexAlgorithm("A")); //0
        vertices.add( new VertexAlgorithm("B")); //1
        vertices.add( new VertexAlgorithm("C")); //2
        vertices.add( new VertexAlgorithm("D")); //3
        vertices.add( new VertexAlgorithm("E")); //4
        vertices.add( new VertexAlgorithm("F")); //5
        vertices.add( new VertexAlgorithm("G")); //6

        vertices.get(0).addNeighbour(new Edge(4, vertices.get(0), vertices.get(1)));
        vertices.get(0).addNeighbour(new Edge(8, vertices.get(0), vertices.get(2)));
        vertices.get(1).addNeighbour(new Edge(9, vertices.get(1), vertices.get(2)));
        vertices.get(1).addNeighbour(new Edge(8, vertices.get(1), vertices.get(3)));
        vertices.get(1).addNeighbour(new Edge(10, vertices.get(1), vertices.get(4)));
        vertices.get(2).addNeighbour(new Edge(1, vertices.get(2), vertices.get(5)));
        vertices.get(3).addNeighbour(new Edge(2, vertices.get(3), vertices.get(2)));
        vertices.get(3).addNeighbour(new Edge(9, vertices.get(3), vertices.get(5)));
        vertices.get(3).addNeighbour(new Edge(7, vertices.get(3), vertices.get(4)));
        vertices.get(4).addNeighbour(new Edge(5, vertices.get(4), vertices.get(5)));
        vertices.get(4).addNeighbour(new Edge(6, vertices.get(4), vertices.get(6)));
        vertices.get(5).addNeighbour(new Edge(2, vertices.get(5), vertices.get(6)));


        ArrayList<Edge> listaAdjacencia = new ArrayList<>();

        for( VertexAlgorithm v : vertices ){
            for( Edge e : v.getAdjacenciesEdgeList() ){
                listaAdjacencia.add( e );
            }
        }

        for( Edge e : listaAdjacencia ){
            System.out.println( e.getStartVertex() + " - " + e.getTargetVertex() + " - " + e.getWeight() );
        }



       CycleDetection cycle = new CycleDetection();
       System.out.println( cycle.detectCycles(vertices));
    }
}
