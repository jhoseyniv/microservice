package com.example.bankmanagementservice.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class AccountService implements AccountRepository {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findAccountByAccountNo(String accountNo) {
        return accountRepository.findAccountByAccountNo(accountNo);
    }
    public boolean  checkExpireDate(long expdate){
        //biz logic must be implement...
        return  true;
    }
    public boolean  checkCVV(long cvv){
        //biz logic must be implement...
        return  true;
    }
    public  int allValidationCheck(Account acc){
        int errorcode=-1;
        if(acc !=null &&
                checkExpireDate(acc.getExpireDateCard()) &&
                        checkCVV(acc.getCvvCard()))

        return  0; // all things is ok...
        else // error type should be return
        return errorcode;
    }

    public int checkCardValidation(String cardNo) {
        Account acc= findAccountByCardNo(cardNo);
       int status = allValidationCheck(acc);
        return status;
    }

    @Override
    public Account findAccountByCardNo(String cardNo) {
       Account acc = accountRepository.findAccountByCardNo(cardNo);
       return acc;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public List<Account> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Account> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Account entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Account> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Account> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Account> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Account> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Account> S saveAndFlush(S entity) {
        return accountRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Account> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Account> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Account getOne(Long aLong) {
        return null;
    }

    @Override
    public Account getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Account> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Account> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Account> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Account, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
