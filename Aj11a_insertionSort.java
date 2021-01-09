import java.util.Scanner;

public class Aj11a_insertionSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //limitation: 1 <= n <= 100
        int n = Integer.parseInt(scan.nextLine());
        int[] m = new int[n];
        for(int i=0; i<n; i++)
            //limitation: 0<= value <= 1000
            m[i] = Integer.parseInt(scan.next());
        printElements(m);
        insertionSort(m);
    }

    public static void insertionSort(int[] m){
        int v;
        int j;
        for(int i = 1; i <= m.length - 1; i++){
            v = m[i];
            j = i - 1;
            while(j >= 0 && m[j] > v){
                m[j+1] = m[j];
                j--;
                m[j+1] = v;
            }
            printElements(m);
        }
    }

    public static void printElements(int[] m){
        for(int v:m){
            System.out.printf("%d ", v);
        }
        System.out.println();
    }
}
