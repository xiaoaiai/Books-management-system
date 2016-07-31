package xinxilei;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
     public static void main(String[] args) throws Exception {
//		AdminDao add=new AdminDao();
//		List<Admin> li=new ArrayList<Admin>();
//		li=add.select();
//		for(Admin ad:li){
//			System.out.print(ad.getId()+"\t");
//			System.out.print(ad.getName()+"\n");
//		}
    	 Management m=new Management();
    	 m.menu();
//    	 Date date=new Date();
//    	 DateFormat format=new SimpleDateFormat("yyyy.MM.dd");
//    	 String time=format.format(date);
//    	 System.out.println(time);
//    	 Book b=new Book();
//    	 b.setBookname("java");
//    	 int state=1;
//    	 System.out.println(b.toString(b, state));
//    	 Management m=new Management();
//    	 m.menu();
//    	 UsersDao ud=new UsersDao();
//    	 List<Users> li=new ArrayList<Users>();
//    	 li=ud.select();
//    	 for(Users u:li){
//    		 System.out.print(u.getId()+"\t");
//    		 System.out.print(u.getName()+"\t");
//    		 System.out.print(u.getSex()+"\t");
//    		 System.out.print(u.getAge()+"\t");
//    		 System.out.print(u.getIdentitycard()+"\t");
//    		 System.out.print(u.getWorkdate()+"\t");
//    		 System.out.print(u.getTel()+"\t");
//    		 System.out.print(u.getYajin()+"\t");
//    		 System.out.print(u.getPassword()+"\t");
//    		 System.out.print(u.getAdmin()+"\n");
//    	 }
//    	 Scanner input=new Scanner(System.in);
//    	 System.out.print("请输入用户名：");
//    	 String name=input.next();
//    	 System.out.print("请输入密码：");
//    	 String password=input.next();
//    	 UsersDao ud=new UsersDao();
//    	 List<Users> li=new ArrayList<Users>();
//    	 try {
//			li=ud.select();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for(Users u:li){
//			if(u.getName().equals(name)&&u.getPassword().equals(password)){
//				System.out.println("登陆成功！");;
//			}
//				
//			}
//		System.out.println("用户名或密码不正确，请查证后重新登陆！");
//			}
     }
}
