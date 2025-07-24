package week1;
import java.util.*;
import java.io.*;

public class BO9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            int m = Integer.parseInt(st.nextToken());
            HashMap<String,Integer> map = new HashMap();
            for(int j=0;j<m;j++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                String garbage = st2.nextToken();
                String type = st2.nextToken();
                //if(map.containsKey(type)) map[type]++;
                //else map.put(type,1);
            }
            int sum=1;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                sum *=entry.getValue();
            }
            System.out.println(sum-1);
        }
    }
}
