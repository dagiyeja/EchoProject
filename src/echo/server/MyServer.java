/*
 * 자바를 이용하여 서버측 프로그램을 작성한다
 * 
 * */
package echo.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	//대화를 나누기 전에 접속을 알려주기 위한 객체!!
	//즉 아직 대화는 못나눈다!!
	//서버는 클라이언트가 찾아오길 기다리므로 
	//클라이언트와 약속한 포트번호만 보유하면 된다!!
	//원칙상으로 포트번호는 자유롭게 정하면 된다
	//예외1)0~1023포트 이미 점유하고 있음
	//예외2)유명한 프로그램들은 피하자 ex)오라클 1521, mysql 3306, web 80
	
	//채팅 - input output stream을 생각하면 됨
	
	ServerSocket server;
	int port=8888;
	Socket socket;
	//나와는 다른 pc접근하는 환경? -터미널
	public MyServer() {
		try {
			server=new ServerSocket(port);
			System.out.println("서버생성");
			
			//클라이언트의 접속을 기다린다
			//접속이 있을때까지 무한대기 즉 지연된다
			//마치 스트림의 read()와 비슷!! 데이터만 있을때 수행되고 무한대기.
			while(true){
				socket=server.accept();
				System.out.println("접속자 발견!!");
				
				//소켓을 이용하여 데이터를 받고자 하는 경우
				//입력 스트림을, 데이터를 보내고자 하는 경우
				//출력 스트림을 뽑아내면 된다
				InputStream is=socket.getInputStream();
				InputStreamReader reader=null; //한글 깨지니까 하나 더 씌우자
				reader=new InputStreamReader(is);
				
				int data;
				
				while(true){
					data=reader.read(); //2byte 읽어들임
					System.out.print((char)data);
				}
				}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MyServer();

	}

}
