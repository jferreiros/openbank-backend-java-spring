package openbank.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import openbank.database.LoanManager;
import openbank.model.Loan;
import openbank.model.LoanResponse;

@CrossOrigin(origins = "*")
@RestController
public class LoanController {
    static LoanManager loanManager;

    public LoanController() {
        loanManager = new LoanManager();
    }

    @GetMapping("/loans")
    public List<Loan> getLoans() {
        System.out.println("/managers");
        try {
            return loanManager.read();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/loans/{id}")
    public Loan getLoanById(@PathVariable int id) {
        try {
            return loanManager.read(id);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/loans")
    public LoanResponse postLoan(@RequestBody Loan loan) {
        try {
            return new LoanResponse(loanManager.create(loan));
        } catch (Exception exception) {
            return new LoanResponse(exception);
        }
    }

    @PutMapping("/loans")
    public LoanResponse putLoan(@RequestBody Loan loan) {
        try {
            return new LoanResponse(loanManager.update(loan));
        } catch (Exception exception) {
            return new LoanResponse(exception);
        }
    }

    @DeleteMapping("/loans")
    public LoanResponse deleteGestores(@RequestBody Loan loan) {
        try {
            return new LoanResponse(loanManager.delete(loan));
        } catch (Exception exception) {
            return new LoanResponse(exception);
        }
    }
}
