import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 10/06/2017.
 */

public class CycleDetection {

    /**
     * Cycles detector
     * @param vertexList
     */
    public boolean detectCycles(ArrayList<VertexAlgorithm> vertexList) {
        for (VertexAlgorithm vertex : vertexList) {
            if (!vertex.isVisited()) {
                return detectarCiclo(vertex);
            }
        }

        return false;
    }


    /**
     * DFS cycle detector
     * @param vertex
     */
    private boolean  detectarCiclo(VertexAlgorithm vertex) {
        vertex.setVisited(false);
        vertex.setBeingVisited(true);

        for (Edge e : vertex.getAdjacenciesEdgeList()  ) {

            VertexAlgorithm v = e.getTargetVertex();

            if (v.isBeingVisited()) {
                return true;
            }
            if (!v.isVisited()) {
                v.setVisited(true);
                detectarCiclo(v);
            }
        }

        return false;
    }
}
