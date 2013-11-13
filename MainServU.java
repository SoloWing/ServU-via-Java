import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MainServU {
    
    private ServerSocket entryInterface;

    public MainServU() {
	try {
	    entryInterface = new ServerSocket(10011);
	    System.out.println("已开启10011端口，等待连接");
	} catch (IOException e) {
	    System.out.println("10011端口被占用，程序将会结束");
	    System.exit(-1);
	}
    }
    
    public void execute() {
	
	while(true) {
	    try {
		Socket request = entryInterface.accept();
		new ScrShot(request).start();
		
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
    
    public static void main(String[] args) {
	new MainServU().execute();
    }
}
