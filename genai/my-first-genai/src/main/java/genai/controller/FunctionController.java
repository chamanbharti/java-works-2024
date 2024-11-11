package genai.controller;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FunctionController {
    @Autowired
    private OllamaChatModel chatModel;

    @GetMapping

    public String prompts(@RequestParam(value = "message",
            defaultValue = "What is the weather in Delhi,India") String message){
        UserMessage userMessage = new UserMessage(message);
        ChatResponse response = chatModel.call(
                new Prompt(
                            List.of(userMessage),
                            OllamaOptions.builder()
                            .withFunction("getWeather")
                            .build()
                          )
        );
        return response.getResult().getOutput().getContent();
    }
}
