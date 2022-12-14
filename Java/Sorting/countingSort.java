import java.util.*;
public class countingSort {

    private static void print(int[] ar){
        for(int i: ar) System.out.print(i+" ");
        System.out.println();
    }

    private static void sort(int[] ar){

        int size=ar[0];
        for(int i: ar)
            size = i > size ? i:size;
        int[] dp = new int[++size];

        for(int i: ar)
            dp[i]++;

        int index = ar.length-1;
        for(int i = size-1; i >= 0; i--){
            while(dp[i] != 0){
                ar[index--] = i;
                dp[i]--;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array: ");
        String input = sc.nextLine();
        int[] ar = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        sort(ar);
        print(ar);
        sc.close();
    }
}
