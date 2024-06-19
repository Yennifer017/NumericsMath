/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package compi1.numericgs;


/**
 *
 * @author yennifer
 */
public class NumericGS {

    public static void main(String[] args) {
        Util util = new Util();
        MatrixUtil matrixUtil = new MatrixUtil();
        GaussSeidel gSeidel = new GaussSeidel();
        int dimention = util.getIntNumber("Ingresa el total de incognitas");
        System.out.println("\nIngresa los datos de la matriz");
        double[][] matrix = matrixUtil.readInfo(dimention, dimention);
        System.out.println("\nIngresa los datos de igualacion");
        double[] vector = matrixUtil.readVector(dimention);
        try {
            double[] solution = gSeidel.solve(matrix, vector, 0.00000001);
            System.out.println("La respuesta es");
            matrixUtil.print(solution);
        } catch (MathException ex) {
            System.out.print(ex);
        }
    }
}
