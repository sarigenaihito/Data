package mvc;

public class Maker {


	private int makerId;
	private String makerName;
	private String tel;
	private String address;

	/**
	 * コンストラクター
	 * 各パラメーターにそれぞれの値を入れる
	 *
	 @param makerId   メーカーコード
	 @param makerName メーカー名
	 @param tell      連絡先
	 @param address   住所
	 */
	public Maker(int makerId, String makerName, String tel, String address){
		this.makerId = makerId;
		this.makerName = makerName;
		this.tel = tel;
		this.address = address;

	}

	// メーカーコード(int)を取り出す
	public int getMakerId() {
		return this.makerId;
	}

	// メーカーコードに値(int)を入れる
	public void setMakerId(int makerId) {
		this.makerId = makerId;
	}

	// メーカー名(String)を取り出す
	public String getMakerName() {
		return this.makerName;
	}

	// メーカー名に値(String)を入れる
	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	// 連絡先(String)を取り出す
	public String getTel() {
		return this.tel;
	}

	// 連絡先に値(String)を入れる
	public void setTel(String tel) {
		this.tel = tel;
	}

	// 住所(String)を取り出す
	public String getAddress() {
		return this.address;
	}

	// 住所に値(String)を入れる
	public void setAddress(String address) {
		this.address = address;
	}
}