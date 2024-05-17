package helpme_AhnD.ver02.Frame;

import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.components.AhnCharacter;
import helpme_AhnD.ver02.service.BGM;
import helpme_AhnD.ver02.components.DeathNote;
import helpme_AhnD.ver02.components.DeathNoteDown;
import helpme_AhnD.ver02.components.DeathNoteLeft;
import helpme_AhnD.ver02.components.DeathNoteRight;
import helpme_AhnD.ver02.components.DeathNoteUp;
import helpme_AhnD.ver02.components.ItemBox;
import helpme_AhnD.ver02.components.ItemBox_kh;
import helpme_AhnD.ver02.service.BGMService;
import helpme_AhnD.ver02.service.DeathNotePlayerService;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.service.PlayerService_js;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class DeathNoteFrame extends JFrame {
	
	// 게임 종료시 최종적으로 게임선택화면으로 돌아가기 위해 필요함
	GameSelectFrame gameSelectFrame;
	
	DeathNoteFrame deathNoteFrame;
	
	// DropNote 게임을 관리하는 서비스 클래스 (플레이어 위치로 나눔)
	DeathNotePlayerService leftPlayerService;
	DeathNotePlayerService rightPlayerService;
	
	JLabel background;
	
	DeathNote deathNote;
//	DeathNoteLeft deathNoteLeft;
//	DeathNoteRight deathNoteRight;
//	DeathNoteUp deathNoteUp;
//	DeathNoteDown deathNoteDown;
	BGM bgm;
	AhnCharacter ahnCharacter;

	ItemBox_kh itemBox;
	private static boolean Running;

	public DeathNoteFrame(GameSelectFrame gameSelectFrame) {
		this.gameSelectFrame = gameSelectFrame;
		deathNoteFrame = this;
		initData();
		setInitLayout();
	}

	private void initData() {
		background = new JLabel(new ImageIcon(Define.IMG_DROPNOTE_BG));

		Running = true;
		setTitle("DeathNote");
		setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		leftPlayerService = new DeathNotePlayerService(this, Player.LEFTPLAYER);
		rightPlayerService = new DeathNotePlayerService(this, Player.RIGHTPLAYER);
		itemBox = new ItemBox_kh(this);
		ahnCharacter = new AhnCharacter(this, leftPlayerService, Player.LEFTPLAYER);
		ahnCharacter = new AhnCharacter(this, rightPlayerService, Player.RIGHTPLAYER);
		bgm = gameSelectFrame.getmContext().getBgmService().createBGM();
		bgm.getClip().start();
	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}
	
	// getter setter
	public boolean isRunning() {
		return Running;
	}

	public static void setRunning(boolean running) {
		Running = running;
	}

	public BGM getBgm() {
		return bgm;
	}

	public DeathNotePlayerService getLeftPlayerService() {
		return leftPlayerService;
	}

	public DeathNotePlayerService getRightPlayerService() {
		return rightPlayerService;
	}
	
}
