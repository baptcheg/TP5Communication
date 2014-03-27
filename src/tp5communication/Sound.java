/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5communication;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author baptman
 */
public class Sound {
        public static void playSound(String fileName) {
        //Fonction permettant de récupérer et lire un fichier audio.wav
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(fileName)));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}
