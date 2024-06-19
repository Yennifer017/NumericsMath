/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi1.numericgs;

/**
 *
 * @author yennifer
 */
public class MatrixUtil {

    public double determinante(double[][] matriz) {
        if (matriz.length == 2) {
            return (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]);
        }

        double det = 0;

        for (int i = 0; i < matriz.length; i++) {
            det += matriz[0][i] * cofactor(matriz, 0, i);
        }

        return det;
    }

    private double cofactor(double[][] matriz, int fila, int columna) {
        int n = matriz.length;
        double[][] submatriz = new double[n - 1][n - 1];

        int subi = 0;
        for (int i = 0; i < n; i++) {
            if (i == fila) {
                continue;
            }
            int subj = 0;
            for (int j = 0; j < n; j++) {
                if (j == columna) {
                    continue;
                }
                submatriz[subi][subj] = matriz[i][j];
                subj++;
            }
            subi++;
        }

        return Math.pow(-1, fila + columna) * determinante(submatriz);
    }

    public void print(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void print(double[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(i + " - [" + matrix[i] + "]");
        }
    }

    public double[][] readInfo(int dimx, int dimy) {
        Util util = new Util();
        double[][] matrix = new double[dimx][dimy];
        for (int i = 0; i < dimx; i++) {
            for (int j = 0; j < dimy; j++) {
                matrix[i][j] = util.getIntNumber("Ingrese el dato " + i + "," + j);
            }
        }
        return matrix;
    }

    public double[] readVector(int dim) {
        Util util = new Util();
        double[] vector = new double[dim];
        for (int i = 0; i < dim; i++) {
            vector[i] = util.getIntNumber("Ingrese el dato " + i);
        }
        return vector;
    }

}
