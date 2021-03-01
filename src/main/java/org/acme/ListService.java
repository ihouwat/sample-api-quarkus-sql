package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

public interface ListService extends PanacheRepository<ListItem> {
//    private List<ListItem> list;
//    int index;

    @GET
    public List<ListItem> getList();

    @POST
    public Response addItem(String item);

    @PUT
    public Response updateItem(@QueryParam("itemId") long id,
                               @QueryParam("updatedItem") String updatedItem);

    @DELETE
    @Path("/{id}")
    public Response deleteItem(@PathParam("id") long id);

    default public ListItem findItem(String item) {
        return find("item", item).list().get(0);
    }

}
