package coe528lab2;

/**
 *
 * @author hsuresh
 */
public class ProceduralAbstraction {

    //Requires: None
    //Modifies: None
    //Effects: Returns the factorial of any positive integer x
    private static int factorial(int x) {
        int factorial = 1; //Set default value of factorial to 1

        for (int y = 1; y <= x; y++) //Loop through all integers from 1 to x
            factorial *= y; //Find product of all integers from 1 to x

        return factorial; //Return product (factorial)
    }

    //Requires: None
    //Modifies: None
    //Effects: Returns the smallest positive integer n for which n!
    // is greater than or equal to x, for positive integer x.
    // Otherwise returns 1.
    public static int reverseFactorial(int x) {
        int n; //Stores the smallest positive integer n for which n! is greater than or equal to x

        for(n = 1; factorial(n) < x; n++); //Calculate n using for loop

        return n; //Return n
    }
    
    //Requires: None
    //Modifies: None
    //Effects: If the matrix arr satisfies Nice property, prints the sum and
    // returns true. Otherwise returns false.
    public static boolean isMatrixNice(int[][] arr)
    {
        int length = arr.length; //Stores the length 
        
        //Check if matrix is a square
        for (int i = 0; i < length; i++) //Loop through all rows
        {
            if (arr[i].length != length) //Check if lengths are equal
                return false; //Return false if matrix is not a square
        }
        
        int sum = 0; //Stores the sum of the nice matrix
        
        //Calculate sum of square matrix
        for (int i = 0; i < length; i++) //Loop through diagonal
            sum += arr[i][i]; //Calculate sum
        
        //Calculate row and column sums
        for (int i = 0; i < length; i++)
        {
            int rowSum = 0; //Stores the sum of the row currently being checked
            int colSum = 0; //Stores the sum of the column currently being checked
            
            for (int j = 0; j < length; j++)
            {
                rowSum += arr[i][j]; //Calculate current row sum
                colSum += arr[j][i]; //Calculate current solumn sum
            }
            
            if (rowSum != sum || colSum != sum) //Check if sums are equal
                return false; //Return false if sums are not equal
        }
        
        int diag1Sum = 0; //Stores the sum of the first diagonal
        int diag2Sum = 0; //Stores the sum of the second diagonal
        
        //Calculate sums of each diagonal
        for (int i = 0; i < length; i++)
        {
            diag1Sum += arr[i][i]; //Calculate the sum of the first diagonal
            diag2Sum += arr[i][length - i - 1]; //Calculate the sum of the second diagonal
        }
        
        //Check if diagonal sums are equal
        if (diag1Sum != sum || diag2Sum != sum)
            return false; //Return false if sums are not equal
        
        System.out.println("Sum of nice matrix: " + sum); //Print sum
        return true; //Return true since matrix is nice
    }
    public static void main(String[] args) {
        
        System.out.println("Reverse factorial of 24: " + reverseFactorial(24));
        System.out.println("Reverse factorial of 119: " + reverseFactorial(119));

        int[][] niceMatrix
                = {
                    {2, 7, 6},
                    {9, 5, 1},
                    {4, 3, 8}
                };

        int[][] notNiceMatrix
                = {
                    {-3, 1, 0},
                    {4, -3, 4},
                    {7, -9, 0}
                };

        System.out.println(isMatrixNice(niceMatrix));
        System.out.println(isMatrixNice(notNiceMatrix));
    }
}

