package team.lunch.planner.team.rest;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = -9169237337408371620L;
    
    @JsonIgnore
    private Long databaseId;
    private String name;
}
