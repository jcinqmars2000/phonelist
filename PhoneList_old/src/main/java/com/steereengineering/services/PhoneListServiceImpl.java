package com.steereengineering.services;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.steereengineering.repositories.PhoneListRepository;
import lombok.extern.slf4j.Slf4j;

import com.steereengineering.commands.PhoneListCommand;
import com.steereengineering.converters.PhoneListCommandToPhoneList;
import com.steereengineering.converters.PhoneListToPhoneListCommand;
import com.steereengineering.model.*;

@Slf4j
@Service
public class PhoneListServiceImpl implements PhoneListService {

	private final PhoneListRepository phoneListRepository;
	private final PhoneListCommandToPhoneList  phoneListCommandToPhoneList;
	private final PhoneListToPhoneListCommand  phoneListToPhoneListCommand; 
    
   
	
	public PhoneListServiceImpl(PhoneListRepository phoneListRepository,PhoneListCommandToPhoneList  phoneListCommandToPhoneList, PhoneListToPhoneListCommand  phoneListToPhoneListCommand) {
		this.phoneListRepository = phoneListRepository;
		this.phoneListCommandToPhoneList = phoneListCommandToPhoneList;
		this.phoneListToPhoneListCommand = phoneListToPhoneListCommand;
	}

	@Override
	public Set<PhoneList> getPhoneList() {
		log.debug("I'm in the service");

		Set<PhoneList> phoneListSet = new LinkedHashSet<PhoneList>();

		phoneListRepository.getOrderByFirstname().iterator().forEachRemaining(phoneListSet::add);
		for(PhoneList phone : phoneListSet) {
			System.out.println(phone.toString());
		}

		return phoneListSet;
	}

	@Override
	public PhoneList findById(Long l) {

		Optional<PhoneList> phoneListOptional = phoneListRepository.findById(l);

		if (!phoneListOptional.isPresent()) {
			throw new RuntimeException("Name Not Found!");
		}

		return phoneListOptional.get();
	}

	@Override
	@Transactional
	public PhoneListCommand savePhoneListCommand(PhoneListCommand command) {
		PhoneList detachedPhoneList = phoneListCommandToPhoneList.convert(command);
		
		PhoneList savePhoneList = phoneListRepository.save(detachedPhoneList);
		log.debug("Saved RecipeID:" + savePhoneList.getId());
		return phoneListToPhoneListCommand.convert(savePhoneList);
	}

	
}  	
