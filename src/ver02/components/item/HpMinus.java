package ver02.components.item;

import javax.swing.ImageIcon;

import ver02.interfaces.Useable;
import ver02.service.DropNote_2P_PlayerService;
import ver02.utils.Define;

public class HpMinus extends Items implements Useable{

	private ImageIcon hpMinus; // 체력 -10
	
	public HpMinus() {
		initData();
		setInitLayout();
	}

	private void initData() {
		hpMinus = new ImageIcon(Define.IMG_ITEMS_HP_MINUS);
		buffType = Items.DEBUFF;
		durationType = Items.IMMEDIATE;
	}
	
	private void setInitLayout() {
		setIcon(hpMinus);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
	}
	
	@Override
	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
		dropNotePlayerService.getScoreService().beAttacked();
		dropNotePlayerService.getScoreService().beAttacked();
	}

}
