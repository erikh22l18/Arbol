package Arbol;

public class Arbol {
  Nodo root = null;

  private Nodo current = null;
  private Nodo before = null;

  public void añadir_r(String dato) {
    Nodo nuevo = new Nodo();

    nuevo.dato = dato;

    if (root == null) {
      root = current = before = nuevo;
    } else {
      nuevo.dad = before;
      before.children.add(nuevo);
      current = nuevo;
      before = current;
    }
  }

  public void subir() {
    current = current.dad;
    before = current;
  }

  public void bajar(String b) {
    if (current.children != null) {
      Nodo p = new Nodo();
      p = current.children.base;
      System.out.println(p.dato);
      while (b.equals(p.dato) == false) {
        p = p.sig;
      }
      if (b.equals(p.dato) == false) {
        System.out.println("La direccion no existe");
      } else {
        before = current = p;
      }
    } else {
    }
  }

  public void contenido(Nodo root) {
    Nodo p = new Nodo();
    p = root;

    while (p != null) {
      System.out.println(p.dato);
      Niv q = new Niv();
      q = p.children;

      Nodo e = new Nodo();
      e = q.base;

      contenido(e);
      p = p.sig;
    }
  }

  public String ruta() {
    String path = "";
    
    Nodo p = new Nodo();
    p = current;

    while (p != null) {
      path = p.dato + path; 
      p = p.dad;
      path = "/"+ path;
    }

    return path;
  }
}
