/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
 interface screen{
    ArrayList<String> a1=new ArrayList<String>();
    void book(String[] str);
    void show();
    void add(String[] data);
}
 interface screenabstractfactory{
    public screen createscreen();
}
class factoryroom1 implements screenabstractfactory{
    public screen createscreen()
    {
        return new room1();
    }
}
 class factoryroom2 implements screenabstractfactory{
    public screen createscreen()
    {
        return new room2();
    }
}
class room1 implements screen{
   public void add(String[] data)
    {
        for(int i=0;i<data.length;i++)
        a1.add(data[i]);
    }
    String[] check;
   public void book(String[] str)
    {
        check=new String[str.length];
        int i=0;
        for(String tikit:str)
        {
            if(a1.contains(tikit))
            {
                
                check[i]=tikit;
                i++;
                a1.remove(tikit);
                
            }
            else{
                System.out.println("Not available");
                check=new String[0];
                break;
            }
        }
        if(check[str.length-1]=="")
            check=new String[0];
    }
   public void show()
    {
        System.out.println("Booked tikit");
        for(int i=0;i<check.length;i++)
            System.out.println(check[i]);
        System.out.println("remain tikit");
        System.out.println(a1);
    }
}
class room2 implements screen{
   public  void add(String[] data)
    {
        for(int i=0;i<data.length;i++)
        a1.add(data[i]);
    }
    String[] check;
  public  void book(String[] str)
    {
         check=new String[str.length];
        int i=0;
        for(String tikit:str)
        {
            if(a1.contains(tikit))
            {
                
                check[i]=tikit;
                i++;
                a1.remove(tikit);
                
            }
            else{
                System.out.println("Not available");
                check=new String[0];
                break;
            }
        }
        if(check[str.length-1]=="")
            check=new String[0];
    }
  public  void show()
    {
        System.out.println("Booked tikit");
        for(int i=0;i<check.length;i++)
            System.out.println(check[i]);
        System.out.println("remain tikit");
        System.out.println(a1);
    }
}
class factory
{
    public screen bild(screenabstractfactory s1)
    {
        return s1.createscreen();
    }
}
class GFG {
	public static void main (String[] args)throws IOException {
	    factory f1=new factory();
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   
	    screen room=f1.bild(new factoryroom1());
	    if(room==null)
	    System.out.println("invalid");
	    String remain[]=new String[]{"p1","p2","p3"};
	    room.add(remain);
	    String data[]=new String[]{"p1"};
	    room.book(data);
	    room.show();
	}
}