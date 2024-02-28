package quru.qa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quru.qa.model.Country;
import quru.qa.service.CountryService;

import java.util.List;

@RestController
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/")
    public List<Country> getAll() {
        return countryService.getAllCountries();
    }

    @GetMapping("/country")
    public Country findByCode(@RequestParam String countryCode) {
        return countryService.findByCountryCode(countryCode);
    }

    @PostMapping("/addCountry")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PatchMapping("/updateCountry")
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);
    }
}

