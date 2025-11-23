package server;
import  java.net.*; 
import  java.util.*;
public class DatagramSocketServer
{
public static void main(String[] args)throws Exception
{
Scanner in=new Scanner(System.in);
DatagramSocket serverSocket=new DatagramSocket(9000); 
byte[] receiveData = new byte[1024];
byte[] sendData = new byte[1024]; System.out.println("***ServerSide***");
/*Createthereceivedatagrampacket */
DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length); 
serverSocket.receive(receivePacket); /* Receive the packet using server socket */ System.out.println(new String(receivePacket.getData()));
InetAddress IPAddress=receivePacket.getAddress(); 
int port = receivePacket.getPort();
while(true)
{
System.out.println("Typesomemessagetodisplayatclientend"); 
String message = in.nextLine();
sendData = message.getBytes();
System.out.println("Message sent from the server:" + new String(sendData)); 
DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress, port);
/*Sendthepacket using serversocket*/
serverSocket.send(sendPacket);
}
}
}
