import java.io.File;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class AlgEx {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("input.txt"));
        FileWriter writer = new FileWriter("output.txt");
        int vertexNum = scanner.nextInt();
        int[][] mtr = new int[vertexNum][vertexNum];
        int[] indexes = new int[vertexNum];
        int counter = 1;
        int line;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                mtr[i][j] = scanner.nextInt();
            }
        }
        while (counter <= vertexNum) {
            for (int i = 0; i < vertexNum; i++) {
                if(indexes[i] == 0) {
                    queue.add(i);
                    break;
                }
            }
            while (queue.size() != 0) {
                line = queue.remove();
                if (indexes[line] == 0) {
                    indexes[line] = counter++;
                }
                for (int j = 0; j < vertexNum; j++) {
                    if (indexes[j] == 0 && mtr[line][j] == 1) {
                        queue.add(j);
                    }
                }
            }
        }
        for (int i = 0; i < vertexNum - 1; i++) {
            writer.write(indexes[i] + " ");
        }
        writer.write(indexes[vertexNum - 1] + "");
        writer.close();
        scanner.close();
    }
}
