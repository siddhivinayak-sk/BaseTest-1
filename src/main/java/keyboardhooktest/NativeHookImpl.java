/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package keyboardhooktest;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.SwingDispatchService;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author Sandeep
 */
public class NativeHookImpl implements NativeKeyListener, NativeMouseInputListener, NativeMouseWheelListener {
    public static final Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
    //private static final long serialVersionUID = 1541183202160543102L;
    public static BufferedWriter bw;


    public NativeHookImpl() {
        // Disable parent logger and set the desired level.
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        // Add our custom formatter to a console handler.
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new java.util.logging.Formatter() {
            @Override
            public String format(LogRecord record) {
                return(record.getMessage());
            }
        });
        handler.setLevel(Level.WARNING);
        logger.addHandler(handler);
        
        
        //Pre-paring buffered writer
        bw = getWriter("c:/no.log");
        
        //Addting registering listeners
        GlobalScreen.addNativeKeyListener(this);
        GlobalScreen.addNativeMouseListener(this);
        GlobalScreen.addNativeMouseMotionListener(this);
        GlobalScreen.addNativeMouseWheelListener(this);
        
        //Starting service for invoking listener
        GlobalScreen.setEventDispatcher(new SwingDispatchService());
        
        try {
            GlobalScreen.registerNativeHook();
        }
        catch(Exception e) {
            //GlobalScreen.unregisterNativeHook();
        }
    }
    

    
    public void nativeKeyPressed(NativeKeyEvent e) {
            displayEventInfo(e);
    }
    public void nativeKeyReleased(NativeKeyEvent e) {
            displayEventInfo(e);
    }
    public void nativeKeyTyped(NativeKeyEvent e) {
            displayEventInfo(e);
    }
    public void nativeMouseClicked(NativeMouseEvent e) {
            displayEventInfo(e);
    }
    public void nativeMousePressed(NativeMouseEvent e) {
            displayEventInfo(e);
    }
    public void nativeMouseReleased(NativeMouseEvent e) {
            displayEventInfo(e);
    }
    public void nativeMouseMoved(NativeMouseEvent e) {
            displayEventInfo(e);
    }
    public void nativeMouseDragged(NativeMouseEvent e) {
            displayEventInfo(e);
    }
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
            displayEventInfo(e);
    }

        
    /**
     * Handler method
     */
    private void displayEventInfo(NativeInputEvent e) {
        if(e instanceof NativeKeyEvent) {
            NativeKeyEvent keyEvent = (NativeKeyEvent)e;

            addMessage(keyEvent.paramString());
        }
        else if(e instanceof NativeMouseEvent) {
            NativeMouseEvent mouseEvent = (NativeMouseEvent)e;
            
            logger.info(mouseEvent.paramString());
        }
        else if(e instanceof NativeMouseWheelEvent) {
            NativeMouseWheelEvent mouseWheelEvent = (NativeMouseWheelEvent)e;
            
            logger.info(mouseWheelEvent.paramString());
        }
    }
    
    public void addMessage(String message) {
        try {
            bw.write(message + "\r\n");
            bw.flush();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public BufferedWriter getWriter(String fileName) {
        BufferedWriter bw = null;
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
        }
        catch(Exception e) {
            bw = null;
        }
        finally {
            return(bw);
        }
    }
    
}
