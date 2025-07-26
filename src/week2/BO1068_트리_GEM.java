package week2;
import java.util.*;
import java.io.*;
public class BO1068_트리_GEM {
    static List<List<Integer>> adjList;
    static int deleteNode;
    static int leafCount = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) adjList.add(new ArrayList());

        // 1. 인접 리스트로 트리 구성
        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rootNode = 0;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                rootNode = i;
            } else {
                adjList.get(parent).add(i);
            }
        }
        deleteNode = Integer.parseInt(br.readLine());
        if (deleteNode == rootNode) {
            System.out.println(0);
            return;
        }
        dfs(rootNode);
    }
    static void dfs(int node){
        boolean isLeaf = true;
        for(int child : adjList.get(node)){
            if(child==deleteNode) continue;
            isLeaf = false;
            dfs(child);
        }
        if(isLeaf) leafCount++;
    }
}
