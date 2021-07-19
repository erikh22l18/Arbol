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

  public void bajar_nivel(String dato) {
    Nodo temp1_nodo = new Nodo();
    temp1_nodo.dato = dato;

    if (nodo_actual == null){
      System.out.println("\tEl nodo actual esta vacío");
    } else {
      Nodo temp2_nodo = nodo_actual.children.buscar_nodo(temp1_nodo);
      if (temp2_nodo == null){
        System.out.println("\tEl nodo pedido no existe");
      } else {
        nodo_actual = temp2_nodo;
      }
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

      Nodo temp_2 = new Nodo();
      temp_2 = temp_1.children.base;

      espacio += 1;
      
      System.out.println(tab + temp_1.dato);
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
