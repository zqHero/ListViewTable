package com.example.listviewtable;

public class Goods {
	private String id;
	private String goodsName;
	private String codeBar;
	private float num;
	private float curPrice;
	private float money;
	
	public Goods() {
		super();
	}

	public Goods(String id, String goodsName, String codeBar, float num,
			float curPrice, float money) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.codeBar = codeBar;
		this.num = num;
		this.curPrice = curPrice;
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getCodeBar() {
		return codeBar;
	}

	public void setCodeBar(String codeBar) {
		this.codeBar = codeBar;
	}

	public float getNum() {
		return num;
	}

	public void setNum(float num) {
		this.num = num;
	}

	public float getCurPrice() {
		return curPrice;
	}

	public void setCurPrice(float curPrice) {
		this.curPrice = curPrice;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
	
	
		
}
