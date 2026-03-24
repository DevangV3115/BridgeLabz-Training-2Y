import java.util.*;

public class NextGreaterFrequency {

    public static int[] nextGreaterFrequency(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        // Step 1: Frequency map
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Stack
        Stack<Integer> stack = new Stack<>();

        // Step 3: Traverse from right
        for (int i = n - 1; i >= 0; i--) {

            // Pop until we find greater frequency
            while (!stack.isEmpty() &&
                   freq.get(stack.peek()) <= freq.get(arr[i])) {
                stack.pop();
            }

            // If empty → no greater frequency
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // Push current element
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 3, 2, 1};

        int[] res = nextGreaterFrequency(arr);

        System.out.println("Output:");
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}