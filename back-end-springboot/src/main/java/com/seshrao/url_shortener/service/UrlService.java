package com.seshrao.url_shortener.service;


import com.seshrao.url_shortener.exception.InvalidUrlException;
import com.seshrao.url_shortener.model.Url;
import com.seshrao.url_shortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.seshrao.url_shortener.logic.GenerateShortUrl.getShortUrl;
import static com.seshrao.url_shortener.logic.GenerateShortUrl.isUrlValid;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String getOriginlUrl(String id) {
        return urlRepository.findByShortUrl( id) ;
    }

    public Url generateShortUrl(String url) {
        if(! isUrlValid(url)) {
            System.out.println("URL is not valid");
            throw new InvalidUrlException("URL is not valid: " + url);
            // return null;
        }

        Url existingUrl = urlRepository.findByOriginalurl(url);
        if (existingUrl != null) {
            return existingUrl; // Return the existing short URL if the long URL already exists
        }

        Url urlObject = new Url();
        urlObject.setOriginalurl(url);
        urlObject.setShorturl(getShortUrl(url));

        return urlRepository.save(urlObject);
    }
}
