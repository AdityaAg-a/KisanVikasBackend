package com.TechNAT.KisanVikas.DAO;

public class ChatBotResponse {
	private String text;
    private String sender;

    public ChatBotResponse(String text, String sender) {
        this.text = text;
        this.sender = sender;
    }

    // Getters and setters (optional)

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
