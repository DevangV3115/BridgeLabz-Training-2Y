class AddOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 9};

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                break;
            }
            arr[i] = 0;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
