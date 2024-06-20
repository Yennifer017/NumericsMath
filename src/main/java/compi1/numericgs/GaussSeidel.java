package compi1.numericgs;

/**
 *
 * @author yennifer
 */
public class GaussSeidel {

    private MatrixUtil matrixUtil;

    public GaussSeidel() {
        matrixUtil = new MatrixUtil();
    }
    
    public double[] solve(double [][] matrix, double [] solVector, double errorTol) throws MathException{
        //metodo con algunos valores arbitrarios por defecto
        double[] actualSolution = new double[matrix.length];
        return solve(matrix, solVector, 1f, errorTol, 70000, actualSolution);
    }

    public double[] solve(double[][] matrix, double[] solVector, float lambda, double errorTol, int imax, double[] actualSolutions) throws MathException {
        if (matrix.length != matrix[0].length) {
            throw new MathException("La matriz debe ser cuadrada");
        } else if (actualSolutions.length != matrix.length){
            throw new MathException("El total de soluciones del sistema debe ser igual a las incognitas");
        } else if (!isViable(matrix)) {
            throw new MathException("La matriz debe ser diagonalmente dominante.");
        } else if (matrixUtil.determinante(matrix) == 0) {
            throw new MathException("El determinante de la matriz debe ser distinto de 0");
        } else if (lambda > 2 || lambda < 0){
            throw new MathException("El valor de lambda debe estar entre 0 y 2");
        }

        int totalIncognits = matrix.length;
        
        //despeje para la diagonal principal
        for (int i = 0; i < totalIncognits; i++) {
            double dummy = matrix[i][i];
            for (int j = 0; j < totalIncognits; j++) {
                matrix[i][j] = matrix[i][j] / dummy;
            }
            solVector[i] = solVector[i] / dummy;
        }
        
        //encontrar las soluciones propuestas iniciales si se establecieron valores
        for (int i = 0; i < totalIncognits; i++) {
            double sum = solVector[i];
            for (int j = 0; j < totalIncognits; j++) {
                if(i != j){
                    sum = sum - matrix[i][j] * actualSolutions[j];
                }
            }
            actualSolutions[i] = sum;
        }
        
        int iter = 1;
        while (true) { //proceso iterativo hasta dar con la solucion       
            boolean centinela = true;
            for (int i = 0; i < totalIncognits; i++) {
                double old = actualSolutions[i];
                double sum = solVector[i];
                for (int j = 0; j < totalIncognits; j++) {
                    if(i != j){
                        //evaluacion en la funcion encontrada*
                        sum = sum - matrix[i][j] * actualSolutions[j];
                    }
                }
                //aproximar mas rapido con el valor lambda
                actualSolutions[i] = lambda * sum + (1-lambda) * old ;
                
                if(centinela && actualSolutions[i] != 0){
                    double ea = absoluteValue((actualSolutions[i] - old) / actualSolutions[i]) * 100;
                    if(ea > errorTol){
                        centinela = false;
                    }
                }
            }
            iter++;
            if(centinela || iter >= imax){
                if(iter >= imax){
                    throw new MathException("El sistema no convergio durante las iteraciones indicadas");
                }
                break;
            }
            System.out.println("Iteracion No. " + iter + " ---------------------------------------------------");
            matrixUtil.print(actualSolutions);
            System.out.println();
            
        }
        return actualSolutions;
    }

    private boolean isViable(double[][] matrix) throws MathException {
        if (matrix.length != matrix[0].length) {
            throw new MathException("La matriz debe ser cuadrada");
        }

        for (int y = 0; y < matrix.length; y++) {
            double diagonal = matrix[y][y];
            for (int x = 0; x < matrix.length; x++) {
                if(x != y ){
                    if(absoluteValue(diagonal) < absoluteValue(matrix[y][x])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private double absoluteValue(double number){
        if(number < 0){
            return number * -1;
        }
        return number;
    }

}
    