package Arbol;

import java.util.Scanner;

public class ArbolApp {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Arbol A = new Arbol();
    String line;
    int n;
    int sw, opcion;

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
      System.out.print("Opcion ==> ");

      opcion = sc.nextInt();

      switch (opcion) {
        case 0:
          sw = 0;
          break;
        // case 2:
        // break;
        case 2:
          line = sc.nextLine();
          System.out.print("Digite valor a insertar ==> ");
          line = sc.nextLine();
          A.añadir_r(line);
          System.out.println(A.ruta());
          break;
        case 3:
          A.subir();
          System.out.println(A.ruta());
          break;
        case 4:
          line = sc.nextLine();
          System.out.print("Digite valor a insertar ==> ");
          line = sc.nextLine();
          A.bajar(line);
          System.out.println(A.ruta());
          break;
        // case 5:
        // int r = L.quitar();
        // System.out.println(r);
        // break;
        // case 6:
        // L.anula();
        // break;
        case 7:
          A.contenido(A.root);
          break;
      }
    } while (sw == 1);
  }
}
