package org.jboss.pnc.buildkitchen;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.pnc.buildkitchen.api.BuildRecipeDTO;
import org.jboss.pnc.buildkitchen.api.Lookup;
import org.jboss.pnc.buildkitchen.api.ScmInfoDTO;
import org.jboss.pnc.buildkitchen.mapper.BuildRecipeMapper;
import org.jboss.pnc.buildkitchen.model.BuildRecipe;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LookupResource implements Lookup {
    @Inject
    BuildRecipeMapper buildRecipeMapper;

    @Override
    public List<BuildRecipeDTO> lookupByScmRevision(String url, String revision) {
        return BuildRecipe.findByScmInfo(url, revision).stream().map(buildRecipeMapper::toResource).collect(Collectors.toList());
    }
}
