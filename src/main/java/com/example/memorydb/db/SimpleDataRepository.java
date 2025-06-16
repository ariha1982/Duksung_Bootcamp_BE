package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;

import java.util.*;

abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID>{
    private final List<T> dataList = new ArrayList<T>();

    private static long index = 0;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    //c, u
    @Override
    public T save(T data) {
        if (Objects.isNull(data)){
            throw new RuntimeException("Data is null");
        }

        //db에 이미 있는가
        var prevData = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(data.getId());
                })
                .findFirst();

        if (prevData.isPresent()) {
            dataList.remove(prevData.get());
            dataList.add(data);
        } else {
            index++;
            data.setId(index);
            dataList.add(data);
        }

        return data;
    }

    //r
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
                .filter(it -> {
                            return (it.getId().equals(id));
                })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .toList();
    }

    // d
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                })
                .findFirst();

        dataList.remove(deleteEntity.get());
    }
}
