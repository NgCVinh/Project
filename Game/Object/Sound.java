package Game.Object;

import javax.sound.sampled.*;
import java.io.File;
public class Sound{
    Clip clip;
    String[] soundURL = new String[3];

    public Sound(){
        soundURL[0] = "C:\\Users\\ASUS\\IdeaProjects\\test\\src\\Game\\Shoot.wav";
        soundURL[1] = "C:\\Users\\ASUS\\IdeaProjects\\test\\src\\Game\\Destroy.wav";
        soundURL[2] = "C:\\Users\\ASUS\\IdeaProjects\\test\\src\\Game\\Hit.wav";
    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(soundURL[i]).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){
            System.err.println(e);
        }
    }

    public void play(){
        clip.start();
    }

    public void playSE(int i){
        setFile(i);
        play();
    }
}