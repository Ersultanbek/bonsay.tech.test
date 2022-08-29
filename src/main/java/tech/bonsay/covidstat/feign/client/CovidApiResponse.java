package tech.bonsay.covidstat.feign.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class CovidApiResponse<T> {

    @JsonProperty("All")
    private T all;

    @JsonProperty("Global")
    private GlobalResponse<T> global;

    public T getData() {
        if (this.all == null) {
            return global.getAll();
        }

        return all;
    }

}
