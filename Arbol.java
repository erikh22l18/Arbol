package Arbol;

public class Arbol {
  Nodo nodo_raiz = null;
  private Nodo nodo_actual = null;


  public void añadir_nodo(String dato) {
    Nodo nodo_a_añadir = new Nodo(null);
    nodo_a_añadir.dato = dato;

    if (nodo_raiz == null) {
      nodo_raiz = nodo_actual = nodo_a_añadir;
    } else {
      nodo_a_añadir.dad = nodo_actual;
      nodo_actual.children.add(nodo_a_añadir);
      System.out.println("\tSe ha añadido el nodo " + nodo_a_añadir.dato);
    }
  }

  public void añadir_nodo_ruta(String dato) {
    String[] lista_nodos = dato.split("/");
    String txt = "";

    boolean add = false;

    Nodo temp_1 = new Nodo(null);
    temp_1 = nodo_raiz;

    Nodo temp_2 = new Nodo(null);
    temp_2 = nodo_actual;

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
      System.out.println("\tNo se puede agregar la ruta " + dato + " por que uno de los nodos no existe");
      temp_2 = nodo_actual;
    }
  }

  public void subir_nivel() {
    Nodo temp1_nodo = nodo_actual.dad;
    if (temp1_nodo == null) {
      System.out.println("\tYa no se puede subir más");
    } else{
      nodo_actual = temp1_nodo;
    System.out.println("\tEsta dentro del nodo " + nodo_actual.dato);
    }
}

  public void bajar_nivel(String dato) {
    Nodo temp1_nodo = new Nodo(null);
    temp1_nodo.dato = dato;

    if (nodo_actual.children.actual == null) {
      System.out.println("\tEl nodo " + nodo_actual.dato + " esta vacío");
    } else {
      Nodo temp2_nodo = nodo_actual.children.buscar_nodo(temp1_nodo);
      if (temp2_nodo.dato != null) {
        nodo_actual = temp2_nodo;
        System.out.println("\tEsta dentro del nodo " + nodo_actual.dato);
      }
    }
  }

  int espacio = 0;

  public void contenido_directorio(Nodo nodo_raiz) {
    String tab = "";

    Nodo temp_1 = new Nodo(null);
    temp_1 = nodo_raiz;

    while (temp_1 != null) {
      for (int i = 1; i <= espacio; i++) {
        tab += "\t";
      }

      Nodo temp_2 = new Nodo(null);
      temp_2 = temp_1.children.base;

      espacio += 1;

      System.out.println(tab + temp_1.dato);
      contenido_directorio(temp_2);

      espacio -= 1;
      tab = "";
      
      temp_1 = temp_1.sig;
    }
  }

  public void contenido_directorio_I(Nodo nodo_inicial) {
    String tab = "";

    Nodo temp_1 = new Nodo(null);
    temp_1 = nodo_inicial;

    while (temp_1 != null) {
      for (int i = 1; i <= espacio; i++) {
        tab += "\t";
      }
      System.out.println(tab + temp_1.dato);

      Nodo temp_2 = new Nodo(null);
      temp_2 = temp_1.children.cima;

      espacio += 1;

      contenido_directorio_I(temp_2);

      espacio -= 1;
      tab = "";
      
      temp_1 = temp_1.ant;

    }
  }

  public String ruta_nodo_actual() {
    String ruta = "";

    Nodo temp = new Nodo(null);
    temp = nodo_actual;

    while (temp != null) {
      ruta = temp.dato + ruta;
      temp = temp.dad;
      ruta = "/" + ruta;
    }

    return ruta;
  }

  public void eliminar_nodo(String dato) {
    Nodo temp1_nodo = new Nodo(null);
    temp1_nodo.dato = dato;

    if (nodo_actual == null) {
      System.out.println("\tEl nodo actual esta vacío");
    } else {
      nodo_actual.children.delete(temp1_nodo);
    }
  }

  public void anular_directorio() {
    nodo_raiz.children.base = null;
    nodo_raiz.children.cima = null;
    nodo_raiz.children.actual = null;

    nodo_actual = nodo_raiz;
  }
}


