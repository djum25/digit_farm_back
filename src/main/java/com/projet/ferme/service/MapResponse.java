package com.projet.ferme.service;

import java.util.HashMap;
import java.util.Map;

public class MapResponse {
    
    private boolean success;

    private String message;

    private Object object;

    public MapResponse withSuccess(boolean success){
        this.success = success;
        return this;
    }

    public MapResponse withMessage(String message) {
        this.message = message;
        return this;
    }


    public MapResponse withObject(Object object){
        this.object = object;
        return this;
    }

    public Map<String,Object> response(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", success);
        map.put("message", message);
        map.put("object", object);
        return map;
    }
}

       