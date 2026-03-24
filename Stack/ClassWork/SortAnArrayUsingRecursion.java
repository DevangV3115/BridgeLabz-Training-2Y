import java.util.*;

public class SortAnArrayUsingRecursion {

    public static void insert(int[] arr, int n, int key) {
        // Base case
        if (n == 0 || arr[n - 1] <= key) {
            arr[n] = key;
            return;
        }

        // Store last element
        int last = arr[n - 1];

        // Recursive call
        insert(arr, n - 1, key);

        // Put back the last element
        arr[n] = last;
    }

    public static void sort(int[] arr, int n) {
        // Base case
        if (n <= 1) return;

        // Remove last element
        int last = arr[n - 1];

        // Sort remaining array
        sort(arr, n - 1);

        // Insert element at correct position
        insert(arr, n - 1, last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr, n);

        System.out.println("Sorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}