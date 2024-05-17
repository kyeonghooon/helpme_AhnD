package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.service.DropNotePlayerService_hj;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class HpBox_hj extends JLabel {

	DropNotePlayerService_hj playerService;
	private Player player;
	
	private final int FIRST_HEART = 1;
	private final int SECOND_HEART = 2;
	private final int THIRD_HEART = 3;
	private int x;
	private int y = 180;

	private ImageIcon hpFull;
	private ImageIcon hpHalf;

	public HpBox_hj(DropNotePlayerService_hj playerService, Player player) {
		this.playerService = playerService;
		this.player = player;
		hpFull = new ImageIcon(Define.IMG_HP_HPFULL);
		hpHalf = new ImageIcon(Define.IMG_HP_HPHALF);
		new Thread(new Heart(FIRST_HEART)).start();
		new Thread(new Heart(SECOND_HEART)).start();
		new Thread(new Heart(THIRD_HEART)).start();
	}

	class Heart extends JLabel implements Runnable {

		private int order;

		public Heart(int order) {
			this.order = order;
			initData();
			setInitLayout();
		}

		public void initData() {
			// 플레이어당 하트 3개 위치 지정
			switch (order) {
			case FIRST_HEART:
				if (player == Player.LEFTPLAYER) {
					x = 650;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1125;
				}
				break;
			case SECOND_HEART:
				if (player == Player.LEFTPLAYER) {
					x = 700;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1075;
				}
				break;
			case THIRD_HEART:
				if (player == Player.LEFTPLAYER) {
					x = 750;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1025;
				}
				break;
			default:
				break;
			}
		}

		public void setInitLayout() {
			setIcon(hpFull);
			setSize(50, 50);
			setLocation(x, y);
			playerService.getmContext().add(this);
		}

		@Override
		public void run() {
			while (DropNoteFrame.isRunning()) {
				// 체력 감소에 따른 하트 변화
				switch (order) {
				case FIRST_HEART:
					if (playerService.getScoreService().getHp() >= Define.HP_1_0_HEART) {
						setIcon(hpFull);
					} else if (playerService.getScoreService().getHp() >= Define.HP_0_5_HEART) {
						setIcon(hpHalf);
					} else {
						setIcon(null);
					}
					break;
				case SECOND_HEART:
					if (playerService.getScoreService().getHp() >= Define.HP_2_0_HEART) {
						setIcon(hpFull);
					} else if (playerService.getScoreService().getHp() >= Define.HP_1_5_HEART) {
						setIcon(hpHalf);
					} else {
						setIcon(null);
					}
					break;
				case THIRD_HEART:
					if (playerService.getScoreService().getHp() >= Define.HP_3_0_HEART) {
						setIcon(hpFull);
					} else if (playerService.getScoreService().getHp() >= Define.HP_2_5_HEART) {
						setIcon(hpHalf);
					} else {
						setIcon(null);
					}
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				default:
					break;
				}

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
