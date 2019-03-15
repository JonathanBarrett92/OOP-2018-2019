package ie.dit;

import ddf.minim.Minim;
import processing.core.PApplet;

public class AudioProcessing extends PApplet {
  Minim minim;
  FFT fft;
  AudioInput ai;


  public static final int FRAME_SIZE = 1024;
  public static final int SAMPLE_RATE = 44100;
  public static final int BITS_PER_SAMPLE = 16;

  public void settings() {
    size(1024, 1024);
    minim = new Minim(this);
    ai = minim.getLineIn(Minim.MONO, FRAME_SIZE, SAMPLE_RATE, BITS_PER_SAMPLE);

  }

  public void draw() {
    background(0);
    float middle = height/2;
    for (int i = 0; i < ai.bufferSize(); i++) {
      line(i, middle, i, middle + ai.left.get(i) * middle);
    }
  }

}
