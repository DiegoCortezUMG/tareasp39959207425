/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.util.Scanner;

/**
 * @author Usuario
 */
public class busqueda {
    
    // Java implementation of recursive Binary Search
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }
        // We reach here when element is not present
        // in array
        return -1;
    }
    // Driver method to test above
    public static void main(String args[])
    {
        //Declaración de variables
        Scanner entradaDatos = new Scanner(System.in);
        busqueda ob = new busqueda();
        int l=0, arr[] = new int [l];
        System.out.println("Longitud del vector? ");
        l = entradaDatos.nextInt();        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        //inicialización del vector
        System.out.println("Vector inicializado");
        int n = arr.length;
        //Llenado del vector
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Dato en posicion? " + (i) + ":" );
            arr[i] = entradaDatos.nextInt();
        }
        //impresión del vector
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Dato en posicion " + (i) + ": [" + arr[i] + "]" );            
        }
        //Se pide el elemento que se quiere buscar con la búsqueda binaria
        System.out.println("Dato a buscar? ");
        int x = entradaDatos.nextInt();
        //Búsqueda
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Dato no encontrado");
        else
            System.out.println("Dato hallado en el índice:  "
                               + result);
    }
}
/* This code is contributed by Rajat Mishra */    

