package genai.controller;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.Media;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class OllamaChatController {

    private OllamaChatModel chatModel;
    private static final String PROMPT = "What is java language";
    public OllamaChatController(OllamaChatModel chatModel){
        this.chatModel = chatModel;
    }

    @GetMapping("/prompt")
    public String promptResponse(@RequestParam("prompt") String prompt){
        String response = chatModel.call(prompt);
        return response;
    }
    @GetMapping("/prompt2")
    public Flux<String> promptResponseFlux(@RequestParam String prompt){
        Flux<String> response = chatModel.stream(prompt);
        return response;
    }
    @GetMapping("/prompt3")
    public Flux<ChatResponse> promptResponseFluxWithChatResponse(@RequestParam String prompt){
        Prompt promptOb = new Prompt(prompt);
        Flux<ChatResponse> response = chatModel.stream(promptOb



        );
        return response;
    }
    @GetMapping("/prompt4")
    public ChatResponse chatResponse(){
        ChatResponse response = chatModel.call(
                new Prompt(
                        "Generate the names of 5 famous pirates.",
                        OllamaOptions.builder()
                                .withModel(OllamaModel.MISTRAL)
                                .withTemperature(0.4)
                                .build()
                ));
        return response;
    }
    @GetMapping("/generate")
    public Map<String,String> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("generation", this.chatModel.call(message));
    }

    @GetMapping("/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return this.chatModel.stream(prompt);
    }

}
