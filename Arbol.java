package Arbol;

public class Arbol {
  Nodo nodo_raiz = null;
  private Nodo nodo_actual = null;

  public void añadir_nodo(String dato) {
    Nodo nuevo_nodo = new Nodo();
    nuevo_nodo.dato = dato;

    if (nodo_raiz == null) {
      nodo_raiz = nodo_actual = nuevo_nodo;
    } else {
      nuevo_nodo.dad = nodo_actual;
      nodo_actual.children.add(nuevo_nodo);
    }
  }

  public void añadir_nodo_ruta(String dato) {
    nodo_actual = nodo_raiz;

    String[] lista_nodos = dato.split("/");
    String txt = "";

    boolean add = false;

    Nodo temp_1 = new Nodo();
    temp_1 = nodo_raiz;

    for (int i = 0; i < lista_nodos.length; i++) {
      if (temp_1.dato.equals(lista_nodos[i]) == false) {
        if (i == lista_nodos.length - 1) {
          add = true;
          txt = lista_nodos[i];
        }
        break;
      }

      if (i <= lista_nodos.length - 3) {
        bajar_nivel(lista_nodos[i + 1]);
        temp_1 = nodo_actual;
      }
    }

    if (add == true) {
      añadir_nodo(txt);
    } else {
      System.out.println("No se puede agregar la ruta");
    }
  }

  public void subir_nivel() {
    nodo_actual = nodo_actual.dad;
  }

  public void bajar_nivel(String b) {
    if (nodo_actual.children.actual != null) {
      Nodo p, c = new Nodo();
      p = nodo_actual.children.base;
      c = nodo_actual.children.cima;

      while (b.equals(p.dato) == false && p.dato.equals(c.dato) == false) {
        System.out.println(" " + p.dato);
        p = p.sig;
      }
      if (b.equals(p.dato)) {
        nodo_actual = p;
      } else {
        System.out.println("La direccion no existe");
      }
    } else {
      System.out.println("La direccion no existe");
    }
  }

  int espacio = 0;

  public void contenido_directorio(Nodo nodo_raiz) {
    String tab = "";

    Nodo temp_1 = new Nodo();
    temp_1 = nodo_raiz;

    while (temp_1 != null) {
      for (int i = 1; i <= espacio; i++) {
        tab += "\t";
      }

      Children tem_a = new Children();
      tem_a = temp_1.children;
      Nodo temp_2 = new Nodo();
      temp_2 = tem_a.base;

      espacio += 1;
      contenido_directorio(temp_2);

      espacio -= 1;
      tab = "";

      temp_1 = temp_1.sig;
    }
  }

  public String ruta_nodo_actual() {
    String ruta = "";

    Nodo temp = new Nodo();
    temp = nodo_actual;

    while (temp != null) {
      ruta = temp.dato + ruta;
      temp = temp.dad;
      ruta = "/" + ruta;
    }

    return ruta;
  }

  public void eliminar_nodo(String line) {
    Nodo temp1_nodo = new Nodo();
    temp1_nodo.dato = line;

    nodo_actual.children.delete(temp1_nodo);
  }

  public void anular_directorio() {
    nodo_raiz.children.base = null;
    nodo_raiz.children.cima = null;
    nodo_raiz.children.actual = null;

    nodo_actual = nodo_raiz;
  }
}
