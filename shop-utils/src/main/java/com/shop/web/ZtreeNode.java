package com.shop.web;

public class ZtreeNode {

	private int id;
	private int pId;
	private String name;
	private boolean open;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	@Override
	public String toString() {
		return "ZtreeNode [id=" + id + ", pId=" + pId + ", name=" + name + ", open=" + open + "]";
	}

}
