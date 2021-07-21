package Arbol;

public class Nodo {
  String dato;

  Nodo ant;
  Nodo sig;
  
  Nodo dad;
  Children children = new Children();

  public Nodo(String dato) {
    this.dato = dato;
  }
}
