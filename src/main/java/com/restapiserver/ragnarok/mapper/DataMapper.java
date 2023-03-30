package com.restapiserver.ragnarok.mapper;

import java.util.List;
import java.sql.Blob;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.restapiserver.ragnarok.model.DataModel;

@Mapper
public interface DataMapper {
    @Select("SELECT * FROM userprofile3 WHERE id=#{id}")
    DataModel getDataModel(@Param("id") int id);
    
    @Select("SELECT * FROM DataDB")
    List<DataModel> getDataModelList();

    @Insert("INSERT INTO DataDB VALUES (#{id}, #{stat}, #{posx}, #{posy}, #{temp1}, #{temp2}, #{data})")
    int insertDataModel(@Param("id") int id, @Param("stat") int stat, @Param("posx") int posx, @Param("posy") int posy, 
                                    @Param("temp1") int itemp, @Param("temp2") String stemp, @Param("data") Blob data);

    // @Insert("")
    // int insertDM(MultipartFile MPF, DataModel DM);

    @Update("UPDATE DataDB SET stat=#{stat}, posx=#{posx}, posy=#{posy}, temp1=#{temp1}, temp2=#{temp2}, data=#{data})")
    int updateDataModel(@Param("id") int id, @Param("stat") int stat, @Param("posx") int posx, @Param("posy") int posy, 
                                    @Param("temp1") int itemp, @Param("temp2") String stemp, @Param("data") Blob data);

    @Delete("DELETE FROM DataDB WHERE id=#{id}")
    int deleteDataModel(@Param("id") int id);

    @Insert("INSERT INTO image_test (id, stat, files) VALUES(#{id}, #{stat}, #{files})")
    int uploadfile(@Param("id") int id, @Param("stat") int stat, @Param("Blob") byte[] files);

    @Insert("INSERT INTO image_test (id, stat) VALUES(#{id}, #{stat})")
    void uploadfile2(int id, int stat);
    
}
