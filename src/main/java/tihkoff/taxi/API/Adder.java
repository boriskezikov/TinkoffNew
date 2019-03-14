package tihkoff.taxi.API;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Adder <T>  {
    public List<T> adder(List<T> oldList, T entity){
        oldList.add(entity);
        return oldList;
    }
}
