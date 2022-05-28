/* Reduction.java
 * ... illustrates the OpenMP parallel-for loop's reduction clause
 *
 * Joel Adams, Calvin College, November 2009.
 * Adapted for Java/Pyjama by Ruth Kurniawati, Westfield State University, July, 2021
 *
 * Usage: 
 *   make run [numThreads]
 *   Example: make run ARGS=4 
 *
 * Exercise:
 * - Compile and run.  Note that incorrect output is produced by parallelSum()
 * - Uncomment 'reduction(+:sum)' clause of #omp in parallelSum()
 * - Recompile and rerun.  Note that correct output is produced again.
 */

import java.util.Random;

class Reduction {
    final static int SIZE=1000000;

    public static void main(String[] args) {
        if (args.length >= 1) {
            Pyjama.omp_set_num_threads(Integer.parseInt(args[0]));
        }
        System.out.println();

        // Generate SIZE random values in [0..1000) range
        // Fix the seed to 123 so the set of numbers will be the same in each run.
        int[] array = new Random(123).ints(SIZE, 0, 1000).toArray();
        System.out.println("Seq. sum: \t" + sequentialSum(array));
        System.out.println("Par. sum: \t" + parallelSum(array));
    } 


    /* sum the array sequentially */
    static int sequentialSum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    /* sum the array using multiple threads */
    static int parallelSum(int[] a) {
        int sum = 0;
        //#omp parallel shared(a,sum) 
        {
            //#omp for /* reduction(+:sum) */
            for(int i = 0; i < a.length;i++) {
                sum += a[i];
            }
        }
        return sum;
    }

    static int parallelSum2(int[] a) {
        int sum = 0;
        //#omp parallel shared(a,sum) 
        {
            //#omp for 
            for(int i = 0; i < a.length;i++) {
                //#omp critical
                sum += a[i];
            }
        }
        return sum;
    }
}