package Arbol;

public class Children {
  Nodo base = null;
  Nodo cima = null;

  Nodo actual = null;

  public void add(Nodo nuevo) {
    if (actual == null) {
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

  public void delete(Nodo eliminado) {
    Nodo temp1_nodo = cima;
    Nodo temp2_nodo = new Nodo();
    if (actual == null)
      System.out.println("Ruta vacía");
    else {
      while (temp1_nodo != null && eliminado.dato.equals(temp1_nodo.dato) == false) {
        temp2_nodo = temp1_nodo;
        temp1_nodo = temp2_nodo.ant;
      }

      if (temp1_nodo == null)
        System.out.println("valor no encontrado");
      else if (temp1_nodo == cima) {
        temp1_nodo = temp1_nodo.ant;
        temp1_nodo.sig = null;
        cima = temp1_nodo.ant;
      } else if (temp1_nodo == base) {
        temp2_nodo.ant = null;
        base = temp2_nodo;
      } else {
        temp1_nodo.ant.sig = temp2_nodo;
        temp2_nodo.ant = temp1_nodo.ant;
        actual = temp2_nodo;
      }
    }
  }

  public Nodo buscar_nodo(Nodo nodo_a_buscar) {
    Nodo temp1_nodo = cima;
    Nodo temp2_nodo = new Nodo();

    while (temp1_nodo != null && nodo_a_buscar.dato.equals(temp1_nodo.dato) == false) {
      temp2_nodo = temp1_nodo;
      temp1_nodo = temp2_nodo.ant;
    }
    // if (nodo_actual.children.actual != null) {
    //   Nodo p, c = new Nodo();
    //   p = nodo_actual.children.base;
    //   c = nodo_actual.children.cima;

    //   while (b.equals(p.dato) == false && p.dato.equals(c.dato) == false) {
    //     System.out.println(" " + p.dato);
    //     p = p.sig;
    //   }
    //   if (b.equals(p.dato)) {
    //     nodo_actual = p;
    //   } else {
    //     System.out.println("La direccion no existe");
    //   }
    // } else {
    //   System.out.println("La direccion no existe");
    // }

    return temp2_nodo;
  }
}
