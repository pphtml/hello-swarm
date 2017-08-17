package com.example;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class NoteDAO {
    @PersistenceContext(unitName = "MyPU")
    private EntityManager entityManager;

    public void add(Note note) {
        entityManager.persist(note);
    }
}
