package entity;

public class NgmcBrand {
	private int brd_id;
	private int man_id;
	private String name_en;
	private String name_cn;
	private char sts_cd;
	public NgmcBrand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NgmcBrand(int brd_id, int man_id, String name_en, String name_cn, char sts_cd) {
		super();
		this.brd_id = brd_id;
		this.man_id = man_id;
		this.name_en = name_en;
		this.name_cn = name_cn;
		this.sts_cd = sts_cd;
	}
	public int getBrd_id() {
		return brd_id;
	}
	public void setBrd_id(int brd_id) {
		this.brd_id = brd_id;
	}
	public int getMan_id() {
		return man_id;
	}
	public void setMan_id(int man_id) {
		this.man_id = man_id;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public String getName_cn() {
		return name_cn;
	}
	public void setName_cn(String name_cn) {
		this.name_cn = name_cn;
	}
	public char getSts_cd() {
		return sts_cd;
	}
	public void setSts_cd(char sts_cd) {
		this.sts_cd = sts_cd;
	}
	
	
}
