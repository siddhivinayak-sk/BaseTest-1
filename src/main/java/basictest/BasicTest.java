/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package basictest;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import java.util.*;
import java.io.*;


/**
 *
 * @author Sandeep
 */
public class BasicTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        PDDocument newDoc = new PDDocument();
        PDDocument document = PDDocument.load(args[0]);
        for(int i = 0; i < document.getNumberOfPages(); i++) {
            PDPage page = (PDPage)document.getDocumentCatalog().getAllPages().get(i);
            System.out.println(i + "findCropBox: " + page.findCropBox().getLowerLeftX() + " " + page.findCropBox().getLowerLeftY() + " " + page.findCropBox().getWidth() + " " + page.findCropBox().getHeight());
            System.out.println(i + "findMediaBox: " + page.findMediaBox().getLowerLeftX() + " " + page.findMediaBox().getLowerLeftY() + " " + page.findMediaBox().getWidth() + " " + page.findMediaBox().getHeight());
            System.out.println(i + "getCropBox: " + page.getCropBox().getLowerLeftX() + " " + page.getCropBox().getLowerLeftY() + " " + page.getCropBox().getWidth() + " " + page.getCropBox().getHeight());
            System.out.println(i + "getMediaBox: " + page.getMediaBox().getLowerLeftX() + " " + page.getMediaBox().getLowerLeftY() + " " + page.getMediaBox().getWidth() + " " + page.getMediaBox().getHeight());
            System.out.println(i + "getArtBox: " + page.getArtBox().getLowerLeftX() + " " + page.getArtBox().getLowerLeftY() + " " + page.getArtBox().getWidth() + " " + page.getArtBox().getHeight());
            System.out.println(i + "getBleedBox: " + page.getBleedBox().getLowerLeftX() + " " + page.getBleedBox().getLowerLeftY() + " " + page.getBleedBox().getWidth() + " " + page.getBleedBox().getHeight());
            //System.err.println(page.convertToImage().getWidth() + "--" + page.convertToImage().getHeight());
            
            
            
            
            org.apache.pdfbox.util.ImageIOUtil.writeImage(page.convertToImage(), "jpeg", ("d:\\Test\\20-01-2015\\images\\" + i + ".jpg"), 600);
            
            
            page.setCropBox(page.getTrimBox());
            newDoc.addPage(page);
        }
        
        newDoc.save("d:\\Test\\20-01-2015\\Test.pdf");
    }
    
}
