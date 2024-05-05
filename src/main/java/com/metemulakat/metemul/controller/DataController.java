package com.metemulakat.metemul.controller;

import com.metemulakat.metemul.model.Data;
import com.metemulakat.metemul.service.DataService;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DataController {
    final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }
    @GetMapping("/getAll")
    public List<Data> getAllData(){
        return dataService.getAllData();
    }
    @GetMapping("/getById")
    public Optional<Data> getById(@RequestParam Long id) throws BadRequestException {

        //if kontrolü eklenebilir
        return dataService.getById(id);
    }
    //yorum satiridir
    @PostMapping("/saveData")
    public Data getSaveData(@RequestBody Data data) throws BadRequestException {
        if (data==null){
            throw new BadRequestException("Kaydedilecek bir bilgi gönderilsin.");
        }
        return dataService.getSaveData(data);
    }
    //kullanıcı bilgisi değiştirme
    @PutMapping("/editData")
    public Data getEditData(@RequestParam Long id, @RequestBody Data data){
        if (data==null){
            try {
                throw new BadRequestException("Düzeltilecek bir data ID'si gönderilsin.");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }
        return dataService.getEditData(id,data);
    }
    //kullanıcı bilgisi silme
    @DeleteMapping("/deleteData")
    public void getDeleteData(@RequestParam Long id){
        dataService.getDeleteData(id);
    }

}
