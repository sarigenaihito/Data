package mvc;

import java.util.ArrayList;

public class Control {
	private ArrayList<Goods> goods = new ArrayList<Goods>();
	private ArrayList<Maker> maker = new ArrayList<Maker>();
	private ArrayList<Goods> arrivalGoods = new ArrayList<Goods>();

	private int newGid;
	private int newMid;

	/**
	 * 画面を呼び出す。
	 */
	public void firstDisplay() {
		goods.add(new Goods(0,"ぽっきー",140,0,3));
		goods.add(new Goods(1,"ハイチュウ", 150,1,5));
		goods.add(new Goods(2,"便器",200,1,5));

		maker.add(new Maker(0,"明治","電話番号なんてなかった","どっか"));
		maker.add(new Maker(1,"森永","電話番号ってなに？","日本のどこか"));
		maker.add(new Maker(2,"TOTO","俺が電話番号だ！","あなたの後ろ"));

		newGid = goods.size() - 1;
		newMid = maker.size() - 1;

		View v = new View();
		v.arrivalGoodsView();

	}

	public boolean checkGoodsId(int goodsId) {
		boolean f = false;
		int gId = 0;
		for (int i = 0; i < goods.size(); i++) {
			Goods item = goods.get(i);
			gId = item.getGoodsId();
			if (gId == goodsId) {
				f = true;
			}
		}
		return f;
	}

	public boolean checkMakerId(int makerId) {
		int mId = 0;
		boolean f = false;
		for (int i = 0; i < maker.size(); i++) {
			Maker m = maker.get(i);
			mId = m.getMakerId();
			if (mId == makerId) {
				f = true;
			}
		}
		return f;
	}

	public int newGoodsIdAssignment() {
		newGid += 1;
		return newGid;
	}

	public int newMakerIdAssignment() {
		newMid += 1;
		return newMid;
	}

	public void arrivalGoodsIn(Goods g) {
		arrivalGoods.add(g);
	}

	public ArrayList<Goods> getArraivalGoods() {
		return arrivalGoods;
	}

	public void insertMaker(Maker m) {
		maker.add(m);
	}

	public void setGoods() {
		boolean f = false;
		for(Goods items : arrivalGoods) {
			for (Goods afterItems : goods) {
				if (items.getGoodsId() == afterItems.getGoodsId()) {
					afterItems.setStock(items.getStock());
					f = true;
					break;
				}
			}

			if(f == false) {
				goods.add(items);
			} else {
				f = false;
			}
		}
	}
}
