package com.metemulakat.metemul.service;

import com.metemulakat.metemul.model.Data;
import com.metemulakat.metemul.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {

    final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<Data> getAllData() {
        return dataRepository.findAll();
    }

    public Data getSaveData(Data data) {
        return dataRepository.save(data);
    }

    public Data getEditData(Long id, Data data) {
        Data data1 = dataRepository.findById(id).orElseThrow(() -> new IllegalStateException("Böyle bir kullanıcı yok"));
        data1.setName(data.getName());
        data1.setMeslek(data.getMeslek());
        data1.setAge(data.getAge());
        data1.setDogumTarihi(data.getDogumTarihi());

        return dataRepository.save(data1);
    }

    public void getDeleteData(Long id) {
        dataRepository.deleteById(id);
    }

    public Optional<Data> getById(Long id) {
        return dataRepository.findById(id);
    }
}
