package fc1;
import java.util.ArrayList;

/* 
 * Codigo generado por WIFA Gencompiler
 */

public class Taxi {

     String matricula;
     ArrayList<Chofer> choferes;


    //Constructor con parametros
    public Taxi(Chofer chofer, String string){
        this.matricula = matricula;
        addChofer(chofer);
    }

    //Getters and Setters

    public String getMatricula() {
         return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void addChofer(Chofer element) {
        choferes.add(element);
    }

    public Chofer getChofer(int index){
        if(this.choferes.size()>index){
            Chofer element =choferes.get(index);
            return element;
        }
        else
            throw new IllegalArgumentException ( "Error: Posicion invalida");
    }

    public int findChofer(Chofer element) {
        return choferes.indexOf(element);
    }

    public void setChofer(int index, Chofer element) {
        if(this.choferes.size() > index)
            choferes.set(index,element);
        else
            throw new IllegalArgumentException ( "Error: Posicion invalida");
    }

    public void removeChofer(Chofer element) {
        if(choferes.contains(element))
            choferes.remove(element);
        else
            throw new IllegalArgumentException ( "Error: Chofer no existe");
    }
}
