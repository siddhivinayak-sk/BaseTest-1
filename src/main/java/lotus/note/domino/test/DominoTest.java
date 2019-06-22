//package lotus.note.domino.test;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//import java.util.Date;
//import java.util.Vector;
//
//import lotus.domino.Database;
//import lotus.domino.Document;
//import lotus.domino.EmbeddedObject;
//import lotus.domino.NotesFactory;
//import lotus.domino.NotesThread;
//import lotus.domino.RichTextItem;
//import lotus.domino.RichTextParagraphStyle;
//import lotus.domino.Session;
//import lotus.domino.View;
//
//
///**
// *
// * @author sandeepkumar
// * Compile with source 1.6 and run with Java 32bit
// * C:\Notes\Bin\jvm\bin>java -cp c:\notes\jvm\lib\ext\Notes.jar;. -Djava.library.path=C:\notes\bin DominoTest
// * 
// * 
// */
//public class DominoTest {
//    
//    public static void main(String argv[]) {
//        DominoTest t = new DominoTest();
//        t.runNotes();
//    }
//
//    public void runNotes() {
//        try {
//			lotus.notes.NotesThread.sinitThread();
//            //Session s = NotesFactory.createSessionWithFullAccess();
//			Session s = NotesFactory.createSession();
//            System.out.println("USername: "+s.getUserName());
//            System.out.println("HTTP URL: "+s.getHttpURL());
//            System.out.println("Name: "+s.getServerName());
//            System.out.println("URL: "+s.getURL());
//
//            //To bypass Readers fields restrictions
//            //Session s = NotesFactory.createSessionWithFullAccess();
//            String p = s.getPlatform();
//            Database database = s.getDatabase("", "C:\\Users\\sandeepkumar\\AppData\\Local\\IBM\\Notes\\Data\\names.nsf");
//            View view = database.getView("($Inbox)");
//            Document d = database.createDocument();
//            RichTextParagraphStyle stream = s.createRichTextParagraphStyle();
//
//            
//            d.setSaveMessageOnSend(true);
//            RichTextItem attachedfile = d.createRichTextItem("Attchement");
//            //attachedfile.embedObject(EmbeddedObject.EMBED_ATTACHMENT, "KHAN", "C:\\LotusNotes\\JavaTeam\\Lotus_java\\test.java", "test");
//            //d.createRichTextItem("C:\\Users\\sandeepkumar\\AppData\\Local\\IBM\\Notes\\Data\\names.nsf");
//
//            StringBuilder bodyContent = new StringBuilder();
//            bodyContent.append("Test Body Content");
//            Vector vecObj = new Vector();
//            vecObj.addElement("siddhivinayak.sk@gmail.com");
//            d.appendItemValue("\n\n");
//            d.appendItemValue("Body", bodyContent.toString());
//            d.appendItemValue("Subject", "Test Subject");
//            d.appendItemValue("SentTo", "siddhivinayak.sk@live.com");
//            d.appendItemValue("CopyTo" , vecObj);
//            d.appendItemValue("From", "Max@bvcps.in");
//            d.appendItemValue("SentFrom", "Max@bvcps.in");
//            d.send("siddhivinayak.sk@live.com");
//
//            System.out.println("Mail sent Successfully!!!");
//            System.out.println("Platform = " + p);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//}
//
