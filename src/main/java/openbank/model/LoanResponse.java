package openbank.model;

import java.util.ArrayList;

public class LoanResponse {
    private Loan loan;
    private ArrayList<Loan> loans;
    private Exception error;
    public LoanResponse() {
    }
    public LoanResponse(Loan loan) {
        this.loan = loan;
    }
    public LoanResponse(ArrayList<Loan> loans) {
        this.loans = loans;
    }
    public LoanResponse(Exception error) {
        this.error = error;
    }
    public Loan getLoan() {
        return loan;
    }
    public void setLoan(Loan loan) {
        this.loan = loan;
    }
    public ArrayList<Loan> getLoans() {
        return loans;
    }
    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }
    public Exception getError() {
        return error;
    }
    public void setError(Exception error) {
        this.error = error;
    }

    
    
}
