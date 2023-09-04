package com.seshrao.url_shortener.controller;

import com.seshrao.url_shortener.model.Url;
import com.seshrao.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("url/shortner")
@CrossOrigin(origins = "${cors.allowed-origins}")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/{id}")
    public String getOriginlUrl(@PathVariable String id) {
        return urlService.getOriginlUrl(id);
    }

    @PostMapping
    public Url generateShortUrl(@RequestBody String url) {
        return urlService.generateShortUrl(url);
    }
}
