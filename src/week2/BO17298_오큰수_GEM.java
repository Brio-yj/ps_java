package week2;
import java.io.*;
import java.util.*;
public class BO17298_오큰수_GEM {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] res = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        Stack<Integer> st = new Stack();
        for(int i=0;i<N;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                res[st.peek()]=arr[i];
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            res[st.pop()] = -1;
        }
    }
}
