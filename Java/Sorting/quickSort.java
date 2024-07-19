import java.util.*;
class quicksort {

    private static void swap(int[] ar, int a, int b){
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

    private static int partition(int[] ar, int s, int e){
        int pivot = ar[e];
        int i = s-1;
        for(int j = s; j < e; j++){
            if(ar[j] < pivot){
                i++;
                swap(ar, i, j);
            }
        }
        swap(ar, e, i+1);
        return i+1;
    }

    private static void sort(int[] ar, int s, int e){
        if(s < e){
            int pi = partition(ar, s, e);
            sort(ar, s, pi-1);
            sort(ar, pi+1, e);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array: ");
        String ar = sc.nextLine();
        int[] array = Arrays.stream(ar.split(" ")).mapToInt(Integer::parseInt).toArray();
        sort(array, 0, array.length-1);
        for(int c: array)
            System.out.print(c+" ");
        sc.close();
    }
}
