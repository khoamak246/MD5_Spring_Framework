package com.ajax.ajaxphone.repository;

import com.ajax.ajaxphone.model.SmartPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends CrudRepository<SmartPhone, Long> {
    Iterable<SmartPhone> findAllByProducerContaining(String producer);
}

