/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5communication;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author baptman
 */
public class Sound {
    
    static String soundValidation = new File("APP01.wav").getAbsolutePath();
    static String soundClick = new File("RVBCLICK.wav").getAbsolutePath();
    
        public static void playSound(String urlWaveFile) {
        //Fonction permettant de récupérer et lire un fichier audio.wav
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(urlWaveFile)));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}
