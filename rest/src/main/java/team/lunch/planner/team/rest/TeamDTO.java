package team.lunch.planner.team.rest;

import java.io.Serializable;

import lombok.Data;

@Data
public class TeamDTO implements Serializable {

    private static final long serialVersionUID = 8203730744538848765L;
    
    private String name;
}
