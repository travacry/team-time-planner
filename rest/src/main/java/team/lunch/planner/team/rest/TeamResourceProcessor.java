package team.lunch.planner.team.rest;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TeamResourceProcessor implements ResourceProcessor<Resource<TeamDTO>> {
    
    private final EntityLinks entityLinks;

    @Override
    public Resource<TeamDTO> process(Resource<TeamDTO> resource) {
        TeamDTO team = resource.getContent();
        resource.add(entityLinks.linkFor(TeamDTO.class).slash(team.getId()).withSelfRel());
        return resource;
    }

}
