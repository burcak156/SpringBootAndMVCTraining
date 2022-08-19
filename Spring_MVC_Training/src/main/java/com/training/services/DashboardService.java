package com.training.services;

import com.sun.org.apache.xerces.internal.xs.XSTypeDefinition;
import com.training.props.Currency;
import com.training.props.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class DashboardService {

    public User[] allProduct() {
        String url = "https://jsonplaceholder.typicode.com/users";
        RestTemplate restTemplate = new RestTemplate();
        User[] users = restTemplate.getForObject(url, User[].class);
        for (User user : users) {
            System.out.println(user.getEmail());
        }
        return users;
    }

    public List<Currency> xml () {
        List<Currency> ls = new ArrayList<>();
        try {
            String url = "https://www.tcmb.gov.tr/kurlar/today.xml";
            String stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements = doc.getElementsByTag("Currency");
            for(Element item : elements) {
                String currencyName = item.getElementsByTag("CurrencyName").text();
                String forexBuying = item.getElementsByTag("forexBuying").text();
                String forexSelling = item.getElementsByTag("forexSelling").text();

                Currency currency = new Currency(currencyName,forexBuying,forexSelling);
                ls.add(currency);
            }
          //  System.out.println("ST DATA : "  + stData);
        }
        catch (Exception ex) {
            System.err.println("xml Err:" + ex);
        }
        return ls;
    }
}
