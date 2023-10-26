package com.airiea.ability.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ModelObject {
    OPEN_AI_EMBEDDING("embedding"),
    OPEN_AI_CHAT_COMPLETION("chat.completion"),
    OPEN_AI_COMPLETION("completion"),

    ANSWER_QUESTION("answer.question"),

    KNOWLEDGE_CONTENT_ENRICHMENT("knowledge.content.enrichment");
    private final String name;

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static ModelObject fromString(String name) {
        for (ModelObject modelObject : ModelObject.values()) {
            if (modelObject.getName().equals(name)) {
                return modelObject;
            }
        }
        throw new IllegalArgumentException("No enum found with name: " + name);
    }
}
