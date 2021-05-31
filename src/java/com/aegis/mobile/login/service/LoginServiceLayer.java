/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.mobile.login.service;


import com.google.gson.JsonObject;

/**
 *
 * @author
 */
public interface LoginServiceLayer {

    public String serveOtpCal(JsonObject janso);
    
    //public String serveOtpCal(String janso);

    public String schoolDetails(String janso);
    
    public String convertFile(JsonObject jo);

    public String scheduleDetails(String teamCode, String fromdate, String todate);

    public String syncDetails(JsonObject jo);

    public String studentDetails(String janso, String fromdate, String todate);

    public String teamwiseDetails(String janso, String fromdate, String todate);
    
    public String districtwiseTean(int janso);
    
    public String districtwiseCenters(int janso);

    public String teamwiseStatusDetails(String janso, String fromdate, String todate);

    public String preliminaryFindings(String janso, String fromdate, String todate, int findingId);

   // public String syncTimeSheetDetails(JsonObject jo);

    public String syncDetailsChildAbs(JsonObject jo);

    public String versionDetailsGet();

    public String syncOtherFindingDtls(JsonObject jo);

    public String syncFindingImagesForYesDtls(JsonObject jo);

    public String validateDEICUser(JsonObject jo);

    public String getStudentMaster(JsonObject jo);

    public String getChildMasterFromSchool(JsonObject jo);

    public String getChildMasterFromAnthropometry(JsonObject jo);

    public String getTreatmentCompletedChildList(JsonObject jo);

    public String saveAfterScreeningImgDtls(JsonObject jo);

    public String getMandalFromTeamCode(JsonObject jo);

    public String saveRescheduleDates(JsonObject jo);

    public String getTabletMaster(JsonObject jo);
}
