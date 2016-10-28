package com.manageyourmoney.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.manageyourmoney.config.security.hmac.HmacRequester;
import com.manageyourmoney.dto.UserDTO;
import com.manageyourmoney.mock.MockUsers;

@Service
public class DefaultHmacRequester implements HmacRequester{
	@Override
    public Boolean canVerify(HttpServletRequest request) {
        return request.getRequestURI().contains("/api") && !request.getRequestURI().contains("/api/authenticate");
    }

    @Override
    public String getSecret(String iss) {
        UserDTO userDTO = MockUsers.findById(Integer.valueOf(iss));
        if(userDTO != null){
            return userDTO.getSecretKey();
        }
        return null;
    }

    @Override
    public Boolean isSecretInBase64() {
        return true;
    }
}
