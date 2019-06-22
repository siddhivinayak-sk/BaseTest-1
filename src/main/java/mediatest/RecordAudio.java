/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatest;

import javax.sound.sampled.*;
import java.io.*;

public class RecordAudio {
    private File audioFile;
    protected boolean running;
    private ByteArrayOutputStream out;
    private AudioInputStream inputStream;
    final static float MAX_8_BITS_SIGNED = Byte.MAX_VALUE;
    final static float MAX_8_BITS_UNSIGNED = 0xff;
    final static float MAX_16_BITS_SIGNED = Short.MAX_VALUE;
    final static float MAX_16_BITS_UNSIGNED = 0xffff;
    private AudioFormat format;
    private float level;
    private int frameSize;

    public RecordAudio(){
         getFormat();
    }

    private AudioFormat getFormat() {
        File file = new File("d:/test/sample-1.wav");
        AudioInputStream stream;
        try {
            stream = AudioSystem.getAudioInputStream(file);
            format=stream.getFormat();
            frameSize=stream.getFormat().getFrameSize();
            return stream.getFormat();
        } catch (UnsupportedAudioFileException e) {

        } catch (IOException e) {

        }
        return null;
    }

    public void stopAudio() {

        running = false;
    }

    public void recordAudio() {

        try {
            final AudioFormat format = getFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            final TargetDataLine line = (TargetDataLine)AudioSystem.getLine(info);
            line.open(format);
            line.start();
            Runnable runner = new Runnable() {
                int bufferSize = (int) format.getSampleRate() * format.getFrameSize();
                byte buffer[] = new byte[bufferSize];

                public void run() {
                    out = new ByteArrayOutputStream();
                    running = true;
                    while (running) {
                        int count = line.read(buffer, 0, buffer.length);

                        calculateLevel(buffer,0,0);
                        System.out.println(level);

                        if (count > 0) {
                            out.write(buffer, 0, count);
                        }
                    }
                    line.stop();
                }
            };
            Thread captureThread = new Thread(runner);
            captureThread.start();
        } catch (LineUnavailableException e) {
            System.err.println("Line unavailable: " + e);
            System.exit(-2);
        }
    }

    public File getAudioFile() {
        byte[] audio = out.toByteArray();
        InputStream input = new ByteArrayInputStream(audio);
        try {
            final AudioFormat format = getFormat();
            final AudioInputStream ais = new AudioInputStream(input, format, audio.length / format.getFrameSize());
            AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File("d:/test/temp.wav"));
            input.close();
            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new File("temp.wav");
    }

    private void calculateLevel (byte[] buffer, int readPoint, int leftOver) {
        int max = 0;
        boolean use16Bit = (format.getSampleSizeInBits() == 16);
        boolean signed = (format.getEncoding() == AudioFormat.Encoding.PCM_SIGNED);
        boolean bigEndian = (format.isBigEndian());
        if (use16Bit) {
            for (int i=readPoint; i<buffer.length-leftOver; i+=2) {
                int value = 0;
                // deal with endianness
                int hiByte = (bigEndian ? buffer[i] : buffer[i+1]);
                int loByte = (bigEndian ? buffer[i+1] : buffer [i]);
                if (signed) {
                    short shortVal = (short) hiByte;
                    shortVal = (short) ((shortVal << 8) | (byte) loByte);
                    value = shortVal;
                } else {
                    value = (hiByte << 8) | loByte;
                }
                max = Math.max(max, value);
            } // for
        } else {
            // 8 bit - no endianness issues, just sign
            for (int i=readPoint; i<buffer.length-leftOver; i++) {
                int value = 0;
                if (signed) {
                    value = buffer [i];
                } else {
                    short shortVal = 0;
                    shortVal = (short) (shortVal | buffer [i]);
                    value = shortVal;
                }
                max = Math.max (max, value);
            } // for
        } // 8 bit
        // express max as float of 0.0 to 1.0 of max value
        // of 8 or 16 bits (signed or unsigned)
        if (signed) {
            if (use16Bit) { level = (float) max / MAX_16_BITS_SIGNED; }
            else { level = (float) max / MAX_8_BITS_SIGNED; }
        } else {
            if (use16Bit) { level = (float) max / MAX_16_BITS_UNSIGNED; }
            else { level = (float) max / MAX_8_BITS_UNSIGNED; }
        }
    } // calculateLevel


    public static void main(String...args) throws Exception {
        RecordAudio ra = new RecordAudio();
        ra.recordAudio();
    }
}