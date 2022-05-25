package com.projet.ferme.service.utile;

import java.util.Map;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class MapToObject {
    
    private Map<String,Object> map;

    public MapToObject(Map<String, Object> map) {
        this.map = map;
    }

    public String getString(String key){
        if(map.get(key) != null)
            return map.get(key).toString();
        else
            return null;
    }

    public Long getLong(String key) {
        if(map.get(key) != null){
            try{
                return Long.parseLong(map.get(key).toString());
            }catch(NumberFormatException e){
                return null;
            }
        }
        else
            return null;
    }

    public Integer getInteger(String key) {
        if(map.get(key) != null){
            try{
                return Integer.parseInt(map.get(key).toString());
            }catch(NumberFormatException e){
                return null;
            }
        }
        else
            return null;
    }

    public Boolean getBoolean(String key) {
        if(map.get(key) != null)
            return Boolean.parseBoolean(map.get(key).toString());
        else
            return null;
    }

}
