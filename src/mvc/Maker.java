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
		this.setMakerId(makerId);
		this.setMakerName(makerName);
		this.setTel(tel);
		this.setAddress(address);

	}

	public int getMakerId() {
		return this.makerId;
	}

	public void setMakerId(int makerId) {
		this.makerId = makerId;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}




}