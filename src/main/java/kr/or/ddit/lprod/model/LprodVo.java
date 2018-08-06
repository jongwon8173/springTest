package kr.or.ddit.lprod.model;

public class LprodVo {
	// 상품대분류 테이블 
	private int lprod_id; 		// 상품순번
	private String lprod_gu;	// 상품분류코드
	private String lprod_nm;	// 상품분류이름
	
	
	public LprodVo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LprodVo(int lprod_id, String lprod_gu, String lprod_nm) {
		super();
		this.lprod_id = lprod_id;
		this.lprod_gu = lprod_gu;
		this.lprod_nm = lprod_nm;
	}
	

	public int getLprod_id() {
		return lprod_id;
	}


	public void setLprod_id(int lprod_id) {
		this.lprod_id = lprod_id;
	}


	public String getLprod_gu() {
		return lprod_gu;
	}


	public void setLprod_gu(String lprod_gu) {
		this.lprod_gu = lprod_gu;
	}


	public String getLprod_nm() {
		return lprod_nm;
	}


	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}



	@Override
	public String toString() {
		return "LprodVo [lprod_id=" + lprod_id + ", lprod_gu=" + lprod_gu
				+ ", lprod_nm=" + lprod_nm + "]";
	}

	

}
