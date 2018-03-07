package team.lunch.planner.user.rest;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = -8381866402192815130L;
    
    @JsonIgnore
    private Long databaseId;
    private String email;
    private String firstname;
    private String lastname;

}
