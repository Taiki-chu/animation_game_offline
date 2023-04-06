package animation_game;

public class Main {
    public static void main( String[] args ){
    	
//    	Threads_ thread_gui=new Threads_("gui");//String "gui"
//    	Threads_ thread_act=new Threads_("act");
//    	thread_gui.start();
//    	thread_act.start();
    	new Threads_("menu").start();
    	
    }
}
