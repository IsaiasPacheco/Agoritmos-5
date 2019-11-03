import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<Vertice> vertices = new ArrayList<>();
        vertices.add( new Vertice("A") ); //0
        vertices.add( new Vertice("B") ); //1
        vertices.add( new Vertice("C") ); //2
        vertices.add( new Vertice("D") ); //3
        vertices.add( new Vertice("E") ); //4
        vertices.add( new Vertice("F") ); //5
        vertices.add( new Vertice("G") ); //6

        Grafo grafo = new Grafo( vertices );
                        
        Arista aristas[] = { 
            new Arista (vertices.get(0), vertices.get(1), 4),
         
            
        };

        for( int i=0; i<aristas.length; i++ ){
            grafo.insertarArista(aristas[i].getVertice1(), aristas[i].getVertice2(), aristas[i].getPeso() );
        }

        int tam = grafo.getAristas().size();

        Comparator comparador = new Comparator<Arista>() {
            public int compare( Arista a, Arista b ){
                return a.getPeso() - b.getPeso();
            }
        };

        PriorityQueue<Arista> listaAristas = new PriorityQueue<>(tam, comparador);

        grafo.getAristas().forEach( (a) -> {
            //System.out.println(">" + a.getVertice1() + " > " + a.getVertice2() + " > " + a.getPeso()  );
            listaAristas.add(a);
        });

        if( esCiclico(7, grafo)){
            System.out.println("Tiene ciclo");
        }

    }

    public static void insertarAristaSinCiclo( Grafo g, Vertice v1, Vertice v2, int peso ){

        //Comprobar si el grafo esta vacio
        if( g.getAristas().size() == 0 ){
            g.insertarArista(v1, v2, peso);
        }else{

            //Obtener aristas
            g.getAristas().forEach( (a) -> {

                //biscar arista con vertice x
                Vertice x = a.getVertice1();
                Vertice y = a.getVertice2(); 

                if( a.getVertice1() == x || a.getVertice2() == x ){
                    System.out.println( ">>>>>>>" +a.getVertice1() + " - " + a.getVertice2() );
                }else{
                    g.insertarArista(v1, v2, peso);
                }

            });

        }
        
    }

    public static boolean tieneCiclo( Vertice v, Boolean visited[], Vertice parent, Grafo g ) {

        visited[ obtenerPoscionVertice(g,v)] = true ;
        Vertice i;

        Iterator<Arista> itr = v.getVecinos().iterator();

        while( itr.hasNext() ){

            i = itr.next().getVertice2();

            if( !visited[ obtenerPoscionVertice(g, i)] ){
                if( tieneCiclo(i, visited, v, g))
                    return true;
            }

            else if( i!= parent ){
                return true;
            }

        }

        return false;
    }

    public static boolean esCiclico( int noVertices , Grafo g ){

        Boolean visited[] = new Boolean[noVertices];
        for( int u = 0; u <noVertices; u++ ){
            visited[u] = false;
        } 

        for( Vertice v: g.getVertices() ){
            if( !visited[obtenerPoscionVertice(g, v)]){
                if( tieneCiclo(v, visited, new Vertice("-1"), g)){
                    return true;
                }
            }
        }

        return false;
    }
    
    

    public static int obtenerPoscionVertice( Grafo  g, Vertice v ){
        int cont =  0;
        for( Vertice ver : g.getVertices() ){
            if( ver.getEtiqueta().equals(v.getEtiqueta())){
                return cont;
            }

            cont ++;
        }

        return -1;
    }

}