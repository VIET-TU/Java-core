package model;

public class MiniCalculatorModel {
	private double fistValue;
	private double secondValue;
	private double answer;
	
	public MiniCalculatorModel() {
	}

	/**
	 * @return the fistValue
	 */
	public double getFistValue() {
		return fistValue;
	}

	/**
	 * @param fistValue the fistValue to set
	 */
	public void setFistValue(double fistValue) {
		this.fistValue = fistValue;
	}

	/**
	 * @return the secondValue
	 */
	public double getSecondValue() {
		return secondValue;
	}

	/**
	 * @param secondValue the secondValue to set
	 */
	public void setSecondValue(double secondValue) {
		this.secondValue = secondValue;
	}

	/**
	 * @return the answer
	 */
	public double getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(double answer) {
		this.answer = answer;
	}
	
	public void plus() {
		this.answer = this.fistValue + this.secondValue ;
	}
	
	public void minus() {
		this.answer = this.fistValue - this.secondValue ;
	}
	public void mutiply() {
		this.answer = this.fistValue * this.secondValue ;
	}
	public void divide() {
		this.answer = this.fistValue / this.secondValue ;
	}
	public void pow() {
		this.answer = Math.pow(this.fistValue , this.secondValue) ;
	}
	public void mod() {
		this.answer = this.fistValue % this.secondValue ;
	}
	
	
}














