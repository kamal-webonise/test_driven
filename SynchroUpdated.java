import java.util.*;

class Load extends Thread
 {
	 
	
   public synchronized void run()
   {
	   System.out.println("Loading to Carts \n");
	 
	  try { 
		Thread.sleep(1000);
		
		 
	  }catch(Exception e){System.out.println(e);}
	
	 
   }

 
 }

class LoadUnload extends Thread
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
 
 
 class Travell extends Thread
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




class BurnBooks extends Thread
 {
	 
	 
   public void run()
   {
	  
	   System.out.println("burning books \n");
           try { 
		Thread.sleep(2000);	  
	  }catch(Exception e){System.out.println(e);}
	
	   
   }
 
 }

public class synchro extends Thread
{
	 public static void main(String args[])
	 {
		int parallel_way = 2; 
		//int book_set=50/2;
	               while(parallel_way-- > 0)
		       {		
			synchro thread1= new synchro();
      			thread1.start();
			}
		
	 }

	public void run()
   	{
		final long startTime = System.currentTimeMillis();

		 int total=0;
		 int no_of_books=50;
		 int set;
		
		
		//int i=1;
		
		set=(no_of_books/(5*2));
		int temp=set;
		Load ob1=new Load();

		ob1.start();
		 try { 
			ob1.join();	  
			}catch(Exception e){System.out.println(e);}
		
		
		while(set-- > 0)
		{
			
				Travell ob2=new Travell();
				ob2.start();
		
				try { 
				
				 ob2.join();	  
				 }catch(Exception e){System.out.println(e);}
				 
		

				
				 
				 LoadUnload ob13=new LoadUnload();

				 ob13.start();
				 try { 
				
				 ob13.join();	  
				 }catch(Exception e){System.out.println(e);}
		
		
			     	 
		
				
		
		
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
			   BurnBooks ob5=new BurnBooks();
			   ob5.start();
		
				try { 
				
				 ob5.join();	  
				 }catch(Exception e){System.out.println(e);}
				 
			    
			}
	final long endTime = System.currentTimeMillis();
	System.out.println("Total execution time: " + (endTime - startTime)/100);
	 }
  }

