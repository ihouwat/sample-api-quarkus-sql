package org.acme;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/list")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class ListResource implements ListService {

    @Override
    public List<ListItem> getList() {
        return ListItem.listAll();
    }

    @Override
    public Response addItem(ListItem item) {
        item.persist();
        return Response.status(Response.Status.CREATED).entity(item).build();
    }

    @Override
    public Response deleteItem(ListItem item) {
        ListItem deletedEntity = findItem(item.getItem());
        deletedEntity.delete();
        return Response.status(Response.Status.OK).entity(deletedEntity).build();
    }

    @Override
    public Response updateItem(ListItem oldItem, ListItem updatedItem) {
        ListItem updatedEntity = findItem(oldItem.getItem());
        updatedEntity.setItem(updatedItem.getItem());
        return Response.status(Response.Status.CREATED).entity(updatedEntity).build();
    }

}