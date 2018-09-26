package com.dao;

import java.util.List;

import com.models.Registration;

public interface RegistrationDao 
{
	
	Registration saveRegist(Registration reg);
	Registration updateRegist(Registration reg);
	Registration getRegist(int id);
	Registration deleteRegist(Registration reg);
	List<Registration> getAllRegist();
	
	}
