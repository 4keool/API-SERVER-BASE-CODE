package com.restapiserver.ragnarok.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import java.sql.Blob;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restapiserver.ragnarok.mapper.DataMapper;
import com.restapiserver.ragnarok.model.DataModel;

@RestController
public class DataController {
    private DataMapper mapper;

    public DataController(DataMapper mapper){
        this.mapper = mapper;
    }

    @GetMapping("/data/{id}")
    public DataModel getDataModel(@PathVariable("id") int id){
        return mapper.getDataModel(id);
    }

    @GetMapping("/data/all")
    public List<DataModel> getDataModelList(){
        return mapper.getDataModelList();
    }

    @PutMapping("/data/{id}")
    public void putDataModel(@PathVariable("id") int id, @RequestParam("stat") int stat, @RequestParam("posx") int posx, @RequestParam("posy") int posy, 
                                    @RequestParam("temp1") int itemp, @RequestParam("temp2") String stemp, @RequestParam("data") Blob data){
                                        mapper.insertDataModel(id, stat, posx, posy, itemp, stemp, data);
    }

    @PostMapping("/data/{id}")
    public void postDataModel(@PathVariable("id") int id, @RequestParam("stat") int stat, @RequestParam("posx") int posx, @RequestParam("posy") int posy, 
                                    @RequestParam("temp1") int itemp, @RequestParam("temp2") String stemp, @RequestParam("data") Blob data){
                                        mapper.updateDataModel(id, stat, posx, posy, itemp, stemp, data);
    }

    @PostMapping("/file")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> upload(@RequestParam int id, @RequestParam int stat, @RequestPart List<MultipartFile> files) throws Exception{
        List<String> list = new ArrayList<>();
        for(MultipartFile file : files){
            // String originalfilename = file.getOriginalFilename();
            // File dest = new File("D:/Image/" + originalfilename);
            // file.transferTo(dest);

            byte[] datas;
            datas = file.getBytes();
            Blob blob = new SerialBlob(datas);
            mapper.uploadfile(id, stat, datas);


        }
        return list;
    }

    @PostMapping("/file2")
    @ResponseStatus(HttpStatus.CREATED)
    public int upload2(@RequestParam int id, @RequestParam int stat) throws Exception{
            mapper.uploadfile2(id, stat);
        return 4444;
    }

    // @PostMapping("/data/a")
    // public void insertData(
    //     @RequestPart(value = "file", required = false) MultipartFile MultipartFile, 
    //     @RequestPart(value = "InsertPostReq") DataModel DM){
    //         System.out.println("Call Controller insertUser Method");
    //         mapper.insertDM(MultipartFile, DM);
    //     }

    // @DeleteMapping("/data/{id}")
    // public void deleteDataModel(@PathVariable("id") int id){
    //     mapper.deleteDataModel(id);
    // }
}
