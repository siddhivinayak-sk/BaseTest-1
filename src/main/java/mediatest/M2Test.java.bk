/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.SourceDataLine;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author sandeep.kumar
 */
public class M2Test {
    
    public static void main(String...args) throws Exception {
        File audioFile1 = new File("d:/test/sample-2.wav");
        AudioFileFormat aff1 = AudioSystem.getAudioFileFormat(audioFile1);
        AudioFormat af1 = aff1.getFormat();
        AudioFileFormat.Type t1 = aff1.getType();
        int byteLength1 = aff1.getByteLength();
        int frameLength1 = aff1.getFrameLength();
        Map<String, Object> mp1 = aff1.properties();
        
        System.out.println("Channels: " + af1.getChannels());
        System.out.println("Encoding: " + af1.getEncoding());
        System.out.println("FrameRate: " + af1.getFrameRate());
        System.out.println("FrameSize: " + af1.getFrameSize());
        System.out.println("SampleRate: " + af1.getSampleRate());
        System.out.println("SampleSizeInBits: " + af1.getSampleSizeInBits());
        System.out.println("BigEndian: " + af1.isBigEndian());
        System.out.println("ByteLength: " + byteLength1);
        System.out.println("FrameLength: " + frameLength1);
        for(Map.Entry<String, Object> entry:mp1.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        AudioInputStream ais1 = AudioSystem.getAudioInputStream(audioFile1);

        SourceDataLine sdl1 = AudioSystem.getSourceDataLine(af1);
        sdl1.open(af1);
        sdl1.start();
        int BUFFER_SIZE = (af1.getFrameSize() * (int)af1.getSampleRate())/2;
        int nBytesRead = 0;
        byte[]  abData = new byte[BUFFER_SIZE];
        while(nBytesRead != -1) {
            nBytesRead = ais1.read(abData, 0, abData.length);
            if(nBytesRead >= 0) {
                System.out.println(volumeRMS1(abData));;
                sdl1.write(abData, 0, nBytesRead);
            }
        }
        sdl1.drain();
        sdl1.close();
        
        
        
//        Clip clip1 = AudioSystem.getClip();
//        clip1.addLineListener(new LineListener() {
//            @Override
//            public void update(LineEvent event) {
//                System.out.println(event.getType());
//                if(event.getType() ==  LineEvent.Type.STOP) {
//                    clip1.stop();
//                }
//            }
//        });
//        clip1.open(ais1);
//        clip1.start();
//        Thread.sleep(10000);
        
        
//        AudioStream as1 = new AudioStream(new FileInputStream(audioFile1));
//        AudioPlayer.player.start(as1);
        

        
        
        
        
        
        
        
        
        
    }
    
    
public static double volumeRMS(double[] raw) {
    double sum = 0d;
    if (raw.length==0) {
        return sum;
    } else {
        for (int ii=0; ii<raw.length; ii++) {
            sum += raw[ii];
        }
    }
    double average = sum/raw.length;

    double sumMeanSquare = 0d;
    for (int ii=0; ii<raw.length; ii++) {
        sumMeanSquare += Math.pow(raw[ii]-average,2d);
    }
    double averageMeanSquare = sumMeanSquare/raw.length;
    double rootMeanSquare = Math.sqrt(averageMeanSquare);

    return rootMeanSquare;
}    
    
public static double volumeRMS1(byte[] raw) {
    double sum = 0d;
    if (raw.length==0) {
        return sum;
    } else {
        for (int ii=0; ii<raw.length; ii++) {
            sum += raw[ii];
        }
    }
    double average = sum/raw.length;

    double sumMeanSquare = 0d;
    for (int ii=0; ii<raw.length; ii++) {
        sumMeanSquare += Math.pow(raw[ii]-average,2d);
    }
    double averageMeanSquare = sumMeanSquare/raw.length;
    double rootMeanSquare = Math.sqrt(averageMeanSquare);

    return rootMeanSquare;
}    


}
