package week1;
import java.util.*;
import java.io.*;

public class BO1620 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap();
        HashMap<Integer, String> reverseMap = new HashMap<>();

        for(int i=1;i<=n;i++){
            String name = br.readLine();
            map.put(name,i);
            reverseMap.put(i,name);
        }
        for(int i=1;i<=m;i++){
            String input =br.readLine();
            try{
                int num = Integer.parseInt(input);
                System.out.println(reverseMap.get(num));
            }catch(NumberFormatException e){
                System.out.println(map.get(input));
            }
        }
    }
}
