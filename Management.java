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
     //������
     public void menu(){
    	 System.out.println("******************ͼ����Ϣ����ϵͳ**********************");
    	 System.out.println();
    	 System.out.print("\t\t1 ����Ա����");
    	 System.out.println("\t\t2 ���߽���");
    	 System.out.println("\t\t3 ����ע��");
    	 System.out.println();
    	 System.out.println("****************************************************");
    	 System.out.print("��ѡ����棺");
    	 int choose=input.nextInt();
    	 switch(choose){
    	 case 1:loginad();break;
    	 case 2:loginwr();break;
    	 case 3:enroll();menu();break;
    	 default:menu();break;
    	 }
     }
     /**
      * ����Ա��½����
      * ��ɾ�Ĳ�
      * @throws Exception 
      */
     public void loginad(){
    	 System.out.println("-->>����Ա����-->>����Ա��½");
    	 List<Admin> li=viewadmin();
    	 System.out.println("--------------------------------------------"); 
    	 System.out.print("���������Ա���ƣ�");
 		 String name=input.next();
 		 System.out.print("���������Ա���룺");
 		 String pass=input.next();
 		 for(Admin ad:li){
 			 if(ad.getName().equals(name)&&ad.getPassword().equals(pass)){
 				 menuad(name);
 			 }
 		 }
 		 System.out.println("�û��������벻��ȷ����ȷ�Ϻ����µ�¼��");
 		 loginad();
     }
     
     public void menuad(String admin){
    	 System.out.println("-->>����Ա����-->>����Ա��½>>-->>����Ա�˵�");
    	 System.out.print("\t\t1 ����Ա��Ϣ����");
    	 System.out.println("\t\t2 ͼ����Ϣ����");
    	 System.out.print("\t\t3 �û���Ϣ����");
    	 System.out.println("\t\t4 ������Ϣ����");
    	 System.out.print("\t\t5 ͼ��������");
    	 System.out.println("\t\t6 ����������");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("��ѡ��˵���");
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
     //����Ա��Ϣ����
     public void adminmenu(String admin){
    	 System.out.println("-->>����Ա����-->>����Ա��½>>-->>����Ա�˵�-->>����Ա��Ϣ����");
    	 System.out.print("\t\t1 �鿴���й���Ա����");
    	 System.out.println("\t\t2 �޸Ĺ���Ա��Ϣ");
    	 System.out.print("\t\t3 ���ӹ���Ա��Ϣ");
    	 System.out.println("\t\t4 ɾ������Ա��Ϣ");
    	 System.out.println("\t\t5 ���ع���Ա����");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("��ѡ��˵���");
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
     //�鿴���й���Ա
     public List<Admin> viewadmin(){
    	 System.out.println("���й���Ա�������£�");
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
     //�޸Ĺ���Ա��Ϣ
     public void updateadmin(){
    	 AdminDao ad=new AdminDao();
    	 Admin a=new Admin();
    	 System.out.print("��������Ҫ�޸ĵĹ���Ա���ƣ�");
    	 String adminname=input.next();
    	 System.out.print("�������޸ĺ�Ĺ���Ա���ƣ�");
    	 String name=input.next();
    	 System.out.print("�������޸ĺ�Ĺ���Ա���룺");
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
    		 System.out.println("�޸Ĺ���Ա��Ϣ�ɹ���");
    	 }else{
    		 System.out.println("�޸Ĺ���Ա��Ϣʧ�ܣ�");
    	 }
     }
     //��ӹ���Ա��Ϣ
     public void addadmin(){
    	 AdminDao ad=new AdminDao();
    	 Admin a=new Admin();
    	 System.out.print("��������ӹ���Ա�����ƣ�");
    	 String name=input.next();
    	 System.out.print("��������ӹ���Ա�����룺");
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
    		 System.out.println("��ӹ���Ա��Ϣ�ɹ���");
    	 }else{
    		 System.out.println("��ӹ���Ա��Ϣʧ�ܣ�");
    	 }
     }
     //ɾ������Ա
     public void deleteadmin(){
    	 AdminDao ad=new AdminDao();
    	 Admin a=new Admin();
    	 System.out.print("��������ӹ���Ա�����ƣ�");
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
    		 System.out.println("ɾ������Ա��Ϣ�ɹ���");
    	 }else{
    		 System.out.println("ɾ������Ա��Ϣʧ�ܣ�");
    	 } 
     }
     //ͼ����Ϣ����
     public void bookmenu(String admin){
    	 System.out.println("-->>����Ա����-->>����Ա��½>>-->>����Ա�˵�-->>ͼ����Ϣ����");
    	 System.out.print("\t\t1 �鿴����ͼ����Ϣ");
    	 System.out.println("\t\t2 �޸�ͼ����Ϣ");
    	 System.out.print("\t\t3 ����ͼ����Ϣ");
    	 System.out.println("\t\t4 ɾ��ͼ����Ϣ");
    	 System.out.println("\t\t5 ���ع���Ա����");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("��ѡ��˵���");
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
     //�鿴����ͼ��
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
     //�޸�ͼ����Ϣ
     public void updatebook(String admin){
    	 System.out.println("->>����Ա����->>����Ա��½>>->>����Ա�˵�->>ͼ����Ϣ����->>�޸�ͼ����Ϣ");
    	 System.out.println("\t\t1 �޸�ͼ��������Ϣ          2 �޸�ͼ����");
    	 System.out.println("\t\t3 �޸�ͼ��۸�                  4 �޸�ͼ������");
    	 System.out.println("\t\t5 �޸�ͼ���׼���          6 ���ع���Ա����");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("��ѡ��˵���");
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
     //�޸�ͼ��������Ϣ
     public void updatebookall(String admin){
    	 boolean flag=true;
    	 BookDao bd=new BookDao();
    	 System.out.print("��������Ҫ�޸�ͼ���ͼ�����ƣ�");
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
		    	 System.out.print("�������޸ĺ�Ĺ��ʱ�׼��ţ�");
		    	 String isbn1=input.next();
		    	 b1.setIsbn(isbn1);
		    	 id=id+1;
		    	 b1.setTypeid(id);
		    	 System.out.print("�������޸ĺ��������");
		    	 String name1=input.next();
		    	 b1.setBookname(name1);
		    	 System.out.print("�������޸ĺ�����ߣ�");
		    	 String author=input.next();
		    	 b1.setWriter(author);
		    	 System.out.print("�������޸ĺ�����ߣ�");
		    	 String translater=input.next();
		    	 b1.setTranslater(translater);
		    	 System.out.print("�������޸ĺ�ĳ����磺");
		    	 String publisher=input.next();
		    	 b1.setPublisher(publisher);
		    	 System.out.print("�������޸ĺ�ĳ������ڣ�");
		    	 String publishdate=input.next();
		    	 b1.setPublishdate(publishdate);
		    	 System.out.print("�������޸ĺ�ļ۸�");
		    	 double price=input.nextDouble();
		    	 b1.setPrice(price);
		    	 System.out.print("�������޸ĺ��ͼ��״̬��");
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
					System.out.println("�޸�ͼ��������Ϣ�ɹ���");
				}else{
					System.out.println("�޸�ͼ��������Ϣʧ�ܣ�");
				}
			 }
		 }
		 if(flag){
			 System.out.println("������ͼ�顶"+name+"������ȷ�����ƺ��ٽ����޸ģ�");
			 this.updatebook(admin);
		 }
     }
     //�޸�ͼ����
     public void updatebookname(String admin){
    	 boolean flag=true;
    	 BookDao bd=new BookDao();
    	 System.out.print("��������Ҫ�޸�ͼ������ͼ�����ƣ�");
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
				 System.out.print("�������޸ĺ��������");
		    	 String name1=input.next();
		    	 int count=0;
		    	 try {
					count=bd.updatename(name1, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("�޸�ͼ�����ɹ���");
				}else{
					System.out.println("�޸�ͼ����ʧ�ܣ�");
				}
			 }
		 }
		 if(flag){
			 System.out.println("������ͼ�顶"+name+"������ȷ�����ƺ��ٽ����޸ģ�");
			 this.updatebook(admin);
		 }
     }
     //�޸�ͼ��۸�
     public void updatebookprice(String admin){
    	 boolean flag=true;
    	 BookDao bd=new BookDao();
    	 System.out.print("��������Ҫ�޸�ͼ��۸��ͼ�����ƣ�");
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
				 System.out.print("�������޸ĺ�ļ۸�");
		    	 double price=input.nextDouble();
		    	 int count=0;
		    	 try {
					count=bd.updateprice(price, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("�޸�ͼ��۸�ɹ���");
				}else{
					System.out.println("�޸�ͼ��۸�ʧ�ܣ�");
				}
			 }
		 }
		 if(flag){
			 System.out.println("������ͼ�顶"+name+"������ȷ�����ƺ��ٽ����޸ģ�");
			 this.updatebook(admin);
		 }
     }
     //�޸�ͼ�����ͱ��
     public void updatebooktypeid(String admin){
    	 boolean flag=true;
    	 BookDao bd=new BookDao();
    	 System.out.print("��������Ҫ�޸�ͼ�����ͱ�ŵ�ͼ�����ƣ�");
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
				 System.out.print("�������޸ĺ�����ͱ�ţ�");
		    	 int type=input.nextInt() ;
		    	 int count=0;
		    	 try {
					count=bd.updatetypeid(type, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("�޸�ͼ�����ͱ�ųɹ���");
				}else{
					System.out.println("�޸�ͼ�����ͱ��ʧ�ܣ�");
				}
			 }
		 }
		 if(flag){
			 System.out.println("������ͼ�顶"+name+"������ȷ�����ƺ��ٽ����޸ģ�");
			 this.updatebook(admin);
		 }
     }
     //�޸�ͼ���׼���
     public void updatebookisbn(String admin){
    	 boolean flag=true;
    	 BookDao bd=new BookDao();
    	 System.out.print("��������Ҫ�޸�ͼ���׼��ŵ�ͼ�����ƣ�");
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
				 System.out.print("�������޸ĺ�ı�׼��ţ�");
		    	 String isbn=input.next();
		    	 int count=0;
		    	 try {
					count=bd.updateisbn(isbn, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("�޸�ͼ���׼��ųɹ���");
				}else{
					System.out.println("�޸�ͼ���׼���ʧ�ܣ�");
				}
			 }
		}
		 if(flag){
			 System.out.println("������ͼ�顶"+name+"������ȷ�����ƺ��ٽ����޸ģ�");
			 this.updatebook(admin);
		 } 
     }
     //����ͼ����Ϣ
     public void addbook(){
    	 BookDao bd=new BookDao();
    	 Book b=new Book();
    	 System.out.print("��������Ҫ���ͼ��Ĺ��ʱ�׼��ţ�");
    	 b.setIsbn(input.next());
    	 id=id+1;
    	 b.setTypeid(id);
    	 System.out.print("��������Ҫ���ͼ���������");
    	 b.setBookname(input.next());
    	 System.out.print("��������Ҫ���ͼ������ߣ�");
    	 b.setWriter(input.next());
    	 System.out.print("��������Ҫ���ͼ������ߣ�");
    	 b.setTranslater(input.next());
    	 System.out.print("��������Ҫ���ͼ��ĳ����磺");
    	 b.setPublisher(input.next());
    	 System.out.print("��������Ҫ���ͼ��ĳ������ڣ�");
    	 b.setPublishdate(input.next());
    	 System.out.print("��������Ҫ���ͼ��ļ۸�");
    	 b.setPrice(input.nextDouble());
    	 System.out.print("��������Ҫ���ͼ���״̬��");
    	 b.setState(input.nextInt());
    	 int count=0;
    	 try {
			count=bd.saveinsert(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܣ�");
		}
     }
     //ɾ��ͼ����Ϣ
     public void deletebook(){
    	 BookDao bd=new BookDao();
    	 System.out.print("��������Ҫɾ��ͼ��Ĺ��ʱ�׼��ţ�");
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
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܣ�");
		}
     }
     //�û���Ϣ����
     public void usermenu(String admin){
    	 System.out.println("-->>����Ա����-->>����Ա��½>>-->>����Ա�˵�-->>�û���Ϣ����");
    	 System.out.print("\t\t1 �û���Ϣ����");
    	 System.out.println("\t\t2 �û���Ϣ�޸�");
    	 System.out.print("\t\t3 �û���Ϣɾ��");
    	 System.out.println("\t\t4 ���ع���Ա����");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("��ѡ��˵���");
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
   //����û���Ϣ
     public void adduser(String admin){
    	 int count=0;
    	 Users u=new Users();
    	 UsersDao ud=new UsersDao();
    	 number=number+1;
    	 u.setId(number);
    	 System.out.print("����������û���������");
    	 String name=input.next();u.setName(name);
    	 System.out.print("����������û����Ա�");
    	 String sex=input.next();u.setSex(sex);
    	 System.out.print("����������û������䣺");
    	 int age=input.nextInt();u.setAge(age);
    	 String str=UserNum.createnumber();
    	 u.setIdentitycard(str);
    	 System.out.println("ϵͳΪ��������֤������Ϊ��"+str);
    	 Date date=new Date();
    	 DateFormat format=new SimpleDateFormat("yyyy.MM.dd");
    	 String time=format.format(date);
    	 u.setWorkdate(time);
    	 System.out.print("����������û��ĵ绰���룺");
    	 String tel=input.next();u.setTel(tel);
    	 System.out.print("����������û���Ѻ��");
    	 int yajin=input.nextInt();u.setYajin(yajin);
    	 System.out.print("����������û������룺");
    	 String password=input.next();u.setPassword(password);
    	 u.setAdmin(admin);
    	 try {
			count=ud.saveinsert(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0){
    		System.out.println("����û��ɹ���");
    	} else{
    		System.out.println("����û�ʧ�ܣ�");
    	}
     }
     //�޸��û���Ϣ
     public void updateuser(String admin){
    	 System.out.println("->>����Ա����->>����Ա��½>>->>����Ա�˵�->>ͼ����Ϣ����->>�޸��û���Ϣ");
    	 System.out.println("\t\t1 �޸��û�������Ϣ             2 �޸��û���");
    	 System.out.println("\t\t3 �޸��û�����                    4 �޸��û�����");
    	 System.out.println("\t\t5 �޸��û��Ĺ���Ա             6 ���ع���Ա����");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("��ѡ��˵���");
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
     //�޸��û�������Ϣ
     public void updateuserall(String admin){
    	 boolean flag=true;
    	 Users u=new Users();
    	 UsersDao ud=new UsersDao();
    	 int count=0;
    	 System.out.print("��������Ҫ�޸���Ϣ���û�������");
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
				 System.out.print("�������޸ĺ�ı�ţ�");
		    	 int id=input.nextInt();u.setId(id);
		    	 System.out.print("�������޸ĺ��������");
		    	 String name1=input.next();u.setName(name1);
		    	 System.out.print("�������޸ĺ���Ա�");
		    	 String sex=input.next();u.setSex(sex);
		    	 System.out.print("�������޸ĺ�����䣺");
		    	 int age=input.nextInt();u.setAge(age);
		    	 System.out.print("�������޸ĺ��֤�����룺");
		    	 String identitycard=input.next();u.setIdentitycard(identitycard);
		    	 System.out.print("�������޸ĺ�İ�֤���ڣ�");
		    	 String workdate=input.next();u.setWorkdate(workdate);
		    	 System.out.print("�������޸ĺ�ĵ绰���룺");
		    	 String tel=input.next();u.setTel(tel);
		    	 System.out.print("�������޸ĺ��Ѻ��");
		    	 int yajin=input.nextInt();u.setYajin(yajin);
		    	 System.out.print("�������޸ĺ�����룺");
		    	 String password=input.next();u.setPassword(password);
		    	 System.out.print("�������޸ĺ�Ĺ���Ա��");
		    	 String admin1=input.next();u.setAdmin(admin1);
		    	 try {
					count=ud.saveupdate(u, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("�޸��û�������Ϣ�ɹ���");
				}else{
					System.out.println("�޸��û�������Ϣʧ�ܣ�");
				} 
			 }
		 }
		 if(flag){
			 System.out.println("�������û�"+name+"����ȷ�Ϻ�����޸ģ�");
	    	 this.updateuser(admin);
		 }
     }
     //�޸��û���
     public void updateusername(String admin){
    	 boolean flag=true;
    	 UsersDao ud=new UsersDao();
    	 int count=0;
    	 System.out.print("��������Ҫ�޸��û������û�������");
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
				 System.out.print("�������޸ĺ��������");
		    	 String name1=input.next();
		    	 try {
					count=ud.updatename(name1, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("�޸��û����ɹ���");
				}else{
					System.out.println("�޸��û���ʧ�ܣ�");
				}
			 }
		 }
		 if(flag){
			 System.out.println("�������û�"+name+"����ȷ�Ϻ�����޸ģ�");
	    	 this.updateuser(admin);
		 }
     }
     //�޸��û�����
     public void updateuserpass(String admin){
    	 boolean flag=true;
    	 UsersDao ud=new UsersDao();
    	 int count=0;
    	 System.out.print("��������Ҫ�޸��û�������û�������");
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
				 System.out.print("�������޸ĺ�����룺");
		    	 String pass=input.next();
		    	 try {
					count=ud.updatepassword(pass, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("�޸��û�����ɹ���");
				}else{
					System.out.println("�޸��û�����ʧ�ܣ�");
				}
			 }
		 }
		 if(flag){
			 System.out.println("�������û�"+name+"����ȷ�Ϻ�����޸ģ�");
	    	 this.updateuser(admin);
		 }
     }
     //�޸��û�����
     public void updateuserage(String admin){
    	 boolean flag=true;
    	 UsersDao ud=new UsersDao();
    	 int count=0;
    	 System.out.print("��������Ҫ�޸��û�������û�������");
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
				 System.out.print("�������޸ĺ�����䣺");
		    	 int age=input.nextInt();
		    	 try {
					count=ud.updateage(age, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("�޸��û�����ɹ���");
				}else{
					System.out.println("�޸��û�����ʧ�ܣ�");
				}
			 }
		 }
		 if(flag){
			 System.out.println("�������û�"+name+"����ȷ�Ϻ�����޸ģ�");
	    	 this.updateuser(admin);
		 }
     }
     //�޸��û�����Ա
     public void updateuseradmin(String admin){
    	 boolean flag=true;
    	 UsersDao ud=new UsersDao();
    	 int count=0;
    	 System.out.print("��������Ҫ�޸��û�������û�������");
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
				 System.out.print("�������޸ĺ�Ĺ���Ա��");
		    	 String admin1=input.next();;
		    	 try {
					count=ud.updateadmin(admin1, name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count>0){
					System.out.println("�޸��û�����Ա�ɹ���");
				}else{
					System.out.println("�޸��û�����Աʧ�ܣ�");
				}
			 }
		 }
		 if(flag){
			 System.out.println("�������û�"+name+"����ȷ�Ϻ�����޸ģ�");
	    	 this.updateuser(admin);
		 }
     }
     //ɾ���û���Ϣ
     public void deleteuser(String admin){
    	 Users u=new Users();
    	 System.out.print("��������Ҫɾ�����û�������");
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
			System.out.println("ɾ���û��ɹ���");
		}else{
			System.out.println("ɾ���û�ʧ�ܣ�");
		}
    	 
     }
     //������Ϣ����
     public void readermenu(String admin){
    	 System.out.println("-->>����Ա����-->>����Ա��½>>-->>����Ա�˵�-->>������Ϣ����");
    	 System.out.print("\t\t1 ������Ϣ�鿴");
    	 System.out.println("\t\t2 ������Ϣ���");
    	 System.out.println("\t\t3 ���ع���Ա����");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("��ѡ��˵���");
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
     //�鿴���ж�����Ϣ
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
     //��Ӷ�����Ϣ
     public void addreader(){
    	 ReaderDao rd=new ReaderDao();
    	 Reader r=new Reader();
    	 num=num+1;
    	 r.setId(num);
    	 System.out.print("��������Ӷ��ߵ�������");
    	 String name=input.next();r.setName(name);
    	 System.out.print("��������Ӷ��ߵ��Ա�");
    	 String sex=input.next();r.setSex(sex);
    	 System.out.print("��������Ӷ��ߵ����䣺");
    	 int age=input.nextInt();r.setAge(age);
    	 String str=UserNum.createnumber();
    	 r.setIdentitycard(str);
    	 System.out.println("ϵͳΪ��������֤������Ϊ��"+str);
    	 Date date=new Date();
    	 DateFormat format=new SimpleDateFormat("yyyy.MM.dd");
    	 String time=format.format(date);r.setNowdate(time);
    	 System.out.print("��������Ӷ��ߵ����������");
    	 int maxnum=input.nextInt();r.setMaxnum(maxnum);
    	 System.out.print("��������Ӷ��ߵĵ绰���룺");
    	 String tel=input.next();r.setTel(tel);
    	 System.out.print("��������Ӷ��ߵ�Ѻ��");
    	 int keepmoney=input.nextInt();r.setKeepmoney(keepmoney);
    	 System.out.print("��������Ӷ��ߵ�֤�����ͣ�");
    	 int zj=input.nextInt();r.setZj(zj);
    	 System.out.print("��������Ӷ��ߵ�ְҵ��");
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
			System.out.println("��Ӷ��߳ɹ���");
		}else{
			System.out.println("��Ӷ���ʧ�ܣ�");
		}
     }
     //ͼ��������
     public void booktypemenu(String admin){
    	 System.out.println("-->>����Ա����-->>����Ա��½>>-->>����Ա�˵�-->>ͼ��������");
    	 System.out.println("\t\t1 ͼ��������");
    	 System.out.println("\t\t2 ͼ������޸�");
    	 System.out.println("\t\t3 ���ع���Ա����");
    	 System.out.println("------------------------------------------------");
    	 System.out.print("��ѡ��˵���");
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
     
     //���ͼ������
     public void addbooktype(){
    	 Booktype bt=new Booktype();
    	 BookTypeDao btd=new BookTypeDao();
    	 int count=0;
    	 System.out.print("���������ͼ�����ͣ�");
    	 String typename=input.next();
    	 System.out.print("���������ͼ�����͵ı�ţ�");
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
    		 System.out.println("���ͼ�����ͳɹ���");
    	 }else{
    		 System.out.println("���ͼ������ʧ�ܣ�");
    	 }
     }
     //�޸�ͼ������
     public void updatebooktype(){
    	 Booktype bt=new Booktype();
    	 BookTypeDao btd=new BookTypeDao();
    	 int count=0;
    	 System.out.print("��������Ҫ�޸ĵ�ͼ�����ͱ�ţ�");
    	 int id=input.nextInt();
    	 System.out.print("�������޸ĺ��ͼ�����ͣ�");
    	 String typename=input.next();
    	 System.out.print("�������޸ĺ��ͼ�����ͱ�ţ�");
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
   		 System.out.println("�޸�ͼ�����ͳɹ���");
   	 }else{
   		 System.out.println("�޸�ͼ������ʧ�ܣ�");
   	 }
     }
     /**
      * ���ߵ�¼����
      * �鿴�����ģ��黹��
      */
     //���ߵ�¼
     public void loginwr(){
    	 System.out.println("-->>���߽���-->>���ߵ�½");
    	 System.out.print("�������������");
    	 String reader=input.next();
    	 System.out.print("���������룺");
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
    	 System.out.println("�û��������벻��ȷ����δע������˺ţ���ȷ�Ϻ����µ�¼!");
    	 loginwr();
     }
     //���߽���
     public void menuwr(String reader){
    	 System.out.println("-->>���߽���-->>���ߵ�½-->>���߲˵�");
    	 System.out.print("\t\t1 �鿴������ϸ");
    	 System.out.println("\t\t2 ����ͼ��");
    	 System.out.print("\t\t3 �黹ͼ��");
    	 System.out.println("\t\t4 ����ͼ��");
    	 System.out.println("\t\t5 ����������");
    	 System.out.println("-------------------------------------------------");
    	 System.out.print("��ѡ��˵���");
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
     //�鿴������ϸ
     public void view(String reader){
    	 BorrowbookDao bbd=new BorrowbookDao();
    	 List<Borrowbook> li=new ArrayList<Borrowbook>();
    	 try {
			li=bbd.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 System.out.println("������"+"\t"+"����"+"\t"+"��������"+"\t\t"+"Ӧ������"+"\t\t"+"�ѽ�����"+"\t");
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
     //����ͼ��
     public void borrow(String reader){
    	 BookDao bd=new BookDao();
    	 Book b=new Book();
    	 Borrowbook bk=new Borrowbook();
    	 System.out.print("��������Ҫ����ͼ������ƣ�");
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
		    	 System.out.print("��������Ҫ����ͼ���ѽ�������");
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
					System.out.println("���ġ�"+b.getBookname()+"���ɹ���");
				}else{
					System.out.println("���ġ�"+b.getBookname()+"��ʧ�ܣ�");
				}   	  
    			}
		}
     }
     //�黹ͼ��
     public void returnbook(String reader){
    	 BookDao bd=new BookDao();
    	 Book b=new Book();
    	 BorrowbookDao bbd=new BorrowbookDao();
    	 int count1=0;
    	 int count=0;
    	 System.out.print("��������Ҫ�黹ͼ������ƣ�");
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
			System.out.println("�黹��"+b.getBookname()+"���ɹ���");
		}else{
			System.out.println("�黹��"+b.getBookname()+"��ʧ��,������δ���ͼ���ͼ�����Ʋ���ȷ��");
		}
	}
   //������������ͼ��
   	public void find(){
   		System.out.print("��������Ҫ���ҵ�ͼ�����ƣ�");
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
		   			System.out.println("���ʱ�׼���"+"\t"+"ͼ������id"+"\t\t"+"����"+"\t\t"+"����"+"\t\t"+"����"+"\t\t"+"������"+"\t"+"��������"+"\t\t"+"�۸�"+"\t"+"״̬");
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
							System.out.print("δ���"+"\n");
						}else{
							System.out.print("�ѽ��"+"\n");
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(flag){
		System.out.println("������ͼ�顶"+name+"����");
		}
   	}
   	//����ע��
   	public void enroll(){
   		boolean b=true;
   		System.out.println("-->>����ע��-->>������Ϣע��");
   		UsersDao ud=new UsersDao();
   		ReaderDao rd=new ReaderDao();
   		int count=0;
   		List<Reader> li=new ArrayList<Reader>();
   		System.out.print("��������Ҫע��Ķ�������");
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
   				System.out.println("�ö����Ѵ��ڣ������ظ�ע�ᣡ");b=false;
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
			System.out.print("�Ƿ����ڴ�Ǯ����y/n��");
			if(input.next().equalsIgnoreCase("y")){
				System.out.print("����Ǯ����");
				int money=input.nextInt();
				r1.setKeepmoney(r1.getKeepmoney()+money);
			}
		   	System.out.print("��������ע��Ϊ����֤�����ͣ���1����ͨ /2��vip��");
			int zj=input.nextInt();
			r1.setZj(zj);
			System.out.print("����ְҵ�ǣ�");
			String zy=input.next();
			r1.setZy(zy);
			System.out.print("��ǰ���ڣ�");
			String date=input.next();
			r1.setNowdate(date);
			System.out.print("��������������������");
			int num=input.nextInt();
			r1.setMaxnum(num);
			try {
				count=rd.saveinsert(r1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count>0){
				System.out.println("ע��ɹ���");b=false;
			}else{
				System.out.println("ע��ʧ�ܣ�");
			} 
   		}
   		
   	}
}
