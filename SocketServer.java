package server;
import  java.net.*;  
import  java.io.*;
public class SocketServer{
public static void main(String args[])throws Exception {

 
ServerSocket servSocket=new ServerSocket(4000); 
System.out.println("****Server Side****");

System.out.println("Server ready for connection");

Socket connSock= servSocket.accept();
System.out.println("Connection is successful and ready for file transfer");

InputStream istream=connSock.getInputStream();
BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream)); 
String fname = fileRead.readLine();
File fileName=new File(fname);

/*Keepingoutputstreamreadytosendthecontents*/ 
OutputStream ostream = connSock.getOutputStream( ); 
PrintWriter pwrite = new PrintWriter(ostream, true);
/*Iffileexistsreadthecontentsoffileandsendto theclient*/
if(fileName.exists())
{
BufferedReader contentRead=new BufferedReader(new FileReader(fname));
System.out.println("Writing file Contents to the socket");
String str;
while((str=contentRead.readLine())!=null)
/*Readingline-by-linefromfile*/
{
/*Sendingeach line totheclient*/
pwrite.println(str);
}
contentRead.close();
}
else
{
System.out.println("Requested file does not exist");
String msg="Requested file does not exist at serverside"; 
pwrite.println(msg);
}

connSock.close();
servSocket.close();	/*Closenetworksockets*/
fileRead.close(); 
pwrite.close();
}
}
