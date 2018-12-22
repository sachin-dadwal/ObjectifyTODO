package service;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import model.Person;
public class OfyService {
    static {
        ObjectifyService.register(Person.class);
    }
    
    public static Objectify ofy(){
        return ObjectifyService.ofy();
    }
    
    public static ObjectifyFactory factory() {
		
		return ObjectifyService.factory();
		
		}
}