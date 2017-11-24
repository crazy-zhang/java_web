package com.option;

//import java.applet.Applet;
//import java.applet.AudioClip;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.net.MalformedURLException;

//import javax.print.DocFlavor.URL;


public class OptionMusic {
	public OptionMusic(){
		
	}
	public void play_music(){
		Thread t=new Thread(new Runnable(){

			@Override
			public void run() {
				java.io.InputStream in;
				// TODO Auto-generated method stub
				while(true){
					try {
						in = new java.io.FileInputStream("music\\back_1.wav");
						sun.audio.AudioStream as;
						try {
							as = new sun.audio.AudioStream(in);
							sun.audio.AudioPlayer.player.start(as);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					}
			}
			
		});
	t.start();	
}	
}
