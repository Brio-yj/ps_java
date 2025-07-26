package week2;
import java.util.*;
import java.io.*;
public class BO17298_오큰수_v {
    static class Tuple{
        int idx,val;
        Tuple(int idx,int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Tuple> tList = new ArrayList();
        List<Integer> nList = new ArrayList();

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            tList.add(new Tuple(i,num));
            nList.add(0);
        }
        tList.sort((t1,t2)->{
            int compareCnt = t1.val-t2.val;
            if(compareCnt==0) return t1.idx-t2.idx;
            return t2.val-t1.val;
        });

        nList.set(tList.get(0).idx,-1);
        for(int i=1;i<tList.size();i++){
            Tuple curT = tList.get(i);
            Tuple preT = tList.get(i-1);
            if(curT.val==preT.val){
                nList.set(curT.idx,-1);
            }
            else{
                if(curT.idx>preT.idx) nList.set(curT.idx,-1);
                else nList.set(curT.idx,preT.val);
            }
        }
        for(int i=0;i<nList.size();i++){
            System.out.print(nList.get(i)+" ");
        }
    }
}
