package com.project.dto;

public class MessageDTO {

    private MessageDTOType type;
    String text;

    public MessageDTO(MessageDTOType type, String text) {
        this.type = type;
        this.text = text;
    }

    public MessageDTO() {

    }

    public MessageDTOType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public enum MessageDTOType {
        INFO("alert alert-info"),
        ERROR("alert alert-warning"),
        WARN("alert alert-danger"),
        SUCCESS("alert alert-success");

        private String cssClass;

        MessageDTOType(String cssClass) {
            this.cssClass = cssClass;
        }

        @Override
        public String toString() {
            return this.cssClass;
        }
    }
}
