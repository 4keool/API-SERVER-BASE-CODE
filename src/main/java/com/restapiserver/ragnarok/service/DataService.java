// package com.restapiserver.ragnarok.service;

// import org.springframework.beans.factory.annotation.Autowired;

// import com.restapiserver.ragnarok.model.DataModel;
// import com.restapiserver.ragnarok.mapper.DataMapper;

// public class DataService {
//     @Autowired
//     private DataMapper m;
    
//     public int TEST_BLOB_INSERT_SERVICE(DataModel test_blob_img_model) throws NullPointerException, Exception{
//         int returnData = -1;

//         try{
//             if(test_blob_img_model != null){
//                 returnData = m.imgmodel(test_blob_img_model);
//                 return returnData;
//             }
//             else
//                 {return returnData;}
//         }
//         catch(Exception e){
//             throw new Exception(e.getMessage());
//         }
//     }
// }
