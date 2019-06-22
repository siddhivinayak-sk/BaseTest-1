/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pdfboxtest;

import org.apache.pdfbox.PDFReader;

/**
 *
 * @author Sandeep
 */
public class PDFBoxTest {
    public static void main(String...args) {
        String file = "e:\\important\\sandeep\\pdfb\\pdfbox\\a.pdf";
        PDFReader reader = new PDFReader();
        reader.setVisible(true);
        
    }
}
