package at.tugraz.blueprint.rest.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SearchResult<T> {
    @JsonProperty(value = "hydra:member")
    List<T> items = new ArrayList<>();
}
