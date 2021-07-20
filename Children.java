package Arbol;

public class Children {
  Nodo base = null;
  Nodo cima = null;

  Nodo actual = null;

  public void add(Nodo nodo_a_añadir) {
    if (actual == null) {
      actual = nodo_a_añadir;
      cima = actual;
      base = actual;
    } else {
      nodo_a_añadir.ant = actual;
      actual.sig = nodo_a_añadir;
      cima =actual = nodo_a_añadir;
    }
  }

  public void delete(Nodo nodo_a_eliminar) {
    Nodo temp1_nodo = buscar_nodo(nodo_a_eliminar);
    Nodo temp2_nodo = new Nodo(null);

    if (temp1_nodo.dato != null) {
      if (temp1_nodo.ant != null) {
        temp1_nodo.ant.sig = temp1_nodo.sig;
      }

      if (temp1_nodo.sig != null) {
        temp1_nodo.sig.ant = temp1_nodo.ant;
      }
      temp2_nodo = temp1_nodo;
      if (base != cima) {
        if (temp1_nodo == base) {
          temp2_nodo = temp2_nodo.sig;
          temp2_nodo.ant = null;
          base = temp2_nodo;
        }
        if (temp1_nodo == cima) {
          temp2_nodo = temp2_nodo.ant;
          temp2_nodo.sig = null;
          cima = temp2_nodo;
        }
      } else {
        base = null;
        cima = null;
        actual = null;
      }

      System.out.println("\tEl nodo " + nodo_a_eliminar.dato + " se ha eliminado");
    }
  }

  public Nodo buscar_nodo(Nodo nodo_a_buscar) {
    Nodo temp1_nodo = cima;
    Nodo temp2_nodo = new Nodo(null);

    while (temp1_nodo != null && nodo_a_buscar.dato.equals(temp1_nodo.dato) == false) {
      temp1_nodo = temp1_nodo.ant;
    }

    if (temp1_nodo == null) {
      System.out.println("\tEl nodo " + nodo_a_buscar.dato + " no existe");
    } else {
      temp2_nodo = temp1_nodo;
    }

    return temp2_nodo;
  }
}
