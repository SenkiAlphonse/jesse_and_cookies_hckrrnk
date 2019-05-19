import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class solution {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {

        int actionCount = 0;

        if (A.length < 1) {
            return -1;
        }
        else if (A.length==1 && A[0] >= k) {
            return actionCount;
        }
        else if (A.length==1 && A[0] < k) {
            return -1;
        }

        PriorityQueue<Integer> pQ = IntStream.of(A)
                .boxed()
                .sorted().collect(Collectors.toCollection(PriorityQueue::new));

        if (k <= pQ.peek()) {
            return actionCount;
        }
        while(pQ.size()>1) {
            if (k <= pQ.peek()) {
                return actionCount;
            }
            else{
                pQ.add(pQ.poll() + 2* pQ.poll());
                actionCount++;
            }
        }
        if (k <= pQ.peek()) {
            return actionCount;
        }
        else {
            return -1;
        }

/*      Arrays.sort(A);
        Stack<Integer> stack = new Stack<>();
        for(int i = A.length-1; i>=0; i--){
            stack.push(A[i]);
        }

        int actionCount = 0;

        while(stack.size()>1) {
            if (stack.peek() >= k) {
                return actionCount;
            }
            else {
                stack.push(stack.pop() + 2 * stack.pop());
                actionCount++;
            }
        }

        if (stack.peek() >= k) {
            return actionCount;
        }
        else {
            return -1;
        }*/

/*        int actionCount = 0;
        if (aList.get(0) >= k) {
            return actionCount;
        }
        while(aList.size()>1) {
            if (aList.get(0) >= k) {
                return actionCount;
            }
            else {
                Integer nextElement = aList.get(0)+2*aList.get(1);
                if(aList.get(aList.size()-1) < nextElement) {
                    aList.add(nextElement);
                }
                else {
                    for (int i = 1; i < aList.size(); i++) {
                        if (aList.get(i) >= nextElement) {
                            aList.add(i, nextElement);
                            break;
                        }
                    }
                }
                aList.remove(1);
                aList.remove(0);
                actionCount++;
            }
        }
        if (aList.get(0) >= k) {
            return actionCount;
        }
        else {
            return -1;
        }*/
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
