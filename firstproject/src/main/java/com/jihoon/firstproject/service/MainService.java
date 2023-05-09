package com.jihoon.firstproject.service;

import com.jihoon.firstproject.provider.UserRole;

public interface MainService {
    public String hello();
    public String getJwt(String data);
    public UserRole validJwt(String jwt);
}
