package xinxilei;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import jdbc.*;

public class Management {
     Scanner input=new Scanner(System.in);
      static int number=2015000;
      static int num=0;
      static int id=5;
     //主界面
     public void menu(){
    	 System.out.println("******************图书信息管理系统**********************");
    	 System.out.println();
    	 System.out.print("\t\t1 管理员界面");
    	 System.out.println("\t\t2 读者界面");
    	 System.out.println("\t\t3 读者注册");
    	 System.out.println();
    	 System.out.println("****************************************************");
    	 System.out.print("请选择界面：");
    	 int choose=input.nextInt();
    	 switch(choose){
    	 case 1:loginad();break;
    	 case 2:loginwr();break;
    	 case 3:enroll();menu();break;
    	 default:menu();break;
    	 }
     }
     /**
      * 管理员登陆界面
      * 增删改查
      * @throws Exception 
      */
     public void loginad(){
    	 System.out.println("-->>管理员界面-->>管理员登陆");
    	 List<Admin> li=viewadmin();
    	 System.out.println("--------------------------------------------"); 
    	 System.out.print("请输入管理员名称：");
 		 String name=input.next();
 		 System.out.print("请输入管理员密码：");
 		 String pass=input.next();
 		 for(Admin ad:li){
 			 if(ad.getName().equals(name)&&ad.getPassword().equals(pass)){
 				 menuad(name);
 			 }
 		 }
 		 System.out.println("用户名或密码不正确，请确认后重新登录！");
 		 loginad();
     }
     
     public void menuad(String admin){
    	 System.out.println("-->>管理员界面-->>管理员登陆>>-->>管理员菜单");
    	 System.out.print("\t\t1 管理员信息管理");
    	 System.out.println("\t\t2 图书信息管理");
    	 System.out.print("\t\t3 用户信息管理");
    	 System.out.println("\t\t4 读者信息管理");
    	 System.out.print("\t\t5 图书类别管理");
    	 System.out.println("\t\t6 返回主界面");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("请选择菜单：");
    	 int choose=input.nextInt();
    	 switch(choose){
    	 case 1:
    		 this.adminmenu(admin);
    		 break;
    	 case 2:
    		 this.bookmenu(admin);
    		 break;
    	 case 3:
    		 this.usermenu(admin);
    		 break;
    	 case 4:
    		 this.readermenu(admin);
    		 break;
    	 case 5:
    		 this.booktypemenu(admin);
    		 break;
    	 default:
    		 this.menu();break;
    	 }
     }
     //管理员信息管理
     public void adminmenu(String admin){
    	 System.out.println("-->>管理员界面-->>管理员登陆>>-->>管理员菜单-->>管理员信息管理");
    	 System.out.print("\t\t1 查看所有管理员名单");
    	 System.out.println("\t\t2 修改管理员信息");
    	 System.out.print("\t\t3 增加管理员信息");
    	 System.out.println("\t\t4 删除管理员信息");
    	 System.out.println("\t\t5 返回管理员界面");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("请选择菜单：");
    	 int choose=input.nextInt();
    	 switch(choose){
    	 case 1:
    		 this.viewadmin();
    		 this.adminmenu(admin);
    		 break;
    	 case 2:
    		 this.updateadmin();
    		 this.adminmenu(admin);
    		 break;
    	 case 3:
    		 this.addadmin();
    		 this.adminmenu(admin);
    		 break;
    	 case 4:
    		 this.deleteadmin();
    		 this.adminmenu(admin);
    		 break;
    	 default:
    		 this.menuad(admin);
    		 break;
    	 }
     }
     //查看所有管理员
     public List<Admin> viewadmin(){
    	 System.out.println("所有管理员名单如下：");
    	 AdminDao add=new AdminDao();
 		 List<Admin> li=new ArrayList<Admin>();
 		 try {
			li=add.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		 for(Admin ad1:li){
 			 System.out.println(ad1.getName());
 		 }
 		 return li;
     }
     //修改管理员信息
     public void updateadmin(){
    	 AdminDao ad=new AdminDao();
    	 Admin a=new Admin();
    	 System.out.print("请输入需要修改的管理员名称：");
    	 String adminname=input.next();
    	 System.out.print("请输入修改后的管理员名称：");
    	 String name=input.next();
    	 System.out.print("请输入修改后的管理员密码：");
    	 String pass=input.next();
    	 a.setName(name);
    	 a.setPassword(pass);
    	 int count=0;
    	 try {
			count=ad.saveupdate(a, adminname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 if(count>0){
    		 System.out.println("修改管理员信息成功！");
    	 }else{
    		 System.out.println("修改管理员信息失败！");
    	 }
     }
     //添加管理员信息
     public void addadmin(){
    	 AdminDao ad=new AdminDao();
    	 Admin a=new Admin();
    	 System.out.print("请输入添加管理员的名称：");
    	 String name=input.next();
    	 System.out.print("请输入添加管理员的密码：");
    	 String pass=input.next();
    	 a.setName(name);
    	 a.setPassword(pass);
    	 int count=0;
    	 try {
			count=ad.saveinsert(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 if(count>0){
    		 System.out.println("添加管理员信息成功！");
    	 }else{
    		 System.out.println("添加管理员信息失败！");
    	 }
     }
     //删除管理员
     public void deleteadmin(){
    	 AdminDao ad=new AdminDao();
    	 Admin a=new Admin();
    	 System.out.print("请输入添加管理员的名称：");
    	 String name=input.next();
    	 a.setName(name);
    	 int count=0;
    	 try {
			count=ad.savedelete(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 if(count>0){
    		 System.out.println("删除管理员信息成功！");
    	 }else{
    		 System.out.println("删除管理员信息失败！");
    	 } 
     }
     //图书信息管理
     public void bookmenu(String admin){
    	 System.out.println("-->>管理员界面-->>管理员登陆>>-->>管理员菜单-->>图书信息管理");
    	 System.out.print("\t\t1 查看所有图书信息");
    	 System.out.println("\t\t2 修改图书信息");
    	 System.out.print("\t\t3 增加图书信息");
    	 System.out.println("\t\t4 删除图书信息");
    	 System.out.println("\t\t5 返回管理员界面");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("请选择菜单：");
    	 int choose=input.nextInt();
    	 switch(choose){
    	 case 1:
    		 this.viewall();
    		 this.bookmenu(admin);
    		 break;
    	 case 2:
    		 this.updatebook(admin);
    		 this.bookmenu(admin);
    		 break;
    	 case 3:
    		 this.addbook();
    		 this.bookmenu(admin);
    		 break;
    	 case 4:
    		 this.deletebook();
    		 this.bookmenu(admin);
    		 break;
    	 default:
    		 this.menuad(admin);
    		 break;
    	 }
     }
     //查看所有图书
     public void  viewall(){
    	 BookDao bd=new BookDao();
    	 List<Book> li=new ArrayList<Book>();
    	 try {
			li=bd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Book b:li){
			System.out.print(b.getIsbn()+"\t");
			System.out.print(b.getTypeid()+"\t");
			System.out.print(b.getBookname()+"\t\t");
			System.out.print(b.getWriter()+"\t\t");
			System.out.print(b.getTranslater()+"\t\t");
			System.out.print(b.getPublisher()+"\t");
			System.out.print(b.getPublishdate()+"\t");
			System.out.print(b.getPrice()+"\t");
			System.out.print(b.getState()+"\n");
		}
     }
     //修改图书信息
     public void updatebook(String admin){
    	 System.out.println("->>管理员界面->>管理员登陆>>->>管理员菜单->>图书信息管理->>修改图书信息");
    	 System.out.println("\t\t1 修改图书所有信息          2 修改图书名");
    	 System.out.println("\t\t3 修改图书价格                  4 修改图书类型");
    	 System.out.println("\t\t5 修改图书标准书号          6 返回管理员界面");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("请选择菜单：");
    	 int choose=input.nextInt();
    	 switch(choose){
    	 case 1:
    		 this.updatebookall(admin);
    		 this.bookmenu(admin);
    		 break;
    	 case 2:
    		 this.updatebookname(admin);
    		 this.bookmenu(admin);
    		 break;
    	 case 3:
    		 this.updatebookprice(admin);
    		 this.bookmenu(admin);
    		 break;
    	 case 4:
    		 this.updatebooktypeid(admin);
    		 this.bookmenu(admin);
    		 break;
    	 case 5:
    		 this.updatebookisbn(admin);
    		 this.bookmenu(admin);
    		 break;
    	 default:
    		 this.bookmenu(admin);
    		 break;
    	 } 
     }
     //修改图书所有信息
     public void updatebookall(String admin){
    	 boolean flag=true;
    	 BookDao bd=new BookDao();
    	 System.out.print("请输入需要修改图书的图书名称：");
    	 String name=input.next();
    	 List<Book> li=new ArrayList<Book>();
    	 try {
			li=bd.select();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(Book b:li){
			 if(b.getBookname().equals(name)){
				 flag=false;
				 Book b1=new Book();
		    	 System.out.print("请输入修改后的国际标准书号：");
		    	 String isbn1=input.next();
		    	 b1.setIsbn(isbn1);
		    	 id=id+1;
		    	 b1.setTypeid(id);
		    	 System.out.print("请输入修改后的书名：");
		    	 String name1=input.next();
		    	 b1.setBookname(name1);
		    	 System.out.print("请输入修改后的作者：");
		    	 String author=input.next();
		    	 b1.setWriter(author);
		    	 System.out.print("请输入修改后的译者：");
		    	 String translater=input.next();
		    	 b1.setTranslater(translater);
		    	 System.out.print("请输入修改后的出版社：");
		    	 String publisher=input.next();
		    	 b1.setPublisher(publisher);
		    	 System.out.print("请输入修改后的出版日期：");
		    	 String publishdate=input.next();
		    	 b1.setPublishdate(publishdate);
		    	 System.out.print("请输入修改后的价格：");
		    	 double price=input.nextDouble();
		    	 b1.setPrice(price);
		    	 System.out.print("请输入修改后的图书状态：");
		    	 int state=input.nextInt();
		    	 b1.setState(state);
		    	 int count=0;
		    	 try {
					count=bd.saveupdate(b1, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("修改图书所有信息成功！");
				}else{
					System.out.println("修改图书所有信息失败！");
				}
			 }
		 }
		 if(flag){
			 System.out.println("不存在图书《"+name+"》，请确认名称后再进行修改！");
			 this.updatebook(admin);
		 }
     }
     //修改图书名
     public void updatebookname(String admin){
    	 boolean flag=true;
    	 BookDao bd=new BookDao();
    	 System.out.print("请输入需要修改图书名的图书名称：");
    	 String name=input.next();
         List<Book> li=new ArrayList<Book>();
    	 try {
			li=bd.select();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(Book b:li){
			 if(b.getBookname().equals(name)){
				 flag=false;
				 System.out.print("请输入修改后的书名：");
		    	 String name1=input.next();
		    	 int count=0;
		    	 try {
					count=bd.updatename(name1, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("修改图书名成功！");
				}else{
					System.out.println("修改图书名失败！");
				}
			 }
		 }
		 if(flag){
			 System.out.println("不存在图书《"+name+"》，请确认名称后再进行修改！");
			 this.updatebook(admin);
		 }
     }
     //修改图书价格
     public void updatebookprice(String admin){
    	 boolean flag=true;
    	 BookDao bd=new BookDao();
    	 System.out.print("请输入需要修改图书价格的图书名称：");
    	 String name=input.next();
    	 List<Book> li=new ArrayList<Book>();
    	 try {
			li=bd.select();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(Book b:li){
			 if(b.getBookname().equals(name)){
				 flag=false;
				 System.out.print("请输入修改后的价格：");
		    	 double price=input.nextDouble();
		    	 int count=0;
		    	 try {
					count=bd.updateprice(price, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("修改图书价格成功！");
				}else{
					System.out.println("修改图书价格失败！");
				}
			 }
		 }
		 if(flag){
			 System.out.println("不存在图书《"+name+"》，请确认名称后再进行修改！");
			 this.updatebook(admin);
		 }
     }
     //修改图书类型编号
     public void updatebooktypeid(String admin){
    	 boolean flag=true;
    	 BookDao bd=new BookDao();
    	 System.out.print("请输入需要修改图书类型编号的图书名称：");
    	 String name=input.next();
    	 List<Book> li=new ArrayList<Book>();
    	 try {
			li=bd.select();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(Book b:li){
			 if(b.getBookname().equals(name)){
				 flag=false;
				 System.out.print("请输入修改后的类型编号：");
		    	 int type=input.nextInt() ;
		    	 int count=0;
		    	 try {
					count=bd.updatetypeid(type, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("修改图书类型编号成功！");
				}else{
					System.out.println("修改图书类型编号失败！");
				}
			 }
		 }
		 if(flag){
			 System.out.println("不存在图书《"+name+"》，请确认名称后再进行修改！");
			 this.updatebook(admin);
		 }
     }
     //修改图书标准书号
     public void updatebookisbn(String admin){
    	 boolean flag=true;
    	 BookDao bd=new BookDao();
    	 System.out.print("请输入需要修改图书标准书号的图书名称：");
    	 String name=input.next();
    	 List<Book> li=new ArrayList<Book>();
    	 try {
			li=bd.select();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(Book b:li){
			 if(b.getBookname().equals(name)){
				 flag=false;
				 System.out.print("请输入修改后的标准书号：");
		    	 String isbn=input.next();
		    	 int count=0;
		    	 try {
					count=bd.updateisbn(isbn, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("修改图书标准书号成功！");
				}else{
					System.out.println("修改图书标准书号失败！");
				}
			 }
		}
		 if(flag){
			 System.out.println("不存在图书《"+name+"》，请确认名称后再进行修改！");
			 this.updatebook(admin);
		 } 
     }
     //增加图书信息
     public void addbook(){
    	 BookDao bd=new BookDao();
    	 Book b=new Book();
    	 System.out.print("请输入需要添加图书的国际标准书号：");
    	 b.setIsbn(input.next());
    	 id=id+1;
    	 b.setTypeid(id);
    	 System.out.print("请输入需要添加图书的书名：");
    	 b.setBookname(input.next());
    	 System.out.print("请输入需要添加图书的作者：");
    	 b.setWriter(input.next());
    	 System.out.print("请输入需要添加图书的译者：");
    	 b.setTranslater(input.next());
    	 System.out.print("请输入需要添加图书的出版社：");
    	 b.setPublisher(input.next());
    	 System.out.print("请输入需要添加图书的出版日期：");
    	 b.setPublishdate(input.next());
    	 System.out.print("请输入需要添加图书的价格：");
    	 b.setPrice(input.nextDouble());
    	 System.out.print("请输入需要添加图书的状态：");
    	 b.setState(input.nextInt());
    	 int count=0;
    	 try {
			count=bd.saveinsert(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("添加成功！");
		}else{
			System.out.println("添加失败！");
		}
     }
     //删除图书信息
     public void deletebook(){
    	 BookDao bd=new BookDao();
    	 System.out.print("请输入需要删除图书的国际标准书号：");
    	 String isbn=input.next();
    	 Book b=new Book();
    	 b.setIsbn(isbn);
    	 int count=0;
    	 try {
			count=bd.savedelete(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("删除成功！");
		}else{
			System.out.println("删除失败！");
		}
     }
     //用户信息管理
     public void usermenu(String admin){
    	 System.out.println("-->>管理员界面-->>管理员登陆>>-->>管理员菜单-->>用户信息管理");
    	 System.out.print("\t\t1 用户信息增加");
    	 System.out.println("\t\t2 用户信息修改");
    	 System.out.print("\t\t3 用户信息删除");
    	 System.out.println("\t\t4 返回管理员界面");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("请选择菜单：");
    	 int choose=input.nextInt();
    	 switch(choose){
    	 case 1:
    		 this.adduser(admin);
    		 this.usermenu(admin);
    		 break;
    	 case 2:
    		 this.updateuser(admin);
    		 this.usermenu(admin);
    		 break;
    	 case 3:
    		 this.deleteuser(admin);
    		 this.usermenu(admin);
    		 break;
    	 default:
    		 this.menuad(admin);
    		 this.menuad(admin);
    		 break;
    	 }
     }
   //添加用户信息
     public void adduser(String admin){
    	 int count=0;
    	 Users u=new Users();
    	 UsersDao ud=new UsersDao();
    	 number=number+1;
    	 u.setId(number);
    	 System.out.print("请输入添加用户的姓名：");
    	 String name=input.next();u.setName(name);
    	 System.out.print("请输入添加用户的性别：");
    	 String sex=input.next();u.setSex(sex);
    	 System.out.print("请输入添加用户的年龄：");
    	 int age=input.nextInt();u.setAge(age);
    	 String str=UserNum.createnumber();
    	 u.setIdentitycard(str);
    	 System.out.println("系统为您产生的证件号码为："+str);
    	 Date date=new Date();
    	 DateFormat format=new SimpleDateFormat("yyyy.MM.dd");
    	 String time=format.format(date);
    	 u.setWorkdate(time);
    	 System.out.print("请输入添加用户的电话号码：");
    	 String tel=input.next();u.setTel(tel);
    	 System.out.print("请输入添加用户的押金：");
    	 int yajin=input.nextInt();u.setYajin(yajin);
    	 System.out.print("请输入添加用户的密码：");
    	 String password=input.next();u.setPassword(password);
    	 u.setAdmin(admin);
    	 try {
			count=ud.saveinsert(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("添加用户成功！");
    	} else{
    		System.out.println("添加用户失败！");
    	}
     }
     //修改用户信息
     public void updateuser(String admin){
    	 System.out.println("->>管理员界面->>管理员登陆>>->>管理员菜单->>图书信息管理->>修改用户信息");
    	 System.out.println("\t\t1 修改用户所有信息             2 修改用户名");
    	 System.out.println("\t\t3 修改用户密码                    4 修改用户年龄");
    	 System.out.println("\t\t5 修改用户的管理员             6 返回管理员界面");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("请选择菜单：");
    	 int choose=input.nextInt();
    	 switch(choose){
    	 case 1:
    		 this.updateuserall(admin);
    		 this.usermenu(admin);
    		 break;
    	 case 2:
    		 this.updateusername(admin);
    		 this.usermenu(admin);
    		 break;
    	 case 3:
    		 this.updateuserpass(admin);
    		 this.usermenu(admin);
    		 break;
    	 case 4:
    		 this.updateuserage(admin);
    		 this.usermenu(admin);
    		 break;
    	 case 5:
    		 this.updateuseradmin(admin);
    		 this.usermenu(admin);
    		 break;
    	 default:
    		 this.usermenu(admin);
    		 break;
    	 } 
     }
     //修改用户所有信息
     public void updateuserall(String admin){
    	 boolean flag=true;
    	 Users u=new Users();
    	 UsersDao ud=new UsersDao();
    	 int count=0;
    	 System.out.print("请输入需要修改信息的用户姓名：");
    	 String name=input.next();
    	 List<Users> li=new ArrayList<Users>();
    	 try {
			li=ud.select();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(Users u1:li){
			 if(u1.getName().equals(name)){
				 flag=false;
				 System.out.print("请输入修改后的编号：");
		    	 int id=input.nextInt();u.setId(id);
		    	 System.out.print("请输入修改后的姓名：");
		    	 String name1=input.next();u.setName(name1);
		    	 System.out.print("请输入修改后的性别：");
		    	 String sex=input.next();u.setSex(sex);
		    	 System.out.print("请输入修改后的年龄：");
		    	 int age=input.nextInt();u.setAge(age);
		    	 System.out.print("请输入修改后的证件号码：");
		    	 String identitycard=input.next();u.setIdentitycard(identitycard);
		    	 System.out.print("请输入修改后的办证日期：");
		    	 String workdate=input.next();u.setWorkdate(workdate);
		    	 System.out.print("请输入修改后的电话号码：");
		    	 String tel=input.next();u.setTel(tel);
		    	 System.out.print("请输入修改后的押金：");
		    	 int yajin=input.nextInt();u.setYajin(yajin);
		    	 System.out.print("请输入修改后的密码：");
		    	 String password=input.next();u.setPassword(password);
		    	 System.out.print("请输入修改后的管理员：");
		    	 String admin1=input.next();u.setAdmin(admin1);
		    	 try {
					count=ud.saveupdate(u, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("修改用户所有信息成功！");
				}else{
					System.out.println("修改用户所有信息失败！");
				} 
			 }
		 }
		 if(flag){
			 System.out.println("不存在用户"+name+"，请确认后进行修改！");
	    	 this.updateuser(admin);
		 }
     }
     //修改用户名
     public void updateusername(String admin){
    	 boolean flag=true;
    	 UsersDao ud=new UsersDao();
    	 int count=0;
    	 System.out.print("请输入需要修改用户名的用户姓名：");
    	 String name=input.next();
    	 List<Users> li=new ArrayList<Users>();
    	 try {
			li=ud.select();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(Users u1:li){
			 if(u1.getName().equals(name)){
				 flag=false;
				 System.out.print("请输入修改后的姓名：");
		    	 String name1=input.next();
		    	 try {
					count=ud.updatename(name1, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("修改用户名成功！");
				}else{
					System.out.println("修改用户名失败！");
				}
			 }
		 }
		 if(flag){
			 System.out.println("不存在用户"+name+"，请确认后进行修改！");
	    	 this.updateuser(admin);
		 }
     }
     //修改用户密码
     public void updateuserpass(String admin){
    	 boolean flag=true;
    	 UsersDao ud=new UsersDao();
    	 int count=0;
    	 System.out.print("请输入需要修改用户密码的用户姓名：");
    	 String name=input.next();
    	 List<Users> li=new ArrayList<Users>();
    	 try {
			li=ud.select();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(Users u1:li){
			 if(u1.getName().equals(name)){
				 flag=false;
				 System.out.print("请输入修改后的密码：");
		    	 String pass=input.next();
		    	 try {
					count=ud.updatepassword(pass, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("修改用户密码成功！");
				}else{
					System.out.println("修改用户密码失败！");
				}
			 }
		 }
		 if(flag){
			 System.out.println("不存在用户"+name+"，请确认后进行修改！");
	    	 this.updateuser(admin);
		 }
     }
     //修改用户年龄
     public void updateuserage(String admin){
    	 boolean flag=true;
    	 UsersDao ud=new UsersDao();
    	 int count=0;
    	 System.out.print("请输入需要修改用户密码的用户姓名：");
    	 String name=input.next();
    	 List<Users> li=new ArrayList<Users>();
    	 try {
			li=ud.select();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(Users u1:li){
			 if(u1.getName().equals(name)){
				 flag=false;
				 System.out.print("请输入修改后的年龄：");
		    	 int age=input.nextInt();
		    	 try {
					count=ud.updateage(age, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("修改用户年龄成功！");
				}else{
					System.out.println("修改用户年龄失败！");
				}
			 }
		 }
		 if(flag){
			 System.out.println("不存在用户"+name+"，请确认后进行修改！");
	    	 this.updateuser(admin);
		 }
     }
     //修改用户管理员
     public void updateuseradmin(String admin){
    	 boolean flag=true;
    	 UsersDao ud=new UsersDao();
    	 int count=0;
    	 System.out.print("请输入需要修改用户密码的用户姓名：");
    	 String name=input.next();
    	 List<Users> li=new ArrayList<Users>();
    	 try {
			li=ud.select();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(Users u1:li){
			 if(u1.getName().equals(name)){
				 flag=false;
				 System.out.print("请输入修改后的管理员：");
		    	 String admin1=input.next();;
		    	 try {
					count=ud.updateadmin(admin1, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("修改用户管理员成功！");
				}else{
					System.out.println("修改用户管理员失败！");
				}
			 }
		 }
		 if(flag){
			 System.out.println("不存在用户"+name+"，请确认后进行修改！");
	    	 this.updateuser(admin);
		 }
     }
     //删除用户信息
     public void deleteuser(String admin){
    	 Users u=new Users();
    	 System.out.print("请输入需要删除的用户姓名：");
    	 u.setName(input.next());
    	 UsersDao ud=new UsersDao();
    	 int count=0;
    	 try {
			count=ud.savedelete(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("删除用户成功！");
		}else{
			System.out.println("删除用户失败！");
		}
    	 
     }
     //读者信息管理
     public void readermenu(String admin){
    	 System.out.println("-->>管理员界面-->>管理员登陆>>-->>管理员菜单-->>读者信息管理");
    	 System.out.print("\t\t1 读者信息查看");
    	 System.out.println("\t\t2 读者信息添加");
    	 System.out.println("\t\t3 返回管理员界面");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("请选择菜单：");
    	 int choose=input.nextInt();
    	 switch(choose){
    	 case 1:
    		 this.viewallreader();
    		 this.readermenu(admin);
    		 break;
    	 case 2:
    		 this.addreader();
    		 this.readermenu(admin);
    		 break;
    	 default:
    		 this.menuad(admin);
    		 break;
    	 }
     }
     //查看所有读者信息
     public void viewallreader(){
    	 ReaderDao wd=new ReaderDao();
    	 List<Reader> li=new ArrayList<Reader>();
    	 try {
			li=wd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Reader r:li){
			System.out.print(r.getId()+"\t");
			System.out.print(r.getName()+"\t");
			System.out.print(r.getSex()+"\t");
			System.out.print(r.getAge()+"\t");
			System.out.print(r.getIdentitycard()+"\t");
			System.out.print(r.getNowdate()+"\t");
			System.out.print(r.getMaxnum()+"\t");
			System.out.print(r.getTel()+"\t");
			System.out.print(r.getKeepmoney()+"\t");
			System.out.print(r.getZj()+"\t");
			System.out.print(r.getZy()+"\t");
			System.out.print(r.getBztime()+"\n");
		}
     }
     //添加读者信息
     public void addreader(){
    	 ReaderDao rd=new ReaderDao();
    	 Reader r=new Reader();
    	 num=num+1;
    	 r.setId(num);
    	 System.out.print("请输入添加读者的姓名：");
    	 String name=input.next();r.setName(name);
    	 System.out.print("请输入添加读者的性别：");
    	 String sex=input.next();r.setSex(sex);
    	 System.out.print("请输入添加读者的年龄：");
    	 int age=input.nextInt();r.setAge(age);
    	 String str=UserNum.createnumber();
    	 r.setIdentitycard(str);
    	 System.out.println("系统为您产生的证件号码为："+str);
    	 Date date=new Date();
    	 DateFormat format=new SimpleDateFormat("yyyy.MM.dd");
    	 String time=format.format(date);r.setNowdate(time);
    	 System.out.print("请输入添加读者的最大书量：");
    	 int maxnum=input.nextInt();r.setMaxnum(maxnum);
    	 System.out.print("请输入添加读者的电话号码：");
    	 String tel=input.next();r.setTel(tel);
    	 System.out.print("请输入添加读者的押金：");
    	 int keepmoney=input.nextInt();r.setKeepmoney(keepmoney);
    	 System.out.print("请输入添加读者的证件类型：");
    	 int zj=input.nextInt();r.setZj(zj);
    	 System.out.print("请输入添加读者的职业：");
    	 String zy=input.next();r.setZy(zy);
    	 UsersDao ud=new UsersDao();
    	 ResultSet rs=null;
    	 String s1=null;
         try {
			rs=ud.findbyname(name);
			while(rs.next()){
				 s1=rs.getString(6);
				 r.setBztime(s1);
			 }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	 int count=0;
    	 try {
			count=rd.saveinsert(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("添加读者成功！");
		}else{
			System.out.println("添加读者失败！");
		}
     }
     //图书类别管理
     public void booktypemenu(String admin){
    	 System.out.println("-->>管理员界面-->>管理员登陆>>-->>管理员菜单-->>图书类别管理");
    	 System.out.println("\t\t1 图书类别添加");
    	 System.out.println("\t\t2 图书类别修改");
    	 System.out.println("\t\t3 返回管理员界面");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("请选择菜单：");
    	 int choose=input.nextInt();
    	 switch(choose){
    	 case 1:
    		 this.addbooktype();
    		 this.booktypemenu(admin);
    		 break;
    	 case 2:
    		 this.updatebooktype();
    		 this.booktypemenu(admin);
    		 break;
    	 default:
    		 this.menuad(admin);
    		 break;
    	 }
     }
     
     //添加图书类型
     public void addbooktype(){
    	 Booktype bt=new Booktype();
    	 BookTypeDao btd=new BookTypeDao();
    	 int count=0;
    	 System.out.print("请输入添加图书类型：");
    	 String typename=input.next();
    	 System.out.print("请输入添加图书类型的编号：");
    	 int id=input.nextInt();
    	 bt.setTypename(typename);
    	 bt.setId(id);
    	 try {
			count=btd.saveinsert(bt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 if(count>0){
    		 System.out.println("添加图书类型成功！");
    	 }else{
    		 System.out.println("添加图书类型失败！");
    	 }
     }
     //修改图书类型
     public void updatebooktype(){
    	 Booktype bt=new Booktype();
    	 BookTypeDao btd=new BookTypeDao();
    	 int count=0;
    	 System.out.print("请输入需要修改的图书类型编号：");
    	 int id=input.nextInt();
    	 System.out.print("请输入修改后的图书类型：");
    	 String typename=input.next();
    	 System.out.print("请输入修改后的图书类型编号：");
    	 int id1=input.nextInt();
    	 bt.setTypename(typename);
    	 bt.setId(id1);
    	 try {
			count=btd.saveupdate(bt, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
   		 System.out.println("修改图书类型成功！");
   	 }else{
   		 System.out.println("修改图书类型失败！");
   	 }
     }
     /**
      * 读者登录界面
      * 查看，借阅，归还，
      */
     //读者登录
     public void loginwr(){
    	 System.out.println("-->>读者界面-->>读者登陆");
    	 System.out.print("请输入读者名：");
    	 String reader=input.next();
    	 System.out.print("请输入密码：");
    	 String password=input.next();
    	 ReaderDao rd=new ReaderDao(); 
    	 List<Reader> li=new ArrayList<Reader>();
    	 try {
			li=rd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Reader r:li){
			if(r.getName().equals(reader)&&r.getPassword().equals(password)){
				menuwr(reader);
			}
		}
    	 System.out.println("用户名或密码不正确或您未注册读者账号，请确认后重新登录!");
    	 loginwr();
     }
     //读者界面
     public void menuwr(String reader){
    	 System.out.println("-->>读者界面-->>读者登陆-->>读者菜单");
    	 System.out.print("\t\t1 查看借阅明细");
    	 System.out.println("\t\t2 借阅图书");
    	 System.out.print("\t\t3 归还图书");
    	 System.out.println("\t\t4 查找图书");
    	 System.out.println("\t\t5 返回主界面");
    	 System.out.println("-------------------------------------------------");
    	 System.out.print("请选择菜单：");
    	 int choose=input.nextInt();
    	 switch(choose){
    	 case 1:
    		 this.view(reader);
    		 this.menuwr(reader);
    		 break;
    	 case 2:
    		 this.borrow(reader);
    		 this.menuwr(reader);
    		 break;
    	 case 3:
    		 this.returnbook(reader);
    		 this.menuwr(reader);
    		 break;
    	 case 4:
    		 this.find();
    		 this.menuwr(reader);
    		 break;
    	 default:
    		 this.menu();
    		 break;
    	 }
     }
     //查看借阅明细
     public void view(String reader){
    	 BorrowbookDao bbd=new BorrowbookDao();
    	 List<Borrowbook> li=new ArrayList<Borrowbook>();
    	 try {
			li=bbd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 System.out.println("读者名"+"\t"+"书名"+"\t"+"借书日期"+"\t\t"+"应还日期"+"\t\t"+"已借天数"+"\t");
		 for(Borrowbook bk:li){
			 if(bk.getBorrower().equals(reader)){
				 System.out.print(bk.getBorrower()+"\t");
				 System.out.print(bk.getBookname()+"\t");
				 System.out.print(bk.getBorrowdate()+"\t");
				 System.out.print(bk.getReturntime()+"\t");
				 System.out.print(bk.getBorrowedday()+"\n");
			 } 
		 }
     }
     //借阅图书
     public void borrow(String reader){
    	 BookDao bd=new BookDao();
    	 Book b=new Book();
    	 Borrowbook bk=new Borrowbook();
    	 System.out.print("请输入需要借阅图书的名称：");
    	 String name=input.next();
    	 bk.setBookname(name);
    	 List<Book> li=new ArrayList<Book>();
    	 try {
			li=bd.select();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	 for(Book b1:li){
    		 if(b1.getBookname().equals(name)&&b.getState()==0){
    			 bk.setBorrower(reader);
    			 Date date=new Date();
    	    	 DateFormat format=new SimpleDateFormat("yyyy.MM.dd");
    	    	 String time=format.format(date);
    	    	 bk.setBorrowdate(time);
    	    	 Date rdate=new Date();
    	    	 DateFormat f=new SimpleDateFormat("yyyy.MM+1.dd");
    	    	 String rtime=f.format(rdate);
		    	 bk.setReturntime(rtime);
		    	 System.out.print("请输入需要借阅图书已借天数：");
		    	 int day=input.nextInt();
		    	 bk.setBorrowedday(day);
		    	 BorrowbookDao bbd=new BorrowbookDao();
		    	 int count1=0;
		    	 try {
					count1=bbd.saveinsert(bk);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	 b.setBookname(name);
		    	 b.setState(1);
		    	 int count=0;
		    	 try {
					count=bd.savemodify(b, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0&&count1>0){
					System.out.println("借阅《"+b.getBookname()+"》成功！");
				}else{
					System.out.println("借阅《"+b.getBookname()+"》失败！");
				}   	  
    			}
		}
     }
     //归还图书
     public void returnbook(String reader){
    	 BookDao bd=new BookDao();
    	 Book b=new Book();
    	 BorrowbookDao bbd=new BorrowbookDao();
    	 int count1=0;
    	 int count=0;
    	 System.out.print("请输入需要归还图书的名称：");
    	 String name=input.next();
    	 b.setBookname(name);
    	 b.setState(0);
    	 try {
			count1=bbd.savedelete(name);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	 try {
			count=bd.savemodify(b, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0&&count1>0){
			System.out.println("归还《"+b.getBookname()+"》成功！");
		}else{
			System.out.println("归还《"+b.getBookname()+"》失败,您可能未借该图书或图书名称不正确！");
		}
	}
   //根据书名查找图书
   	public void find(){
   		System.out.print("请输入需要查找的图书名称：");
   		boolean flag=true;
   		String name=input.next();
   		BookDao bd=new BookDao();
   		List<Book> li=new ArrayList<Book>();
   		try {
			li=bd.select();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Book b:li){
			if(b.getBookname().equals(name)){
				flag=false;
				try {
		   			System.out.println("国际标准书号"+"\t"+"图书类型id"+"\t\t"+"书名"+"\t\t"+"作者"+"\t\t"+"译者"+"\t\t"+"出版社"+"\t"+"出版日期"+"\t\t"+"价格"+"\t"+"状态");
					ResultSet rs=bd.savefind(name);
					while(rs.next()){
						System.out.print(rs.getString(1)+"\t\t");
						System.out.print(rs.getInt(2)+"\t\t");
						System.out.print(rs.getString(3)+"\t\t");
						System.out.print(rs.getString(4)+"\t\t");
						System.out.print(rs.getString(5)+"\t\t");
						System.out.print(rs.getString(6)+"\t");
						System.out.print(rs.getString(7)+"\t");
						System.out.print(rs.getDouble(8)+"\t");
						if(rs.getInt(9)==0){
							System.out.print("未借出"+"\n");
						}else{
							System.out.print("已借出"+"\n");
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(flag){
		System.out.println("不存在图书《"+name+"》！");
		}
   	}
   	//读者注册
   	public void enroll(){
   		boolean b=true;
   		System.out.println("-->>读者注册-->>读者信息注册");
   		UsersDao ud=new UsersDao();
   		ReaderDao rd=new ReaderDao();
   		int count=0;
   		List<Reader> li=new ArrayList<Reader>();
   		System.out.print("请输入需要注册的读者名：");
   		String name=input.next();
   		try {
			li=rd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		Reader r1=new Reader();
   		for(Reader r:li){
   			if(r.getName().equals(name)){
   				System.out.println("该读者已存在，无需重复注册！");b=false;
   			}else{
   			}
   		}
   		if(b){
			try{
			ResultSet rs=ud.findbyname(name);
			while(rs.next()){
				r1.setId(rs.getInt(1));
				r1.setName(rs.getString(2));
				r1.setSex(rs.getString(3));
				r1.setAge(rs.getInt(4));
				r1.setIdentitycard(rs.getString(5));
				r1.setBztime(rs.getString(6));
				r1.setTel(rs.getString(7));
				r1.setKeepmoney(rs.getInt(8));
				r1.setPassword(rs.getString(9));
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("是否现在存钱？（y/n）");
			if(input.next().equalsIgnoreCase("y")){
				System.out.print("所存钱数：");
				int money=input.nextInt();
				r1.setKeepmoney(r1.getKeepmoney()+money);
			}
		   	System.out.print("请问您想注册为哪种证件类型？（1、普通 /2、vip）");
			int zj=input.nextInt();
			r1.setZj(zj);
			System.out.print("您的职业是：");
			String zy=input.next();
			r1.setZy(zy);
			System.out.print("当前日期：");
			String date=input.next();
			r1.setNowdate(date);
			System.out.print("请输入您的最大借书量：");
			int num=input.nextInt();
			r1.setMaxnum(num);
			try {
				count=rd.saveinsert(r1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count>0){
				System.out.println("注册成功！");b=false;
			}else{
				System.out.println("注册失败！");
			} 
   		}
   		
   	}
}
