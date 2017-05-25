import java.util.Random;
import java.util.*;

/**
 * Created by Barnabas_Ravindranath on 4/30/17.
 */
public class Heap {


    private static final int d = 2, scope = 100000;
    private static int sizeofHeap;
    private static int currentSize;
    private int array [];
    private int swap = 0;


    public Heap(){


    }


    public Heap(int capacity){

        currentSize = 0;
        sizeofHeap = capacity;
        array = new int[sizeofHeap + 1];
        Arrays.fill(array, -1);

    }

    public void insert_Algorithm_1() {

        if (isFull()) {
            throw new NoSuchElementException("Overflow Exception");
        }

        for (int a = 0; a < sizeofHeap; a++) {

            Random rand = new Random();

            //Percolate Up
            array[currentSize++] = rand.nextInt(scope) + 1;
            percolateUp(currentSize - 1);
        }
    }

        public void insert_Algorithm_2(){

            if(isFull()){
                throw new NoSuchElementException("Overflow Exception");
            }
            int a;
            int parentIndexOfLastElement = (sizeofHeap-1-1)/2;
            for(a = 0; a < sizeofHeap; a ++) {
                Random rand = new Random();
                array[a] = rand.nextInt(scope) + 1;
                currentSize++;
                //percolateUp(currentSize - 1);
            }

            System.out.println("A :" + a);
            while(parentIndexOfLastElement >= 0) {
                modifyheap(getparent(parentIndexOfLastElement));
                parentIndexOfLastElement--;
            }

        }


        public void modifyheap(int parentIndex){

            int rightChildIndex = getrightchild(parentIndex);
            int leftChildIndex = getleftChild(parentIndex);

            if(rightChildIndex < sizeofHeap){
                if(array[parentIndex] > array[rightChildIndex]){
                    //do swap
                    int temp = array[rightChildIndex];
                    array[rightChildIndex] = array[parentIndex];
                    array[parentIndex] = temp;
                    swap++;
                    modifyheap(rightChildIndex);
                }
            }

            if(leftChildIndex < sizeofHeap){
                if(array[parentIndex] > array[leftChildIndex]){
                    swap++;
                    int temp = array[leftChildIndex];
                    array[leftChildIndex] = array[parentIndex];
                    array[parentIndex] = temp;

                    modifyheap(leftChildIndex);

                }
            }


        }



    public int getMin(int num){

        int bestChild = getchild(num, 1);
        int k = 2;
        int pos = getchild(num, k);
        while((k <= d) && (pos < currentSize)){
            if(array[pos] < array[bestChild]){
                bestChild = pos;
            }
            pos = getchild(num, k++);
        }

        return bestChild;
    }

    public int deleteMin(){


        int minItem = array[0];
        delete(0);
        percolateDown(1);

        return minItem;
    }

    public int delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = array[ind];
        array[ind] = array[currentSize - 1];
        currentSize--;
        percolateDown(ind);
        return keyItem;
    }


    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == array.length;
    }

    public void makeEmpty(){
        currentSize = 0;
        swap = 0;
        array = null;



    }


    public void printHeap()
    {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(array[i] +" ");
        }

        System.out.println();
    }

    public int totalSwaps(){
        return swap;
    }

    private void percolateUp(int num){

        int tmp = array[num];
        while(num > 0 && tmp < array[getparent(num)]){
            array[num] = array[getparent(num)];
            num = getparent(num);
            swap++;
        }

        array[num] = tmp;

    }

    private void percolateDown(int hole){

        int child;
        int tmp = array[hole];

        while(getchild(hole, 1) < currentSize){

            child = getMin(hole);
            if(array[hole] < tmp) array[hole] = array[child];

            else break;

            hole =  child;
        }

        array[hole] = tmp;
    }

    private int getleftChild(int position){

        return position * d + 1 ;
    }

    private int getrightchild(int position){

        return position * d + 2;
    }



    private int getparent(int i){
        return (i-1)/d;
    }

    private int getchild(int i, int k){
        return d * i + k;
    }

    private void buildHeap() {
        for(int i = currentSize / 2; i > 0; i--){
            percolateDown(i);
        }

    }

    private void enlargeArray(int newSize){

        int [] old = array;
        array = new int[newSize];
        for(int i = 0; i < old.length; i++){
            array[i] = old[i];
        }

    }

}
