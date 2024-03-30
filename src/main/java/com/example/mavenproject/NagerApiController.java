package com.example.mavenproject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class NagerApiController {

  //  @RequestMapping(value = "/AvailableCountries", method = RequestMethod.GET)
   // @ResponseBody
    //@GetMapping(value = "/AvailableCountries")
    @RequestMapping(value = "/AvailableCountries", method = RequestMethod.GET)
    public String AvailableCountries() {
        String url = "/AvailableCountries";

        return callEntity(url).getBody();
    }

    @RequestMapping(value = "/CountryInfo", method = RequestMethod.GET)
    public String getCountryInfo(@RequestParam("countryId") String countryId) {
        String url = "/CountryInfo/".concat(countryId);

        return callEntity(url).getBody();
    }

    @RequestMapping(value = "/LongWeekend", method = RequestMethod.GET)
    public String LongWeekend(@RequestParam("year") String year, @RequestParam("countryCode") String countryCode) {
        String url = "/LongWeekend/".concat(year) +"/".concat(countryCode);

        return callEntity(url).getBody();
    }

    @RequestMapping(value = "/PublicHolidays", method = RequestMethod.GET)
    public String PublicHolidays(@RequestParam("year") String year, @RequestParam("countryCode") String countryCode) {
        String url = "/PublicHolidays/".concat(year) +"/".concat(countryCode);

        return callEntity(url).getBody();
    }

    @RequestMapping(value = "/IsTodayPublicHoliday", method = RequestMethod.GET)
    public ResponseEntity<String> IsTodayPublicHoliday(@RequestParam("countryCode") String countryCode, @RequestParam("countyCode") String countyCode,
                                                       @RequestParam("offset") String offset) {
        String url = "/IsTodayPublicHoliday/".concat(countryCode) +"?countyCode=".concat(countyCode)+"&offset=".concat(offset);

        return callEntity(url);
    }

    @RequestMapping(value = "/NextPublicHolidays", method = RequestMethod.GET)
    public String NextPublicHolidays(@RequestParam("countryCode") String countryCode) {
        String url = "/NextPublicHolidays/".concat(countryCode);

        return callEntity(url).getBody();

    }

    @RequestMapping(value = "/NextPublicHolidaysWorldwide", method = RequestMethod.GET)
    public String NextPublicHolidaysWorldwide() {
        String url = "/NextPublicHolidaysWorldwide";

        return callEntity(url).getBody();
    }

    @RequestMapping(value = "/Version", method = RequestMethod.GET)
    public String Version() {
        String url = "/Version";

        return callEntity(url).getBody();
    }

    public ResponseEntity<String> callEntity(String param){
        String url = "https://date.nager.at/api/v3".concat(param);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        return response;
    }

}
