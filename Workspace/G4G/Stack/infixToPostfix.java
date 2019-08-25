/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    String s = sc.next();
		    System.out.println(infixToPostfix(s));
		}
	}
	public static String infixToPostfix(String s){
	    HashMap<Character,Integer> prec = new HashMap<>();
	    prec.put('+',1);
	    prec.put('-',1);
	    prec.put('*',2);
	    prec.put('/',2);
	    prec.put('^',3);
	    
	    Stack<Character> stack = new Stack<>();
	    String expression = "";
	    for(int i=0;i<s.length();i++){
	        char cc = s.charAt(i);
	        int offset = cc - 'A';
	        if(offset>=0 && offset<=25){
	            expression+=cc;
	        }
	        else if(offset>=32 && offset<=57){
	            expression+=cc;
	        }
	        else if(cc=='('){
	            stack.push('(');
	        }
	        else if(cc==')'){
	            while(stack.size()>0 && stack.peek()!='('){
	                expression+=stack.pop();
	            }
	            stack.pop();
	        }
	        else{
	            if(stack.isEmpty() || stack.peek()=='('){
	                stack.push(cc);
	            }
	            else if(prec.get(cc)>prec.get(stack.peek())){
	                stack.push(cc);
	            }
	            else{
	                while(stack.size()>0 && stack.peek()!='(' && prec.get(cc)<=prec.get(stack.peek())){
	                    expression+=stack.pop();
	                }
	                stack.push(cc);        
	           }
	            
	        }
	    }
	    while(stack.size()!=0){
	        expression+=stack.pop();
	    }
	    return expression;
	}
}
