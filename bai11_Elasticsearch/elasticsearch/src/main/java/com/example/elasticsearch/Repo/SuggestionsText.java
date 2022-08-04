package com.example.elasticsearch.Repo;

import com.example.elasticsearch.Config.Config;
import com.example.elasticsearch.Model.SearchField;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.SuggestionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
@Scope("prototype")
public class SuggestionsText {

    @Autowired
    private Config config;
    public List<String> getSuggest(String input) throws IOException {

        RestHighLevelClient client = config.elasticsearchClient();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SuggestionBuilder termSuggestionBuilder = SuggestBuilders.completionSuggestion(SearchField.FIELD_NAME).text(input).skipDuplicates( true ).size(10);

        SuggestBuilder suggestBuilder = new SuggestBuilder();
        suggestBuilder.addSuggestion(SearchField.NAME_SUGGESTION, termSuggestionBuilder);

        searchSourceBuilder.suggest(suggestBuilder);

        SearchRequest searchRequest = new SearchRequest(SearchField.INDICES);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(searchResponse.getSuggest().iterator(), Spliterator.ORDERED), false)
                .flatMap(suggestion -> suggestion.getEntries().get(0).getOptions().stream())
                .map((Suggest.Suggestion.Entry.Option option) -> option.getText().toString())
                .collect(Collectors.toList());
    }
}
