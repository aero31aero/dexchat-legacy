




import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
class DexCT extends Thread
{
    private Socket s;
    private DexQuote bart;
    private String online1="",a="";
    public static String curpath="C:\\";
    private int[] status;
    private int oncnt=0,conf=0;
    private boolean fs=true;
    
    //static ArrayList<String> q = new ArrayList<String>(); 
    public DexCT(Socket socket, DexQuote bart) 
    {
        this.s = socket;
        this.bart = bart;
    }
    public String getTime()
    {
        Calendar calendar = new GregorianCalendar();
    
    String ap="!!";
    int hour = calendar.get(Calendar.HOUR);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);

    int yo=calendar.get(Calendar.AM_PM) ;
    if(yo==0)
      ap="AM";
    else if(yo==1)
      ap="PM";
    
    String time=""+hour + ":" + minute + " " + ap;
        return time;
    }
    public static void gettime1()
    {
        Calendar calendar = new GregorianCalendar();
    
    String ap="!!";
    
    int hour = calendar.get(Calendar.HOUR);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);

    int yo=calendar.get(Calendar.AM_PM) ;
    if(yo==0)
      ap="AM";
    else if(yo==1)
      ap="PM";
    
    Server.timeold=""+hour + ":" + minute + " " + ap;
   
    }
    public void run() 
    {
        Server.hash="C:\\@";
        String client = s.getInetAddress().toString();
             
        String user11="randomize the string here";
        try
        {
            Scanner in = new Scanner(s.getInputStream());
            PrintWriter out;
            out = new PrintWriter(s.getOutputStream(),
            true);
            
            String input,name,pass;
            name = in.nextLine();
             {
//                Server.namelist=Server.namelist.replace(name+"---- Online\n", "");
//                 Server.namelist=Server.namelist+name+"---- Online"+"\n";
            }
             try{
  InetAddress ownIP=InetAddress.getLocalHost();
 user11=ownIP.getHostAddress();
  
  }catch (Exception e){
  
  }
            if(name.equalsIgnoreCase(user11))
                System.exit(1);
            pass=in.nextLine();
            if(pass.equals(Server.pass))
            {
                out.println("APPROVE");
                while (true)
            {
                Server.serveradd.repaint();
                Server.setDefaultLookAndFeelDecorated(true);
                input = in.nextLine();
                if(!((input.equalsIgnoreCase("CMD_ONLINE"))||(input.toUpperCase().startsWith("CMD_SENDFILE "))||(input.equalsIgnoreCase("CMD_FSTOGGLE_ON"))||(input.equalsIgnoreCase("CMD_FSTOGGLE_OFF"))||(input.equalsIgnoreCase("CMD_ADMIN_GETMSG"))||(input.equalsIgnoreCase("CMD_RESTORE"))||(input.equalsIgnoreCase("CMD_ADMIN_MSG"))||(input.equalsIgnoreCase("CMD_ADMIN_EXIT"))||(input.equalsIgnoreCase("CMD_UPTIME"))||(input.equalsIgnoreCase("CMD_GETMSGCUR"))||(input.equalsIgnoreCase("CMD_GETMSG"))||(input.equalsIgnoreCase("CMD_EXIT"))||(input.equalsIgnoreCase("REFRESH"))||(input.equalsIgnoreCase("CMD_DISCONNECT"))||(input.equalsIgnoreCase("CMD_CONNECT"))||(input.equalsIgnoreCase("CMD_BACKUP"))||(input.equalsIgnoreCase("CMD_GETTIME"))))                
                {
                    
                    int s1=0xD83D,s2=0xDE03;
                    String smile1=""+(char)s1+(char)s2;
                    input=input.replace("<s>", "☺");
                    input=input.replace("<b>", "☠");
                    input=input.replace("<v>", "✌");
                    input=input.replace("<h>", "♡");
                    String time=getTime();
                    Server.chat=Server.chat+time+":~"+name+": "+input+"\n";
                    Server.msg++;
                    Server.msg1++;
                    
                }
                
                
                if(input.equalsIgnoreCase("DIR")&&fs==true){
                    conf=1;
                     String path = curpath; 
                     String output="";
                      File files;
                      File folder = new File(path);
                      File[] listOfFiles = folder.listFiles(); 
                      
                      if(listOfFiles.length!=0){
                          output=output+"\n\n>>DIRECTORIES---------\n";
                      for (int i = 0; i < listOfFiles.length; i++) 
                      {
                           if (listOfFiles[i].isDirectory()) 
                           {
                           files = listOfFiles[i];
                           String temp=files.getName();
                           if(files.getName().length()>100){
                               temp=files.getName().substring(0,99);
                           }
                           output=output+"->\t"+temp+"\n";                           
//                           for(int chk=0;chk<100-files.getName().length();i++){
//                               output=output+" ";                               
//                                    }
                           
                           //output=output+"\tSize: "+(files.length()/1024)+" KB\n";
                              }
                        }
                      output=output+"\n>>FILES---------------\n";
                      for (int i = 0; i < listOfFiles.length; i++) 
                      {
                           if (listOfFiles[i].isFile()) 
                           {
                           files = listOfFiles[i];
                           String temp=files.getName();
                           if(files.getName().length()>100){
                               temp=files.getName().substring(0,99);
                           }
                           output=output+"->\t"+temp;
//                           for(int chk=0;chk<100-temp.length();i++){
//                               output=output+" ";                               
//                                    }
                           output=output+"\t\tSize: "+(double)(files.length()/1024)+" KB\n";
                              }               
                        }
                      }
                      else {
                        output=output+"\nNO FILES FOUND";
                    }
                      output=output+"\n>>DIRECTORY LISTING OVER\n";
                      if(fs==false){
                                    output="";
                                }
                      Server.chat=Server.chat+output;
                }
                
                if((input.toUpperCase().startsWith("CD "))&&fs==true){
                    
                            String backup=curpath;
                            String output="";
                            conf=1;
                            if(input.substring(3).equals("..")){
                                int i=curpath.length()-1;
                                boolean ch=true,ch1=true;
                                while(ch1){
                                    if((ch==false)&&(curpath.charAt(i)==Server.def)){
                                        ch1=false;
                                    }
                                    if(curpath.charAt(i)==Server.def){
                                        ch=false;
                                    }
                                    curpath = curpath.substring(0,i);
                                    i--;
                                }
                            }
                            else {
                                curpath=curpath+input.substring(3);
                            }
                            if(!(curpath.charAt(curpath.length()-1)==Server.def)){
                                curpath=curpath + Server.def;
                            }
                            curpath=General.hashReturn(curpath);
                            File temp2=new File(curpath);
                            if(temp2.exists()){
                                output=output+"\n>>CD: Directory changed to: "+curpath+"\n";
                            }
                            else{
                                output=output+"\n>>CD: Invalid Directory at path. Reverting to original path: "+backup+"\n";
                                curpath=backup;
                            }
                            if(fs==false){
                                    output="";
                                }
                            Server.chat=Server.chat+output;
                   }
                if(input.toUpperCase().startsWith("RD ")&&fs==true){//NEW CODEPOINT START, TYPE=COMMAND
                                conf=1;
                                String backup=curpath;
                                String output="";
                                        curpath=input.substring(3);
                                        if(!(curpath.charAt(curpath.length()-1)==Server.def)){
                                             curpath=curpath + Server.def;
                                     }
                                        curpath=General.hashReturn(curpath);
                            File temp2=new File(curpath);
                            if(temp2.exists()){
                                output=output+"\n>>CD: Directory changed to: "+curpath+"\n";
                            }
                            else{
                                output=output+"\n>>CD: Invalid Directory path. Reverting to original path: "+backup+"\n";
                                curpath=backup;
                            }
                            if(fs==false){
                                    output="";
                                }
                            Server.chat=Server.chat+output;
                 }
                if((input.toUpperCase().startsWith("CMD_SENDFILE "))&&fs==true){//NEW CODEPOINT START, TYPE=COMMAND
                                conf=1;
                                Default.Var.file1=curpath+input.substring(13);
                                String output="";
                                Thread setFile=new NetworkCopy();
                                setFile.start();
                                        
                           
                            
                                output=output+"\n>>NETWORKCOPY: Thread started.\n";
                            
                            
                            
                            if(fs==false){
                                    output="";
                                }
                            Server.chat=Server.chat+output;
                 }
                if(input.toUpperCase().startsWith("MKDIR ")&&fs==true){
                                conf=1;
                                String output="";
                                String fname=input.substring(6);
                                curpath=General.hashReturn(curpath);
                                File folder = new File(curpath+fname);
                                boolean result=false;
                                if(fs==true){
                                    result=folder.mkdirs();
                                }
                                
                                if(result){
                                    output=output+"\n>>MKDIR: Directory created. Directory Path is: "+curpath+fname+"\n";
                                }
                                if(!result){
                                    output=output+"\n>>MKDIR: Directory creation failed. Try again.\n";
                                }             
                                if(fs==false){
                                    output="";
                                }
                            Server.chat=Server.chat+output;
                 }
                if(input.toUpperCase().startsWith("SETDEFCHAR ")&&fs==true){
                                conf=1;
                                String output="";
                                Server.def=input.charAt(11);                                
                                output=output+"\n>>SETDEFCHAR: Default character changed to: "+Server.def+"\n";
                                
                            Server.chat=Server.chat+output;
                 }
                if(input.toUpperCase().startsWith("SAVEHASH ")&&fs==true){
                                conf=1;
                                String output="";
                                Server.hash=curpath+"@";                                
                                output=output+"\n>>SAVEHASH: Current path: "+curpath+" saved at "+Server.curcount+"#\n";
                                Server.curcount++;
                            Server.chat=Server.chat+output;
                 }
                if(input.toUpperCase().startsWith("COPY ")&&fs==true){
                                conf=1;
                                String output="";
                                String paths=input.substring(5);
                                String[] split = paths.split("@");
                                split[1]=General.hashReturn(split[1]);
                                if(split.length==2){
                                if(!(split[1].charAt(split[1].length()-1)==Server.def)){
                                             split[1]=split[1] + Server.def;
                                     }
                                //Threaded Copy Code Strarts
                                Server.cpy1=curpath+split[0];
                                Server.cpy2=split[1]+split[0];
                                Server.cpy3=split[1];
                                Server.delete=false;
                                Thread cpythread=new ThreadedCopy();
                                cpythread.start();
//                                boolean result = classes.Files.copy(curpath+split[0], split[1]+split[0],split[1]);
//                                while(Server.opstatus!=100&&Server.opcheck){
//                                    out.println("Status: "+Server.opstatus+"%");
//                                }
                                boolean result=Server.opcheck;
//                                if(result){
                                    output=output+"\n>>COPY: File Copying in Background. Continue with your work.\n";
//                                }
//                                if(!result){
//                                    output=output+"\n>>COPY: File copying failed. Please check the file name and path and try again.\n";
//                                }
                                }
                                if(split.length!=2){
                                    output=output+"\n>>COPY: File copying failed. Syntax error. Use COPY <filename>@<targetDir>\n";
                                }
                                
                            Server.chat=Server.chat+output;
                 }
                if(input.toUpperCase().startsWith("MOVE ")&&fs==true){
                                conf=1;
                                String output="";
                                String paths=input.substring(5);
                                String[] split = paths.split("@");
                                split[1]=General.hashReturn(split[1]);
                                if(split.length==2)
                                {
                                    
                                if(!(split[1].charAt(split[1].length()-1)==Server.def)){
                                             split[1]=split[1] + Server.def;
                                     }
                                //Threaded Copy Code Strarts
                                Server.cpy1=curpath+split[0];
                                Server.cpy2=split[1]+split[0];
                                Server.cpy3=split[1];
                                Server.delete=true;
                                Thread cpythread=new ThreadedCopy();
                                cpythread.start();
                                //boolean result = classes.Files.copy(curpath+split[0], split[1]+split[0],split[1]);
                                boolean res2=false;
//                                if(result){
                                    output=output+"\n>>MOVE: File Copying in Background. Continue with your work.\n";
//                                    File temp=new File(curpath+split[0]);
//                                    res2=temp.delete();
//                                }
//                                if(!result){
//                                    output=output+"\n>>MOVE: File copying failed. Please check the file name and path and try again.\n";
//                                } 
                                if(res2){
                                    output=output+">>MOVE: Original File deleted. The file was "+curpath+split[1]+"\n>>MOVE:\tOPERATION SUCCESSFUL\n";
                                }
                                }
                                if(split.length!=2){
                                    output=output+"\n>>MOVE: File copying failed. Syntax error. Use COPY <filename>@<targetDir>\n";
                                }
                                
                            Server.chat=Server.chat+output;
                 }
                if(input.toUpperCase().equalsIgnoreCase("GETDEFCHAR")&&fs==true){
                                conf=1;
                                String output="";                                                                
                                output=output+"\n>>GETDEFCHAR: Default character is: "+Server.def+"\n";
                                
                            Server.chat=Server.chat+output;
                 }
                if(input.toUpperCase().equalsIgnoreCase("ROOTDIR")&&fs==true){
                                conf=1;
                                File[] temp=File.listRoots();
                                String output="\n>>ROOTDIR: List of root directories\n";
                                for (int i = 0; i < temp.length; i++) 
                                    {                         
                           File temp2 = temp[i];                                                      
                           output=output+"->\t"+temp2; 
                           output=output+"\t\tTotal Space: "+(temp2.getTotalSpace()/(1024*1024))+" MB\tFree Space: "+(temp2.getFreeSpace()/(1024*1024))+" MB\n";
                                        }
                                output=output+">>Root Directory Listing Over.\n";
                                
                            Server.chat=Server.chat+output;
                 }
                if(input.toUpperCase().startsWith("DELETE ")){
                                conf=1;
                                String output="";
                                String fname=input.substring(7);
                                curpath=General.hashReturn(curpath);
                                File folder = new File(curpath+fname);
                                boolean result=false;
                                if(fs==true){
                                    if(folder.isDirectory()) {
                                        try{
                                            org.apache.commons.io.FileUtils.deleteDirectory(folder);
                                            result=true;
                                        }
                                        catch(java.io.IOException e){
                                            result=false;
                                        }                                        
                                    }
                                    if(folder.isFile()) {
                                        result = org.apache.commons.io.FileUtils.deleteQuietly(folder);
                                    }
                                }
                                //boolean result=FileDeleter.delete(folder);
                                if(result){
                                    output=output+"\n>>DELETE: Directory deleted succesfully. The path was: "+curpath+fname+"\n";
                                }
                                if(!result){
                                    output=output+"\n>>DELETE: Directory deletion failed. Try again.\n";
                                }   
                                if(fs==false){
                                    output="";
                                }
                            Server.chat=Server.chat+output;
                 }
                
                if (input.equalsIgnoreCase("CMD_ADMIN_EXIT"))
                {
                    System.exit(1);
                    break;
                    
                }
                if (input.equalsIgnoreCase("CMD_FSTOGGLE_ON"))
                {
                    fs=true;
                    a="----------------------------------------------------------------------------\n"+"Sharing enabled"+": "+Server.namelist;
                    
                }
                if (input.equalsIgnoreCase("CMD_FSTOGGLE_OFF"))
                {
                    fs=false;
                    a="----------------------------------------------------------------------------\n"+"Sharing disabled"+": "+Server.namelist;
                    
                }
                if (input.equalsIgnoreCase("CMD_RESTORE"))
                {
                    String time=this.getTime();
                    Server.chat=Server.backup+"---------------------------------------------------------------------------\n"+time+" Server: Chat Restored\n---------------------------------------------------------------------------\n"+Server.chat;
                    conf=1;
                }
                if (input.equalsIgnoreCase("CMD_ADMIN_MSG"))
                {
                    String time=this.getTime();
//                    String temp = "";
//                    for(int i=0;i<=Server.oncnt;i++)
//                    {
//                        temp=temp+Server.online1[i]+"\n";
//                    }
                    conf=1;
                    a="----------------------------------------------------------------------------\n"+time+": "+Server.namelist;
                    //out.println(Server.get_online()+"\nEND");
                }
                if (input.equalsIgnoreCase("CMD_ADMIN_DELCHAT"))
                {
                    Server.chat="";  
                    Server.backup="";
                    conf=1;
                }
                if (input.equalsIgnoreCase("CMD_GETTIME"))
                {
                    String time=getTime();
                    conf=1;
                    //Server.chat=Server.chat+time+": Server: Reply to " + name+": Current time: "+ time+" Server time\n";
                    //out.println(Server.chat+"END");
                    a="---------------------------------------------------------------------------\n"+time+": Server: Reply to " + name+": Current time: "+ time+" Server time";
                    //out.println(a);
                    conf=1;
                }
                if (input.equalsIgnoreCase("CMD_UPTIME"))
                {
                    String time=getTime();
                    a="---------------------------------------------------------------------------\n"+time+": Server: Reply to " + name+": Up Since: "+ Server.timeold+" Server time";
                    //out.println(a);
                    conf=1;
                }
                if (input.equalsIgnoreCase("CMD_GETMSG"))
                {
                    String time=getTime();
                    a="---------------------------------------------------------------------------\n"+time+": Server: Reply to " + name+": Total Messages: "+ Server.msg+"";
                    //out.println(a);
                    conf=1;
                }
                if (input.equalsIgnoreCase("CMD_GETMSGCUR"))
                {
                    String time=getTime();
                    a="---------------------------------------------------------------------------\n"+time+": Server: Reply to " + name+": Messages In This Conversation: "+ Server.msg1;
                    //out.println(a);
                    conf=1;
                }
                if (input.equalsIgnoreCase("CMD_ADMIN_GETMSG"))
                {
                    
                    a=""+Server.msg1;
                    out.println(a);
                    conf=2;
                }
                if (input.equalsIgnoreCase("CMD_CONNECT"))
                {
                    Server.namelist=Server.namelist+"- "+name+"\n";
                    conf=1;
                    oncnt++;
                    String time=getTime();
                    Server.online++;
                    Server.chat=Server.chat+time+": Server: New User Connected: " + name+": Users Online:"+Server.online+"\n";
                    Server.online12=Server.online12+time+": Server: New User Connected: " + name+": Users Online:"+Server.online+"\n";
                    out.println(Server.chat+"END");
                    //Server.online1[Server.oncnt]=time+": "+name+ " is Online"+ "\n";
//                    Server.users[Server.oncnt]=name;
//                    Server.status[Server.oncnt]=1;
                    //Server.oncnt++;
                    //Server.online1="New User";
                }
                if (input.equalsIgnoreCase("CMD_ONLINE"))
                {
                    String time=getTime();                    
                    a="---------------------------------------------------------------------------\n"+time+": Server: Reply to " + name+": Users Online:"+Server.online+"";
                    //out.println(a);
                    conf=1;
                }
                if (input.equalsIgnoreCase("CMD_DISCONNECT"))
                {
                    String time=getTime();
                    Server.namelist=Server.namelist.replace("- "+name+"\n","");
                    //Server.online1[Server.oncnt]=time+": "+name+ " is Offline"+ "\n";
                    //Server.oncnt++;
                    //BEGIN
//                    for(int i=0;i<=Server.oncnt;i++)
//                    {
//                        if(Server.users[i].equals(name)==true)
//                        {
//                            Server.status[i]=0;
//                        }
//                    }
                    //END
                    Server.online--;
                    Server.chat=Server.chat+time+": Server: User Disconnected: " + name+": Users Online:"+Server.online+"\n";
                    Server.online12=Server.online12+time+": Server: User Disconnected: " + name+": Users Online:"+Server.online+"\n";
                    out.println(Server.chat+"END");
                    conf=1;
                }
                //else if (input.equalsIgnoreCase("get"))
                //{
                 //   out.println(bart.getQuote());
                 //   System.out.println("Serving " + client);
                 //   out.println(Server.chat+"\nEND");
                //}
                else if (input.equalsIgnoreCase("CMD_BACKUP"))
                {
                    String time=getTime();
                    Server.backup=Server.backup+Server.chat;
                    Server.chat=time+": Server: Chat Hidden\n";
                    out.println(Server.chat+"END");
                    Server.msg1=0;
                    conf=1;
                }
                else if(conf!=2)
                out.println(Server.chat+"\n"+a+"\nEND");
            }}
            else
                out.println("DISAPPROVE");
            s.close();
        }
        catch (Exception e)
        {
        e.printStackTrace();
        }
        System.out.println("Closed connection to " + client);
        
    }
    
}