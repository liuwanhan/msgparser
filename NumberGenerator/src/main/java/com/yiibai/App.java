package com.yiibai;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.simplejavamail.*;

import com.auxilii.msgparser.Message;
import com.auxilii.msgparser.MsgParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World1!" );
        
        MsgParser msgp = new MsgParser();
        try {
			   Message msg = msgp.parseMsg("D:\\data\\a.msg");
			   
			   String fromEmail = msg.getFromEmail();
			   String fromName = msg.getFromName();
			   String subject = msg.getSubject();
			   String body = msg.getBodyText();
			   
			   
			   System.out.println(fromEmail );
			   System.out.println(fromName );
			   System.out.println(subject );
			   //System.out.println(body );
			   
			   File file =new File("D:\\data\\a.html");
			   
			   if(!file.exists()){
			       file.createNewFile();
			      }
			   
			   
			   OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file),"UTF-8"); 
			   BufferedWriter writer=new BufferedWriter(write); 
			   writer.write(body);
			   writer.close(); 
			  
			   System.out.println("Done");
			   
			   
			   
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
