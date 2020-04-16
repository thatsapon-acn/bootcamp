package com.example.mission2_v02;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StoreService {
    //ArrayList<Store> data = new ArrayList<Store>(); //Create variables to store
    //private List<Store> data{ //Set initial value
    //    Store a = new Store(1L,"First","1,2",4F);
    //   Store b = new Store(2L,"Second","1,-2",3F);
    //    data.add(b);
    //   data.add(a);
    //}
    private List<Store> data = new ArrayList<>(Arrays.asList(
            new Store((long) 1,"First","1,2",4F),
            new Store((long) 2,"Second","1,-2",3F)
    ));
    public List<Store> findAll(){
        return data;
    }
    public Store findById(Long InputId){
        return data.stream().filter(row -> row.getId() == InputId).findFirst().get();
    }
    public void deleteById(Long InputId){
        data.removeIf(row -> row.getId() == InputId);
    }
    public void updateById(Long InputId,Store updatedStore){
        data.set(data.indexOf(findById(InputId)),updatedStore);
    }
    public void addNewStore(Store newStore){
        data.add(newStore);
    }
}