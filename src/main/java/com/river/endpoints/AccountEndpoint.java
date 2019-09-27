package com.river.endpoints;

import com.river.services.AccountService;
import com.river.webservices.Account;
import com.river.webservices.accountservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

/**
 * The class CreateAccount service
 */
@Endpoint
public class AccountEndpoint {

    private static final String TARGET_NAMESPACE = "http://com/river/webservices/accountservice";

    @Autowired
    private AccountService accountService;

    /**
     * Gets the account details.
     *
     *
     * @return the account details
     */



    @PayloadRoot(localPart = "getAccountRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload
    GetAccountResponse getAccountDetails(@RequestPayload GetAccountRequest request)
    {
        GetAccountResponse response = new GetAccountResponse();
        Account account = accountService.getAccount(request.getAccountId());
        response.setAccount(account);
        return response;
    }
    @PayloadRoot(localPart = "getAllAccountRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload
    GetAllAccountResponse getAllAccount(@RequestPayload GetAllAccountRequest request)
    {
        GetAllAccountResponse response = new GetAllAccountResponse();
        List<Account> accounts  = accountService.getAllAccount();
        response.getAccount().addAll(accounts);
        return response;
    }

    @PayloadRoot(localPart = "addAccountRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload
    AddAccountResponse addAccount(@RequestPayload AddAccountRequest request)
    {
        AddAccountResponse response = new AddAccountResponse();
        Account account = new Account();
        account.setAccountName(request.getAccountName());
        accountService.addAccount(account);
        response.setAccount(account);
        return response;
    }

    @PayloadRoot(localPart = "updateAccountRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload
    UpdateAccountResponse updateAccount(@RequestPayload UpdateAccountRequest request)
    {
        UpdateAccountResponse response = new UpdateAccountResponse();
        Account account = new Account();
        account.setAccountId(request.getAccountId());
        account.setAccountName(request.getAccountName());
        accountService.addAccount(account);
        response.setAccount(account);
        return response;
    }

    @PayloadRoot(localPart = "deleteAccountRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload
    DeleteStudentResponse deleteAccount(@RequestPayload DeleteAccountRequest request)
    {
        DeleteStudentResponse response = new DeleteStudentResponse();
        accountService.deleteAccount(request.getAccountId());
        return response;
    }
}