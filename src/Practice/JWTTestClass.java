package Practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

import java.net.HttpURLConnection;
import java.net.URL;
import io.jsonwebtoken.impl.DefaultClaims;
import org.apache.xpath.operations.Bool;

import javax.xml.bind.DatatypeConverter;

public class JWTTestClass {
    private static Map<String,String> falUserGroups = new HashMap<>();
    private static Map<String,String> fboUserGroups = new HashMap<>();
    private static Map<String,String> fpdsUserGroups = new HashMap<>();
    private static Map<String,Map<String,String>> userGroupsMSTR = new HashMap<>();
    static {
        falUserGroups.put("Assistance Listings Grand User","ASSISTANCE_LISTING_GRAND_USER");
        falUserGroups.put("Assistance Administrator","ASSISTANCE_ADMIN");
        falUserGroups.put("Assistance User","ASSISTANCE_USER");
        falUserGroups.put("OMB Administrator","OMB_ADMIN");
        falUserGroups.put("OMB Analyst","OMB_ANALYST");

        fpdsUserGroups.put("Contract Data Grand User","CONTRACT_DATA_GRAND_USER");
        fpdsUserGroups.put("NASA Contracting Officer Administrator","NASA_CO_ADMIN");
        fpdsUserGroups.put("DOD Contracting Officer Administrator","DOD_CO_ADMIN");
        fpdsUserGroups.put("Contracting Officer Administrator","CO_ADMIN");
        fpdsUserGroups.put("NASA Contracting Specialist","NASA_CONTRACTING_OFFICER");
        fpdsUserGroups.put("DOD Contracting Specialist","DOD_CONTRACTING_OFFICER");
        fpdsUserGroups.put("Contracting Specialist","CONTRACTING_OFFICER");
        fpdsUserGroups.put("NASA Contracting Officer","NASA_CONTRACTING_OFFICER");
        fpdsUserGroups.put("DOD Contracting Officer","DOD_CONTRACTING_OFFICER");
        fpdsUserGroups.put("Contracting Officer","CONTRACTING_OFFICER");

        userGroupsMSTR.put("Contract Opportunities",fboUserGroups);
        userGroupsMSTR.put("Assistance Listings",falUserGroups);
        userGroupsMSTR.put("Contract Data",fpdsUserGroups);
    }


    public static DefaultClaims validateJWT(String jwtToken) {
        System.out.println("Started getJWTPublicKey");

        try {
            System.out.println("getJWTPublicKey - parsing jwt token");
            //Jwts.parser().setSigningKey(getJWTPublicKey()).parseClaimsJws(jwtToken).getBody();
            System.out.println("getJWTPublicKey - returning true");
            return (DefaultClaims) Jwts.parser().setSigningKey(getJWTPublicKey()).parse(jwtToken).getBody();
        } catch (GeneralSecurityException e) {
            System.err.println(String.format("Unable to create public key: %s", e.getMessage()));
        } catch (SignatureException e) {
            System.err.println(String.format("Signature error: %s", e.getMessage()));
        } catch (ExpiredJwtException e) {
            System.err.println(String.format("Expired JWT found: %s", e.getMessage()));
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e) {
            System.err.println(String.format("Malformed JWT found: %s", e.getMessage()));
        }

        return null;
    }

    public static Map<String,Set<String>> userRoles(DefaultClaims claims){
        Map<String,Map<String,Set<String>>> domainRoleUsers = new HashMap<>();
        Map<String,Set<String>> domainUserRoles = new HashMap<>();
        Map<String,String> domainScheduleRoleMap = new HashMap<>();
        domainScheduleRoleMap.put("Contract Opportunities","Contract Opportunities Schedule User");
        domainScheduleRoleMap.put("Contract Data","Contract Data Schedule User");
        domainScheduleRoleMap.put("Assistance Listing","Assistance Listings Schedule User");
        if (claims.get("domainMapContent") == null) {
            return domainUserRoles;
        }
        List<LinkedHashMap> domainMapContent = (ArrayList<LinkedHashMap>) claims.get("domainMapContent");
        System.out.println("***"+domainMapContent);
        Set<String> getOrgIds = new HashSet<>();

        Map<String,Map<String,Set<String>>> domainRoleOrgsIds = new HashMap<>();
        Map<String,Boolean> domainSchedulePermission = new HashMap<>();
        for (LinkedHashMap domainMap : domainMapContent) {
            LinkedHashMap domain = (LinkedHashMap) domainMap.get("domain");
            String domainStatic = (String) domain.get("staticVal");
            Boolean isScheduleUser = false;
            System.out.println("checkIAMRole - domain staticVal " + domainStatic);
            List<LinkedHashMap> roleMapContent = (ArrayList<LinkedHashMap>) domainMap.get("roleMapContent");
            Set<String> userDomainRole = new HashSet<>();
            Map<String,Set<String>> roleOrgIds = new HashMap<>();
            for (LinkedHashMap roleMap : roleMapContent) {
                LinkedHashMap r = (LinkedHashMap) roleMap.get("role");
                String roleStatic = (String) r.get("staticVal");
                List<LinkedHashMap> orgMap = (ArrayList<LinkedHashMap>) roleMap.get("organizationMapContent");
                Set<String> orgIds = getOrgId(orgMap);
                if(!isScheduleUser){
                    boolean scheduleUser = getReportingAccess(orgMap);
                    if(scheduleUser){
                        isScheduleUser = scheduleUser;
                        String scheduleUserRole = domainScheduleRoleMap.get(domainStatic);
                        roleOrgIds.put(scheduleUserRole,orgIds);
                        userDomainRole.add(scheduleUserRole);
                    }
                }
                roleOrgIds.put(roleStatic,orgIds);
                getOrgIds.addAll(orgIds);
                System.out.println("checkIAMRole - role staticVal " + roleStatic);
                userDomainRole.add(roleStatic);
            }
            domainRoleOrgsIds.put(domainStatic,roleOrgIds);
            domainSchedulePermission.put(domainStatic,isScheduleUser);
            System.out.println("userroles"+userDomainRole);
            domainUserRoles.put(domainStatic,userDomainRole);
        }
        Map<String,String> userOrgNames = isOrgOrChildOfOrg(getOrgIds);
        // Manipulate CD Roles with permissions
        if(userOrgNames.containsValue("NATIONAL AERONAUTICS AND SPACE ADMINISTRATION") || userOrgNames.containsValue("DEPARTMENT OF DEFENSE")){
            System.out.println("*****************"+domainUserRoles);
            addNewRoleToUser(domainUserRoles,userOrgNames,domainRoleOrgsIds,"Agency Specific");
        }
        else{
            addNewRoleToUser(domainUserRoles,userOrgNames,domainRoleOrgsIds,"All Roles");
        }
        System.out.println(userOrgNames.containsValue("TRANSPORTATION, DEPARTMENT OF"));
        System.out.println(domainRoleOrgsIds);
        System.out.println("UserDomainRoles - "+domainUserRoles);
        System.out.println(userGroupsMSTR);
        System.out.println("Domain Schedule Permissions --------- "+domainSchedulePermission);
        for(String s : userGroupsMSTR.keySet()){
            System.out.println("CharanTest"+s);
            Map<String,String> grps = userGroupsMSTR.get(s);
            System.out.println(grps);
        }
        System.out.println("Domain Roles"+domainUserRoles);
        return domainUserRoles;
    }


    // Checks if user has Schedule Reports Permission
    private static Boolean getReportingAccess(List<LinkedHashMap> orgMaps) {
        Boolean isScheduleUser = false;
        if(orgMaps != null){
            for(LinkedHashMap orgMap : orgMaps){
                List<LinkedHashMap> functionContent = (ArrayList<LinkedHashMap>)orgMap.get("functionMapContent");
                for(LinkedHashMap content:functionContent){
                    LinkedHashMap functionType = (LinkedHashMap) content.get("function");
                    if(functionType.get("staticVal").equals("Reports")){
                        List<LinkedHashMap> permissionSets = (ArrayList<LinkedHashMap>)content.get("permission");
                        for(LinkedHashMap permissionSet:permissionSets){
                            if(permissionSet.get("val").equals("Schedule Reports")){
                                isScheduleUser = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return isScheduleUser;
    }

    private static void addNewRoleToUser(Map<String,Set<String>> roles,Map<String,String> userOrgName,Map<String,Map<String,Set<String>>> roleOrgIds, String domainRole){
        Set<String> userRoles = roles.get("Contract Data");
        System.out.println("#######"+userRoles);
        Map<String,Set<String>> userMap = roleOrgIds.get("Contract Data");
        Set<String> newRoles = new HashSet<>();
        System.out.println("DomianRole******************************"+domainRole);
        for(String s:userRoles){
            System.out.println("UserRoles"+s);
            System.out.println(userMap);
            Set<String> orgIds = userMap.get(s);
            if(domainRole.equals("Agency Specific") && null !=orgIds){
                System.out.println("OrgName***********"+orgIds);
                for(String q:orgIds){
                    System.out.println("177"+q);
                    System.out.println(s);
                    System.out.println("OrgName***********"+userOrgName.get(q));
                    if(userOrgName.get(q).equals("DEPARTMENT OF DEFENSE")){
                        System.out.println("Inside DOD***********");
                        newRoles.add("DOD "+s);
                        System.out.println(newRoles);
                    }
                    else if(userOrgName.get(q).equals("NATIONAL AERONAUTICS AND SPACE ADMINISTRATION")){
                        newRoles.add("NASA "+s);
                    }
                }
            }
            else{
                if(s.equals("Contract Data Schedule User")){
                    newRoles.add(s);
                }else{
                    newRoles.add("Contract Data "+s);
                }
            }
        }
        System.out.println("NewRoles****"+newRoles);
        roles.put("Contract Data",newRoles);
    }

    private static Set<String> getOrgId(List<LinkedHashMap> orgMaps){
        Set<String> orgIds = new HashSet<>();
        if(orgMaps != null){
            System.out.println("checkIAMRole - additional checking: extracting organization map content");
            for(LinkedHashMap orgMap : orgMaps){
                List<String> oArray = (ArrayList<String>) orgMap.get("organizations");
                if(oArray != null){
                    for(String orgId : oArray){
                        orgIds.add(orgId);
                    }
                }
            }
            return orgIds;
        }
        else {
            return null;
        }
    }

    private static Map<String,String> isOrgOrChildOfOrg(Set<String> orgIds) {
        Map<String,String> orgNames = new HashMap<>();
        JsonNode orgInfoObj = getOrgHierarchy(orgIds);
        System.out.println("isOrgOrChildOfOrg - making call to get api response, orgInfo is not null: " + (orgInfoObj != null));

        // now that we have the response we just grab the l1Name property
        System.out.println("isOrgOrChildOfOrg - making call to grab embedded prop");
        JsonNode embedded = orgInfoObj.get("_embedded");
        if(embedded != null){
            System.out.println("isOrgOrChildOfOrg - embedded is not null");
            System.out.println("isOrgOrChildOfOrg - making call to grab orgs prop");
            JsonNode orgs = embedded.get("orgs");
            if(orgs != null){
                System.out.println("isOrgOrChildOfOrg - orgs is not null");
                System.out.println("isOrgOrChildOfOrg - making call to grab first element of orgs array");
                for(JsonNode org:orgs){
                    System.out.println("ORG"+org);
                    System.out.println(org.get("org"));
                    orgNames.put(org.get("org").get("orgKey").asText(),org.get("org").get("l1Name").asText());

                }
//                JsonNode orgObject = orgs.get(0);
////                if(orgObject != null){
////                    System.out.println("isOrgOrChildOfOrg - first element of orgs array is not null");
////                    System.out.println("isOrgOrChildOfOrg - grabbing the org property");
////                    JsonNode org = orgObject.get("org");
////                    if(org != null){
////                        System.out.println("isOrgOrChildOfOrg - org object is not null");
////                        String l1Name = org.get("l1Name").asText();
////                        if(l1Name != null && l1Name != ""){
////                            System.out.println(l1Name);
//////                            System.out.println("isOrgOrChildOfOrg - l1Name is stored as: " + l1Name);
//////                            System.out.println("isOrgOrChildOfOrg - l1Name prop is equal to our orgName provided: " + (l1Name.equalsIgnoreCase(orgName)));
//////                            return l1Name.equalsIgnoreCase(orgName);
////                        }
////                    }
////                }
            }
        }
        System.out.println("OrgNames    "+orgNames);
        return orgNames;
    }

    // this is the actual api call to search for the org
    private static JsonNode getOrgHierarchy(Set<String> orgIds){
        JsonNode response = null;
        HttpURLConnection conn = null;
        try {
            System.out.println("getOrgHierarchy - building iam request");
            System.out.println(String.join(",", orgIds));
            String tokenInfoEndpoint = String.format("%s/federalorganizations/v1/organizations?api_key=%s&orgKey=%s", "https://api.sam.gov/prod", "llgpVNeqT8VEU0s4h8xkk71dPUMHFkIDehOdBfEl", String.join(",", orgIds));
            System.out.println("here is our constructed endpoint url: " + tokenInfoEndpoint);
            URL url = new URL(tokenInfoEndpoint);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                System.out.println("getOrgHierarchy - request failed: " + conn.getResponseCode());
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            System.out.println("getOrgHierarchy - reading response");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder json = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }

            System.out.println("getOrgHierarchy - response : " + json.toString());
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.readTree(json.toString());

            conn.disconnect();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        System.out.println("getOrgHierarchy - returning response : " + response.toString());
        return response;
    }

    public static PublicKey getJWTPublicKey() throws GeneralSecurityException {
        System.out.println("Started getJWTPublicKey");
        byte[] data = DatatypeConverter.parseBase64Binary("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEHZe0/S9px+yvJzDTou6r0kCPkYCmw1zrNY2/iHXGpkl0pDqCa6tg8EP29f+Bp3Kb5ruTeFZy3aC7Yc2038NkMw==");
        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        KeyFactory fact = KeyFactory.getInstance("EC");
        System.out.println("getJWTPublicKey - returning key");
        System.out.println(fact.generatePublic(spec));
        return fact.generatePublic(spec);
    }

    public static void main(String[] args){
        String jwtToken = "eyJhbGciOiJFUzI1NiJ9.eyJkb21haW5NYXBDb250ZW50IjpbeyJkb21haW4iOnsiaWQiOjEsInZhbCI6IkNvbnRyYWN0IERhdGEiLCJzdGF0aWNWYWwiOiJDb250cmFjdCBEYXRhIn0sInJvbGVNYXBDb250ZW50IjpbeyJyb2xlIjp7ImlkIjo2OCwidmFsIjoiQWRtaW5pc3RyYXRvciIsInN0YXRpY1ZhbCI6IkNvbnRyYWN0aW5nIE9mZmljZXIgQWRtaW5pc3RyYXRvciJ9LCJvcmdhbml6YXRpb25NYXBDb250ZW50IjpbeyJvcmdhbml6YXRpb25zIjpbIjEwMDAwNjY4OCJdLCJmdW5jdGlvbk1hcENvbnRlbnQiOlt7ImZ1bmN0aW9uIjp7ImlkIjowLCJ2YWwiOiJST0xFIEFETUlOSVNUUkFUSU9OIiwic3RhdGljVmFsIjoiUk9MRSBBRE1JTklTVFJBVElPTiJ9LCJwZXJtaXNzaW9uIjpbeyJpZCI6NywidmFsIjoiQ29udHJhY3RpbmcgT2ZmaWNlciIsImlzRGVmYXVsdCI6ZmFsc2V9LHsiaWQiOjgsInZhbCI6IkNvbnRyYWN0aW5nIFNwZWNpYWxpc3QiLCJpc0RlZmF1bHQiOmZhbHNlfV19LHsiZnVuY3Rpb24iOnsiaWQiOjE2LCJ2YWwiOiJPdGhlclRyYW5zYWN0aW9uIEF3YXJkL0lEViIsInN0YXRpY1ZhbCI6Ik90aGVyVHJhbnNhY3Rpb24gQXdhcmQvSURWIn0sInBlcm1pc3Npb24iOlt7ImlkIjo1MiwidmFsIjoiRGVsZXRlIn0seyJpZCI6NTQsInZhbCI6IkRlbGV0ZSBEcmFmdCJ9LHsiaWQiOjg4LCJ2YWwiOiJDcmVhdGUvVmFsaWRhdGUvSXNDb21wbGV0ZS9Nb2RpZnkifSx7ImlkIjo4OSwidmFsIjoiQ29ycmVjdC9VcGRhdGUifSx7ImlkIjo5MCwidmFsIjoiVHJhbnNmZXIifSx7ImlkIjo5MSwidmFsIjoiQXBwcm92ZSJ9XX0seyJmdW5jdGlvbiI6eyJpZCI6MTcsInZhbCI6IkF3YXJkL0lEViIsInN0YXRpY1ZhbCI6IkF3YXJkL0lEViJ9LCJwZXJtaXNzaW9uIjpbeyJpZCI6NTIsInZhbCI6IkRlbGV0ZSJ9LHsiaWQiOjU0LCJ2YWwiOiJEZWxldGUgRHJhZnQifSx7ImlkIjo4OCwidmFsIjoiQ3JlYXRlL1ZhbGlkYXRlL0lzQ29tcGxldGUvTW9kaWZ5In0seyJpZCI6ODksInZhbCI6IkNvcnJlY3QvVXBkYXRlIn0seyJpZCI6OTAsInZhbCI6IlRyYW5zZmVyIn0seyJpZCI6OTEsInZhbCI6IkFwcHJvdmUifV19LHsiZnVuY3Rpb24iOnsiaWQiOjE0LCJ2YWwiOiJSZXBvcnRzIiwic3RhdGljVmFsIjoiUmVwb3J0cyJ9LCJwZXJtaXNzaW9uIjpbeyJpZCI6MjQwLCJ2YWwiOiJBZC1Ib2MgUmVwb3J0cyJ9LHsiaWQiOjI2MywidmFsIjoiU2NoZWR1bGUgUmVwb3J0cyJ9LHsiaWQiOjIzOSwidmFsIjoiUmVwb3J0IFVzZXIifV19LHsiZnVuY3Rpb24iOnsiaWQiOjE1LCJ2YWwiOiJVc2VyIiwic3RhdGljVmFsIjoiVXNlciJ9LCJwZXJtaXNzaW9uIjpbeyJpZCI6ODcsInZhbCI6IkFzc2lnbi9SZW1vdmUgUHJpdmlsZWdlcyJ9XX1dfV19XX1dLCJzdWIiOiJjaGFyYW4ubWFyZWVkdSthc3Npc3RhbmNldXNlckBnc2EuZ292IiwiaWF0IjoxNTUyMzE1NjYxLCJleHAiOjE1NTIzMTY1NjEsImF1ZCI6ImdzYSJ9.MEQCIAjXkURxMFfNa-On5N_MTCHPvtNurfk0HSiNOYytPEqwAiAM9wVjp5x3S-SknvK7Un6Yr4m6Rl07ylNPsHVBOFGFpQ";
        DefaultClaims defaultClaims = validateJWT(jwtToken);
        System.out.println("****"+defaultClaims);
        Map<String,Set<String>> userRoles = userRoles(defaultClaims);
        System.out.println(userRoles.size()==0);
        for(String s:userRoles.keySet()){
            System.out.println(s);
        }
        System.out.println(userRoles);
    }
}
