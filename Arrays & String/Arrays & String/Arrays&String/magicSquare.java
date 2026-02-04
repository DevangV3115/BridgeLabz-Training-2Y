class magicSquare {
    public static void main(String[] args) {
        int[][] a = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8}
        };

        int sum = 0;
        for (int j = 0; j < 3; j++)
            sum += a[0][j];

        boolean magic = true;

        for (int i = 0; i < 3; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < 3; j++) {
                rowSum += a[i][j];
                colSum += a[j][i];
            }
            if (rowSum != sum || colSum != sum)
                magic = false;
        }

        System.out.println(magic ? "Magic Square" : "Not a Magic Square");
    }
}
