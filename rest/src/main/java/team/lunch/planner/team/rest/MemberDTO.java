package team.lunch.planner.team.rest;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MemberDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = -9169237337408371620L;
    
    @JsonIgnore
    private final Long databaseId;
    @JsonIgnore
    private final Long databaseUserId;
    private String name;
    private boolean turn;
    private boolean present;
}
