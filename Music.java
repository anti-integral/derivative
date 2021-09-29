import processing.core.PApplet;
import ddf.minim.*;
//import ddf.minim.analysis.FFT; 
//import processing.core.PImage; 

public class Music extends PApplet {
    private Minim music;
    private AudioPlayer audio;
    private int centerX;
    private int centerY;
    private final int red = color(244, 180, 26);
    private final int blue = color(20, 61, 89);
    //private FFT fft;
    public static void main(String[] args) {
        PApplet.main("Music");
    }
    public void settings(){
        size(900, 650);

    }

    public void setup(){
        background(0);
        music = new Minim(this);
        audio = music.loadFile("Resources/HITR.mp3");
        audio.loop();
        centerX = width/2;
        centerY = height/2;

    }

    public void draw(){
        background(0);
        float[] left = audio.left.toArray();
        float[] right = audio.right.toArray();
        for(int i = 0; i < left.length - 1; i++){
            musicDrawer(left, i, -1, blue);
            musicDrawer(right, i, 1, red);
        }
    }
    public void musicDrawer(float[] channel, int count, int dir, int color){
        stroke(color);
        line(count, centerY + (dir * abs(channel[count] * 50)), count + 1,  centerY + (dir * abs( channel[count + 1] * 150)));

    }
}