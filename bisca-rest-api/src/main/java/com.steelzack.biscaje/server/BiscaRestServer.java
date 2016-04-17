package com.steelzack.biscaje.server;

import com.steelzack.biscaje.model.User;
import com.steelzack.biscaje.security.BiscaJESecurityGenerator;
import com.steelzack.biscaje.service.BiscaService;
import org.apache.commons.httpclient.HttpStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

/**
 * Created by joaofilipesabinoesperancinha on 16-04-16.
 */

@Path("/biscaje")
public class BiscaRestServer {

    @Inject
    private BiscaService biscaService;

    @Inject
    private BiscaJESecurityGenerator biscaJESecurityGenerator;

    @GET
    @Path("test")
    @Consumes(MediaType.TEXT_PLAIN)
    public void ping() throws InvalidKeySpecException, NoSuchAlgorithmException {
       biscaService.createUser("Joao", biscaJESecurityGenerator.generateStrongPasswordHash("12345"), new Date());
    }

    @POST
    @Path("newuser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewUser(User user)
    {
        return Response.status(HttpStatus.SC_OK).entity(user).build();
    }
}
