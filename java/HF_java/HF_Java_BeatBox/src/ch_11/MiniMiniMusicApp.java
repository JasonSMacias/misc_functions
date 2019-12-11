package ch_11;
import javax.sound.midi.*;

public class MiniMiniMusicApp {
	public static void main(String[] args) {
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}
	
	public void play() {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			ShortMessage first = new ShortMessage();
			// change 3rd arg for different instruments
			first.setMessage(192, 1, 50, 0);
			MidiEvent changeI = new MidiEvent(first,1);
			track.add(changeI);
			
			ShortMessage a = new ShortMessage();
			// 3rd arg pitch, 0-127
			a.setMessage(144, 1, 44, 100);
			// second arg beat number
			MidiEvent noteOn = new MidiEvent(a,1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			// second arg end beat number
			MidiEvent noteOff = new MidiEvent(b, 12);
			track.add(noteOff);
			
			System.out.println("sequence ready");
			player.setSequence(seq);
			
			player.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("done");
	}
}
