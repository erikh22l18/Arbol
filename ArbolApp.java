package Arbol;

import java.util.Scanner;

public class ArbolApp {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Arbol A = new Arbol();
    String line;
    int n;
    int sw, opcion;

    A.añadir_nodo("root");
    A.añadir_nodo("A");
    A.añadir_nodo("B");
    A.subir_nivel();
    A.añadir_nodo("C");
    A.subir_nivel();
    A.añadir_nodo("E");
    A.subir_nivel();
    A.añadir_nodo("F");
    A.subir_nivel();
    A.subir_nivel();
    A.añadir_nodo("G");
    A.añadir_nodo("H");
    A.añadir_nodo("I");

    sw = 1;
    do {

      System.out.println("\n\nDirectorio de rutas\n");
      System.out.println("0. Salir");
      System.out.println("1. Inserta ruta");
      System.out.println("2. Inserta nodo");
      System.out.println("3. Subir directorio");
      System.out.println("4. Bajar directorio");
      System.out.println("5. Elimiar esta ruta");
      System.out.println("6. Eliminar directorio");
      System.out.println("7. Mostrar directorio");

      System.out.println("\nRuta actual: \t/" + A.ruta_nodo_actual() + ">");

      System.out.print("Opcion ==> ");

      opcion = sc.nextInt();

      switch (opcion) {
        case 0:
          sw = 0;
          break;

        case 1:
          line = sc.nextLine();
          System.out.print("Digite la nueva ruta ==> ");
          line = sc.nextLine();
          A.añadir_nodo_ruta(line);
          break;

        case 2:
          line = sc.nextLine();
          System.out.print("Digite el nuevo nodo para esta ruta ==> ");
          line = sc.nextLine();
          A.añadir_nodo(line);
          break;

        case 3:
          A.subir_nivel();
          break;

        case 4:
          line = sc.nextLine();
          System.out.print("Digite el nodo a ingresar ==> ");
          line = sc.nextLine();
          A.bajar_nivel(line);
          break;

        // case 5:
        // int r = L.quitar();
        // System.out.println(r);
        // break;

        case 6:
          A.anular_directorio();
          break;

        case 7:
          A.contenido_directorio(A.nodo_raiz);
          break;
      }
    } while (sw == 1);
  }
}
