package org.acme;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;


@Path("/list")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class ListResource implements ListService {

    @Override
    public List<ListItem> getList() {return ListItem.listAll(Sort.ascending("id"));}

    @Override
    public Response addItem(String input) {
        ListItem item = new ListItem(input);
        item.persist();
        return Response.status(Response.Status.CREATED).entity(item).build();
    }

    @Override
    public Response deleteItem(long id) {
        ListItem deletedEntity = findById(id);
        deletedEntity.delete();
        return Response.status(Response.Status.OK).entity(deletedEntity).build();
    }

    @Override
    public Response updateItem(long id, String updatedItem) {
        ListItem updatedEntity = findById(id);
        updatedEntity.setItem(updatedItem);
        return Response.status(Response.Status.OK).entity(updatedEntity).build();
    }

}