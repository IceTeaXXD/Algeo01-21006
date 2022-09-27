package Matrix;
import java.util.*;

public class Matrix {
    public static double[][] InputMatrix(){
        // get m rows and n colls
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris (m): ");
        int m = sc.nextInt();
        System.out.print("Masukkan jumlah kolom (n): ");
        int n = sc.nextInt();
        // create matrix
        double[][] matrix = new double[m][n];
        // input 1 row of matrix in 1 line (separated by space)
        System.out.println("Masukkan elemen-elemen matriks");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = sc.nextDouble();
            }
        }
        
        sc.close();
        return matrix;
    }

    public static void outputMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double DetByGauss(double[][] matrix){
        // call copy function
        double[][] copy = CopyMatrix(matrix);

        // call gauss function
        Gauss(copy);
        // calculate determinant
        double det = 1;
        for (int i = 0; i < copy.length; i++){
            det *= copy[i][i];
        }
        return det;
    }

    public static void Gauss(double[][] matrix){
        // eliminasi gauss
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            // cari pivot
            int pivot = i;
            for (int j = i + 1; j < m; j++){
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[pivot][i])){
                    pivot = j;
                }
            }
            // swap baris
            if (pivot != i){
                double[] temp = matrix[i];
                matrix[i] = matrix[pivot];
                matrix[pivot] = temp;
            }
            // eliminasi
            for (int j = i + 1; j < m; j++){
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i; k < n; k++){
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }
    }

    public static double[][] CopyMatrix(double[][] matrix){
        // copy matrix
        double[][] copy = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                copy[i][j] = matrix[i][j];
            }
        }
        return copy;
    }
}