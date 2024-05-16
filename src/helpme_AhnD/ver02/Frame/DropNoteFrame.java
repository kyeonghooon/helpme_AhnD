package helpme_AhnD.ver02.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.components.ItemBox;
import helpme_AhnD.ver02.components.NoteBar;
import helpme_AhnD.ver02.service.BGM;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.utils.Define;

public class DropNoteFrame extends JFrame {
	
	// 게임 종료시 최종적으로 게임선택화면으로 돌아가기 위해 필요함
	GameSelectFrame gameSelectFrame;
	
	JLabel background;
	DropNotePlayerService dropNotePlayerService1;
	DropNotePlayerService dropNotePlayerService2;
	NoteBar noteBarLeft;
	NoteBar noteBarRight;
	BGM bgm;
	
	ItemBox itembox;
	private static boolean Running;

	public DropNoteFrame(GameSelectFrame gameSelectFrame) {
		this.gameSelectFrame = gameSelectFrame;
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		// todo 각종 라벨 추가 예정
		background = new JLabel(new ImageIcon(Define.IMG_DROPNOTE_BG));
		
		Running = true;
		setTitle("DropNote");
		setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		noteBarLeft = new NoteBar(this, 1);
		noteBarRight = new NoteBar(this, 2);
		dropNotePlayerService1 = new DropNotePlayerService(this, 1);
		dropNotePlayerService2 = new DropNotePlayerService(this, 2);
		new Thread(dropNotePlayerService1).start();
		new Thread(dropNotePlayerService2).start();
		itembox = new ItemBox(this);
		bgm = gameSelectFrame.getmContext().getBgmService().createBGM();
		bgm.getClip().start();
	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setResizable(false);
		setVisible(true);

		// todo 각종 컴포넌트 add
	}

	private void addEventListener() {
		
	}

	
	// getter setter
	public static boolean isRunning() {
		return Running;
	}
	
	public static void setRunning(boolean running) {
		Running = running;
	}
	
}