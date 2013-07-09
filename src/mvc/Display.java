package mvc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Display {

	Control control = new Control();
	private int goodsId;
	private int stock;
	private String goodsName;
	private int price;
	private int makerId;
	private String makerName;
	private String tel;
	private String address;

	/**
	 * 入荷伝票を入力する画面を表示する
	 */
	public boolean arrivalGoodsView() {
		System.out.println("入荷伝票入力");
		System.out.println("商品コードを入力してください");
		goodsId = new BufferedReader(new InputStreamReader(System.in)).read();
		System.out.println("数量を入力してください");
		stock = new BufferedReader(new InputStreamReader(System.in)).read();

		return control.checkGoodsId(goodsId);
	}

	/**
	 * 新しい商品情報を入力する画面を表示する
	 */
	public boolean newGoodsInsertView() {
		goodsId = control.newGoodsIdAssignment();
		System.out.println("商品名を入力してください");
		goodsName = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("定価を入力してください");
		price = new BufferedReader(new InputStreamReader(System.in)).read();
		System.out.println("メーカー・コードを入力してください");
		makerId = new BufferedReader(new InputStreamReader(System.in)).readLine();

		return control.checkMakerId(makerId);
	}

	/**
	 * 新しいメーカー情報を表示する画面を表示する
	 */
	public void newMakerInsertView() {
		makerId = control.newMakerIdAssignment();
		System.out.println("会社名を入力してください");
		makerName = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("電話番号を入力してください");
		tel = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("住所を入力してください");
		address = new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

	/**
	 * 入力された商品の情報を表示する
	 */
	public boolean insertGoodsView() {
		System.out.println("入荷商品");
		System.out.println("商品ID：" + goodsId);
		System.out.println("数量：" + stock);
		System.out.println("商品名：" + goodsName);
		System.out.println("定価：" + goods.price());
		System.out.println("メーカーID：" + goods.makerId());
		System.out.println("メーカー名：" + maker.makerName());
		System.out.println("連絡先：" + maker.tel());
		System.out.println("住所：" + maker.address());
		System.out.println("登録しますか？（Y・N）");
		String ｊudgment = new BufferedReader(new InputStreamReader(System.in)).readLine();
		if(ｊudgment.equals("Y")) {
			return true;
		} else {
			return false;
		}
	}

	public int getGoodsId() {
		return goodsId;
	}

	public int getStock() {
		return stock;
	}

	public Goods getGoods() {
		return new Goods(goodsId, goodsName, price, makerId, stock);
	}

	public Maker getMaker() {
		return new Maker(makerId, makerName, tel, address);
	}
}
