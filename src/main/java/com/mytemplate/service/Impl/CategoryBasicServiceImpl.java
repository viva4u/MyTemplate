package com.mytemplate.service.Impl;

import com.mytemplate.mapper.CateBasicMapper.CateBasicMapper;
import com.mytemplate.model.Category;
import com.mytemplate.service.CategoryBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryBasicServiceImpl implements CategoryBasicService {
    @Autowired
    private CateBasicMapper cateBasicMapper;

    public CateBasicMapper getCateBasicMapper() {
        return cateBasicMapper;
    }

    public void setCateBasicMapper(CateBasicMapper cateBasicMapper) {
        this.cateBasicMapper = cateBasicMapper;
    }
    @Override
    public Category getCategory (Category category){
        return this.getCateBasicMapper().getCategory(category);
    }
//    @Transactional
    @Override
    public void addCategory(Category category) throws Exception{
        try {
            this.getCateBasicMapper().addCategory(category);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception();
//            throw e;
        }
//        throw new Exception();
    }
}
