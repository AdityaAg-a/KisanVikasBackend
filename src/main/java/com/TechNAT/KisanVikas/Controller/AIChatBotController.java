package com.TechNAT.KisanVikas.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechNAT.KisanVikas.DAO.ChatBotResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/chatbot")
public class AIChatBotController {

	@PostMapping("/reply")
	public String SendRespone(@RequestBody String str) {
		String text = "View style={{flex:1,justifyContent:'center',backgroundColor:'#E9E7D2',paddingTop:5}}>\r\n"
				+ "             <View style={{flex: 1,marginBottom:20}}>\r\n"
				+ "            <FlatList\r\n"
				+ "                data={chatmssg}\r\n"
				+ "                ref={flatListRef}\r\n"
				+ "                renderItem={({ item ";
        String sender = "server";
        System.out.println(str);
        ObjectMapper mapper = new ObjectMapper();
        String replyJson = null;
        try {
            replyJson = mapper.writeValueAsString(new ChatBotResponse(text, sender));
        } catch (Exception e) {
            // Handle JSON serialization exception
            e.printStackTrace();
        }
		return replyJson;
	}
}
