package org.javaturk.wap.jsp.ch05;

public class CompoundInterestBean {
    private double interestRate;
    private int years;
    private double principal;
    private int compounds;

    public CompoundInterestBean() {
        this(12);
    }

    public CompoundInterestBean(int compounds) {
        this.compounds = compounds;
        interestRate = -1;
        years = -1;
        principal = -1;
    }

    /*
      FV = Principal(1 + i/12)^(12 * years)
      assuming 12 compounding periods per year
    */
    public double getFutureValue() {
        if ((compounds != -1) && (interestRate != -1) && (years != -1))
            return principal * Math.pow(1 + interestRate / compounds, years * 12);
        else
            throw new RuntimeException("Bean requires configuration!");
    }

    public void setInterestRate(double rate) {
        if (rate > 0)
            this.interestRate = rate;
        else
            this.interestRate = 0;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setYears(int years) {
        if (years >= 1)
            this.years = years;
        else
            this.years = 1;
    }

    public int getYears() {
        return years;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getPrincipal() {
        return principal;
    }
}
