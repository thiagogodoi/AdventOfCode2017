import java.util.*;

public class Day6 {

    private static int[] memory = {2,8,8,5,4,2,3,1,5,5,1,2,15,13,5,14};

    public static void main(String args[]) {
        Map<String, Integer> alreadySeen = new HashMap<>();
        int it = 0;
        String currentRep;
        do {
            int max = findMaxPos(memory);
            distributeMax(memory, max);
            currentRep = Arrays.toString(memory);
            it++;
            if (!alreadySeen.containsKey(currentRep)) {
                alreadySeen.put(currentRep, it);
            } else {
                int cycleSize = it - alreadySeen.get(currentRep);
                System.out.println(cycleSize);
                break;
            }

        } while (true);

    }

    private static void distributeMax(int[] memory, int maxPos) {
        int completeCycle = memory[maxPos]/memory.length;
        int rest = memory[maxPos] % memory.length;
        memory[maxPos] = 0;

        for(int i=1; i<=memory.length; i++) {
            int curPos = (maxPos + i) % memory.length;
            memory[curPos] += completeCycle + (rest-- > 0 ? 1 : 0);
        }
    }

    private static int findMaxPos(int[] memory) {
        int maxPos =0;
        for(int i=1; i< memory.length; i++) {
            if(memory[i] > memory[maxPos]) {
                maxPos = i;
            }
        }
        return maxPos;
    }
}
