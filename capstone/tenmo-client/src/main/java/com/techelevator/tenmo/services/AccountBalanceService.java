package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AccountBalance;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class AccountBalanceService {

    private static String BASE_URL = "http://localhost:8080";
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }


    public AccountBalance getBalance (String user) {
        AccountBalance accountBalance = null;
        try {
            ResponseEntity<AccountBalance> response =
                    restTemplate.exchange(BASE_URL + "/account" + user,
                            HttpMethod.GET, makeAuthEntity(), AccountBalance.class);
            accountBalance = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return accountBalance;
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }


}












