/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2023-2024 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.pnc.buildkitchen.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/recipes")
public interface Recipes {

    @GET
    @Path("/{id}")
    BuildRecipeDTO getSpecific(@PathParam("id") long id);

    @POST
    BuildRecipeDTO createRecipe(@Valid BuildRecipeDTO recipe);

    @POST
    @Path("/pnc-build")
    BuildRecipeDTO submitPNCBuild(@Valid PNCBuild build);

    @POST
    @Path("/pnc-build-by-id")
    BuildRecipeDTO submitPNCBuild(@NotEmpty String buildId);
}
