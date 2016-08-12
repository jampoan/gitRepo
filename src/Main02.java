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
        while (in.hasNextLine() ) {//ע��while������case
            
            String sIn = in.nextLine();  // numIn���������
            String s = in.nextLine();  //ϵ����
            
            int numIn = Integer.parseInt(sIn);
            
            String[] c = s.split("\\s+"); //�ÿո���ָ���ַ�������  
        	int size = c.length;  
        	int[] numS = new int[size];  
        	for (int m = 0; m < numS.length; m++) {  
            	numS[m] = Integer.parseInt(c[m]);  //���ַ�������ת����int����  
        	}
            
            int temp=0;     //int�����������
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
