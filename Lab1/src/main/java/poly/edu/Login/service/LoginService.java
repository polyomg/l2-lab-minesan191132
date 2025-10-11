package poly.edu.Login.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public HashMap<String, String> users = new HashMap<String, String>();
    
    public LoginService() {
    	users.put("Admin", "123");
    	users.put("Admin1", "123");
    	users.put("Admin2", "123");
    }
    
    public String checkLogin(String username, String password) {
    	if(!users.containsKey(username)) {
    		return "Ban da sai";
    	}
    	
    	if(!users.get(username).equals(password)){
			return "Password khong dung";
		}
    	
    	return "Dang Nhap Thanh Cong";
    }
}
