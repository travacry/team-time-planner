package team.lunch.planner.team.rest;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 8203730744538848765L;
    
    @JsonIgnore
    private Long databaseId;
    private String name;
    private List<MemberDTO> members = Collections.emptyList();
}
