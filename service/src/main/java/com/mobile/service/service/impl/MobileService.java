package com.mobile.service.service.impl;

import com.mobile.service.dto.UpdateMobileDto;
import com.mobile.service.entity.Mobile;
import com.mobile.service.exception.MobileAlreadyExistsException;
import com.mobile.service.exception.MobileNotFoundException;
import com.mobile.service.service.IMobileService;
import com.mobile.service.utils.MockUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Service
public class MobileService implements IMobileService {

    @Override
    public LinkedHashSet<Mobile> getAll() {
        return MockUtils.getMobilesFromMemory
                .stream()
                .sorted(Comparator.comparing(Mobile::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Mobile update(String mobileId, UpdateMobileDto updateMobileDto) {
        final var mobile = MockUtils.getMobilesFromMemory
                .stream()
                .filter(m -> m.getId().toString().equals(mobileId))
                .findFirst();

        if (mobile.isEmpty()) {
            throw new MobileNotFoundException(mobileId);
        }

        final var isAlreadyStored = MockUtils.getMobilesFromMemory
                .stream()
                .anyMatch(m -> m.getName().equalsIgnoreCase(updateMobileDto.getName()));


        if (isAlreadyStored) {
            throw new MobileAlreadyExistsException(updateMobileDto.getName());
        }

        mobile.get().setName(updateMobileDto.getName());
        return mobile.get();
    }
}
