package tech.bonsay.covidstat.feign.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class GlobalResponse<T> {

    @JsonProperty("All")
    private T all;

}
