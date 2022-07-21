package com.mobile.service.service;

import com.mobile.service.dto.UpdateMobileDto;
import com.mobile.service.entity.Mobile;

import java.util.LinkedHashSet;
import java.util.UUID;

public interface IMobileService {

    LinkedHashSet<Mobile> getAll();

    Mobile update(String mobileId, UpdateMobileDto updateMobileDto);
}
