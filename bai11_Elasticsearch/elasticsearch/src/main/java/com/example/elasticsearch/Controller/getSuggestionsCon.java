package com.example.elasticsearch.Controller;

import com.example.elasticsearch.Repo.SuggestionsText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class getSuggestionsCon {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/find/{input}")
    public List<String> find(@PathVariable("input") String input) throws IOException {
        SuggestionsText suggestionsText = context.getBean(SuggestionsText.class);
        return  suggestionsText.getSuggest(input);
    }
}
