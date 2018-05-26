package pl.narodzinyprograsmity.table;

import pl.narodzinyprograsmity.model.BaseModel;

import java.util.List;

public interface CrudManager<T extends BaseModel> {
    String create(T t);

    void update(T newT);

    void delete(String id);

    List<T> read();

}
