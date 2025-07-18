package com.lihui.langchain4j_ai_demo.aiservice;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

@AiService(
//        wiringMode = AiServiceWiringMode.EXPLICIT,//手动装配
        chatModel = "openAiChatModel",
        streamingChatModel = "openAiStreamingChatModel",
        //chatMemory = "chatMemory",//配置会话记忆对象
        chatMemoryProvider = "chatMemoryProvider",  //配置会话记忆提供者对象
        contentRetriever = "contentRetriever",//配置向量数据库检索对象
        tools = "reservationTool"
)
//@AiService
public interface ConsultantService {
    //用于聊天的方法
    //public String chat(String message);
//    @SystemMessage("")
//    @SystemMessage(fromResource = "system.txt")
//@UserMessage("你是一只小猪{{it}}" )
//@UserMessage("你是一只小猪{{msg}}" )
// public Flux<String> chat(@V("msg") String message);
    public Flux<String> chat(@MemoryId String memoryId, @UserMessage String message);
}
