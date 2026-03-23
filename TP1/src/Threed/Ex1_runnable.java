package Threed;

class ChiffresRubbable implements Runnable{
	public void run() {
	for(int i=1; i<=10 ;i++) {
	System.out.print(i + " ");
	}
}
}

class LettresRubbable implements Runnable{
	public void run() {
	for(char x='a'; x<='z' ;x++) {
	System.out.print(x + " ");
	}
}
}
public class Ex1_runnable {
	public static void main(String[] args) {
		Thread t1 = new Thread(new ChiffresRubbable());
		Thread t2 = new Thread(new LettresRubbable());
		
		t1.start();
		// application de join (si on veut attendre jusqu'a le premier thread se termine)
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t2.start();
		t2.start();
		
		//t1.setPriority(Thread.MAX_PRIORITY);
        //t2.setPriority(Thread.MIN_PRIORITY);
	}

}
