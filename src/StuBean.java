public class StuBean 
{
	private int roll;
	private String stuName,fName,collName;
	private double hindi,eng,maths,science,sst;
	public double per,tot;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getCollName() {
		return collName;
	}
	public void setCollName(String collName) {
		this.collName = collName;
	}
	public double getHindi() {
		return hindi;
	}
	public void setHindi(double hindi) {
		this.hindi = hindi;
	}
	public double getEng() {
		return eng;
	}
	public void setEng(double eng) {
		this.eng = eng;
	}
	public double getMaths() {
		return maths;
	}
	public void setMaths(double maths) {
		this.maths = maths;
	}
	public double getScience() {
		return science;
	}
	public void setScience(double science) {
		this.science = science;
	}
	public double getSst() {
		return sst;
	}
	public void setSst(double sst) {
		this.sst = sst;
	}
	public double getTotal()
	{
		this.tot=(hindi+eng+maths+science+sst);
		return this.tot;
	}
	public double getPercentage()
	{
		this.per=tot/5;
		return this.per;
	}
	public String getDivision()
	{
		if(this.per>=60)
			return " First";
		else if(this.per>=50)
			return " Second";
		else if(this.per>=40)
			return " Third";
		else
			return " Failed";
	}
	}

