package org.example.Library.service;

import java.util.List;

public interface BaseService<RES,REQ> {

        public List<RES> getAll();

        public RES getById(Integer id) throws Exception;


        public RES create(REQ items);


        public RES update(REQ items) throws Exception;


        public void deleteById(Integer id);


}
