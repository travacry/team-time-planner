package team.lunch.planner.user.rest;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.rest.TeamDTO;

@Component
@RequiredArgsConstructor
class UserResourceProcessor implements ResourceProcessor<Resource<UserDTO>> {

    private final EntityLinks entityLinks;

    @Override
    public Resource<UserDTO> process(Resource<UserDTO> resource) {
        UserDTO content = resource.getContent();
        resource.add(entityLinks.linkFor(UserDTO.class).slash(content.getId()).withSelfRel());
        resource.add(entityLinks.linkFor(TeamDTO.class).withRel("teams"));
        return resource;
    }
}
