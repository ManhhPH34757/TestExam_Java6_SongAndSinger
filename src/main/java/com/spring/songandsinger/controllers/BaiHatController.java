package com.spring.songandsinger.controllers;

import com.spring.songandsinger.dto.BaiHatDto;
import com.spring.songandsinger.dto.BaiHatDtoRepository;
import com.spring.songandsinger.entities.BaiHat;
import com.spring.songandsinger.repositories.BaiHatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class BaiHatController {

    @Autowired
    private BaiHatRepository baiHatRepository;

    @Autowired
    private BaiHatDtoRepository baiHatDtoRepository;

    @GetMapping()
    public List<BaiHatDto> getBaiHats() {
        return baiHatDtoRepository.getBaiHatDtoList();
    }

    @GetMapping("/paginators")
    public List<BaiHatDto> getBaiHatsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        if (page < 1) {
            page = 0;
        }
        return baiHatDtoRepository.getBaiHatDtoPage(PageRequest.of(page, size)).getContent();
    }

    @PostMapping()
    public BaiHat createBaiHat(@RequestBody BaiHat baiHat) {
        return baiHatRepository.save(baiHat);
    }

    @DeleteMapping("/{id}")
    public void deleteBaiHat(@PathVariable Integer id) {
        BaiHat baiHat = baiHatRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Bai hat not found with id: " + id));
        baiHatRepository.delete(baiHat);
    }

    @GetMapping("/search")
    public List<BaiHatDto> searchBaiHat(@RequestParam(required = false) String tenCaSi,
                                      @RequestParam(required = false) Double to,
                                      @RequestParam(required = false) Double from) {
        return baiHatDtoRepository.getBaiHatByGiaAndTenCaSi(tenCaSi, to, from);
    }


    @GetMapping("/song")
    public List<BaiHat> getBaiHat() {
        return baiHatRepository.findAll();
    }

}
