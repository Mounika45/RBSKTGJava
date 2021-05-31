/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.mobile.login.controllers;

import com.aegis.mobile.login.service.LoginServiceLayer;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pavani
 */
@RestController
//@Controller
@RequestMapping("/restControl")
public class ServiceContoller {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginService
     */
    public ServiceContoller() {
        System.out.println("in rbskAppTG controller");
    }
    @Autowired
    private LoginServiceLayer loginServiceLayer;

    public LoginServiceLayer getLoginServiceLayer() {
        return loginServiceLayer;
    }

    public void setLoginServiceLayer(LoginServiceLayer loginServiceLayer) {
        this.loginServiceLayer = loginServiceLayer;
    }

    @RequestMapping(value = "/get.htm", method = RequestMethod.GET)
    public @ResponseBody
    String checkMenthod() {

        try {
            //dataServices.deleteEntity(id);
            return "in get!";
        } catch (Exception e) {
            return "in catch!";
        }
    }

    @RequestMapping(value = "/getAuthOtp.htm", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String serValidationOtp(@RequestBody String jsonStr) {

        // System.out.println("in rest service Q & answ");
        //String response = "{\"status\":\"Failed\",\"Mess\":\"null\"}";
        // Session session = null;
        //Gson gson = new Gson();
        // Map<String, Object> result = new HashMap<String, Object>();
        String result = "";
        //response.setCharacterEncoding("utf-8");     
        try {
            // System.out.println("jsonStr::"+jsonStr);
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //System.out.println("jo::"+jo);
            String janso = jo.get("teamCode").getAsString();
            //System.out.println("in rest service before try");
            result = loginServiceLayer.serveOtpCal(jo);
            // System.out.println("result::"+result);
            return result;// response=loginService.updateLocation(usid,location);
        } catch (Exception e) {
            e.printStackTrace();
            // result.put("Status", "Failed");
            // result.put("message", "Unable to get Data for selected servey");
            result = "{\"Status\":\"Failed\",\"OtpMess\":\"Please check requested jsondata\"}";

            return result;
        }
    }
    
//    @RequestMapping(value = "/getAuthOtp.htm", method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    String serValidationOtp(@RequestBody String jsonStr) {
//
//        // System.out.println("in rest service Q & answ");
//        //String response = "{\"status\":\"Failed\",\"Mess\":\"null\"}";
//        // Session session = null;
//        //Gson gson = new Gson();
//        // Map<String, Object> result = new HashMap<String, Object>();
//        String result = "";
//        //response.setCharacterEncoding("utf-8");     
//        try {
//            // System.out.println("jsonStr::"+jsonStr);
//            JsonParser jsonParser = new JsonParser();
//            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
//            //System.out.println("jo::"+jo);
//            String janso = jo.get("teamCode").getAsString();
//            //System.out.println("in rest service before try");
//            result = loginServiceLayer.serveOtpCal(janso);
//            // System.out.println("result::"+result);
//            return result;// response=loginService.updateLocation(usid,location);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // result.put("Status", "Failed");
//            // result.put("message", "Unable to get Data for selected servey");
//            result = "{\"Status\":\"Failed\",\"OtpMess\":\"Please check requested jsondata\"}";
//
//            return result;
//        }
//    }
    
    @RequestMapping(value = "/getMandalFromTeamCode.htm", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getMandalFromTeamCode(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getMandalFromTeamCode(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"Status\":\"Failed\",\"OtpMess\":\"Please check requested jsondata\"}";

            return result;
        }
    }
    
    @RequestMapping(value = "/getSchoolDetails.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String schoolDetails(@RequestBody String jsonStr) {
        String result = "";
        try {

            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //System.out.println("jo::"+jo);
            String janso = jo.get("teamId").getAsString();
            //System.out.println("in rest service before try");
            result = loginServiceLayer.schoolDetails(janso);
            // System.out.println("result::"+result);
            return result;// response=loginService.updateLocation(usid,location);
        } catch (Exception e) {
            e.printStackTrace();
            // result.put("Status", "Failed");
            // result.put("message", "Unable to get Data for selected servey");
            result = "{\"status\":\"Failed\",\"Message\":\"Please check requested jsondata\"}";

            return result;
        }
    }

    @RequestMapping(value = "/upload.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String uploadCit(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            String filName = (jo.get("file_name").toString()).replaceAll("\"", "");
            result = loginServiceLayer.convertFile(jo);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            // result.put("Status", "Failed");
            //result.put("statusMessage", "Problem with request");
            //result.put("serId", null);
            return result;
        }

        //Prints my json object
        // return avc;
    }

    @RequestMapping(value = "/scheduleDetails.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String scheduleDetails(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            String teamCode = (jo.get("teamCode").toString()).replaceAll("\"", "");
            String fromdate = (jo.get("fromdate").toString()).replaceAll("\"", "");
            String todate = (jo.get("todate").toString()).replaceAll("\"", "");
            result = loginServiceLayer.scheduleDetails(teamCode, fromdate, todate);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            // result.put("Status", "Failed");
            //result.put("statusMessage", "Problem with request");
            //result.put("serId", null);
            return result;
        }

        //Prints my json object
        // return avc;
    }

    @RequestMapping(value = "/saveDetails.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String syncDetails(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            System.out.println("SYNC OBJECT :::" + jo);
            //String teamCode=(jo.get("teamCode").toString()).replaceAll("\"","");
            result = loginServiceLayer.syncDetails(jo);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            // result.put("Status", "Failed");
            //result.put("statusMessage", "Problem with request");
            //result.put("serId", null);
            return result;
        }

        //Prints my json object
        // return avc;
    }

    @RequestMapping(value = "/getStudentReport.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String studentDetails(@RequestBody String jsonStr) {
        String result = "";
        try {

            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //System.out.println("jo::"+jo);
            String janso = jo.get("teamId").getAsString();
            String todate = jo.get("todate").getAsString();
            String fromdate = jo.get("fromdate").getAsString();
            //System.out.println("in rest service before try");
            result = loginServiceLayer.studentDetails(janso, fromdate, todate);
            //System.out.println("result::"+result);
            return result;// response=loginService.updateLocation(usid,location);
        } catch (Exception e) {
            e.printStackTrace();
            // result.put("Status", "Failed");
            // result.put("message", "Unable to get Data for selected servey");
            result = "{\"status\":\"Failed\",\"Message\":\"Please check requested jsondata\"}";

            return result;
        }
    }

    @RequestMapping(value = "/getTeamDataReport.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String teamCollDetails(@RequestBody String jsonStr) {
        String result = "";
        try {

            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //System.out.println("jo::"+jo);
            String janso = jo.get("teamId").getAsString();
            String todate = jo.get("todate").getAsString();
            String fromdate = jo.get("fromdate").getAsString();
            //System.out.println("in rest service before try");
            result = loginServiceLayer.teamwiseDetails(janso, fromdate, todate);
            //System.out.println("result::"+result);
            return result;// response=loginService.updateLocation(usid,location);
        } catch (Exception e) {
            e.printStackTrace();
            // result.put("Status", "Failed");
            // result.put("message", "Unable to get Data for selected servey");
            result = "{\"status\":\"Failed\",\"Message\":\"Please check requested jsondata\"}";

            return result;
        }
    }

    @RequestMapping(value = "/getTeamsDetails.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String distWiseTeam(@RequestBody String jsonStr) {

        // System.out.println("in rest service Q & answ");
        //String response = "{\"status\":\"Failed\",\"Mess\":\"null\"}";
        // Session session = null;
        //Gson gson = new Gson();
        // Map<String, Object> result = new HashMap<String, Object>();
        String result = "";
        //response.setCharacterEncoding("utf-8");     
        try {
            // System.out.println("jsonStr::"+jsonStr);
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //System.out.println("jo::"+jo);
            int janso = jo.get("districtId").getAsInt();
            //System.out.println("in rest service before try");
            result = loginServiceLayer.districtwiseTean(janso);
            // System.out.println("result::"+result);
            return result;// response=loginService.updateLocation(usid,location);
        } catch (Exception e) {
            e.printStackTrace();
            // result.put("Status", "Failed");
            // result.put("message", "Unable to get Data for selected servey");
            result = "{\"status\":\"Failed\",\"OtpMess\":\"Please check requested jsondata\"}";

            return result;
        }
    }

    @RequestMapping(value = "/getCentersDetails.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String distWiseCenters(@RequestBody String jsonStr) {

        // System.out.println("in rest service Q & answ");
        //String response = "{\"status\":\"Failed\",\"Mess\":\"null\"}";
        // Session session = null;
        //Gson gson = new Gson();
        // Map<String, Object> result = new HashMap<String, Object>();
        String result = "";
        //response.setCharacterEncoding("utf-8");     
        try {
            // System.out.println("jsonStr::"+jsonStr);
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //System.out.println("jo::"+jo);
            int janso = jo.get("districtId").getAsInt();
            //System.out.println("in rest service before try");
            result = loginServiceLayer.districtwiseCenters(janso);
            // System.out.println("result::"+result);
            return result;// response=loginService.updateLocation(usid,location);
        } catch (Exception e) {
            e.printStackTrace();
            // result.put("Status", "Failed");
            // result.put("message", "Unable to get Data for selected servey");
            result = "{\"status\":\"Failed\",\"OtpMess\":\"Please check requested jsondata\"}";

            return result;
        }
    }

    //PRO_RPT_TEAM_PSTATUS_Android
    @RequestMapping(value = "/getTeamStatusReport.htm", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String teamCollStatusDetails(@RequestBody String jsonStr) {
        String result = "";
        try {

            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //System.out.println("jo::"+jo);
            String janso = jo.get("teamId").getAsString();
            String todate = jo.get("todate").getAsString();
            String fromdate = jo.get("fromdate").getAsString();
            //System.out.println("in rest service before try");
            result = loginServiceLayer.teamwiseStatusDetails(janso.trim(), fromdate, todate);
            //System.out.println("result::"+result);
            return result;// response=loginService.updateLocation(usid,location);
        } catch (Exception e) {
            e.printStackTrace();
            // result.put("Status", "Failed");
            // result.put("message", "Unable to get Data for selected servey");
            result = "{\"status\":\"Failed\",\"Message\":\"Please check requested jsondata\"}";

            return result;
        }
    }

    //public String preliminaryFindings(String janso, String fromdate, String todate,int findingId){
    @RequestMapping(value = "/getpreliminaryFindings.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String preliminaryFindings(@RequestBody String jsonStr) {
        String result = "";
        try {

            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //System.out.println("jo::"+jo);
            String janso = jo.get("teamId").getAsString();
            String todate = jo.get("todate").getAsString();
            String fromdate = jo.get("fromdate").getAsString();
            int findingId = jo.get("findingId").getAsInt();
            //System.out.println("in rest service before try");
            result = loginServiceLayer.preliminaryFindings(janso, fromdate, todate, findingId);
            //System.out.println("result::"+result);
            return result;// response=loginService.updateLocation(usid,location);
        } catch (Exception e) {
            e.printStackTrace();
            // result.put("Status", "Failed");
            // result.put("message", "Unable to get Data for selected servey");
            result = "{\"status\":\"Failed\",\"Message\":\"Please check requested jsondata\"}";

            return result;
        }
    }

    /*  @RequestMapping(value = "/saveTimeSheetDetails.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String syncTimeSheetDetails(@RequestBody String jsonStr) {
                String result = "";
		 try{
		 Gson myGson = new Gson();
		 JsonParser jsonParser = new JsonParser();
		 JsonObject jo = (JsonObject)jsonParser.parse(jsonStr);
		 //String teamCode=(jo.get("teamCode").toString()).replaceAll("\"","");
		 result=   loginServiceLayer.syncTimeSheetDetails(jo);
	          return result;
		 
		 }catch(Exception e){
			 
			 e.printStackTrace();
                         result="{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
                        // result.put("Status", "Failed");
                        //result.put("statusMessage", "Problem with request");
                        //result.put("serId", null);
                         return result;
		 }
	        
	        //Prints my json object
	       // return avc;
	    }*/
    @RequestMapping(value = "/saveChildAbsentDetails.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String syncDetailsChildAbs(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //String teamCode=(jo.get("teamCode").toString()).replaceAll("\"","");
            result = loginServiceLayer.syncDetailsChildAbs(jo);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            // result.put("Status", "Failed");
            //result.put("statusMessage", "Problem with request");
            //result.put("serId", null);
            return result;
        }
    }

    @RequestMapping(value = "/versionDetailsGet.htm", method = RequestMethod.GET)
    public @ResponseBody
    String versionDetailsGet() {
        String result = "";
        try {
            result = loginServiceLayer.versionDetailsGet();
            return result;
        } catch (Exception e) {
            return "in catch!";
        }
    }

    @RequestMapping(value = "/syncOtherFindingDtls.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String syncOtherFindingDtls(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //String teamCode=(jo.get("teamCode").toString()).replaceAll("\"","");
            result = loginServiceLayer.syncOtherFindingDtls(jo);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            // result.put("Status", "Failed");
            //result.put("statusMessage", "Problem with request");
            //result.put("serId", null);
            return result;
        }
    }

    @RequestMapping(value = "/syncFindingImagesForYesDtls.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String syncFindingImagesForYesDtls(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //String teamCode=(jo.get("teamCode").toString()).replaceAll("\"","");
            result = loginServiceLayer.syncFindingImagesForYesDtls(jo);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            // result.put("Status", "Failed");
            //result.put("statusMessage", "Problem with request");
            //result.put("serId", null);
            return result;
        }
    }

    @RequestMapping(value = "/validateDEICUser.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String validateDEICUser(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.validateDEICUser(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/getStudentMaster.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getStudentMaster(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getStudentMaster(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/getChildMasterFromSchool.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getChildMasterFromSchool(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getChildMasterFromSchool(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/getChildMasterFromAnthropometry.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getChildMasterFromAnthropometry(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getChildMasterFromAnthropometry(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/getTreatmentCompletedChildList.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getTreatmentCompletedChildList(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getTreatmentCompletedChildList(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/saveAfterScreeningImgDtls.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String saveAfterScreeningImgDtls(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.saveAfterScreeningImgDtls(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/saveRescheduleDates.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String saveRescheduleDates(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.saveRescheduleDates(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/getTabletMaster.htm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getTabletMaster(@RequestBody String jsonStr) {
        String result = "";
        try {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getTabletMaster(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
}
