package com.mark_1.Mark_1.service;

import com.mark_1.Mark_1.models.ChatCompletionResponse;
import com.mark_1.Mark_1.requests.ChatCompletionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatResponseService {
    @Autowired
    RestTemplate restTemplate;
    public String getOpenAiResponse(String prompt){
        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest("gpt-3.5-turbo",prompt);

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions"
        ,chatCompletionRequest,ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }
}
