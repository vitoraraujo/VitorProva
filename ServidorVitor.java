import java.io.*;
import java.util.*;
import java.net.*;
import java.awt.*;

class ServidorVitor implements Serializable{
	public void go(){
		try{
		ServerSocket serverSocket = new ServerSocket(5555);
			while(true){
				Socket socket = serverSocket.accept();
				OutputStream os = socket.getOutputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			}
		}catch(IOException ex){
			ex .printStackTrace();
		}
	}
	public static void main(String[] args) {
		ServidorVitor server = new ServidorVitor();
		server.go() ;
	}
}