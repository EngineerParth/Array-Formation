import java.io.*;
import java.util.*;


public class ArrayFormation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_A = br.readLine().split(" ");
         int[] A = new int[n];
         for(int i_A=0; i_A<arr_A.length; i_A++)
         {
            A[i_A] = Integer.parseInt(arr_A[i_A]);
         }

         int[][] out_ = queue_and_stack(A);
         for(int i_out_=0; i_out_<out_.length; i_out_++)
         {
            if(out_[i_out_][0]!=0) 
                System.out.print(out_[i_out_][0]);
            for(int j_out_=1; j_out_<out_[i_out_].length; j_out_++)
            {
                if(out_[i_out_][j_out_]!=0)
                    System.out.print(" " + out_[i_out_][j_out_]);
            }
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    static int[][] queue_and_stack(int[] A){
        int top=-1, f=-1, r=-1, l=A.length;
        int res[][] = new int[2][l];
        int s[]=new int[l];
        //int q[]=new int[l];
        for(int i=0;i<l;i++){
            if(isPrime(A[i]))
                s[++top]=A[i];
            else
                //q[++r]=A[i];
                res[0][++r]=A[i];
        }
        // while((++f)<l)
        //     res[0][f]=q[f];
        int k=0;
        while(top>-1)
            res[1][k++]=s[top--];
        return res;
    }
    
    static boolean isPrime(int n){
        int i,m=0;
        m=(int)Math.sqrt(n);      
        for(i=2;i<=m;i++){      
            if(n%i==0)      
                return true;      
        }
        return false;
    }
}