import java.util.List;
import java.util.Scanner;



public class views {
	private static final String CONTEXT="歡迎登录学生成绩系统： \n"+
    "[query/q]：查詢全部学生信息\n"+
	"[get/g]:查看某個学生信息\n"+
    "[add/a]:添加学生信息\n"+
	"[update/u]:更新学生信息\n"+
	"[show/s]:按总成绩从高到低输出学生信息\n"+
    "[delete/d]:刪除学生信息\n"+
    "[exit/e]:退出学生成绩系统\n";
    public static final String cquery="query";
    public static final String cget="get";
    public static final String cadd="add";
    public static final String cupdate="update";
    public static final String cdelete="delete";
    public static final String cexit="exit";
    public static final String cshow="show";
    

	public static void main(String[] args) {
	    System.out.println(CONTEXT);
	    Scanner scan=new Scanner(System.in);
	    String prenious=null,pre=null,pp=null,ppp=null,pppp=null;
	    Integer step=1,step1=1,step2=1,step3=1;
	    Students goddness=new Students();
	    action act=new action();
        while(scan.hasNext()){
        	String in=scan.next().toString();
        	if(cexit.equals(in)){
        		System.out.println("你已經成功退出学生成绩系统");
        		break;
        	}else if(cquery.equals(in)||cquery.equals(pre)){
        		try {
					List<Students> list=act.query();
					for(Students go :list){
						 System.out.println(go.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
					 System.out.println("查詢錯誤");}
				}else if(cshow.equals(in)||cshow.equals(pppp)){
	        		try {
	        			List<Students> list=act.show();
	        			 System.out.println("将成绩从高到低排序");
						for(Students go :list){
							
							 System.out.println(go.toString());}
						
					} catch (Exception e) {
						e.printStackTrace();
						 System.out.println("查詢錯誤");
					}
        	}else if(cget.equals(in)||cget.equals(pre)){
            		try {
            			if(step1==1){
            			System.out.println("请输入要查询学生的学号"); 
            			step1++;}
            			else if(step1==2){
            			goddness =act.get(Integer.valueOf(in));
      
            			System.out.println(goddness.toString());}
    					
    				} catch (Exception e) {
    					e.printStackTrace();
    					 System.out.println("查詢錯誤");
    				}
            		if(cdelete.equals(pre)){
            	 		step1++;
            	 	}
        	}else if(cdelete.equals(in)||cdelete.equals(pp)){
     		   pp=cdelete;
       		try {
       			if(step2==1){
       			System.out.println("请输入要删除学生的学号"); 
       			}
       			else if(step2==2){
       			act.del(Integer.valueOf(in));
       			System.out.println("删除成功");}
					
				} catch (Exception e) {
					e.printStackTrace();
					 System.out.println("删除失败");
				}
       		if(cdelete.equals(pp)){
    	 		step2++;
    	 	}
        	}else if(cupdate.equals(in)||cupdate.equals(ppp)){
      		   ppp=cupdate;
      		 if(1==step3){
     	 		System.out.println("請輸入学生学号！");
     	 	}else if(2==step3){
     	 		goddness.setSid(Integer.valueOf(in));
     	 		System.out.println("請輸入学生姓名！");
     	 	}else if(3==step3){
     	 		goddness.setSname(in);
     	 		System.out.println("請輸入数据结构成绩！");
     	 	}else if(4==step3){
     	 		goddness.setScore1(Integer.valueOf(in));
					System.out.println("請輸入操作系统成绩！");
					
     	 	}else if(5==step3){
     	 		goddness.setScore2(Integer.valueOf(in));
     	 		System.out.println("請輸入数值运算成绩！");
     	 		
     	 	
     	 	}else if(6==step3){     	 		
     	 		goddness.setScore3(Integer.valueOf(in));
     	 		int a=Integer.valueOf(goddness.getScore1())+Integer.valueOf(goddness.getScore2())+Integer.valueOf(goddness.getScore3());
     	 		goddness.setScore4(a);
     	 		try {
						act.edit(goddness);
						System.out.println("修改学生信息成功！");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("修改学生信息失败！");
						
					}
     	 	}
     	 	if(cupdate.equals(ppp)){
     	 		step3++;
     	 	}
        	}else if(cadd.equals(in)||cadd.equals(prenious)){
        	 	prenious=cadd;
        		//新增女神；
        	 
        		if(1==step){
        	 		System.out.println("請輸入学生学号！");
        	 	}else if(2==step){
        	 		goddness.setSid(Integer.valueOf(in));
        	 		System.out.println("請輸入学生姓名！");
        	 	}else if(3==step){
        	 		goddness.setSname(in);
        	 		System.out.println("請輸入数据结构成绩！");
        	 	}else if(4==step){
        	 		goddness.setScore1(Integer.valueOf(in));
					System.out.println("請輸入操作系统成绩！");
					
        	 	}else if(5==step){
        	 		goddness.setScore2(Integer.valueOf(in));
        	 		System.out.println("請輸入数值运算成绩！");
        	 		
        	 	
        	 	}else if(6==step){     	 		
        	 		goddness.setScore3(Integer.valueOf(in));
        	 		int a=Integer.valueOf(goddness.getScore1())+Integer.valueOf(goddness.getScore2())+Integer.valueOf(goddness.getScore3());
        	 		goddness.setScore4(a);
        	 		try {
						act.add(goddness);
						System.out.println("新增学生成功！");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("新增学生失敗！");
						
					}
        	 	}
        	 	if(cadd.equals(prenious)){
        	 		step++;
        	 	}
        		
        		
        	}else{
        	System.out.println("你輸入的值為："+in);
        	}
        }
	}

}
