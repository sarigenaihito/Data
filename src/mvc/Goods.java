package mvc;

public class Goods {
	private int goodsId;
	private String goodsName;
	private int price;
	private int makerId;
	private int stock;

	/**
	 * コンストラクター
	 * @param goodsId
	 * @param goodsName
	 * @param price
	 * @param makerId
	 * @param stock
	 */

	public Goods(int goodsId, String goodsName, int price, int makerId, int stock){
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.price = price;
		this.makerId = makerId;
		this.stock = stock;
	}


	/**
	 * 商品IDを取得して取得した商品IDを返す
	 * @return 商品ID
	 * 	 */
	public int getGoodsId(){
		return this.goodsId;

	}

	/**
	 * 在庫を取得して取得した在庫を返す
	 * @return 在庫
	 */
	public int getStock(){
		return this.stock;


	}

	/**
	 * 在庫を設定する
	 * @param stock
	 */
	public void setStock(int stock){
		this.stock = stock;


	}

	//追加 getterメソッド


	/**
	 * 商品名を取得して取得した商品名を返す
	 * @return 商品名
	 */
	public String getgoodsName(){
		return this.goodsName;

	}


	/**
	 * 値段を取得して、取得した値段を返す
	 * @return 値段
	 */
	public int getPrice(){
		return this.price;
	}


	/**
	 * メーカーIDを取得し、取得したメーカーIDを返す
	 * @return メーカーID
	 */
	public int getmakerId(){
		return this.makerId;
	}

}

