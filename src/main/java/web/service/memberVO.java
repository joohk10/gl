package web.service;

public class memberVO {
	
	private String seq = "";
	private String id = "";
	private String pw = "";
	private String name = "";
	private String birth = "";
	private String num = "";
	private String mlevel = "";
	private String sex = "";
	private String hobby = "";
	private String intro = "";
	private String area = "";
	private String filen = "";
	private String sel = "";
	private String search="";
	
	public void setSel(String sel) {
		this.sel = sel;
	}
	
	public void setSearch(String search) {
		this.search = search;
	}
	
	public String getSel() {
		return sel;
	}
	
	public String getsearch() {
		return search;
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getnum()	{
		return num;
	}
	public void setnum(String num){
		this.num = num;
	}
	public String getMlevel() {
		return mlevel;
	}
	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}
	public String getsex() {
		return sex;
	}
	public void setsex(String sex) {
		this.sex = sex;
	}
	public String gethobby() {
		return hobby;
	}
	public void sethobby(String hobby) {
		this.hobby = hobby;
	}
	public String getintro() {
		return intro;
	}
	public void setintro(String intro) {
		this.intro = intro;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFilen() {
		return filen;
	}
	public void setFilen(String filen) {
		this.filen = filen;
	}
}
