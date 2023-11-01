package com.airiea.ability.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"abilityName"})
public class AbilityDTO {
    @JsonProperty("ability_name")
    String abilityName;

    @JsonProperty("model")
    String model;

    @JsonProperty("model_object")
    String modelObject;

    @JsonProperty("max_tokens")
    Integer maxTokens;

    Double temperature;

    //Your task is to devise up to 5 highly effective goals and an appropriate role-based name (_GPT) for an autonomous agent,
    //ensuring that the goals are optimally aligned with the successful completion of its assigned task.
    String description;

    //The user will provide the task, you will provide only the output in the exact format specified below with no explanation or conversation.
    @JsonProperty("response_requirement")
    String responseRequirement;

    @JsonProperty("response_delimiter")
    String responseDelimiter;

    @JsonProperty("example_input")
    String exampleInput;

    @JsonProperty("example_output")
    String exampleOutput;

    @JsonProperty("prompt_format")
    String promptFormat;

    @JsonProperty("update_type")
    String updateType;

    @JsonProperty("update_delimiter")
    String updateDelimiter;
}
