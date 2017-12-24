public class Day3 {

    public static void main(String args[]) {
        int solution = 0;
        int input = 312051;
        int[][] matrix = new int[99][99];
        int x = 44;
        int y = 45;

        matrix[x][y] = 1;
        int currentValue = 0;
        int step = 1;
        int dir = 1;
        int iteration = 0;

        while(true) {
            for(int i=1; i<=step; i++) {
                if (iteration % 2 == 0) {
                    x += dir;
                } else {
                    y += dir;
                }

                updateMatrix(matrix, x, y);
                currentValue = matrix [x][y];

                System.out.println(String.format("x=%s, y=%s, value=%s",x, y, currentValue));
                if (currentValue > input) {
                    return;
                }
            }
            if (iteration++ % 2 == 0) {
                dir *= -1;
            } else {
                step++;
            }
        }
    }

    private static void updateMatrix(int[][] matrix, int x, int y) {
        matrix[x][y] += matrix[x-1][y-1];
        matrix[x][y] += matrix[x-1][y];
        matrix[x][y] += matrix[x-1][y+1];
        matrix[x][y] += matrix[x][y-1];
        matrix[x][y] += matrix[x][y+1];
        matrix[x][y] += matrix[x+1][y-1];
        matrix[x][y] += matrix[x+1][y];
        matrix[x][y] += matrix[x+1][y+1];
    }
}
