package dao;

public interface iDao<T> {
    //todos los metodos comunes para desp implementar en los dao
    //aca debemos tener el CRUD
     T guardar(T t);

}
