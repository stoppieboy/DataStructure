import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class App {

    public static List<Integer> findKLargestNumbers(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a,b) ->  a-b);
        for(int i = 0; i < k; i++){
            minHeap.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return new ArrayList<>(minHeap);
    }
    
    public static List<Integer> findKSmallestNumbers(int[] nums, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a,b) -> b-a);
        for(int i = 0; i < k; i++){
            maxHeap.add(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            if(nums[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) throws Exception {
        int[] list = {3,5,1,3,8,4,9,4};
        int k = 3;
        List<Integer> topK = App.findKLargestNumbers(list, k);
        List<Integer> bottomK = App.findKSmallestNumbers(list, k);
        System.out.println("Tok "+k+" = "+topK);
        System.out.println("Bottom "+k+" = "+bottomK);
    }
}
