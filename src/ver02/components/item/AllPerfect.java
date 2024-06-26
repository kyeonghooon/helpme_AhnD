package ver02.components.item;

import javax.swing.ImageIcon;

import ver02.interfaces.Useable;
import ver02.service.DropNote_2P_PlayerService;
import ver02.utils.Define;

public class AllPerfect extends Items implements Useable {
	
	
	private ImageIcon itemAllPerfect;
	
	public AllPerfect() {
		initData();
		setInitLayout();
	}

	private void initData() {
		itemAllPerfect = new ImageIcon(Define.IMG_ITEMS_ALLPERFECT);
		buffType = Items.BUFF;
		durationType = Items.DURATION;
	}

	private void setInitLayout() {
		setIcon(itemAllPerfect);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
	}

	// todo 전부 퍼펙트
	@Override
	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
		dropNotePlayerService.getScoreService().setNeverPerfect(true);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.getScoreService().setNeverPerfect(false);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
