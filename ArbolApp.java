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
    A.bajar_nivel("root");
    A.añadir_nodo("A");
    A.bajar_nivel("A");
    A.añadir_nodo("B");
    A.subir_nivel();
    A.añadir_nodo("C");
    A.añadir_nodo("J");
    A.bajar_nivel("J");
    A.añadir_nodo("K");
    A.bajar_nivel("K");
    A.subir_nivel();
    A.añadir_nodo("E");
    A.bajar_nivel("E");
    A.añadir_nodo("F");
    A.bajar_nivel("F");
    A.añadir_nodo("G");
    A.añadir_nodo("H");
    A.subir_nivel();
    A.subir_nivel();
    A.añadir_nodo("I");

    sw = 1;
    do {

      System.out.println("\n\n" + "************************************\n" + "\tDirectorio de rutas\n"
          + "************************************\n");
      System.out.println("0. Salir");
      System.out.println("1. Inserta ruta");
      System.out.println("2. Inserta nodo a esta ruta");
      System.out.println("3. Subir directorio");
      System.out.println("4. Bajar directorio");
      System.out.println("5. Eliminar nodo de esta ruta");
      System.out.println("6. Eliminar directorio");
      System.out.println("7. Mostrar directorio");

      System.out.println("\nRuta actual: \t/" + A.ruta_nodo_actual() + ">");

      System.out.print("Opción ==> ");

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

        case 5:
          line = sc.nextLine();
          System.out.print("Digite el nodo de esta ruta a eliminar ==> ");
          line = sc.nextLine();
          A.eliminar_nodo(line);
          break;

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
