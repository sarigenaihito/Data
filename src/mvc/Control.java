package mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 商品登録システムの主な機能を実装したクラス。
 * @author 2年高度情報技術科7番の人
 *
 */
public class Control {
	private ArrayList<Goods> goods = new ArrayList<Goods>();
	private ArrayList<Maker> maker = new ArrayList<Maker>();
	private ArrayList<Goods> arrivalGoods = new ArrayList<Goods>();

	private int newGid;
	private int newMid;

	/**
	 * コンストラクタ
	 */
	public Control() {
		super();
		goods.add(new Goods(0,"ぽっきー",140,0,3));
		goods.add(new Goods(1,"ハイチュウ", 150,1,5));
		goods.add(new Goods(2,"便器",200,1,5));

		maker.add(new Maker(0,"明治","000-111-1111","日本"));
		maker.add(new Maker(1,"森永","000-111-2222","日本"));
		maker.add(new Maker(2,"TOTO","0120-117-9193","ニッポン"));

		newGid = goods.size() - 1;
		newMid = maker.size() - 1;
	}

	/**
	 * 最初に表示する画面を呼びだして、処理を進めていく。
	 */
	public void firstDisplay() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		View v = new View();
		boolean flag = true;
		insert :
			while(flag) {
				v.arrivalGoodsView();
				try {
					System.out.print("まだ入力しますン？(y/n)\n>");
					String judg = br.readLine();
					if (judg.equals("y")) {
						continue insert;
					}

				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				v.insertGoodsView();
				try {
					System.out.print("これで登録しますか？(y/n)\n>");
					String f = br.readLine();
					if (f.equals("y")) {
						setGoods();
						System.out.println("登録しました。システムを終了します。");
						break insert;
					} else {
						System.out.println("登録を中止し、再度入力を開始します。");
						flag = true;
						for (int idx = 0; idx < arrivalGoods.size(); idx++) {
							arrivalGoods.remove(idx);
						}
						continue insert;
					}
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
	}

	/**
	 * 商品がすでに登録されているかどうかを調べる。
	 * @param goodsId
	 * @return f
	 */
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

	/**
	 * メーカー情報が既に登録されているか調べる。
	 * @param makerId
	 * @return f
	 */
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

	/**
	 * 新しい商品コードを作成する。
	 * @return 新しい商品コード
	 */
	public int newGoodsIdAssignment() {
		newGid += 1;
		return newGid;
	}

	/**
	 * 新しいメーカーコードを作成する。
	 * @return 新しいメーカーコード
	 */
	public int newMakerIdAssignment() {
		newMid += 1;
		return newMid;
	}

	/**
	 * 入荷商品の情報を、一時的な保管場所に入れる。
	 * @param g
	 */

	public void arrivalGoodsIn(Goods g) {
		arrivalGoods.add(g);
	}

	/**
	 * 登録する前の入荷商品の情報を返す。
	 * @return 登録する前の入荷商品情報
	 */
	public ArrayList<Goods> getArraivalGoods() {
		return arrivalGoods;
	}

	/**
	 *
	 * @param idx
	 * @return goods配列の中身を取得する。
	 */
	public Goods getGoods(int idx) {
		return goods.get(idx);
	}

	/**
	 * メーカー情報を保存する。
	 * @param m
	 */
	public void insertMaker(Maker m) {
		maker.add(m);
	}

	/**
	 * 商品情報の本登録をする。
	 */
	public void setGoods() {
		boolean f = false;
		for(Goods items : arrivalGoods) {
			for (Goods afterItems : goods) {
				//すでに登録されている商品だったら、数量の更新をする。
				//そうでないときは、新しい商品の情報を登録する。
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
