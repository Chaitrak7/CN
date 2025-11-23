package client;
import java.net.*;
public class DatagramSocketClient{
public static void main(String[] args)throws Exception
{
String line="Connected with Client";
/*Createnewdatagramsocketat clientside*/
DatagramSocket clientSocket =new DatagramSocket();
/*GetIPAddressusingtheInetAddressclass*/
InetAddress IPAddress=InetAddress.getByName("localhost");
byte[] sendData = new byte[1024]; 
byte[]receiveData=new byte[1024];
sendData = line.getBytes();

/*Createthesenddatagrampacket */
DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress, 9000);
/*Sendthepacket usingclientsocket */
clientSocket.send(sendPacket);
System.out.println("*****ClientDisplayTerminal****"); while(true)
{
/*Createthereceivedatagrampacket */
DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
/*Receivethepacketusingclient socket*/
clientSocket.receive(receivePacket);
/*Convertthemessagereceivedintothestring*/
String messageReceived = new String(receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength()); 
System.out.println("Message typed at server side is : " + messageReceived);
}
}
}
 