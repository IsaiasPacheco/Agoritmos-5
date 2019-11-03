import java.util.Comparator;

public class Comparador implements Comparator<Nodo>{
    public int compare( Arista x, Arista y){
        if( x.getPeso() == y.getPeso() ){
            return 0;
        }else if( x.getPeso() > y.getPeso() ) {
            return 1;
        }else{
            return -1;
        }
    }
}