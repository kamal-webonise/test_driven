import java.util.*;

class Gopher1 extends Thread
 {
	 
	
   public synchronized void run()
   {
	   System.out.println("Loading to Carts \n");
	 
	  try { 
		Thread.sleep(1000);
		
		 
	  }catch(Exception e){System.out.println(e);}
	
	 
   }

 
 }

class Gopher13 extends Thread
 {
	 
	
   public synchronized void run()
   {
	   System.out.println("Loading to Cart \n");
	   System.out.println("Unloading from cart \n"); 
		  try { 
		Thread.sleep(1000);
		
		 
	  }catch(Exception e){System.out.println(e);}
	
	 
   }

 
 }
 
 
 class Gopher2 extends Thread
 {
	 
	 
   public void run()
   {
	   System.out.println("Travelling from pile to incinerator \n");
	   System.out.println("Travelling back to pile from incinerator \n");
           try { 
		Thread.sleep(3000);	  
	  }catch(Exception e){System.out.println(e);}
	
	   
   }
 
 }


class Gopher3 extends Thread
 {
	 
	 
   public void run()
   {
	  
	   System.out.println("unloading books \n");
           try { 
		Thread.sleep(1000);	  
	  }catch(Exception e){System.out.println(e);}
	
	   
   }
 
 }

class Gopher5 extends Thread
 {
	 
	 
   public void run()
   {
	  
	   System.out.println("burning books \n");
           try { 
		Thread.sleep(2000);	  
	  }catch(Exception e){System.out.println(e);}
	
	   
   }
 
 }

public class Synchro
{
	 public static void main(String args[])
	 {
		 final long startTime = System.currentTimeMillis();

		 int total=0;
		 int no_of_books=50;
		 int set;
		set=(no_of_books/5);
		int temp=set;
		int i=1;
		
		while(set-- > 0)
		{
			if(i==1)
			{
				 Gopher1 ob1=new Gopher1();
				 Gopher2 ob2=new Gopher2();
				 Gopher3 ob3=new Gopher3();
				 Gopher13 ob13=new Gopher13();

				ob1.start();
				 try { 
				
				 ob1.join();	  
				 }catch(Exception e){System.out.println(e);}
		
	
			     	ob2.start();
		
				try { 
				
				 ob2.join();	  
				 }catch(Exception e){System.out.println(e);}
				 
				ob3.start();
		
				try { 
				
				 ob3.join();	  
				 }catch(Exception e){System.out.println(e);}
				i++;
				 	
			     	}


				else
				{
			
					Gopher1 ob1=new Gopher1();
				 Gopher2 ob2=new Gopher2();
				 Gopher3 ob3=new Gopher3();
				 Gopher13 ob13=new Gopher13();

					ob13.start();
				 try { 
				
				 ob13.join();	  
				 }catch(Exception e){System.out.println(e);}
		
		
		

			     	 ob2.start();
		
				try { 
				
				 ob2.join();	  
				 }catch(Exception e){System.out.println(e);}
				 
		
		
				}
		
		
		}

			int remaining_books = temp*2;
			//System.out.println(remainingBook);
			 if (remaining_books%3 == 0){
			   set=remaining_books/3;
		       }
		       else
		       {
			   set=remaining_books/3 + 1;
		       }
			
			while(set-- >0)
			{
			   Gopher5 ob5=new Gopher5();
			   ob5.start();
		
				try { 
				
				 ob5.join();	  
				 }catch(Exception e){System.out.println(e);}
				 
			    
			}
	final long endTime = System.currentTimeMillis();
	System.out.println("Total execution time: " + (endTime - startTime)/100);
	 }
  }
