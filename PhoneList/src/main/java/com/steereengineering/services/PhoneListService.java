package com.steereengineering.services;

import java.util.Set;

import com.steereengineering.commands.PhoneListCommand;
import com.steereengineering.model.PhoneList;

public interface PhoneListService {
	  Set<PhoneList> getPhoneList();
      PhoneList findById(Long l);
      PhoneListCommand findCommandById(Long l);
      PhoneListCommand savePhoneListCommand(PhoneListCommand command);
      void deleteById(Long idToDelete);
}
