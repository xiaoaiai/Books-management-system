package xinxilei;

import java.util.Random;

public class UserNum {
	private static int length=10;
	//²úÉú¿¨ºÅ
	public static String createnumber(){
		StringBuffer str=new StringBuffer();
		for(int i=1;i<=length;i++){
			Random r=new Random();
			str.append(r.nextInt(10));
		}
		return str.toString();
	}
}
