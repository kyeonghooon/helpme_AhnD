package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.utils.Define;

public class ItemReverse extends Items implements Useable {

	private ImageIcon reverse; // 점수 2배

	public ItemReverse() {
		initData();
		setInitLayout();
	}

	private void initData() {
		reverse = new ImageIcon(Define.IMG_ITEMS_REVERSE);
	}

	private void setInitLayout() {
		setIcon(reverse);
		setSize(50, 50);
		setLocation(x, y);
	}
	

}
