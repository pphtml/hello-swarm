package com.example;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("note")
@Produces(MediaType.APPLICATION_JSON)
public class NoteResource {
    @Inject
    NoteDAO noteDAO;

    @GET
    @Path("new")
    public Note newNote() {
        //Person person = new Person("Christian");
        Note note = new Note("blablebla", new Date());
        noteDAO.add(note);
        return note;
    }

    @GET
    @Path("student")
    public Person student() {
        return new Person("Ana");
    }
}