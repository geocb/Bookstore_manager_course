package com.geovanna.bookstoremanager.dto;

import lombok.Data;

@Data
public class MessageResponseDTO {

    private String message;

    MessageResponseDTO(String message) {
        this.message = message;
    }

    public static MessageResponseDTOBuilder builder() {
        return new MessageResponseDTOBuilder();
    }

    public static class MessageResponseDTOBuilder {
        private String message;

        MessageResponseDTOBuilder() {
        }

        public MessageResponseDTOBuilder message(String message) {
            this.message = message;
            return this;
        }

        public MessageResponseDTO build() {
            return new MessageResponseDTO(message);
        }

        public String toString() {
            return "MessageResponseDTO.MessageResponseDTOBuilder(message=" + this.message + ")";
        }
    }
}
