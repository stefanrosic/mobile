package com.mobile.service.controller;

import com.mobile.service.dto.UpdateMobileDto;
import com.mobile.service.entity.Mobile;
import com.mobile.service.service.IMobileService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashSet;

@RestController
@RequestMapping("/api/mobiles")
public class MobileController {

    private final IMobileService mobileService;

    public MobileController(IMobileService mobileService) {
        this.mobileService = mobileService;
    }

    @GetMapping
    public LinkedHashSet<Mobile> getAllMobiles() {
        return mobileService.getAll();
    }

    @PatchMapping("/{mobileId}")
    public Mobile getAllMobiles(@PathVariable String mobileId, @Valid @RequestBody UpdateMobileDto updateMobileDto) {
        return mobileService.update(mobileId, updateMobileDto);
    }
}
