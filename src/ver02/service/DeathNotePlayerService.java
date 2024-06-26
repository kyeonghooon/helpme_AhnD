package ver02.service;

import ver02.Frame.DeathNoteFrame;
import ver02.components.ComboBox_kh;
import ver02.components.DeathNote;
import ver02.components.HpBox_kh;
import ver02.components.ScoreBox_kh;
import ver02.state.KeyType;
import ver02.state.Player;

public class DeathNotePlayerService implements Runnable {

	DeathNoteFrame mContext;
	DeathNote deathNoteRight;
	DeathNote deathNoteLeft;
	DeathNote deathNoteUp;
	DeathNote deathNoteDown;
	private DeathNote note;
	private ScoreService_kh scoreService_kh;

	public DeathNotePlayerService(DeathNoteFrame mContext, Player player) {
		this.mContext = mContext;

		scoreService_kh = new ScoreService_kh(mContext, player);

		new HpBox_kh(this, player);
		new ScoreBox_kh(this, player);
		new ComboBox_kh(this, player);
		switch (player) {
		case LEFTPLAYER:
			deathNoteLeft = new DeathNote(this, Player.LEFTPLAYER, KeyType.LEFT);
			deathNoteUp = new DeathNote(this, Player.LEFTPLAYER, KeyType.UP);
			deathNoteDown = new DeathNote(this, Player.LEFTPLAYER, KeyType.DOWN);
			deathNoteRight = new DeathNote(this, Player.LEFTPLAYER, KeyType.RIGHT);
			break;
		case RIGHTPLAYER:
			deathNoteLeft = new DeathNote(this, Player.RIGHTPLAYER, KeyType.LEFT);
			deathNoteUp = new DeathNote(this, Player.RIGHTPLAYER, KeyType.UP);
			deathNoteDown = new DeathNote(this, Player.RIGHTPLAYER, KeyType.DOWN);
			deathNoteRight = new DeathNote(this, Player.RIGHTPLAYER, KeyType.RIGHT);
			break;
		default:
			break;
		}
	}


	@Override
	public void run() {
	}

	// getter
	public DeathNoteFrame getmContext() {
		return mContext;
	}

	public ScoreService_kh getScoreService_kh() {
		return scoreService_kh;
	}

}
