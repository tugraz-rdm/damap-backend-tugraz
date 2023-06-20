package at.tugraz.damap.rest.dmp.domain;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TUGrazPerson {
    @Size(max = 255)
    private String identifier;
    @Size(max = 255)
    private String givenName;
    @Size(max = 255)
    private String familyName;

    @JsonSetter(nulls = Nulls.SKIP)
    private Map<String, String> localData = new HashMap<>();

    public String getFromLocalData(String key) {
        return localData.get(key);
    }

    public String getEmail() {
        return getFromLocalData("email");
    }
}
