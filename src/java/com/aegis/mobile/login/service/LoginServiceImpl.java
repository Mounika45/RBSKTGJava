/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.mobile.login.service;

import com.aegis.mobile.login.dao.LoginDao;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginServiceLayer")
public class LoginServiceImpl implements LoginServiceLayer {

    @Autowired
    private LoginDao loginDao;

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public String serveOtpCal(JsonObject janso) {
        return loginDao.serveOtpCal(janso);
    }

//    @Override
//    public String serveOtpCal(String janso) {
//        return loginDao.serveOtpCal(janso);
//    }

    @Override
    public String schoolDetails(String janso) {
        return loginDao.schoolDetails(janso);
    }

    @Override
    public String convertFile(JsonObject jo) {
        return loginDao.convertFile(jo);
    }

    @Override
    public String scheduleDetails(String teamCode, String fromdate, String todate) {
        return loginDao.scheduleDetails(teamCode, fromdate, todate);
    }

    @Override
    public String syncDetails(JsonObject jo) {
        return loginDao.syncDetails(jo);
    }

    @Override
    public String studentDetails(String janso, String fromdate, String todate) {
        return loginDao.studentDetails(janso, fromdate, todate);
    }

    @Override
    public String teamwiseDetails(String janso, String fromdate, String todate) {
        return loginDao.teamwiseDetails(janso, fromdate, todate);
    }

    @Override
    public String districtwiseTean(int janso) {
        return loginDao.districtwiseTean(janso);
    }

    @Override
    public String districtwiseCenters(int janso) {
        return loginDao.districtwiseCenters(janso);
    }

    @Override
    public String teamwiseStatusDetails(String janso, String fromdate, String todate) {
        return loginDao.teamwiseStatusDetails(janso, fromdate, todate);
    }

    @Override
    public String preliminaryFindings(String janso, String fromdate, String todate, int findingId) {
        return loginDao.preliminaryFindings(janso, fromdate, todate, findingId);
    }

    /* public String syncTimeSheetDetails(JsonObject jo){
          return loginDao.syncTimeSheetDetails(jo);
      }*/
    
    @Override
    public String syncDetailsChildAbs(JsonObject jo) {
        return loginDao.syncDetailsChildAbs(jo);
    }

    @Override
    public String versionDetailsGet() {
        return loginDao.versionDetailsGet();
    }

    @Override
    public String syncOtherFindingDtls(JsonObject jo) {
        return loginDao.syncOtherFindingDtls(jo);
    }

    @Override
    public String syncFindingImagesForYesDtls(JsonObject jo) {
        return loginDao.syncFindingImagesForYesDtls(jo);
    }

    @Override
    public String validateDEICUser(JsonObject jo) {
        return loginDao.validateDEICUser(jo);
    }

    @Override
    public String getStudentMaster(JsonObject jo) {
        return loginDao.getStudentMaster(jo);
    }

    @Override
    public String getChildMasterFromSchool(JsonObject jo) {
        return loginDao.getChildMasterFromSchool(jo);
    }

    @Override
    public String getChildMasterFromAnthropometry(JsonObject jo) {
        return loginDao.getChildMasterFromAnthropometry(jo);
    }

    @Override
    public String getTreatmentCompletedChildList(JsonObject jo) {
        return loginDao.getTreatmentCompletedChildList(jo);
    }

    @Override
    public String saveAfterScreeningImgDtls(JsonObject jo) {
        return loginDao.saveAfterScreeningImgDtls(jo);
    }

    @Override
    public String getMandalFromTeamCode(JsonObject jo) {
        return loginDao.getMandalFromTeamCode(jo);
    }

    @Override
    public String saveRescheduleDates(JsonObject jo) {
        return loginDao.saveRescheduleDates(jo);
    }

    @Override
    public String getTabletMaster(JsonObject jo) {
        return loginDao.getTabletMaster(jo);
    }
}