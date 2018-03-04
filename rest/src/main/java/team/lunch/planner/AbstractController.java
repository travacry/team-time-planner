package team.lunch.planner;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

public abstract class AbstractController {

    protected <T> Resource<T> createResource(T content, ResourceProcessor<Resource<T>> resourceProcessor) {
        return resourceProcessor.process(new Resource<T>(content));
    }
}
