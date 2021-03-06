package com.xyzcorp.jqwik.generators;

import net.jqwik.api.*;

import java.util.List;

public class CustomGeneratorProperties {
    @Provide(value = "countries")
    Arbitrary<String> singleCountryProvider() {
        String[] countryStrings = getCountryStrings();
        return Arbitraries.of(countryStrings);
    }

    private String[] getCountryStrings() {
        String countries = "Afghanistan\n" +
            "Albania\n" +
            "Algeria\n" +
            "Andorra\n" +
            "Angola\n" +
            "Antigua & Deps\n" +
            "Argentina\n" +
            "Armenia\n" +
            "Australia\n" +
            "Austria\n" +
            "Azerbaijan\n" +
            "Bahamas\n" +
            "Bahrain\n" +
            "Bangladesh\n" +
            "Barbados\n" +
            "Belarus\n" +
            "Belgium\n" +
            "Belize\n" +
            "Benin\n" +
            "Bhutan\n" +
            "Bolivia\n" +
            "Bosnia Herzegovina\n" +
            "Botswana\n" +
            "Brazil\n" +
            "Brunei\n" +
            "Bulgaria\n" +
            "Burkina\n" +
            "Burundi\n" +
            "Cambodia\n" +
            "Cameroon\n" +
            "Canada\n" +
            "Cape Verde\n" +
            "Central African Rep\n" +
            "Chad\n" +
            "Chile\n" +
            "China\n" +
            "Colombia\n" +
            "Comoros\n" +
            "Congo\n" +
            "Congo {Democratic Rep}\n" +
            "Costa Rica\n" +
            "Croatia\n" +
            "Cuba\n" +
            "Cyprus\n" +
            "Czech Republic\n" +
            "Denmark\n" +
            "Djibouti\n" +
            "Dominica\n" +
            "Dominican Republic\n" +
            "East Timor\n" +
            "Ecuador\n" +
            "Egypt\n" +
            "El Salvador\n" +
            "Equatorial Guinea\n" +
            "Eritrea\n" +
            "Estonia\n" +
            "Ethiopia\n" +
            "Fiji\n" +
            "Finland\n" +
            "France\n" +
            "Gabon\n" +
            "Gambia\n" +
            "Georgia\n" +
            "Germany\n" +
            "Ghana\n" +
            "Greece\n" +
            "Grenada\n" +
            "Guatemala\n" +
            "Guinea\n" +
            "Guinea-Bissau\n" +
            "Guyana\n" +
            "Haiti\n" +
            "Honduras\n" +
            "Hungary\n" +
            "Iceland\n" +
            "India\n" +
            "Indonesia\n" +
            "Iran\n" +
            "Iraq\n" +
            "Ireland {Republic}\n" +
            "Israel\n" +
            "Italy\n" +
            "Ivory Coast\n" +
            "Jamaica\n" +
            "Japan\n" +
            "Jordan\n" +
            "Kazakhstan\n" +
            "Kenya\n" +
            "Kiribati\n" +
            "Korea North\n" +
            "Korea South\n" +
            "Kosovo\n" +
            "Kuwait\n" +
            "Kyrgyzstan\n" +
            "Laos\n" +
            "Latvia\n" +
            "Lebanon\n" +
            "Lesotho\n" +
            "Liberia\n" +
            "Libya\n" +
            "Liechtenstein\n" +
            "Lithuania\n" +
            "Luxembourg\n" +
            "Macedonia\n" +
            "Madagascar\n" +
            "Malawi\n" +
            "Malaysia\n" +
            "Maldives\n" +
            "Mali\n" +
            "Malta\n" +
            "Marshall Islands\n" +
            "Mauritania\n" +
            "Mauritius\n" +
            "Mexico\n" +
            "Micronesia\n" +
            "Moldova\n" +
            "Monaco\n" +
            "Mongolia\n" +
            "Montenegro\n" +
            "Morocco\n" +
            "Mozambique\n" +
            "Myanmar, {Burma}\n" +
            "Nambia\n" +
            "Namibia\n" +
            "Nauru\n" +
            "Nepal\n" +
            "Netherlands\n" +
            "New Zealand\n" +
            "Nicaragua\n" +
            "Niger\n" +
            "Nigeria\n" +
            "Norway\n" +
            "Oman\n" +
            "Pakistan\n" +
            "Palau\n" +
            "Panama\n" +
            "Papua New Guinea\n" +
            "Paraguay\n" +
            "Peru\n" +
            "Philippines\n" +
            "Poland\n" +
            "Portugal\n" +
            "Qatar\n" +
            "Romania\n" +
            "Russian Federation\n" +
            "Rwanda\n" +
            "St Kitts & Nevis\n" +
            "St Lucia\n" +
            "Saint Vincent & the Grenadines\n" +
            "Samoa\n" +
            "San Marino\n" +
            "Sao Tome & Principe\n" +
            "Saudi Arabia\n" +
            "Senegal\n" +
            "Serbia\n" +
            "Seychelles\n" +
            "Sierra Leone\n" +
            "Singapore\n" +
            "Slovakia\n" +
            "Slovenia\n" +
            "Solomon Islands\n" +
            "Somalia\n" +
            "South Africa\n" +
            "South Sudan\n" +
            "Spain\n" +
            "Sri Lanka\n" +
            "Sudan\n" +
            "Suriname\n" +
            "Swaziland\n" +
            "Sweden\n" +
            "Switzerland\n" +
            "Syria\n" +
            "Taiwan\n" +
            "Tajikistan\n" +
            "Tanzania\n" +
            "Thailand\n" +
            "Togo\n" +
            "Tonga\n" +
            "Trinidad & Tobago\n" +
            "Tunisia\n" +
            "Turkey\n" +
            "Turkmenistan\n" +
            "Tuvalu\n" +
            "Uganda\n" +
            "Ukraine\n" +
            "United Arab Emirates\n" +
            "United Kingdom\n" +
            "United States\n" +
            "Uruguay\n" +
            "Uzbekistan\n" +
            "Vaishnoria\n" +
            "Vanuatu\n" +
            "Vatican City\n" +
            "Venezuela\n" +
            "Vietnam\n" +
            "Yemen\n" +
            "Zambia\n" +
            "Zimbabwe\n";
        return countries.split("\n");
    }

    @Property
    public void countryProperty(@ForAll("countries") String countries1,
                                @ForAll("countries") String countries2) {
        System.out.format("%s %s%n", countries1, countries2);
    }

    @Property
    public void countryListProperty(@ForAll List<@From("countries") String> countryList) {
        System.out.format("%s%n", countryList);
    }
}
