package week2;
import java.util.*;
import java.io.*;
public class BO1325_효율적인해킹_v {
    static List<List<Integer>> nList;
    static int N,M;
    static int[] visit;
    static int depth;
    static public void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nList = new ArrayList();
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<=N;i++){
            nList.add(new ArrayList());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            nList.get(B).add(A);
        }

        for(int i=1;i<=N;i++){
            visit = new int[N+1];
            System.out.println("dfs => "+ dfs(i));
            map.put(dfs(i),i);
        }

        List<Integer> mapList = new ArrayList(map.keySet());
        mapList.sort(null);
        int maxVal = mapList.get(0);
        System.out.println("max= "+maxVal);
        for(int i=0;i<mapList.size();i++){
            if(maxVal==mapList.get(i)) System.out.print(map.get(mapList.get(i))+" ");
        }
    }
    static int dfs(int node){
        if(nList.get(node).size()==0) return 0;

        boolean isLeaf = true;
        for(int child : nList.get(node)){
            if(visit[child]==0){
                visit[child] =1;
                isLeaf = false;
                dfs(child);
            }
            if(!isLeaf) depth++;
        }
        return depth;
    }
}
