import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0){
	        int n=sc.nextInt();
	        int m=sc.nextInt();
	        LinkedList<Integer> q=new LinkedList<>();
	        for(int i=1;i<=9;i++){
	            q.add(i);
	        }
	        int count=n==0?1:0;
	        while(true){
	            int fr=q.removeFirst();
	            if(n<=fr && fr<=m){
	                count++;
	            }
	            if(fr>m){
	                break;
	            }
	            // consider 78, for this we will add 789 and 787 as the next stepping numbers
	            // this all depends on the last digit
	            // 78 has to listen to only 8 i.e the last digit
	            // as it is the only one going to decide whether
	            // the next number added will be a stepping number or not
	            // i.e for 8 i.e the last digit, we can add 8-1=7 and 8+1=9 in the end
	            // ie. 787 and 789 will be added
	            if(fr%10==0){
    	            q.add(fr*10+fr%10+1);	                
	            }else if(fr%10==9){
    	            q.add(fr*10+fr%10-1);    
	            }else{
    	            q.add(fr*10+fr%10-1);
	                q.add(fr*10+fr%10+1);
	            }
	        }
	        System.out.println(count);
	    }
	 }
}