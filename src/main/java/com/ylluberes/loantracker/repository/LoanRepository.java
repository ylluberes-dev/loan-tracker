package com.ylluberes.loantracker.repository;

import com.ylluberes.loantracker.domain.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends MongoRepository<Loan, String> {


}
