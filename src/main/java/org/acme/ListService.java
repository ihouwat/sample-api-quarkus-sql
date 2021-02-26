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
    public Response addItem(ListItem item);

    @PUT
    public Response updateItem(@QueryParam("item") ListItem oldItem,
                               @QueryParam("updateditem") ListItem updatedItem);

    @DELETE
    public Response deleteItem(ListItem item);

    default public ListItem findItem(String item) {
        return find("item", item).list().get(0);
    }

}
