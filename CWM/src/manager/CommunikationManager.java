package manager;

import java.util.LinkedList;
import java.util.List;

import net.client.Connection;
import net.server.Hoster;

public class CommunikationManager{
	
   private static LinkedList<Hoster> Servers=new LinkedList<>();
	
   public static void host(int Port, String Name) throws Exception{
    Hoster Server=new Hoster(Port,Name,Servers.size()+1);
    Servers.add(Server);
   }
   
   public static void connect(String IP, int Port){
	   Connection Con=new Connection(IP,Port);
	   new Thread(() -> Con.handleIn()).start();
	   Con.handleOut();
   }
   
   public static List<Hoster> getServerList(){
	   return Servers;
   }
   
   public static Hoster getServerByID(int ID){
	   return Servers.get(ID-1);
   }
   
   public static Hoster getServerByName(String name){
	   for(Hoster Server: Servers){
		   if(Server.getName().equals(name)){return Server;}
	   }
   return null;
   }

}
