package services;

import com.techelevator.tenmo.model.Account;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestAccountService implements AccountService{

    private static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Account getAccount(){
        return restTemplate.getForObject(API_BASE_URL, Account.class);
    }

}
