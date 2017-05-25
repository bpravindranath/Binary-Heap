import java.util.Scanner;


/**
 * Created by Barnabas_Ravindranath on 4/30/17.
 */
public class BinaryHeap {

    public static void main(String[] args) {

        long startTime = 0;
        char ch;
        boolean insert = false;




        Scanner scan = new Scanner(System.in);


        System.out.println("Binary Heap");
        System.out.println("Enter Size of the Binary Heap:");
        int x = scan.nextInt();

        Heap binaryheap = new Heap(x);

        do {

            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. Insert Random Numbers and Start Algorithm O(n log n) ");
            System.out.println("2. Insert Random Numbers and Start Algorithm O(n) ");
            System.out.println("3. Delete Min");
            System.out.println("4. Clear Heap");
            System.out.println("5. Re-enter Heap Size");

            int choice = scan.nextInt();

            switch (choice) {

                case 1:

                    try {
                        System.out.println("\nInserting " + x + " Numbers in O( n log n) Binary Heap\n");
                        startTime = System.nanoTime();
                        binaryheap.insert_Algorithm_1();

                        insert = true;
                    }

                    catch (Exception e) { System.out.println(e.getMessage());}

                    break;

                case 2: {

                    try {
                        System.out.println("\nInserting " + x + " Numbers in O(n) Binary Heap\n");
                        startTime = System.nanoTime();
                        binaryheap.insert_Algorithm_2();

                        insert = true;
                    }

                    catch (Exception e) { System.out.println(e.getMessage());}

                    break;


                }

                case 3:

                    try { System.out.println("Min Element: " + binaryheap.deleteMin()); }

                    catch (Exception e) {System.out.println(e.getMessage());}

                    break;

                case 4: {

                    binaryheap.makeEmpty();

                    System.out.println("\nHeap Cleared\n");

                    break;
                }

                case 5: {

                    System.out.println("\nEnter Size of the Binary Heap:");

                    x = scan.nextInt();

                    binaryheap = new Heap(x);

                    break;

                }
                default:

                    System.out.println("\nWrong Entry \n ");

                    break;

            }
            binaryheap.printHeap();



            long estimatedTime = System.nanoTime() - startTime;

             if (insert){

                 System.out.println("\nTotal Swaps: " + binaryheap.totalSwaps());

                 System.out.print("\nRun time for input of " + x + " : " + (double) estimatedTime / 1000000);
                 System.out.print(" Milliseconds\n");
                 System.out.print("\nRun time for input of " + x + " : " + (double) estimatedTime/1000000000.0);
                 System.out.print(" seconds\n");
                 insert = false;

            }

            binaryheap = new Heap(x);
            System.out.println("\nDo you want to continue? (Type Y or N) \n");
            ch = scan.next().charAt(0);

        } while(ch == 'Y' || ch == 'y');


    }

}