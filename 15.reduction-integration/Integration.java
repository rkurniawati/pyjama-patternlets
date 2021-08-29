/* Integration.java
 * ... illustrates the OpenMP parallel-for loop's reduction clause for integration
 *
 * Joel Adams, Calvin College, November 2009.
 * Adapted for Java/Pyjama by Ruth Kurniawati, Westfield State University, July, 2021
 *
 * Usage: 
 *   make run ARGS=[numThreads]
 *   Example: make run ARGS=4 
 *
 * Exercise:
 * - Compile and run.  Note that expected output is 2.0.
 * - Run with one thread: make run ARGS=1
 * - Try running with more than one threads, eg. make run ARGS=4
 * - Uncomment 'reduction(+:integration)' clause of #omp in main()
 * - Recompile and rerun.  Note that correct output is produced.
 */

class Integration {
    static double f(double x) {
        return Math.sin(x);
    }
    
    public static void main(String[] args) {
        if (args.length >= 1) {
            Pyjama.omp_set_num_threads(Integer.parseInt(args[0]));
        }
        System.out.println();

        //Variables

        double a = 0.0, b = Math.PI;         //limits of integration
        int n = 1048576;                //number of subdivisions = 2^20
        double h = (b - a) / n;         //width of each subdivision
        double integral;                // accumulates answer

        integral = (f(a) + f(b))/2.0;  //initial value

        //sum up all the trapezoids

        //option 1:
        //#omp parallel for shared(a, h, n, integral) 
        //option 2:
        /*#omp parallel for shared(a, h, n)  reduction(+:integral) */
        for(int i = 1; i < n; i++) {
            integral += f(a+i*h);
        }

        integral = integral * h;
        System.out.printf("With %d trapezoids, our estimate of the integral from \n", n);
        System.out.printf("%f to %f is %f\n", a,b,integral);
    } 
}