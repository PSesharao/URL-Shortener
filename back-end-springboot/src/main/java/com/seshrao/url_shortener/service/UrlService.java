package com.seshrao.url_shortener.service;


import com.seshrao.url_shortener.model.Url;
import com.seshrao.url_shortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String getOriginlUrl(String id) {
        return urlRepository.findByShortUrl( id) ;
    }

    public Url generateShortUrl(String url) {
        return null ;
    }
}
