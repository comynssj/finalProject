package com.easyinventory.enterprise;

import com.easyinventory.enterprise.dto.Category;
import com.easyinventory.enterprise.service.EasyInventoryService;
import org.apache.catalina.startup.Catalina;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EnterpriseApplicationTests {

    @Autowired
    EasyInventoryService easyInventoryService;
    @Test
    void contextLoads() {
    }
    @Test
    void verifyCategories(){
        if(easyInventoryService.getAllCategories() !=null){
            assert true;
        }else{
            assert false;
        }
    }

    @Test
    void verifyAddCategory() throws Exception {
        Category category = new Category();
        category.setCategoryName("fruit");
        category = easyInventoryService.saveCategory(category);
        assertEquals("fruit", easyInventoryService.getCategoryByCategoryId(category.getCategoryId()));
        easyInventoryService.deleteCategory(category);
    }


    @Test
    void verifyItems(){
        if(easyInventoryService.getAllItems() !=null){
            assert true;
        }else{
            assert false;
        }
    }

}
