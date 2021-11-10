package fast_food.fast_food_be.service.security;



import fast_food.fast_food_be.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    //create by HauHP
    void saveAccount(Account account);

    //create by HauHP
    void editAccount(Account account);

    //create by HauHP
    void saveRoleForAccount(Long accountId, Long roleId);

    //create by HauHP
    List<Account> getAccountList();

    //khue
    Optional<Account> findByUserNames(String userName);

    void changePassWord(String newPassword,Long accountId);

    void changeStatus(int Status, Long accountId);

}
