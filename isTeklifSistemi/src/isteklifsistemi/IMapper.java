/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isteklifsistemi;

import java.util.HashMap;

/**
 *
 * @author Ali İhsan Şepar
 */
public interface IMapper {
    public Object get(String id);
    public void put(Object o, String id);
    
    HashMap mappers = new HashMap();
    
    
}
