import java.util.Scanner;


public class Main02 {
	
	public static int sumNum(int n, int[] nums){
        int sum = 0;
        for(int i = 0; i < n ; i++){
            sum = sum + nums[i];
        }
        return sum;
    }
    
    public static int proNum(int n, int[] nums){
        int pro = 1;
        for(int i = 0; i < n ; i++){
            pro = pro * nums[i];
        }
        return pro;
    }
    
	@SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine() ) {//注意while处理多个case
            
            String sIn = in.nextLine();  // numIn是输入的数
            String s = in.nextLine();  //系列数
            
            int numIn = Integer.parseInt(sIn);
            
            String[] c = s.split("\\s+"); //用空格将其分割成字符串数组  
        	int size = c.length;  
        	int[] numS = new int[size];  
        	for (int m = 0; m < numS.length; m++) {  
            	numS[m] = Integer.parseInt(c[m]);  //讲字符串数组转换成int数组  
        	}
            
            int temp=0;     //int数组进行排序
        	for (int i = 0; i < numS.length; i++) {  
            	for (int j = 0; j < numS.length-i-1; j++) {  
                	if(numS[j]>numS[j+1]){  
                    	temp=numS[j];  
                    	numS[j]=numS[j+1];  
                    	numS[j+1]=temp;  
                	}  
            	}  
        	}
            
            int luckNum = 0;
            for(int i = 0; i < numIn; i++) {
                if( sumNum(numIn - i , numS) > proNum(numIn - i , numS) )
                    luckNum++;
            }
            
            System.out.println( luckNum );
       
            
        }
            
       
    }
}
