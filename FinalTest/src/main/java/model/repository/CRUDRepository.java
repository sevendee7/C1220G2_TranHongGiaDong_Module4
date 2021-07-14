package model.repository;

import java.util.List;

public interface CRUDRepository<E> {

    List<E> findAll();

//    List<E> findClass();
//
//    E findById(String id);
//
//    boolean delete(String id);
//
//    boolean insertNewStudent(E e);
//
//    boolean save(E e);
}
