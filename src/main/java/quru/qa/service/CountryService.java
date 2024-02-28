package quru.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quru.qa.data.CountryEntity;
import quru.qa.data.CountryRepository;
import quru.qa.model.Country;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(Country::fromEntity)
                .toList();
    }

    public Country findByCountryCode(String countryCode) {
        return Country.fromEntity(countryRepository.findByCountryCode(countryCode));
    }

    public Country addCountry(Country country) {
        return Country.fromEntity(
                countryRepository.save(CountryEntity.fromJson(country))
        );
    }

    public Country updateCountry(Country country) {
        CountryEntity findCountry = countryRepository.findByCountryCode(country.countryCode());
        findCountry.setCountryName(country.countryName());
        return Country.fromEntity(countryRepository.save(findCountry));
    }
}
