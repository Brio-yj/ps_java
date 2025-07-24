package week1;
import java.util.*;
import java.io.*;

public class BO10988 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Boolean check = true;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-(i+1))){
                check = false;
            }
        }
        if(check) System.out.print(1);
        else System.out.print(0);

    }
}
