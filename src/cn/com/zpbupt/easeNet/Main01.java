package cn.com.zpbupt.easeNet;

import java.util.Scanner;

//this is a selution for the test of a company

public class Main01 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            
            int numIn = in.nextInt();  // numIn是输入的数
            
            if(numIn == 0 || numIn == 1 || numIn == 2 || numIn == 3)
                System.out.println( 0 );
            else{
                
                int preNum=1;
        		int prePreNum=0;
        		int result=0;
                while(numIn > result){
                    result=preNum+prePreNum;
            		prePreNum=preNum;
           			preNum=result;
                }
                if(numIn == result)
                    System.out.println( 0 );
                else{
                    System.out.println( (result - numIn) > (numIn - preNum) ? (numIn - preNum) :(result - numIn) );
                }
        		
            }
        }
            
       
    }

}
