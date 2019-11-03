import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue; 
import java.util.Set;

public class Main{

    public static void main(String[] args) {
        
        Grafo grafo = new Grafo();

        Vertice vertices[] = { new Vertice("A"), //0
                               new Vertice("B"), //1
                               new Vertice("C"),//2
                               new Vertice("D"),//3
                               new Vertice("E"),//4
                               new Vertice("F"),//5
                               new Vertice("G")//6
                        };

        grafo.insertarArista(vertices[0], vertices[1], 4); //A-B
        grafo.insertarArista(vertices[0], vertices[2], 8); //A-C 
        grafo.insertarArista(vertices[1], vertices[2], 9); //B-C
        grafo.insertarArista(vertices[1], vertices[3], 8); //B-D
        grafo.insertarArista(vertices[1], vertices[4], 10); //B-E
        grafo.insertarArista(vertices[2], vertices[5], 1); //C-F
        grafo.insertarArista(vertices[3], vertices[2], 2); //D-C
        grafo.insertarArista(vertices[3], vertices[5], 9); //D-F
        grafo.insertarArista(vertices[3], vertices[4], 7); //D-E
        grafo.insertarArista(vertices[4], vertices[5], 5); //E-F
        grafo.insertarArista(vertices[4], vertices[6], 6); //E-G
        grafo.insertarArista(vertices[5], vertices[6], 2); //F-G
        

        
        Comparator p = new Comparator<Arista>() {
            public int compare( Arista x, Arista y){
                return y.getPeso() - x.getPeso();
            }
        };

        Set<Arista> arista = grafo.getAristas();

        int tam = arista.size();

        //Se crea la cola de prioridad con las aristas
        PriorityQueue<Arista> listaAristas = new PriorityQueue<>(tam, p);

        //Se agrega a la cola con prioridades
        arista.forEach( (a) ->{
            listaAristas.add(a);
        });

        Grafo g = new Grafo();

        while( listaAristas.size() > 1 ) {

            Arista a = listaAristas.peek();
            g.insertarArista( a.getVertice1() ,a.getVertice2()  , a.getPeso() );

            listaAristas.poll();

        }

        Set<Arista> nueva = g.getAristas();

        nueva.forEach( (a) -> {
            System.out.println(a.getVertice1() + " - " +a.getVertice2() + " - " + a.getPeso() );
        });

        /*Recorrer la cola
        while( listaAristas.size() > 1 ) {

            Arista a = listaAristas.peek();
            System.out.println( a.getPeso() );

            listaAristas.poll();

        }*/
        
       
        
        
    
    }

}