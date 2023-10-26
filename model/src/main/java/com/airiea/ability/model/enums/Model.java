package com.airiea.ability.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Model {
    OPEN_AI_GPT_3_5_TURBO("gpt-3.5-turbo"),
    OPEN_AI_GPT_3_5_TURBO_0613("gpt-3.5-turbo-0613"),
    OPEN_AI_GPT_3_5_TURBO_16K("gpt-3.5-turbo-16k"),
    OPEN_AI_GPT_3_5_TURBO_16K_0613("gpt-3.5-turbo-16k-0613"),
    OPEN_AI_GPT_4("gpt-4"),
    OPEN_AI_GPT_4_32K("gpt-4-32k"),
    OPEN_AI_GPT_4_0613("gpt-4-0613"),
    OPEN_AI_GPT_4_32K_0613("gpt-4-32k-0613"),
    OPEN_AI_TEXT_EMBEDDING_ADA_002("text-embedding-ada-002"),
    KNOWLEDGE_BASE_UPDATE("knowledge-base-write");
    private final String name;

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static Model fromString(String name) {
        for (Model model : Model.values()) {
            if (model.getName().equals(name)) {
                return model;
            }
        }
        throw new IllegalArgumentException("No enum found with name: " + name);
    }
}
