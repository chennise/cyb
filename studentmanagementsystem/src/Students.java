

public class Students {
    
	private int sid;
	private String xuehao;
	private String sname;
	private int score1;
	private int  score2;
	private int score3;
	private int score4;	
	public Students()
	{
		
	}
	public Students(int sid, String xuehao, String sname, int score1,
			int score2, int score3, int score4) {
		super();
		this.sid = sid;
		this.xuehao = xuehao;
		this.sname = sname;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
	}
	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}
	/**
	 * @return the xuehao
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * @param xuehao the xuehao to set
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}
	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	/**
	 * @return the score1
	 */
	public int getScore1() {
		return score1;
	}
	/**
	 * @param score1 the score1 to set
	 */
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	/**
	 * @return the score2
	 */
	public int getScore2() {
		return score2;
	}
	/**
	 * @param score2 the score2 to set
	 */
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	/**
	 * @return the score3
	 */
	public int getScore3() {
		return score3;
	}
	/**
	 * @param score3 the score3 to set
	 */
	public void setScore3(int score3) {
		this.score3 = score3;
	}
	/**
	 * @return the score4
	 */
	public int getScore4() {
		return score4;
	}
	/**
	 * @param score4 the score4 to set
	 */
	public void setScore4(int score4) {
		this.score4 = score4;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Students [学号=" + sid + ", 姓名=" + sname + ", 数据结构="
				+ score1 + ", 操作系统=" + score2 + ", 数值运算=" + score3
				+ ", 总成绩=" + score4   + "]";
	}
	
	

	
	
	
}
