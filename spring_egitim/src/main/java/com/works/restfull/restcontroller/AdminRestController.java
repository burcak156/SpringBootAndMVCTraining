package com.works.restfull.restcontroller;

import com.works.restfull.entities.Admin;
import com.works.restfull.services.AdminDetailService;
import com.works.restfull.utils.REnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminRestController {

    final AdminDetailService adminDetailService;

    @PostMapping("/register")
    public ResponseEntity save (@RequestBody Admin admin) {
        Map<REnum,Object> hm = new LinkedHashMap<>();
        hm.put(REnum.result,adminDetailService.register(admin));
        hm.put(REnum.status, true);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
