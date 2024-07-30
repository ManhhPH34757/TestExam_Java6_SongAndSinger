package com.spring.songandsinger.controllers;

import com.spring.songandsinger.dto.BaiHatDto;
import com.spring.songandsinger.dto.CaSiDto;
import com.spring.songandsinger.repositories.BaiHatDtoRepository;
import com.spring.songandsinger.entities.BaiHat;
import com.spring.songandsinger.repositories.BaiHatRepository;
import com.spring.songandsinger.repositories.CaSiDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/songs")
public class BaiHatController {

    @Autowired
    private BaiHatRepository baiHatRepository;

    @Autowired
    private BaiHatDtoRepository baiHatDtoRepository;

    @Autowired
    private CaSiDtoRepository caSiDtoRepository;

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

    @GetMapping("/maxPrice")
    public List<BaiHatDto> maxPrice() {

        List<BaiHatDto> list = baiHatDtoRepository.getBaiHatDtoList();

        Optional<Double> maxPrice = list.stream()
                .map(BaiHatDto::getGia)
                .max(Comparator.comparingDouble(Double::doubleValue));

        return maxPrice.map(aDouble -> list.stream()
                .filter(baiHatDto -> baiHatDto.getGia().equals(aDouble))
                .collect(Collectors.toList())).orElse(null);

    }
    
    @GetMapping("/maxDuration")
    public List<BaiHatDto> maxDuration() {
        List<BaiHatDto> list = baiHatDtoRepository.getBaiHatDtoList();

        Optional<Integer> maxDuration = list.stream()
               .map(BaiHatDto::getThoiluong)
               .max(Comparator.comparingInt(Integer::intValue));

        return maxDuration.map(anInt -> list.stream()
               .filter(baiHatDto -> baiHatDto.getThoiluong().equals(anInt))
               .collect(Collectors.toList())).orElse(null);
    }

    @GetMapping("/sumDurations")
    public List<CaSiDto> getSumDurations() {
        return caSiDtoRepository.getCaSiDtoList();
    }

    @GetMapping("/song") /* Get data to add */
    public List<BaiHat> getBaiHat() {
        return baiHatRepository.findAll();
    }

}
