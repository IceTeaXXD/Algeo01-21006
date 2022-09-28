package Main;
import Matrix.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(
            "Menu"
        );
        // read a matrix
        double[][] matrix = Input_Matrix.MatrixFileInput();
        // output the matrix
        Matrix.outputMatrix(matrix);
        // det by kofaktor
        double det = Matrix.DetByGauss(matrix);
        System.out.println("Determinan = " + det);
        // transpose
        System.out.println("Transpose :");
        double[][] transpose = Matrix.TransposeMatrix(matrix);
        Matrix.outputMatrix(transpose);
    }
}