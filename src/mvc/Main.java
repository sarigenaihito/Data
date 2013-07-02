package mvc;

public class Main {
	public static void main(String[]args) {
		Control c = new Control();

		c.firstDisplay();

		if (c.checkGoodsId(2)) {
			System.out.println("ある");
		} else {
			System.out.println("ない");
		}

		if(c.checkMakerId(2)) {
			System.out.println("ある");
		} else {
			System.out.println("ない");
		}

		int id = c.newGoodsIdAssignment();
		c.arrivalGoodsIn(new Goods(id,"なにか", 100, 2, 100));
		c.arrivalGoodsIn(new Goods(2, null, 0, 0, 50));

		c.setGoods();

		System.out.println("しゅーりょー");
	}
}
