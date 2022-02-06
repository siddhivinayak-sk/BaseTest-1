package pdfstriper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        String string = null;
        try {

        	/*
        	PDFParser pdfParser = new PDFParser( new RandomAccessBufferedFileInputStream("C:\\Users\\AB350816\\Desktop\\Oriental PDF File Format\\Oriental PDF File Format" + "\\happySilverPaln\\141200_48_2019_26126.pdf"));
            pdfParser.parse();
            PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
            PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
            string = pdfTextStripper.getText(pdDocument);
            System.out.println("string " +string);

            
            String pattern = "Prev\\. Policy  No.([ ]+): ([^/]+)/([^/]+)/([^/]+)/([^ ]+)";
            String prevPolicy = RegExUtils.getSecondIteamFromPattern(pattern, string, ":");
           // System.out.println(prevPolicy);

            pattern = "Policy No.([ ]+): ([^/]+)/([^/]+)/([^/]+)/([^ ]+)";
            String policy = RegExUtils.getSecondIteamFromPattern(pattern, string, ":");
           // System.out.println(policy);
            
            pattern = "Cover  Note No.     :(.*?)Cover  Note Date";
            String coverNote = RegExUtils.getSecondIteamFromPattern(pattern, string, ":").replace("Cover  Note Date", "").trim();
            //System.out.println(coverNote);
            
            pattern = "Cover  Note Date    :(.*)";
            String coverNoteDate = RegExUtils.getSecondIteamFromPattern(pattern, string, ":").trim();
           // System.out.println(coverNoteDate);


//            pattern = "       Insured Name        :(.*?)       Address            :";
//            String startTxt = "       Insured Name        :";
//            String endTxt = "       Address            :";
//            String midTxt = "Issue Office Name :";

//          pattern = "       Address            :(.*?)       Tel./Fax/Email     :";
//          String startTxt = "       Address            :";
//          String endTxt = "       Tel./Fax/Email     :";
//          String midTxt = "Address             :";
//            
//            
//            List<String> inList = RegExUtils.getMultiLines(pattern, string, startTxt, endTxt, Arrays.asList(midTxt));
//            System.out.println(inList);
            
            pattern = "        Dev.Off.Code      :.*";
            String devOff = RegExUtils.getSecondIteamFromPattern(pattern, string, ":");
            String var40 = devOff.substring(0, devOff.indexOf(' '));
            String var41 = devOff.substring(devOff.indexOf(' '), devOff.length() - 1);
            
           // System.out.println(var40);
           // System.out.println(var41.trim());
            
            
//            pattern = "Insurer Name                          Sum   Insured                  (.*?)      Place :";
//            String startTxt = "Insurer Name                          Sum   Insured                  ";
//            String endTxt = "      Place :";
//              
//              
//              Map<Integer,List<String>> inList = RegExUtils.getTab1(pattern, string, startTxt, endTxt);
//              System.out.println(inList);
            
          pattern = "Sum  Insured  \\(INR                (.*?)      Place :";
          String startTxt = "Sum  Insured  \\(INR                ";
          String endTxt = "      Place :";
            
            
          // Map<Integer, List<String>> inList = RegExUtils.getTab2(pattern, string, startTxt, endTxt);
           // System.out.println(inList);
            * 
            * 
            */
        	
        	FileInputStream fis = new FileInputStream(new File("C:\\newFormat"));
        	byte[] data = new byte[fis.available()];
        	fis.read(data);
        	string = new String(data);
        	fis.close();
        	
        	
        	
        	System.out.println(RegExUtils.getTables(string));
        	
        	
        	
        	
        	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };
      // System.out.println("string :::::"+string.trim());
//        String lines[] = string.split("\\r?\\n");
//        for(String line:lines){
//        System.out.println("string :::::"+line.trim());
//   }
}
}
