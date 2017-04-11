/*
 * �ڹٸ� �̿��Ͽ� ������ ���α׷��� �ۼ��Ѵ�
 * 
 * */
package echo.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	//��ȭ�� ������ ���� ������ �˷��ֱ� ���� ��ü!!
	//�� ���� ��ȭ�� ��������!!
	//������ Ŭ���̾�Ʈ�� ã�ƿ��� ��ٸ��Ƿ� 
	//Ŭ���̾�Ʈ�� ����� ��Ʈ��ȣ�� �����ϸ� �ȴ�!!
	//��Ģ������ ��Ʈ��ȣ�� �����Ӱ� ���ϸ� �ȴ�
	//����1)0~1023��Ʈ �̹� �����ϰ� ����
	//����2)������ ���α׷����� ������ ex)����Ŭ 1521, mysql 3306, web 80
	
	//ä�� - input output stream�� �����ϸ� ��
	
	ServerSocket server;
	int port=8888;
	Socket socket;
	//���ʹ� �ٸ� pc�����ϴ� ȯ��? -�͹̳�
	public MyServer() {
		try {
			server=new ServerSocket(port);
			System.out.println("��������");
			
			//Ŭ���̾�Ʈ�� ������ ��ٸ���
			//������ ���������� ���Ѵ�� �� �����ȴ�
			//��ġ ��Ʈ���� read()�� ���!! �����͸� ������ ����ǰ� ���Ѵ��.
			while(true){
				socket=server.accept();
				System.out.println("������ �߰�!!");
				
				//������ �̿��Ͽ� �����͸� �ް��� �ϴ� ���
				//�Է� ��Ʈ����, �����͸� �������� �ϴ� ���
				//��� ��Ʈ���� �̾Ƴ��� �ȴ�
				InputStream is=socket.getInputStream();
				InputStreamReader reader=null; //�ѱ� �����ϱ� �ϳ� �� ������
				reader=new InputStreamReader(is);
				
				int data;
				
				while(true){
					data=reader.read(); //2byte �о����
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
