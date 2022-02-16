/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatest;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;


/**
 *
 * @author sandeep.kumar
 */
public class M1Test {

    public static void main(String...args) throws Exception {
        MidiDevice.Info[] infoArr = MidiSystem.getMidiDeviceInfo();
        MidiDevice.Info tempInfo = null;
        for(MidiDevice.Info mdevice:infoArr) {
            //System.out.println("Name: " +  mdevice.getName());
            //System.out.println("Description: " +  mdevice.getDescription());
            //System.out.println("Vendor: " +  mdevice.getVendor());
            //System.out.println("Version: " +  mdevice.getVersion());
            //System.out.println("--------------------------------------------");
            if(mdevice.getVendor().equalsIgnoreCase("Oracle Corporation")) {
                tempInfo = mdevice;
            }
        }
        if(null == tempInfo && infoArr.length > 0) {
            tempInfo = infoArr[0];
        }
        MidiDevice mDevice = MidiSystem.getMidiDevice(tempInfo);
        Receiver r1 = mDevice.getReceiver();
        Transmitter t1 = mDevice.getTransmitter();

        //Sequence sequence = MidiSystem.getSequence(stream);
        //Soundbank soundbank = MidiSystem.getSoundbank(stream);
        Receiver receiver = MidiSystem.getReceiver();
        //Transmitter transmitter = MidiSystem.getTransmitter();
        Sequencer sequencer = MidiSystem.getSequencer();
        
        
        
        
        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        Receiver r2 = synthesizer.getReceiver();
        //Transmitter t2 = synthesizer.getTransmitter();
        Instrument[] instruments1 = synthesizer.getAvailableInstruments();
//        for(Instrument it:instruments1) {
//            System.out.println("Name: " + it.getName());
//            System.out.println("---------------------------");
//        }
        
        
        
        //Instrument[] instruments2 = synthesizer.getLoadedInstruments();
        MidiChannel[]  midiChannels = synthesizer.getChannels();
        Soundbank sb2 = synthesizer.getDefaultSoundbank();
        
        
        System.out.println("Note Examle");
        //Select a channel and add noteOn or noteOff value between 0-127
        MidiChannel selectedChannel = midiChannels[0];
        synthesizer.open();
        selectedChannel.noteOn(60, 60);
        Thread.sleep(500);
        selectedChannel.noteOff(60);
        Thread.sleep(100);
        selectedChannel.noteOn(10, 60);
        Thread.sleep(500);
        selectedChannel.noteOff(10);
        Thread.sleep(100);
        selectedChannel.noteOn(70, 60);
        Thread.sleep(500);
        selectedChannel.noteOff(70);
        synthesizer.close();
        //End
        
    }
}
