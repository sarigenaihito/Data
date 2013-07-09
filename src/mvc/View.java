package mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class View {
	Control c = new Control();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void arrivalGoodsView() {
		try {
			System.out.print("商品コード\n>");
			String unko = br.readLine();
			int id;
			if (unko.length() == 0) {
				id = 99999999;
			} else {
				id = Integer.parseInt(unko);
			}
			boolean f = c.checkGoodsId(id);
			int stock;
			if (!f) {
				newGoodsInsertView();
			} else {
				System.out.print("数量\n>");
				stock = Integer.parseInt(br.readLine());
				Goods g = c.getGoods(id);
				String name = g.getgoodsName();
				int price = g.getPrice();
				int mId = g.getmakerId();

				c.arrivalGoodsIn(new Goods(id,name,price,mId,stock));
			}

		} catch (NumberFormatException e) {
			// TODO 自動生成された catch ブロック
			System.err.println("数値に変換できない値が入力されました。");
			System.exit(-1);

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void newGoodsInsertView() {
		System.out.println("未登録の商品です。商品情報を新規追加してください。");
		int id = c.newGoodsIdAssignment();
		try {
		System.out.print("商品の名前\n>");
		String name = br.readLine();

		System.out.print("商品の値段\n>");
		int price = Integer.parseInt(br.readLine());

		System.out.println("メーカーコード\n>");
		int mId = Integer.parseInt(br.readLine());
		boolean flag = c.checkMakerId(mId);

		if(!flag) {
			mId = newMakerInsertView();
			System.out.println("メーカー情報を登録しました。");
		}

		System.out.println("数量\n>");
		int stock = Integer.parseInt(br.readLine());

		c.arrivalGoodsIn(new Goods(id,name,price,mId,stock));

		} catch (NumberFormatException e) {
			System.err.println("数値に変換できない値が入力されました。");

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public int newMakerInsertView() {
		System.out.println("未登録のメーカーです。メーカーの情報を入力してください。");

		int mId = c.newMakerIdAssignment();
		try {
			System.out.print("メーカーの名前\n>");
			String name = br.readLine();

			System.out.print("メーカーの連絡先\n>");
			String tel = br.readLine();

			System.out.print("メーカーの住所\n>");
			String address = br.readLine();

			c.insertMaker(new Maker(mId,name,tel,address));

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return mId;
	}

	public void insertGoodsView() {
		ArrayList<Goods> goods = new ArrayList<Goods>();
		goods = c.getArraivalGoods();
		for (Goods g : goods) {
			System.out.println("商品ID：" + g.getGoodsId() + "\n商品名：" + g.getgoodsName() + "\n数量：" + g.getStock() + "\n");
		}
	}
}
