package client; 
import  java.net.*;
 import  java.io.*;
 import java.util.*;
public class SocketClient
{
public static void main( String args[] )throws Exception
{
Scanner in=new Scanner(System.in);
/*Createsocket atclientside*/
Socket clientSocket=new Socket("127.0.0.1",4000); 
System.out.println("****Client side****");
/*Readingthefilenamefromkeyboard.*/
System.out.println("Enter the file name to transfer"); 
String fname = in.nextLine();
/*Sendingthefilenametoserver.UsesPrintWritertowritefilenametooutputstream*/
OutputStream ostream=clientSocket.getOutputStream(); 
PrintWriter pwrite = new PrintWriter(ostream, true); 
pwrite.println(fname);

/*Receivingthecontentsfromserver.Usesinputstream*/
InputStream istream=clientSocket.getInputStream();
BufferedReader socketRead=new BufferedReader(new InputStreamReader(istream)); 
System.out.println("Contents of the file " + fname + " are");
String str;
while((str=socketRead.readLine())!= null)
/*Reading line-by-line*/
{
System.out.println(str);
}
pwrite.close(); socketRead.close();
}
}
