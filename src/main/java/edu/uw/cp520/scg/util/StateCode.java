package edu.uw.cp520.scg.util;


import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * StateCode Enum
 */
public enum StateCode {

    AL("Alabama"),
    AK("Alaska"),
    AB("Alberta"),
    AS("American Samoa"),
    AZ("Arizona"),
    AR("Arkansas"),
    AE("Armed Forces (AE)"),
    AA("Armed Forces Americas"),
    AP("Armed Forces Pacific"),
    BC("British Columbia"),
    CA("California"),
    CO("Colorado"),
    CT("Connecticut"),
    DE("Delaware"),
    DC("District Of Columbia"),
    FL("Florida"),
    GA("Georgia"),
    GU("Guam"),
    HI("Hawaii"),
    ID("Idaho"),
    IL("Illinois"),
    IN("Indiana"),
    IA("Iowa"),
    KS("Kansas"),
    KY("Kentucky"),
    LA("Louisiana"),
    ME("Maine"),
    MB("Manitoba"),
    MD("Maryland"),
    MA("Massachusetts"),
    MI("Michigan"),
    MN("Minnesota"),
    MS("Mississippi"),
    MO("Missouri"),
    MT("Montana"),
    NE("Nebraska"),
    NV("Nevada"),
    NB("New Brunswick"),
    NH("New Hampshire"),
    NJ("New Jersey"),
    NM("New Mexico"),
    NY("New York"),
    NF("Newfoundland"),
    NC("North Carolina"),
    ND("North Dakota"),
    NT("Northwest Territories"),
    NS("Nova Scotia"),
    NU("Nunavut"),
    OH("Ohio"),
    OK("Oklahoma"),
    ON("Ontario"),
    OR("Oregon"),
    PA("Pennsylvania"),
    PE("Prince Edward Island"),
    PR("Puerto Rico"),
    QC("Quebec"),
    RI("Rhode Island"),
    SK("Saskatchewan"),
    SC("South Carolina"),
    SD("South Dakota"),
    TN("Tennessee"),
    TX("Texas"),
    UT("Utah"),
    VT("Vermont"),
    VI("Virgin Islands"),
    VA("Virginia"),
    WA("Washington"),
    WV("West Virginia"),
    WI("Wisconsin"),
    WY("Wyoming"),
    YT("Yukon Territory");

    private static Map<String,StateCode> stateNameMap;

    static {
//        stateNameMap = new HashMap<>();
//        for(final StateCode code : values()) {
//            stateNameMap.put(code.stateName.toUpperCase(Locale.US),code);
//        }

        stateNameMap = Stream.of(StateCode.values())
                .collect(Collectors.toMap(c -> c.stateName.toUpperCase(Locale.US),c -> c));
    }

    private String stateName;

    private StateCode(final String stateName) {
        this.stateName = stateName;
    }

    public static StateCode forName(final String stateName) {
        return stateNameMap.get(stateName.toUpperCase(Locale.US));
    }

    public String getName() {
        return stateName;
    }


}
