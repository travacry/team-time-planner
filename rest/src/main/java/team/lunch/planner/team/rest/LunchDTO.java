package team.lunch.planner.team.rest;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LunchDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 8910284061387158334L;
    
    @JsonIgnore
    private final Long databaseId;

    private List<MemberDTO> participants;
    private String restaurant;
}
