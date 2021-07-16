package Arbol;

public class Niv {
  Nodo base = null;
  Nodo cima = null;
  
  Nodo actual = null;

  public void add(Nodo nuevo){
    if (actual ==  null) {
      actual = nuevo;
      cima = actual;
      base = actual;
    } else {
      nuevo.ant = actual;
      actual.sig = nuevo;
      actual = nuevo;
      actual.ant = cima;
      cima = nuevo;
    }
  }
}
