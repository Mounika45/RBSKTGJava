
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.mobile.login.dao;

//import com.aegis.entities.MCenters;
//import com.aegis.entities.MCentertypes;
import com.aegis.entities.AndroidVersionControl;
import com.aegis.entities.MAcademicyear;
import com.aegis.entities.MChild;
import com.aegis.entities.MChildAddress;
import com.aegis.entities.MDesignation;
import com.aegis.entities.MDistrict;
import com.aegis.entities.MFinding;
import com.aegis.entities.MHospital;
import com.aegis.entities.MHospitaltype;
import com.aegis.mobile.common.HibernateDao;
import com.aegis.mobile.common.OTP;
//import com.aegis.entities.MChildren;
import com.aegis.entities.MMandal;
import com.aegis.entities.MPhc;
import com.aegis.entities.MSchool;
import com.aegis.entities.MSchoolcategory;
import com.aegis.entities.MSchoolquestion;
import com.aegis.entities.MStatus;
import com.aegis.entities.MTeam;
import com.aegis.entities.MTeammember;
import com.aegis.entities.MVillage;
import com.aegis.entities.TAnthropometry;
import com.aegis.entities.TChildacademy;
import com.aegis.entities.TFinding;
//import com.aegis.entities.TGeneralmedicalquestionanswer;
//import com.aegis.entities.TGeneralmedicalquestionanswer;
import com.aegis.entities.TSchoolquestionanswer;
import com.aegis.entities.TScreentimelog;
import com.aegis.entities.TTeamschedule;
import com.aegis.entities.TfindingImages;
//import com.aegis.entities.TimmunizationQuesAns;
//import com.aegis.entities.TfindingsWithoutReferels;
import com.aegis.entities.TotherFindings;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
//import com.itextpdf.text.pdf.codec.Base64;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.icefaces.impl.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mahendra Reddy Bijjam
 */
@Repository("loginDao")
@Transactional
public class LoginDaoImpl extends HibernateDao implements LoginDao {

    // @SuppressWarnings("FieldMayBeFinal")
    private static Logger logger = Logger.getLogger(LoginDaoImpl.class);

    @Autowired
    public SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    final String SOURCE = "0123456789ABCDEFGHIJKLMNOPQRS1234567890TUVWXYZabcdefghijk1234567890lmnopqrstuvwxyz";
    Random rnd = new Random();

    public LoginDaoImpl() {
        logger.info("on DaoImpl");
    }

    @Override
    public String serveOtpCal(JsonObject janso) {
        String result = "";
        Session session = null;
        String messageTo = "";
        // Gson gson = new Gson();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            session = getSessionFactory().openSession();
            //String query = " FROM MTeam where code='" + janso + "' and CAST(CreatedDate as date) = '"+ format.format(new Date()) +"'";
            SQLQuery query = session.createSQLQuery("select Id,Code,DistrictId,value as MandalId,ReportPHCId,AssociatedPHCId,IMEINumber, IsActive,\n"
                    + "CreatedUserId, CreatedDate from m_team \n"
                    + "cross apply STRING_SPLIT (MandalId, ',') cs where code='" + janso.get("teamCode").getAsString() + "' and IsActive=1 ");
                            //+ "and value='" + janso.get("mandalid").getAsString() + "'");
            //System.out.println("query  ::" + query);
            List qlist = query.list();
            if (qlist.size() > 0) {
                //MTeam mTeams = (MTeam) qlist.get(0);
                Object[] os = (Object[]) qlist.get(0);
                MDesignation designation = (MDesignation) session.load(MDesignation.class, 1);
                MTeam mTeam = (MTeam) session.load(MTeam.class, (int) os[0]);
                Criteria criteria = session.createCriteria(MTeammember.class);
                //criteria.add(Restrictions.eq("teamId", mTeams.getId()));
                criteria.add(Restrictions.eq("teamId", mTeam));
                criteria.add(Restrictions.eq("designationId", designation));

                List regList = criteria.list();
                if (regList != null && regList.size() > 0) {
                    MTeammember mTeammember = (MTeammember) regList.get(0);

                    //MTeammember mTeammember = (MTeammember) criteria.uniqueResult();
                    //if(mTeammember!=null){
                    String phNo = mTeammember.getMobileNumber();
                    System.out.println("phNo  ::" + phNo);
                    String key = phNo.substring(0, 8);
                    System.out.println("key::" + key + " System.currentTimeMillis()::" + System.currentTimeMillis());
                    String otpString = "";
                    for (int i = 0; i < 10; i++) {
                        otpString = OTP.generate("" + key, "" + System.currentTimeMillis(), 6, "totp");

                        System.out.println(otpString);
                    }
                    //result = "{\"status\":\"Success\",\"team_id\":\"" + mTeams.getId() + "\",\"OtpMess\":\"" + otpString + "\"}";
                    result = "{\"status\":\"Success\",\"team_id\":\"" + os[0] + "\",\"OtpMess\":\"" + otpString + "\"}";
                    messageTo = " One Time password to continue is " + otpString;
                    System.out.println("otpString::" + otpString);
                    sendSms(phNo, messageTo, session);
                } else {
                    result = "{\"status\":\"Failed\",\"OtpMess\":\"No team\"}";
                }
            } else {
                result = "{\"status\":\"Failed\",\"OtpMess\":\"Wrong team code\"}";
            }
            //TtOtp otp=session.load(null, seed,);
        } catch (Exception ex) {
            ex.printStackTrace();
            // result.put("status", "Success");
            //   result.put("message", "Currently no data available for selected servey");
            result = "{\"status\":\"Failed\",\"OtpMess\":\"Problem with the request\"}";

            return result;
        }
        return result;
    }
    
//    @Override
//    public String validateUser(JsonObject json){
//        
//    }

    @Override
    public String getMandalFromTeamCode(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonArray jsa = new JsonArray();
        session = getSessionFactory().openSession();

        try {
            SQLQuery query = session.createSQLQuery("select  tm.Id,tm.code,tm.DistrictId,cs.Value as MandalId,tm.ReportPHCId, m.Name --SplitData\n"
                    + "from m_team tm cross apply STRING_SPLIT (MandalId, ',') cs\n"
                    + "inner join m_mandal m on value = m.Id where tm.IsActive=1 AND tm.DistrictId=" + jo.get("districtId").getAsString()
                    + " AND tm.Code = '" + jo.get("teamcode").getAsString() + "'");

            List list = query.list();
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    Object[] os = (Object[]) list.get(i);
                    JsonObject userObj = new JsonObject();

                    userObj.addProperty("id", "" + os[0]);
                    userObj.addProperty("teamcode", "" + os[1]);
                    userObj.addProperty("districtId", "" + os[2]);
                    userObj.addProperty("mandalid", "" + os[3]);
                    userObj.addProperty("reportPHCId", "" + os[4]);
                    userObj.addProperty("mandalname", "" + os[5]);

                    jsa.add(userObj);
                    System.out.println("jsa" + jsa);
                }
                result = "{\"status\":\"Success\",\"responseArray\" :" + jsa + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Data not available\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\", \"statusMessage\":" + e + "}";
            if (session != null) {
                e.printStackTrace();
                session.close();
            }
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //sms integration 
    public static HttpURLConnection sendSms(String mobileNo, String message, Session sess) {
        /*HttpURLConnection connection = null;
        String username = "MEESEVA";
        String senderId = "MESEVA";
        String password = "1qaz!QAZ";
        try {
            char ch = 0;
            URL url = new URL("http://msdgweb.mgov.gov.in/esms/sendsmsrequest");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setFollowRedirects(true);
            String msg = URLEncoder.encode(message, "UTF-8");
            // System.out.println("msg" + msg);
            String smsservicetype = "singlemsg";

            String query = "username=" + URLEncoder.encode(username) + "&password=" + URLEncoder.encode(password) + "&smsservicetype="
                    + URLEncoder.encode(smsservicetype) + "&content=" + URLEncoder.encode(message) + "&mobileno="
                    + URLEncoder.encode(mobileNo) + "&senderid=" + URLEncoder.encode(senderId);

            connection.setRequestProperty("Content-length", String.valueOf(query.length()));
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");

            // open up the output stream of the connection
            DataOutputStream output = new DataOutputStream(connection.getOutputStream());

            // write out the data
            int queryLength = query.length();
            output.writeBytes(query);
            // output.close();

            // get ready to read the response from the cgi script
            DataInputStream input = new DataInputStream(connection.getInputStream());

            // read in each character until end-of-stream is detected
            for (int c = input.read(); c != -1; c = input.read()) {
                //  System.out.print((char) c);
            }
            input.close();

        } catch (Exception e) {
            //System.out.println("Something bad just happened.");
            connection = null;
            e.printStackTrace();
        } finally {
        }
        return connection;*/
        HttpURLConnection connection = null;
        String username = "aegistrans";
        String senderId = "COMMAG";
        String password = "ifZ87Cjb";
        String type = "0";
        String dlr = "1";
        try {
            char ch = 0;
            URL url = new URL("http://sms6.routesms.com:8080/bulksms/bulksms?");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setFollowRedirects(true);
            String msg = URLEncoder.encode(message, "UTF-8");
            // System.out.println("msg" + msg);
            String smsservicetype = "singlemsg";

            String query = "username=" + URLEncoder.encode(username) + "&password=" + URLEncoder.encode(password) + "&type="
                    + URLEncoder.encode(type) + "&dlr=" + URLEncoder.encode(dlr) + "&destination="
                    + URLEncoder.encode(mobileNo) + "&source=" + URLEncoder.encode(senderId) + "&message=" + msg;

            connection.setRequestProperty("Content-length", String.valueOf(query.length()));
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");

            // open up the output stream of the connection
            DataOutputStream output = new DataOutputStream(connection.getOutputStream());

            // write out the data
            int queryLength = query.length();
            output.writeBytes(query);
            // output.close();

            // get ready to read the response from the cgi script
            DataInputStream input = new DataInputStream(connection.getInputStream());

            // read in each character until end-of-stream is detected
            for (int c = input.read(); c != -1; c = input.read()) {
                //  System.out.print((char) c);
            }
            input.close();

        } catch (Exception e) {
            //System.out.println("Something bad just happened.");
            connection = null;
            e.printStackTrace();
        } finally {
        }
        return connection;
    }

    @Override
    public String schoolDetails(String janso) {
        String result = "";
        Session session = null;
        List listschool = new ArrayList();
        List listChild = new ArrayList();
        // JsonArray jsonArray=new JsonArray();
        session = getSessionFactory().openSession();
        try {
            Date dandt = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(dandt);
            //String ury = " FROM TTeamschedule WHERE teamId=" + Integer.parseInt(janso) + " AND scheduledDate='" + date + "'";
            SQLQuery ury = session.createSQLQuery("select ts.Id as schooldpid,ts.TeamId, ts.SchoolId,ts.ScheduledDate, ts.IsVisited,ts.Remarks,ts.TargetStudents,\n" +
                    "ts.DataSource,ts.CreatedUserId,ts.CreatedDate,ts.AchievedCount,ts.ScheduleType,ts.IsDeleted,ts.ScreenedDate,\n" +
                    "ms.DistrictId,ms.MandalId,ms.VillageId,msc.Name as schooltypename,m.id as mediumid,m.Name as mediumname,\n" +
                    "mca.DistrictId as childdistrictid,mv.Name as villagename, COUNT(*) as count,ms.Name as schoolname, ms.Latitude,ms.Longitude,ms.CategoryId,\n" +
                    "ms.ImagePath,ms.Code from t_teamschedule  ts\n" +
                    "inner join m_school ms on ms.id = ts.SchoolId\n" +
                    "inner join m_schoolcategory msc on msc.Id=ms.CategoryId\n" +
                    "inner join m_child mc on mc.SchoolId=ms.id\n" +
                    "inner join m_child_address mca on mca.ChildId = mc.Id\n" +
                    "inner join m_medium m on m.id = ms.MediumId\n" +
                    "inner join m_village mv on mv.Id = mca.VillageId \n" +
                    "where ts.TeamId=" + Integer.parseInt(janso) + " and ts.ScheduledDate='" + date + "' \n" +
                    "group by ts.Id,ts.TeamId, ts.SchoolId,ts.ScheduledDate, ts.IsVisited,ts.Remarks,ts.TargetStudents,\n" +
                    "ts.DataSource,ts.CreatedUserId,ts.CreatedDate,ts.AchievedCount,ts.ScheduleType,ts.IsDeleted,ts.ScreenedDate,\n" +
                    "ms.DistrictId,ms.MandalId,ms.VillageId,msc.Name, m.id, m.Name, mca.DistrictId,mv.Name,ms.Name,ms.Latitude,ms.Longitude,\n" +
                    "ms.CategoryId,ms.ImagePath,ms.Code");
            List list = ury.list();
            for (int i = 0; i < list.size(); i++) {
                Object[] os = (Object[]) list.get(i);
                MSchool mSchooldetails = (MSchool) session.load(MSchool.class, (int) os[2]);
                List listschooltep = new ArrayList();
                listschooltep = (List) mSchooldetails.getMChildCollection();
                String obj = "{\"schoolId\":\"" + os[2]
                        + "\",\"mandalId\":\"" + os[15]
                        + "\",\"districtId\":\"" + os[14]
                        + "\",\"totalnoofstudents\":\"" + os[22]
                        // + "\",\"teamId\":\"" + mSchooldetails.getTeamId() 
                        + "\",\"schoolName\":\"" + os[23] + "\",\"medium\":\"" + os[18] + 
                        "\",\"targetStudents\":\"" + os[6] 
                        + "\",\"latitude\":\"" + os[24] + "\",\"longitude\":\"" + os[25] + 
                        "\",\"schoolType\":\"" + os[17] + "\",\"schoolCatId\":\"" + os[26] + 
                        "\",\"photopath\":\"" + os[27]
                        + "\",\"villageName\":\"" + os[21] + "\",\"schoolCode\":\"" + os[28] + "\"}";
                listschool.add(obj);

                for (int l = 0; l < listschooltep.size(); l++) {
                    MChild children = (MChild) listschooltep.get(l);
                    Integer ms = children.getSchoolId().getId();
                    List<MChildAddress> addresses= (List<MChildAddress>) children.getMChildAddressCollection();
                    MChildAddress address= addresses.get(0);
                    System.out.println("address::"+address.getId());
                    System.out.println("village::"+address.getVillageId()+"::mandal::"+address.getMandalId()+":::dist::"+address.getDistrictId());
//                    MChildAddress mca = (MChildAddress) session.load(MChildAddress.class, address.getId());
                    
                    String objProp = "{\"childId\":\"" + children.getId() + "\",\"aadharNo\":\"" + children.getAadharNumber() + 
                            "\",\"childCaste\":\"" + children.getCaste()
                            + "\",\"contact\":\"" + children.getMobileNumber() + "\",\"disability\":\"" + children.getDisability() + 
                            "\",\"StudyingClass\":\"" + children.getClass1() + "\",\"father\":\"" + children.getFatherName()
                            + "\",\"gender\":\"" + children.getGender() + "\",\"mother\":\"" + children.getMotherName() + 
                            "\",\"motherTounge\":\"" + children.getMotherTongue()
                            + "\",\"childName\":\"" + children.getName() + "\",\"religion\":\"" + children.getReligion() + 
                            "\",\"Ucid\":\"" + children.getUCId()
                            + "\",\"dateofBirth\":\"" + children.getDateofBirth() + "\",\"schoolId\":\"" + ms + 
                            "\",\"districtId\":\"" + address.getDistrictId() + "\",\"mandalId\":\"" + address.getMandalId().getId() + 
                            "\",\"villageName\":\"" + address.getVillageId() + "\"}";
                    //System.out.println();
                    listChild.add(objProp);
                }
            }
            result = "{\"status\":\"Success\",\"Schools\":" + listschool + ",\"Children\":" + listChild + "}";
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Retry Problem with request\"}";
            return result;
        }
    }

    @Override
    public String convertFile(JsonObject jo) {
        String result = "";

        // String location = "survey";
        byte[] bytes = null;
        Session session = null;

        try {
            //System.out.println("jo::" + jo);
            String id = jo.get("schoolId").getAsString();
            session = getSessionFactory().openSession();
            //System.out.println("in upload");
            session.beginTransaction();
            MSchool mSchooldetails = (MSchool) session.load(MSchool.class, Integer.parseInt(id));

            if (jo.get("tSchoolquestionanswer") != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                JsonArray finArr = jo.get("tSchoolquestionanswer").getAsJsonArray();
                for (int i = 0; i < finArr.size(); i++) {
                    JsonObject jsonfinRef = (JsonObject) finArr.get(i);
                    //System.out.println("jsonfinRef::" + jsonfinRef);
                    TSchoolquestionanswer schoolquestionanswer = new TSchoolquestionanswer();

                    Boolean param = Boolean.parseBoolean(jsonfinRef.get("answer").getAsString());
                    //System.out.println("jsonfinRef.get(\"answer\").getAsBoolean()::" + param);
                    schoolquestionanswer.setAnswer(param);
                    schoolquestionanswer.setCreatedDate(dateFormat.parse(jsonfinRef.get("createdDate").getAsString()));
                    MTeam mTeam = (MTeam) session.load(MTeam.class, jsonfinRef.get("teamId").getAsInt());
                     schoolquestionanswer.setCreatedTeamId(mTeam);
                    //schoolquestionanswer.setCreatedTeamId(jsonfinRef.get("teamId").getAsInt());
                    MSchoolquestion mSchoolquestion = (MSchoolquestion) session.load(MSchoolquestion.class, jsonfinRef.get("questionId").getAsInt());
                    schoolquestionanswer.setQuestionId(mSchoolquestion);
                    //schoolquestionanswer.setQuestionId(jsonfinRef.get("questionId").getAsInt());
                    schoolquestionanswer.setSchoolId(mSchooldetails);
                    //schoolquestionanswer.setSchoolId(mSchooldetails.getId());
                    session.save(schoolquestionanswer);
                }
            }
            if (jo.get("longitude") != null) {
                String lon = jo.get("longitude").getAsString();
                mSchooldetails.setLongitude(lon);
            }
            if (jo.get("latitude") != null) {
                String lati = jo.get("latitude").getAsString();
                mSchooldetails.setLatitude(lati);
            }
            if (jo.get("file") != null && jo.get("file_name") != null) {
                String file_string = jo.get("file").getAsString();
                String file_name = jo.get("file_name").getAsString();
                String file_names = file_name.replaceAll("\"", "");
                //String file_names1 = file_name.replaceAll("\n","");
                //System.out.println("file_string ::" + file_string);
                // String fileStream = file_string.substring(1, file_string.length() - 1);
                String fileStream = file_string;
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                String textDate = df.format(sqlDate);
                //System.out.println("fileStream ::"+fileStream);
                bytes = Base64.decode(fileStream);
                // System.out.println("bytes ::"+bytes);
                // bytes = Base64.decodeBase64(fileStream);
                String locFile = "D:\\RBSK\\" + "\\" + textDate + "\\" + id + "\\" + file_names;
                File file = new File(locFile);
                String filPathabs = file.getAbsolutePath();
                String filePath = filPathabs.substring(0, filPathabs.lastIndexOf(File.separator));
                String fil = file.getPath();
                boolean val = file.getParentFile().mkdirs();
                FileOutputStream fop = null;
                try {
                    fop = new FileOutputStream(file);

                    fop.write(bytes);

                    fop.flush();
                    fop.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    /*if (session != null) {
                    e.printStackTrace();
                    session.getTransaction().rollback();
                }*/
                    result = "{\"Status\":\"Failed\",\"statusMessage\":\"File not Uploaded To server due to failure in file creation\"}";
//                result.put("Status", "Failed");
//                result.put("statusMessage", "File not Uploaded To server due to failure in file creation");
                    //result.put("serId", null);
                    return result;

                }
                if (filePath != null) {

                    // surveyorDtls.setPhotoLocation(filePath+file_name);
                    mSchooldetails.setImagePath(filPathabs);
                }
            }
            session.update(mSchooldetails);
            session.getTransaction().commit();
            result = "{\"status\":\"Success\",\"statusMessage\":\"File Uploaded To server\"}";
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"File not Uploaded To server due to failure in file creation\"}";
            return result;
        }
    }

    @Override
    public String scheduleDetails(String teamCode, String fromdate, String todate) {
        String result = "";
        Session session = null;
        Gson gson = new Gson();
        List listschool = new ArrayList();
        session = getSessionFactory().openSession();
        try {
            Date dandt = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(dandt);
            //String ury = " FROM TtTeamschedule WHERE teamId=" + Integer.parseInt(teamCode) +" AND teamScheduleDate='"+date+"'";
            //String ury = " FROM TTeamschedule WHERE teamId=" + Integer.parseInt(teamCode) + " AND scheduledDate >= cast(GETDATE() as date)";
            String ury = " FROM TTeamschedule WHERE teamId=" + Integer.parseInt(teamCode) + " AND scheduledDate between '" + fromdate + "' and '" + todate + "'";
            System.out.println("ury:::" + ury);
            List list = session.createQuery(ury).list();
            for (int i = 0; i < list.size(); i++) {
                TTeamschedule ttTeamschedule = (TTeamschedule) list.get(i);
                //String obj=gson.toJson(building);
                /*  String obj = "{\"buildingId\":\"" + ttTeamschedule.get+  "\",\"address\":\"" + building.getAddress() + "\",\"createdDate\":\"" + building.getCreatedDate()
                 + "\",\"hno\":\"" + building.getHNo() + "\",\"uniqueId\":\"" + building.getUniqueId() + "\",\"createdBy\":\"" + building.getCreatedBy()
                 + "\",\"ulbId\":\"" + building.getUlbId() + "\",\"wardId\":\"" + building.getWardId() + "\"}";*/
                MSchool mSchooldetails = (MSchool) session.load(MSchool.class, ttTeamschedule.getSchoolId());
                //MSchooldetails mSchooldetails=(MSchooldetails) session.load(MSchooldetails.class, schoolId);
                //MMandal mMandal = mSchooldetails.getMandalId();
                int mMandal = mSchooldetails.getMandalId();
                MSchoolcategory mSchoolCategory = mSchooldetails.getCategoryId();
                //MVillage mVillage = mSchooldetails.getVillageId();
                int mVillage = mSchooldetails.getVillageId();
                //MTeam mTeam = (MTeam) session.load(MSchool.class,ttTeamschedule.getTeamId());
//                String obj = "{\"schoolId\":\"" + mSchooldetails.getId() + "\",\"schoolName\":\"" + mSchooldetails.getName()
//                        + "\",\"schoolCode\":\"" + mSchooldetails.getCode() + "\",\"scheduledDate\":\"" + ttTeamschedule.getScheduledDate()
//                        + "\",\"scheduleId\":\"" + ttTeamschedule.getId() + "\",\"schoolType\":\"" + mSchoolCategory.getName() 
//                        + "\",\"villageName\":\"" + mVillage.getName() + "\",\"mandalName\":\"" + mMandal.getName() 
//                        + "\",\"teamId\":\"" + mTeam.getId() + "\"}";
//                String obj = "{\"schoolId\":\"" + mSchooldetails.getId() + "\",\"schoolName\":\"" + mSchooldetails.getName()
//                        + "\",\"schoolCode\":\"" + mSchooldetails.getCode() + "\",\"scheduledDate\":\"" + ttTeamschedule.getScheduledDate()
//                        + "\",\"scheduleId\":\"" + ttTeamschedule.getId() + "\",\"schoolType\":\"" + mSchoolCategory.getName() 
//                        + "\",\"villageName\":\"" + mVillage + "\",\"mandalName\":\"" + mMandal 
//                        + "\",\"teamId\":\"" + mTeam.getId() + "\"}";
                String obj = "{\"schoolId\":\"" + mSchooldetails.getId() + "\",\"schoolName\":\"" + mSchooldetails.getName()
                        + "\",\"schoolCode\":\"" + mSchooldetails.getCode() + "\",\"scheduledDate\":\"" + ttTeamschedule.getScheduledDate()
                        + "\",\"scheduleId\":\"" + ttTeamschedule.getId() + "\",\"schoolType\":\"" + mSchoolCategory.getName()
                        + "\",\"villageName\":\"" + mVillage + "\",\"mandalName\":\"" + mMandal
                        + "\",\"teamId\":\"" + ttTeamschedule.getTeamId() + "\",\"totalNoOfStudents\":\"" + mSchooldetails.getMChildCollection()+ 
                        "\",\"targetStudents\":\"" + ttTeamschedule.getTargetStudents() + "\"}";
                // mSchooldetails.getMChildCollection() for mSchooldetails.getTotalNoofStudents()
                listschool.add(obj);
            }
            result = "{\"status\":\"Success\",\"scheduledList\":" + listschool + "}";
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Problem in request\"}";
//            result.put("status", "Failed");
//            result.put("statusMessage", "File not Uploaded To server due to failure in file creation");
            //result.put("serId", null);
            return result;
        }
    }

    @Override
    public String syncDetails(JsonObject jo) {
        String result = "";
        Session session = null;
        Gson gson = new Gson();
        List listschool = new ArrayList();
        session = getSessionFactory().openSession();
        try {
            //session.getTransaction().begin();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Integer csaveid = 0;
            int schId = 0;
            if (jo.get("child") != null) {
                JsonObject jsonObjecta = jo.get("child").getAsJsonObject();
                MChild mChildren = new MChild();
                MChildAddress child_address = new MChildAddress();
                TChildacademy child_academy = new TChildacademy();

                Date cuDate = new Date();
                String cuDatSt = dateFormat1.format(cuDate);
                mChildren.setInsertedDate(dateFormat1.parse(cuDatSt));
                System.out.println("setInsertedDate ::" + dateFormat1.parse(cuDatSt));
                if (jsonObjecta.get("aadharNo") != null) {
                    mChildren.setAadharNumber(jsonObjecta.get("aadharNo").getAsString());
                }
                if (jsonObjecta.get("caste") != null) {
                    mChildren.setCaste(jsonObjecta.get("caste").getAsString());
                }
                if (jsonObjecta.get("cContact") != null) {
                    mChildren.setMobileNumber(jsonObjecta.get("cContact").getAsString());
                }
                if (jsonObjecta.get("motherTounge") != null) {
                    mChildren.setMotherTongue(jsonObjecta.get("motherTounge").getAsString());
                }
                if (jsonObjecta.get("disability") != null) {
                    mChildren.setDisability(jsonObjecta.get("disability").getAsString());
                }
//                if (jsonObjecta.get("districtId") != null) {
//                    MDistrict district = (MDistrict) session.load(MDistrict.class, jsonObjecta.get("districtId").getAsInt());
//                    //mChildren.setDistrictId(district);
//                    //mChildren.setDistrictId(jsonObjecta.get("districtId").getAsInt());
//                    child_address.setDistrictId(jsonObjecta.get("districtId").getAsInt());
//                }
                if (jsonObjecta.get("ChildDOB") != null) {
                    mChildren.setDateofBirth(dateFormat1.parse(jsonObjecta.get("ChildDOB").getAsString()));
                }
                if (jsonObjecta.get("fatherName") != null) {
                    mChildren.setFatherName(jsonObjecta.get("fatherName").getAsString());
                }
                if (jsonObjecta.get("gender") != null) {
                    String gender = jsonObjecta.get("gender").getAsString();
                    if (gender.equalsIgnoreCase("Boy")) {
                        mChildren.setGender("M");
                    } else {
                        mChildren.setGender("F");
                    }
                }
//                if (jsonObjecta.get("mandalId") != null) {
//                    MMandal mMandal = (MMandal) session.load(MMandal.class, jsonObjecta.get("mandalId").getAsInt());
//                    //mChildren.setMandalId(mMandal);
//                    //mChildren.setMandalId(jsonObjecta.get("mandalId").getAsInt());
//                    child_address.setMandalId(jsonObjecta.get("mandalId").getAsInt());
//                }
                if (jsonObjecta.get("motherName") != null) {
                    mChildren.setMotherName(jsonObjecta.get("motherName").getAsString());
                }
                if (jsonObjecta.get("childName") != null) {
                    mChildren.setName(jsonObjecta.get("childName").getAsString());
                }
                if (jsonObjecta.get("religion") != null) {
                    mChildren.setReligion(jsonObjecta.get("religion").getAsString());
                }
                if (jsonObjecta.get("schoolId") != null) {
                    MSchool mSchool = (MSchool) session.load(MSchool.class, jsonObjecta.get("schoolId").getAsInt());
                    mChildren.setSchoolId(mSchool);
                    //schId = jsonObjecta.get("schoolId").getAsInt();
                    //mChildren.setSchoolId(schId);
                }
//                if (jsonObjecta.get("villageName") != null) {
//                    MVillage mVillage = (MVillage) session.load(MVillage.class, jsonObjecta.get("villageName").getAsInt());
//                    //mChildren.setVillageId(mVillage);
//                    //mChildren.setVillageId(jsonObjecta.get("villageName").getAsInt());
//                    child_address.setVillageId(jsonObjecta.get("villageName").getAsInt());
//                }
                if (jsonObjecta.get("teamId") != null) {
                    // MTeam mTeam = (MTeam) session.load(MTeam.class, jsonObjecta.get("teamId").getAsInt());
                    mChildren.setCreatedTeamId(jsonObjecta.get("teamId").getAsInt());
                }
//                if (jsonObjecta.get("address") != null) {
//                    //mChildren.setAddress(jsonObjecta.get("address").getAsString());
//                    child_address.setAddress(jsonObjecta.get("address").getAsString());
//                }
                if (jsonObjecta.get("class") != null) {
                    mChildren.setClass1(jsonObjecta.get("class").getAsInt());
                }
//                   if(jsonObjecta.get("disability")!=null){
//                       mChildren.setDisablity(jsonObjecta.get("address").getAsString());
//                   }
                if (jsonObjecta.get("createDateTime") != null) {
                    mChildren.setCreatedDate(dateFormat1.parse(jsonObjecta.get("createDateTime").getAsString()));
                }
                DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
                String formattedDate = df.format(Calendar.getInstance().getTime());
                if (jsonObjecta.get("ucid") != null) {
                    mChildren.setUCId(jsonObjecta.get("ucid").getAsLong());
                } else {
                    MTeam mTeam = (MTeam) session.load(MTeam.class, jsonObjecta.get("teamId").getAsInt());
                    String UIDCrea = mTeam.getCode();
                    Calendar now = Calendar.getInstance();
                    int year = now.get(Calendar.YEAR);
                    int month = (now.get(Calendar.MONTH) + 1);
                    System.out.println("Current Year is : " + now.get(Calendar.YEAR));
                    // month start from 0 to 11
                    System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
                    System.out.println("Current Date is : " + now.get(Calendar.DATE));
                    Criteria criteria = session.createCriteria(MChild.class);
                    if (month >= 04) {
                        criteria.add(Restrictions.ge("insertedDate", dateFormat1.parse(year + "-" + month + "-" + "01")));
                        criteria.add(Restrictions.eq("createdTeamId", jsonObjecta.get("teamId").getAsInt()));
                        //year = year;
                        List mcList = criteria.list();
                        System.out.println("mcList size::" + mcList.size());
                        if (mcList.size() > 0) {
                            String qury = "SELECT MAX(UCId) as UCId FROM m_child where InsertedDate<='" 
                                    + cuDatSt + "' AND createdTeamId=" + jsonObjecta.get("teamId").getAsInt();
                            System.out.println("qury in else::" + (session.createSQLQuery(qury).list()).get(0));
                            if (((session.createSQLQuery(qury).list()).get(0)) != null) {
                                List valUcid = session.createSQLQuery(qury).list();
                                // if(valUcid>0){
                                String val = String.valueOf(valUcid.get(0));
                                String subVal = val.substring(val.length() - 5);
                                System.out.println("subVal:::" + subVal);
                                Long valString = (new Long(subVal)) + 1;
                                System.out.println("valString:::" + valString);
                                String vak = String.valueOf(valString);
                                if (vak.length() == 1) {
                                    vak = "0000" + vak;
                                } else if (vak.length() == 2) {
                                    vak = "000" + vak;
                                } else if (vak.length() == 3) {
                                    vak = "00" + vak;
                                } else if (vak.length() == 4) {
                                    vak = "0" + vak;
                                } else if (vak.length() == 5) {
                                    vak = vak;
                                }
                                //UIDCrea = UIDCrea+formattedDate+(valString+1);
                                UIDCrea = UIDCrea + formattedDate + vak;
                            } else {
                                UIDCrea = UIDCrea + formattedDate + "00001";
                                System.out.println("UIDCrea ::" + UIDCrea);
                                mChildren.setUCId(new Long(UIDCrea));
                            }
                            mChildren.setUCId(new Long(UIDCrea));
                        } else {

                            UIDCrea = UIDCrea + formattedDate + "00001";
                            System.out.println("UIDCrea::" + UIDCrea);
                            mChildren.setUCId(new Long(UIDCrea));
                        }
                    } else {
                        String qury = "SELECT MAX(UCId) as UCId FROM m_child where InsertedDate<='" +
                                cuDatSt + "' AND createdTeamId=" + jsonObjecta.get("teamId").getAsInt();
                        System.out.println("qury in else::" + (session.createSQLQuery(qury).list()).get(0));
                        if (((session.createSQLQuery(qury).list()).get(0)) != null) {
                            List valUcid = session.createSQLQuery(qury).list();
                            // if(valUcid >0){
                            String val = String.valueOf(valUcid.get(0));
                            String subVal = val.substring(val.length() - 5);
//                        Long valString = new Long(subVal);
//                        UIDCrea = UIDCrea+formattedDate+(valString+1);
                            System.out.println("subVal:::" + subVal);
                            Long valString = (new Long(subVal)) + 1;
                            System.out.println("valString:::" + valString);
                            String vak = String.valueOf(valString);
                            if (vak.length() == 1) {
                                vak = "0000" + vak;
                            } else if (vak.length() == 2) {
                                vak = "000" + vak;
                            } else if (vak.length() == 3) {
                                vak = "00" + vak;
                            } else if (vak.length() == 4) {
                                vak = "0" + vak;
                            } else if (vak.length() == 5) {
                                vak = vak;
                            }
                            //UIDCrea = UIDCrea+formattedDate+(valString+1);
                            UIDCrea = UIDCrea + formattedDate + vak;
                        } else {
                            UIDCrea = UIDCrea + formattedDate + "00001";
                            System.out.println("UIDCrea::" + UIDCrea);
                            mChildren.setUCId(new Long(UIDCrea));
                        }
                        mChildren.setUCId(new Long(UIDCrea));
                    }
                    //criteria.add(Restrictions.eq("designationId", 1));
                }

                if (jsonObjecta.get("updateTeamId") != null) {
                    // MTeam mTeam = (MTeam) session.load(MTeam.class, jsonObjecta.get("updateTeamId").getAsInt());
                    mChildren.setLastUpdatedTeamId(jsonObjecta.get("updateTeamId").getAsInt());
                }
                if (jsonObjecta.get("updateDate") != null) {
                    mChildren.setLastUpdatedDate(dateFormat.parse(jsonObjecta.get("updateDate").getAsString()));
                }
                if (jsonObjecta.get("studyingClass") != null) {
                    mChildren.setClass1(jsonObjecta.get("studyingClass").getAsInt());
                }
                /* if(jsonObjecta.get("schoolAcadamin")!=null)
                 mChildren.setSchoolAcademic(jsonObjecta.get("schoolAcadamin").getAsString());
                 if(jsonObjecta.get("schoolCode")!=null)
                 mChildren.setSchoolCode(jsonObjecta.get("schoolCode").getAsString());
                 if(jsonObjecta.get("childRefId")!=null)
                 mChildren.setChildReferId(jsonObjecta.get("childRefId").getAsString());*/
                //if(jsonObjecta.get("childId")!=null){
                System.out.println("setInsertedDate ::" + dateFormat1.parse(cuDatSt));
                mChildren.setInsertedDate(dateFormat1.parse(cuDatSt));

                if (jsonObjecta.get("isNew") != null && ((jsonObjecta.get("isNew").getAsString()).equalsIgnoreCase("YES"))) {
                    jsonObjecta.remove("childId");
                    csaveid = (Integer) session.save(mChildren);
                    System.out.println("csaveid ::" + csaveid);

                    MChild child = (MChild) session.load(MChild.class, csaveid);
                    //child_address.setChildId(csaveid);
                    child_address.setChildId(child);
                    child_address.setIsActive(true);
                    child_address.setCreatedOn(cuDate);
                    child_address.setCreatedUserId(jsonObjecta.get("teamId").getAsInt());

                    if (jsonObjecta.get("districtId") != null) {
                        MDistrict district = (MDistrict) session.load(MDistrict.class, jsonObjecta.get("districtId").getAsInt());
                        //mChildren.setDistrictId(district);
                        //mChildren.setDistrictId(jsonObjecta.get("districtId").getAsInt());
                        child_address.setDistrictId(jsonObjecta.get("districtId").getAsInt());
                    }

                    if (jsonObjecta.get("mandalId") != null) {
                        MMandal mMandal = (MMandal) session.load(MMandal.class, jsonObjecta.get("mandalId").getAsInt());
                        //mChildren.setMandalId(mMandal);
                        //mChildren.setMandalId(jsonObjecta.get("mandalId").getAsInt());
                        //child_address.setMandalId(jsonObjecta.get("mandalId").getAsInt());
                        child_address.setMandalId(mMandal);
                    }
                    if (jsonObjecta.get("villageName") != null) {
                        MVillage mVillage = (MVillage) session.load(MVillage.class, jsonObjecta.get("villageName").getAsInt());
                        //mChildren.setVillageId(mVillage);
                        //mChildren.setVillageId(jsonObjecta.get("villageName").getAsInt());
                        child_address.setVillageId(jsonObjecta.get("villageName").getAsInt());
                    }
                    if (jsonObjecta.get("address") != null) {
                        //mChildren.setAddress(jsonObjecta.get("address").getAsString());
                        child_address.setAddress(jsonObjecta.get("address").getAsString());
                    }

                    //child_academy.setChildId(csaveid);
                    child_academy.setChildId(child);
                    
                    MAcademicyear ayear = (MAcademicyear) session.load(MAcademicyear.class, 2);
                    //child_academy.setAcademicyearId(2);
                    child_academy.setAcademicyearId(ayear);
                    child_academy.setCreatedOn(cuDate);
                    child_academy.setCreatedUserId(jsonObjecta.get("teamId").getAsInt());

                    if (jsonObjecta.get("schoolId") != null) {
                        MSchool mSchool = (MSchool) session.load(MSchool.class, jsonObjecta.get("schoolId").getAsInt());
                        mChildren.setSchoolId(mSchool);
                        //schId = jsonObjecta.get("schoolId").getAsInt();
                        //child_academy.setSchoolID(schId);
                    }
                    if (jsonObjecta.get("class") != null) {
                        child_academy.setClass1(jsonObjecta.get("class").getAsInt());
                    }

                    session.save(child_address);
                    session.save(child_academy);
                    // mChildren.setChildId(new Long(jsonObjecta.get("childId").getAsString()));
                    //session.saveOrUpdate(mChildren);
                    //session.update(mChildren);
                } else { //if(!(jsonObjecta.get("isNew").getAsString()).equalsIgnoreCase("YES")){
                    //csaveid = jsonObjecta.get("childId").getAsInt();
                    mChildren.setId(jsonObjecta.get("childId").getAsInt());
                    session.saveOrUpdate(mChildren);
                    //child_address.setChildId(jsonObjecta.get("childId").getAsInt());
                    child_address.setChildId(mChildren);
                    //child_academy.setChildId(jsonObjecta.get("childId").getAsInt());
                    child_academy.setChildId(mChildren);

                    //session.saveOrUpdate(child_address);
                    //session.saveOrUpdate(child_academy);

                    //if(jsonObjecta.get("childId")==null){
                    // csaveid=(long) session.save(mChildren);
                    //System.out.println("csaveid ::"+csaveid);
                }
            }

            if (jo.get("anthropometry") != null) {
                JsonObject jsonAnth = jo.get("anthropometry").getAsJsonObject();
                TAnthropometry anthropometry = new TAnthropometry();
                //System.out.println("jsonAnth.get(\"anthroDate\"):: " + jsonAnth.get("anthroDate"));
                if (jsonAnth.get("anthroDate") != null) {
                    anthropometry.setCreatedDate(dateFormat1.parse(jsonAnth.get("anthroDate").getAsString()));
                }
                if (jsonAnth.get("childId") != null) {
                    MChild child = (MChild) session.load(MChild.class, jsonAnth.get("childId").getAsInt());
                    //anthropometry.setChildId(jsonAnth.get("childId").getAsInt());
                    anthropometry.setChildId(child);
                    csaveid = jsonAnth.get("childId").getAsInt();
                } else {
                    MChild child = (MChild) session.load(MChild.class, csaveid);
                    //anthropometry.setChildId(csaveid);
                    anthropometry.setChildId(child);
                }
                /*if(jsonAnth.get("childMonth")!=null)
                 anthropometry.setChildMonths(jsonAnth.get("childMonth").getAsInt());*/
                if (jsonAnth.get("headCirr") != null) {
                    anthropometry.setHeadCircumferenceValue(jsonAnth.get("headCirr").getAsString());
                }
                if (jsonAnth.get("headClass") != null) {
                    anthropometry.setHeadCircumferenceClassification(jsonAnth.get("headClass").getAsString());
                }
                if (jsonAnth.get("headCircumferenceDeviation") != null) {
                    anthropometry.setHeadCircumferenceDeviation(jsonAnth.get("headCircumferenceDeviation").getAsString());
                }
                if (jsonAnth.get("heightDeviation") != null) {
                    anthropometry.setHeightDeviation(jsonAnth.get("heightDeviation").getAsString());
                }
                if (jsonAnth.get("height") != null) {
                    anthropometry.setHeight(jsonAnth.get("height").getAsBigDecimal());
                }
                if (jsonAnth.get("createdUserId") != null) {
                    anthropometry.setCreatedUserId(jsonAnth.get("createdUserId").getAsInt());
                }
                if (jsonAnth.get("weightforHeightLenghtDeviation") != null) {
                    anthropometry.setWeightforHeightLenghtDeviation(jsonAnth.get("weightforHeightLenghtDeviation").getAsString());
                }
                /* if(jsonAnth.get("heightClass")!=null)
                 anthropometry.setHeightClassification(jsonAnth.get("heightClass").getAsString());*/
                if (jsonAnth.get("heightDeviation") != null) {
                    anthropometry.setHeightDeviation(jsonAnth.get("heightDeviation").getAsString());
                }
                if (jsonAnth.get("muac") != null) {
                    anthropometry.setMUACValue(jsonAnth.get("muac").getAsString());
                }
                if (jsonAnth.get("muacClass") != null) {
                    anthropometry.setMUACClassification(jsonAnth.get("muacClass").getAsString());
                }
                if (jsonAnth.get("teamId") != null) {
                    MTeam mTeam = (MTeam) session.load(MTeam.class, jsonAnth.get("teamId").getAsInt());
                    //anthropometry.setTeamId(jsonAnth.get("teamId").getAsInt());
                    anthropometry.setTeamId(mTeam);
                }
                if (jsonAnth.get("weight") != null) {
                    anthropometry.setWeight(jsonAnth.get("weight").getAsBigDecimal());
                }
                if (jsonAnth.get("weightDeviation") != null) {
                    anthropometry.setWeightDeviation(jsonAnth.get("weightDeviation").getAsString());
                }
                /*if(jsonAnth.get("anthropometrytypeid")!=null)
                 anthropometry.setAnthropometryTypeId(jsonAnth.get("anthropometrytypeid").getAsInt());*/
                if (jsonAnth.get("bloodpressure") != null) {
                    anthropometry.setBPValue(jsonAnth.get("bloodpressure").getAsString());
                }
                if (jsonAnth.get("bloodpressureclass") != null) {
                    anthropometry.setBPClassification(jsonAnth.get("bloodpressureclass").getAsString());
                }
                if (jsonAnth.get("bmi") != null) {
                    anthropometry.setBMIValue(jsonAnth.get("bmi").getAsBigDecimal());
                }
                if (jsonAnth.get("bmiclassification") != null) {
                    anthropometry.setBMIClassification(jsonAnth.get("bmiclassification").getAsString());
                }
                if (jsonAnth.get("visionlefteye") != null) {
                    anthropometry.setVisionLeftEye(jsonAnth.get("visionlefteye").getAsBigDecimal());
                }
                if (jsonAnth.get("visionrighteye") != null) {
                    anthropometry.setVisionRightEye(jsonAnth.get("visionrighteye").getAsBigDecimal());
                }
                /*if(schId>0){
                 MSchool mSchool = (MSchool) session.load(MSchool.class, schId);
                 anthropometry.setSchoolId(mSchool);
                 }else{
                 MChild children = (MChildren) session.load(MChildren.class, jsonAnth.get("childId").getAsInt());
                 anthropometry.setSchoolId(children.getChildSchoolId());
                 }*/
                session.save(anthropometry);
            }

            // if(jo.get("findingRefferal")!=null){
            if (jo.get("findingreferalobject") != null) {
                JsonArray finArr = jo.get("findingreferalobject").getAsJsonArray();
                for (int i = 0; i < finArr.size(); i++) {
                    JsonObject jsonfinRef = (JsonObject) finArr.get(i);
                    TFinding findings = new TFinding();
                    // if(jsonfinRef.get("childId")!=null){  
                    if (jo.get("child") == null) {
                        MChild child = (MChild) session.load(MChild.class, jsonfinRef.get("childId").getAsInt());
                        //findings.setChildId(child);
                        findings.setChildId(jsonfinRef.get("childId").getAsInt());
                    } else {
                        MChild child = (MChild) session.load(MChild.class, csaveid);
                        //findings.setChildId(child);
                        findings.setChildId(csaveid);
                    }
                    /* if(jsonfinRef.get("anthropometryTypeId")!=null){
                     findings.setAnthropometryTypeId(jsonfinRef.get("anthropometryTypeId").getAsInt());
                     }*/
                    if (jsonfinRef.get("hospitalId") != null) {
                        MHospital hospital = (MHospital) session.load(MHospital.class, jsonfinRef.get("hospitalId").getAsInt());
                        //findings.setReferredCenterId(hospital);
                        //findings.setHospitalId(hospital);
                        findings.setHospitalId(jsonfinRef.get("hospitalId").getAsInt());
                    }
                    if (jsonfinRef.get("symptomId") != null) {
                        findings.setSymptomId(jsonfinRef.get("symptomId").getAsString());
                    }
                    /*  if(jsonfinRef.get("referCenterType")!=null){   
                     findings.setReferCenterType(jsonfinRef.get("referCenterType").getAsInt());
                     }*/
                    if (jsonfinRef.get("referDate") != null) {
                        String dateRef = jsonfinRef.get("referDate").getAsString();
                        findings.setCreatedDate(dateFormat1.parse(dateRef));
                    }
                    if (jsonfinRef.get("teamId") != null) {
                        // MTeam mTeam = (MTeam) session.load(MTeam.class, jsonfinRef.get("teamId").getAsInt());
                        findings.setTeamId(jsonfinRef.get("teamId").getAsInt());
                    }
                    if (jsonfinRef.get("findingId") != null) {
                        MFinding finding = (MFinding) session.load(MFinding.class, jsonfinRef.get("findingId").getAsInt());
                        //findings.setFindingId(finding);
                        findings.setFindingId(jsonfinRef.get("findingId").getAsInt());
                    }
                    if (jsonfinRef.get("findingStatusId") != null) {
                    // MStatus mStatus = (MStatus) session.load(MStatus.class, jsonfinRef.get("findingStatusId").getAsBigDecimal());
                    MStatus mStatus = (MStatus) session.load(MStatus.class, 1);
                    //findings.setFindingStatusId(mStatus);
                    findings.setFindingStatusId(jsonfinRef.get("findingStatusId").getAsInt());
                    }
                    session.save(findings);
                    /*  TtFindingReferral findingReferral = new TtFindingReferral();
                     if(jsonfinRef.get("childId")!=null){
                     findingReferral.setChildId(jsonfinRef.get("childId").getAsInt());
                     }else{
                     findingReferral.setChildId(csaveid);
                     }
                     if(jsonfinRef.get("createdBy")!=null)
                     findingReferral.setCreatedBy(jsonfinRef.get("createdBy").getAsString());
                     if(jsonfinRef.get("createdDate")!=null)
                     findingReferral.setCrecatedDate(dateFormat1.parse(jsonfinRef.get("createdDate").getAsString()));
                     if(jsonfinRef.get("refeeralDate")!=null)
                     findingReferral.setReferralDate(dateFormat1.parse(jsonfinRef.get("refeeralDate").getAsString()));
                     if(jsonfinRef.get("referalDoctor")!=null)
                     findingReferral.setReferralDoctor(jsonfinRef.get("referalDoctor").getAsString());
                     if(jsonfinRef.get("referalHos")!=null)
                     findingReferral.setReferralHospital(jsonfinRef.get("referalHos").getAsString());
                     if(jsonfinRef.get("teamId")!=null)
                     findingReferral.setTeamId(jsonfinRef.get("teamId").getAsInt());
                     if(jsonfinRef.get("tranFindId")!=null)
                     findingReferral.setTranFindingId(jsonfinRef.get("tranFindId").getAsInt());
                     session.save(findingReferral);*/
                }
            }
            /*if (jo.get("anthropometrytwoobject") != null) {
                JsonArray finArrAntho = jo.get("anthropometrytwoobject").getAsJsonArray();
                for (int i = 0; i < finArrAntho.size(); i++) {
                    JsonObject jsonAnthoQ = (JsonObject) finArrAntho.get(i);
                    TGeneralmedicalquestionanswer queanthropometry = new TGeneralmedicalquestionanswer();
                    if (jsonAnthoQ.get("questionid") != null) {
                        MGeneralmedicalquestion generalmedicalquestion = (MGeneralmedicalquestion) session.load(MGeneralmedicalquestion.class, jsonAnthoQ.get("questionid").getAsInt());
                        queanthropometry.setQuestionId(generalmedicalquestion);
                    }
                    if (jsonAnthoQ.get("answerid") != null) {
                        Boolean param = Boolean.parseBoolean(jsonAnthoQ.get("answerid").getAsString());
                        queanthropometry.setAnswer(param);
                    }
                    /* if(jsonAnthoQ.get("remarks")!=null)
                     queanthropometry.setRemarks(jsonAnthoQ.get("remarks").getAsString());*/
                    //if(jsonAnthoQ.get("childId")!=null){
                   /* if (jo.get("child") == null) {
                        MChild mChild = (MChild) session.load(MChild.class, jsonAnthoQ.get("childId").getAsInt());
                        //queanthropometry.setChildId(jsonAnthoQ.get("childId").getAsInt());
                        queanthropometry.setChildId(mChild);
                    } else {
                        MChild mChild = (MChild) session.load(MChild.class, csaveid);
                        //queanthropometry.setChildId(csaveid);
                        queanthropometry.setChildId(mChild);

                    }
                    if (jsonAnthoQ.get("teamId") != null) {
                        MTeam mTeam = (MTeam) session.load(MTeam.class, jsonAnthoQ.get("teamId").getAsInt());
                        //queanthropometry.setCreatedTeamId(jsonAnthoQ.get("teamId").getAsInt());
                        queanthropometry.setCreatedTeamId(mTeam);
                    }
                    if (jsonAnthoQ.get("createdDate") != null) {
                        // MTeam mTeam = (MTeam) session.load(MTeam.class, jsonAnthoQ.get("teamId").getAsInt());
                        queanthropometry.setCreatedDate(dateFormat1.parse(jsonAnthoQ.get("createdDate").getAsString()));
                    }
                    session.save(queanthropometry);
                }
            }*/
            if (!jo.get("timeSheetDetails").getAsJsonObject().equals("{}")) {
                SimpleDateFormat dateFormat1H = new SimpleDateFormat("HH:mm:ss");
                Date datenull = dateFormat1H.parse("00:00:00");
                JsonObject jsonObjecta = jo.get("timeSheetDetails").getAsJsonObject();
                TScreentimelog screenstimedetails = new TScreentimelog();
                if (jsonObjecta.get("anthopometrySchoolScreen") != null) {
                    screenstimedetails.setAnthropometrySchoolScreen(dateFormat1H.parse(jsonObjecta.get("anthopometrySchoolScreen").getAsString()));
                }
                if (jsonObjecta.get("anthropometryAnganwadiScreen") != null) {
                    screenstimedetails.setAnthropometryAnganwadiScreen(dateFormat1H.parse(jsonObjecta.get("anthropometryAnganwadiScreen").getAsString()));
                }
                if (!(jo.get("child") == null)) {
                    MChild mChild = (MChild) session.load(MChild.class, csaveid);
                    //screenstimedetails.setChildId(csaveid);   //setChildID(csaveid);
                    screenstimedetails.setChildId(mChild);   //setChildID(csaveid);
                } else {
                    MChild mChild = (MChild) session.load(MChild.class, jsonObjecta.get("childID").getAsInt());
                    //screenstimedetails.setChildId(jsonObjecta.get("childID").getAsInt());
                    screenstimedetails.setChildId(mChild);
                }
                if (jsonObjecta.get("findingReferalScreen") != null && !jsonObjecta.get("findingReferalScreen").getAsString().equalsIgnoreCase("")) {
                    if (jsonObjecta.get("findingReferalScreen") == null || jsonObjecta.get("findingReferalScreen").getAsString().equalsIgnoreCase("null")) {
                        screenstimedetails.setFindingReferralScreen(datenull);
                    } else {
                        screenstimedetails.setFindingReferralScreen(dateFormat1H.parse(jsonObjecta.get("findingReferalScreen").getAsString()));
                    }
                }
                if (jsonObjecta.get("generalMedicalQuestionsScreen") != null && !jsonObjecta.get("generalMedicalQuestionsScreen").getAsString().equalsIgnoreCase("")) {
                    if (jsonObjecta.get("generalMedicalQuestionsScreen") == null || jsonObjecta.get("generalMedicalQuestionsScreen").getAsString().equalsIgnoreCase("null")) {
                        screenstimedetails.setGeneralMedicalQuestionScreen(datenull);
                    } else {
                        screenstimedetails.setGeneralMedicalQuestionScreen(dateFormat1H.parse(jsonObjecta.get("generalMedicalQuestionsScreen").getAsString()));
                    }
                }
                if (jsonObjecta.get("homeScreen") != null) {
                    screenstimedetails.setHomeScreen(dateFormat1H.parse(jsonObjecta.get("homeScreen").getAsString()));
                }
                if (jsonObjecta.get("preliminaryfindingsScreen") != null) {
                    screenstimedetails.setPreliminaryFindingScreen(dateFormat1H.parse(jsonObjecta.get("preliminaryfindingsScreen").getAsString()));
                }
                if (jsonObjecta.get("teamId") != null) {
                    MTeam mTeam = (MTeam) session.load(MTeam.class, jsonObjecta.get("teamId").getAsInt());
                    //screenstimedetails.setCreatedTeamId(jsonObjecta.get("teamId").getAsInt());
                    screenstimedetails.setCreatedTeamId(mTeam);
                }
                if (jsonObjecta.get("createdDate") != null) {
                    // MTeam mTeam = (MTeam) session.load(MTeam.class, jsonAnthoQ.get("teamId").getAsInt());
                    screenstimedetails.setCreatedDate(dateFormat1.parse(jsonObjecta.get("createdDate").getAsString()));
                }
                int s = (int) session.save(screenstimedetails);
            }

            /*if (jo.get("immunization_details") != null) {
                JsonArray immunizationdetails = jo.get("immunization_details").getAsJsonArray();
                for (int i = 0; i < immunizationdetails.size(); i++) {
                    JsonObject immune = immunizationdetails.get(i).getAsJsonObject();
                    TimmunizationQuesAns immunizationques = new TimmunizationQuesAns();
                    if (immune.get("child_id").getAsString() != null) {
                        MChild mChild = (MChild) session.load(MChild.class, immune.get("child_id").getAsInt());
                        //immunizationques.setChildID(immune.get("child_id").getAsInt());
                        immunizationques.setChildID(mChild);
                    }
                    if (immune.get("vaccine_id").getAsString() != null) {
                        MVaccineImmunization vaccineimmune = (MVaccineImmunization) session.load(MVaccineImmunization.class, immune.get("vaccine_id").getAsInt());
                        immunizationques.setVaccineID(vaccineimmune);
                    }
                    System.out.println("dateFormat" + jo.get("date"));

                    SimpleDateFormat datefor = new SimpleDateFormat("dd/MM/yyyy");

                    if (!immune.get("date").getAsString().equals("")) {
                        //System.out.println("inside if condition");
                        Date datee = datefor.parse(immune.get("date").getAsString());
                        immunizationques.setDate(datee);
                    } else {
                        //System.out.println("else condition beginning");
                        immunizationques.setDate(null);
                        //System.out.println("else condition conclusion");
                    }
                    immunizationques.setCreatedDate(date);
                    session.save(immunizationques);
                }
            }*/
//            if (jo.get("findingArray") != null) {
//                JsonArray findingArray = jo.get("findingArray").getAsJsonArray();
//                for (int i = 0; i < findingArray.size(); i++) {
//                    JsonObject findingObject = findingArray.get(i).getAsJsonObject();
//                    TfindingsWithoutReferels findingRef = new TfindingsWithoutReferels();
//                    if (findingObject.get("childid").getAsString() != null) {
//                        findingRef.setChildid(findingObject.get("childid").getAsString());
//                    }
//                    if (findingObject.get("findingid").getAsString() != null) {
//                        findingRef.setFindingid(findingObject.get("findingid").getAsInt());
//                    }
//                    if (findingObject.get("createdBy").getAsString() != null) {
//                        findingRef.setCreatedby(findingObject.get("createdBy").getAsInt());
//                    }
//                    findingRef.setCreateddate(date);
//                }
//            }
            result = "{\"status\":\"Success\",\"statusMessage\":\"Data Saved\",\"csaveid\":\"" + csaveid + "\"}";
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Data Sync failed\"}";
//            result.put("status", "Failed");
//            result.put("statusMessage", "File not Uploaded To server due to failure in file creation");
//            result.put("serId", null);
            return result;
        }
    }

    @Override
    public String studentDetails(String janso, String fromdate, String todate) {
        String result = "";
        Session session = null;
        Gson gson = new Gson();
        List listschool = new ArrayList();

        try {
            session = getSessionFactory().openSession();
            //String ury = " exec PRO_RPT_TEAMFindinsStatus " + Integer.parseInt(janso) + ",'" + fromdate + "','" + todate + "';";
            SQLQuery q = session.createSQLQuery("exec PRO_RPT_TEAMFindingStatus :param1, :param2, :param3");
            //System.out.println("janso ::" + janso + "::");
            String s = janso.trim();
            //System.out.println("s ::" + s.trim() + "::");
            int l = Integer.parseInt(s);
            q.setInteger("param1", l);
            q.setString("param2", fromdate);
            q.setString("param3", todate);
            List list = q.list();
            //System.out.println("ury:::" + q);
            //List list = session.createSQLQuery(ury).list();
            for (int i = 0; i < list.size(); i++) {
                Object[] os = (Object[]) list.get(i);
                String subString = "{\"refDate\":\"" + os[0] + "\",\"UCID\":\"" + os[1] + "\",\"childName\":\"" + os[2]
                        + "\",\"schoolName\":\"" + os[3] + "\",\"findingId\":\"" + os[4] + "\",\"findingName\":\"" + os[5]
                        + "\",\"findingStatus\":\"" + os[6] + "\"}";
                listschool.add(subString);
            }
            result = "{\"status\":\"Success\",\"studentList\":" + listschool + "}";
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Problem in request\"}";
            return result;
        }
    }

    @Override
    public String teamwiseDetails(String janso, String fromdate, String todate) {
        String result = "";
        Session session = null;
        Gson gson = new Gson();
        List listschool = new ArrayList();

        try {
            session = getSessionFactory().openSession();
            //String ury = " exec PRO_RPT_Children_InstitutionWise " + Integer.parseInt(janso) + ",'" + fromdate + "','" + todate + "';";
            //System.out.println("ury:::" + ury);
            //SQLQuery q = session.createSQLQuery("exec PRO_RPT_Children_InstitutionWise :param1, :param2, :param3");
            SQLQuery q = session.createSQLQuery("exec GetScreenedVsReferralVsFindingsInstitutiowise :param1, :param2, :param3");
            //System.out.println("janso ::" + janso + "::");
            String s = janso.trim();
            //System.out.println("s ::" + s.trim() + "::");
            int l = Integer.parseInt(s);
            q.setInteger("param1", l);
            q.setString("param2", fromdate);
            q.setString("param3", todate);
            List list = q.list();
            //List list = session.createSQLQuery(ury).list();
            for (int i = 0; i < list.size(); i++) {
                Object[] os = (Object[]) list.get(i);
                String subString = "{\"schoolName\":\"" + os[0] + "\",\"totalNoOfStudents\":\"" + os[1] + "\",\"targetStudents\":\"" + os[2]
                        + "\",\"screened\":\"" + os[3] + "\",\"referred\":\"" + os[4] + "\",\"absent\":\"" + os[5] + "\",\"remaining\":\"" + os[6] + "\"}";
                listschool.add(subString);
            }
            result = "{\"status\":\"Success\",\"teamDataList\":" + listschool + "}";
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Problem in request\"}";
            return result;
        }
    }

    @Override
    public String districtwiseTean(int janso) {
        String result = "";

        Session session = null;
        List listschool = new ArrayList();

        try {
            session = getSessionFactory().openSession();
            SQLQuery ury = session.createSQLQuery("select distinct Id,IMEINumber,code,DistrictId,0 as MandalId,IsActive,ReportPHCId --SplitData\n"
                    + "from m_team\n"
                    + "--cross apply STRING_SPLIT (MandalId, ',') cs\n"
                    + "where IsActive=1 AND DistrictId=" + janso + "");
            //ury.setInteger("param1", janso);
            //System.out.println("ury:::" + ury);
            List list = ury.list();
            //System.out.println("list::::" + list);

            for (int i = 0; i < list.size(); i++) {
                Object[] os = (Object[]) list.get(i);
                int district = (int) os[3];
                int mandal = Integer.parseInt(os[4].toString());
                MDesignation designation = (MDesignation) session.load(MDesignation.class, 1);
                Criteria criteria = session.createCriteria(MTeammember.class);
                
                MTeam mTeam = (MTeam) session.load(MTeam.class, (int) os[0]);
                criteria.add(Restrictions.eq("teamId", mTeam));
                criteria.add(Restrictions.eq("designationId", designation));
                //System.out.println("MTeamMember" + MTeammember.class);

                List regList = criteria.list();
                if (regList != null && regList.size() > 0) {
                    MTeammember mTeammember = (MTeammember) regList.get(0);
                    MPhc mPhc = (MPhc) session.load(MPhc.class, (int) os[6]);
                    System.out.println("mTeams ::" + os[0]);
                    if (mTeammember != null) {
                        String subString = "{\"teamId\":\"" + "" + os[0]
                                + "\",\"imeId\":\"" + "" + os[1]
                                + "\",\"mobileNum\":\"" + mTeammember.getMobileNumber()
                                + "\",\"teamCode\":\"" + os[2]
                                + "\",\"teamLeaderName\":\"" + mTeammember.getName()
                                + "\",\"districtId\":\"" + district
                                + "\",\"mandalId\":\"" + mandal
                                + "\",\"active\":\"" + os[5]
                                + "\",\"reportPhcId\":\"" + mPhc.getId() + "\"}";
                        listschool.add(subString);
                    }
                }
            }
            result = "{\"status\":\"Success\",\"teamData\":" + listschool + "}";
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Problem in request\"}";
            return result;
        }
    }

    @Override
    public String districtwiseCenters(int janso) {
        String result = "";
        Session session = null;
        Gson gson = new Gson();
        List listschool = new ArrayList();

        try {
            session = getSessionFactory().openSession();
            String ury = " From MHospital where districtId=" + janso;
            System.out.println("ury:::" + ury);
            List list = session.createQuery(ury).list();

            for (int i = 0; i < list.size(); i++) {
                // Object[] os = (Object[]) list.get(i);
                MHospital mCenters = (MHospital) list.get(i);
                MHospitaltype centertypes = mCenters.getHospitalTypeId();
                // MHospitaltype centertypes= (MHospitaltype) session.load(MHospitaltype.class, mCenters.getHospitalTypeId());
                String subString = "{\"Id\":\"" + mCenters.getId() + "\",\"districtId\":\"" + mCenters.getDistrictId() + 
                        "\",\"hospitalName\":\"" + mCenters.getName()
                        + "\",\"HospitalTypeId\":\"" + centertypes.getId() + "\"}";
                listschool.add(subString);
            }
            result = "{\"status\":\"Success\",\"centerData\":" + listschool + "}";
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Problem in request\"}";
            return result;
        }
    }

    @Override
    public String teamwiseStatusDetails(String janso, String fromdate, String todate) {
        String result = "";
        Session session = null;
        Gson gson = new Gson();
        List listschool = new ArrayList();

        try {
            session = getSessionFactory().openSession();
            //exec
            //String ury = "exec PRO_RPT_TEAM_PSTATUS_Android " + janso + "," + fromdate + "," + todate;
            SQLQuery q = session.createSQLQuery("exec PRO_RPT_TEAM_PSTATUS_Android :param1, :param2, :param3");
            //System.out.println("janso ::" + janso + "::");
            String s = janso.trim();
            System.out.println("s ::" + s.trim() + "::");
            int l = Integer.parseInt(s);

            q.setInteger("param1", l);
            q.setString("param2", fromdate);
            q.setString("param3", todate);
            System.out.println("q:::" + q + "  ::");
            //session.createStoredProcedureCall(ury)
            //List list = session.createSQLQuery(ury).list();
            List list = q.list();
            for (int i = 0; i < list.size(); i++) {
                Object[] os = (Object[]) list.get(i);
                String subString = "{\"teamCode\":\"" + os[0] + "\",\"Target\":\"" + os[1] + "\",\"achieved\":\"" + os[2]
                        + "\",\"Remaining\":\"" + os[3] + "\"}";
                listschool.add(subString);
            }
            result = "{\"status\":\"Success\",\"teamCollDataList\":" + listschool + "}";
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Problem in request\"}";
            return result;
        }
    }

    //CALL PRO_RPT_TEAM_FINDINGSTATUS_ANDR(6,'2016-01-01','2016-09-13',0)
    @Override
    public String preliminaryFindings(String janso, String fromdate, String todate, int findingId) {
        String result = "";
        Session session = null;
        Gson gson = new Gson();
        List listschool = new ArrayList();

        try {
            session = getSessionFactory().openSession();
            //String ury = " exec PRO_RPT_TEAM_FINDINGSTATUS_ANDR " + Integer.parseInt(janso) + ",'" + fromdate + "','" + todate + "'," + findingId + ";";
            // System.out.println("ury:::" + ury);
            SQLQuery q = session.createSQLQuery("exec PRO_RPT_TEAM_FINDINGSTATUS_ANDR :param1, :param2, :param3, :param4");
            System.out.println("janso ::" + janso + "::");
            String s = janso.trim();
            System.out.println("s ::" + s.trim() + "::");
            int l = Integer.parseInt(s);
            q.setInteger("param1", l);
            q.setString("param2", fromdate);
            q.setString("param3", todate);
            q.setInteger("param4", findingId);
            List list = q.list();
            if (findingId == 0) {
                for (int i = 0; i < list.size(); i++) {
                    //preliminaryId  preliminaryName findingId FindingName achieved
                    Object[] os = (Object[]) list.get(i);
                    String subString = "{\"preliminaryId\":\"" + os[0] + "\",\"preliminaryName\":\"" + os[1] + "\",\"findingId\":\"" + os[2]
                            + "\",\"FindingName\":\"" + os[3] + "\",\"achieved\":\"" + os[4] + "\"}";
                    listschool.add(subString);
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    //UCID Child_name childFather childGender childVillage FindinStatus
                    Object[] os = (Object[]) list.get(i);
                    String subString = "{\"UCID\":\"" + os[0] + "\",\"childName\":\"" + os[1] + "\",\"childFather\":\"" + os[2]
                            + "\",\"childGender\":\"" + os[3] + "\",\"childVillage\":\"" + os[4] + "\",\"FindinStatus\":\"" + os[5] + "\"}";
                    listschool.add(subString);
                }
            }
            result = "{\"status\":\"Success\",\"teamCollDataList\":" + listschool + "}";
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Problem in request\"}";
            return result;
        }
    }

    /* public String syncTimeSheetDetails(JsonObject jo){
     String result = "";
     Session session = null;
     Gson gson = new Gson();
     List listschool = new ArrayList();
     session = getSessionFactory().openSession();
     try{
     //session.getTransaction().begin();
     SimpleDateFormat dateFormat= new SimpleDateFormat("HH:mm:ss");
     //SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd");
     int csaveid=0;
     if(jo.get("timeSheetDetails")!=null){
                
     JsonObject jsonObjecta= jo.get("timeSheetDetails").getAsJsonObject();
     TtScreenstimedetails screenstimedetails = new TtScreenstimedetails();
     if(jsonObjecta.get("anthopometrySchoolScreen")!=null)
     screenstimedetails.setAnthopometrySchoolScreen(dateFormat.parse(jsonObjecta.get("anthopometrySchoolScreen").getAsString()));
     if(jsonObjecta.get("anthropometryAnganwadiScreen")!=null)
     screenstimedetails.setAnthropometryAnganwadiScreen(dateFormat.parse(jsonObjecta.get("anthropometryAnganwadiScreen").getAsString()));
     if(jsonObjecta.get("childID")!=null)
     screenstimedetails.setChildId(new Long(jsonObjecta.get("childID").getAsString()));
     if(jsonObjecta.get("findingReferalScreen")!=null)
     screenstimedetails.setFindingReferalScreen(dateFormat.parse(jsonObjecta.get("findingReferalScreen").getAsString()));
     if(jsonObjecta.get("generalMedicalQuestionsScreen")!=null)
     screenstimedetails.setGeneralMedicalQuestionsScreen(dateFormat.parse(jsonObjecta.get("generalMedicalQuestionsScreen").getAsString()));
     if(jsonObjecta.get("homeScreen")!=null)
     screenstimedetails.setHomeScreen(dateFormat.parse(jsonObjecta.get("homeScreen").getAsString()));
     if(jsonObjecta.get("preliminaryfindingsScreen")!=null)
     screenstimedetails.setPreliminaryfindingsScreen(dateFormat.parse(jsonObjecta.get("preliminaryfindingsScreen").getAsString()));
     if(jsonObjecta.get("teamId")!=null)
     screenstimedetails.setTeamId(jsonObjecta.get("teamId").getAsInt());
     csaveid = (int) session.save(screenstimedetails);
                   
     }  
               
     // session.getTransaction().commit();
     result = "{\"status\":\"Success\",\"statusMessage\":\"Data Saved\"}";
     return result;
     }catch (Exception e) {
     e.printStackTrace();
     if (session != null) {
     e.printStackTrace();
     session.getTransaction().rollback();
     }
     result = "{\"status\":\"Failed\",\"statusMessage\":\"Data Sync failed\"}";
     //            result.put("status", "Failed");
     //            result.put("statusMessage", "File not Uploaded To server due to failure in file creation");
     //result.put("serId", null);
     return result;
     }
     }*/
    @Override
    public String syncDetailsChildAbs(JsonObject jo) {
        String result = "";
        Session session = null;
        Gson gson = new Gson();
        List listschool = new ArrayList();
        session = getSessionFactory().openSession();
        try {
            //session.getTransaction().begin();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Integer csaveid = 0;
            int schId = 0;
            if (jo.get("child") != null) {
                JsonObject jsonObjecta = jo.get("child").getAsJsonObject();
                MChild mChildren = new MChild();
                MChildAddress child_address = new MChildAddress();
                TChildacademy child_academy = new TChildacademy();

                Date cuDate = new Date();
                String cuDatSt = dateFormat1.format(cuDate);
                if (jsonObjecta.get("aadharNo") != null) {
                    mChildren.setAadharNumber(jsonObjecta.get("aadharNo").getAsString());
                }
                if (jsonObjecta.get("caste") != null) {
                    mChildren.setCaste(jsonObjecta.get("caste").getAsString());
                }
                if (jsonObjecta.get("cContact") != null) {
                    mChildren.setMobileNumber(jsonObjecta.get("cContact").getAsString());
                }
                if (jsonObjecta.get("disability") != null) {
                    mChildren.setDisability(jsonObjecta.get("disability").getAsString());
                }
//                if (jsonObjecta.get("districtId") != null) {
//                    MDistrict district = (MDistrict) session.load(MDistrict.class, jsonObjecta.get("districtId").getAsInt());
//                    //mChildren.setDistrictId(district);
//                    //mChildren.setDistrictId(jsonObjecta.get("districtId").getAsInt());
//                    child_address.setDistrictId(jsonObjecta.get("districtId").getAsInt());
//                }
                if (jsonObjecta.get("ChildDOB") != null) {
                    mChildren.setDateofBirth(dateFormat1.parse(jsonObjecta.get("ChildDOB").getAsString()));
                }
                if (jsonObjecta.get("fatherName") != null) {
                    mChildren.setFatherName(jsonObjecta.get("fatherName").getAsString());
                }
                if (jsonObjecta.get("gender") != null) {
                    mChildren.setGender(jsonObjecta.get("gender").getAsString());

                }
//                if (jsonObjecta.get("mandalId") != null) {
//                    MMandal mMandal = (MMandal) session.load(MMandal.class,
//                            jsonObjecta.get("mandalId").getAsInt());
//                    //mChildren.setMandalId(mMandal);
//                    //mChildren.setMandalId(jsonObjecta.get("mandalId").getAsInt());
//                    child_address.setMandalId(jsonObjecta.get("mandalId").getAsInt());
//                }
                if (jsonObjecta.get("motherName") != null) {
                    mChildren.setMotherName(jsonObjecta.get("motherName").getAsString());
                }
                if (jsonObjecta.get("childName") != null) {
                    mChildren.setName(jsonObjecta.get("childName").getAsString());
                }
                if (jsonObjecta.get("religion") != null) {
                    mChildren.setReligion(jsonObjecta.get("religion").getAsString());
                }
                if (jsonObjecta.get("schoolId") != null) {
                    MSchool mSchool = (MSchool) session.load(MSchool.class, jsonObjecta.get("schoolId").getAsInt());
                    //mChildren.setSchoolId(mSchool);
                    schId = jsonObjecta.get("schoolId").getAsInt();
                    //mChildren.setSchoolId(schId);
                    mChildren.setSchoolId(mSchool);

                }
//                if (jsonObjecta.get("villageName") != null) {
//                    MVillage mVillage = (MVillage) session.load(MVillage.class,
//                            jsonObjecta.get("villageName").getAsInt());
//                    //mChildren.setVillageId(mVillage);
//                    //mChildren.setVillageId(jsonObjecta.get("villageName").getAsInt());
//                    child_address.setVillageId(jsonObjecta.get("villageName").getAsInt());
//                }
                if (jsonObjecta.get("teamId") != null) {
                    //MTeam mTeam = (MTeam) session.load(MTeam.class, jsonObjecta.get("teamId").getAsInt());
                    mChildren.setCreatedTeamId(jsonObjecta.get("teamId").getAsInt());
                }
                if (jsonObjecta.get("createDateTime") != null) {
                    mChildren.setCreatedDate(dateFormat.parse(jsonObjecta.get("createDateTime").getAsString()));
                }
                if (jsonObjecta.get("ucid") != null) {
                    mChildren.setUCId(jsonObjecta.get("ucid").getAsLong());
                }
                if (jsonObjecta.get("updateTeamId") != null) {
                    // MTeam mTeam = (MTeam) session.load(MTeam.class, jsonObjecta.get("updateTeamId").getAsInt());
                    mChildren.setLastUpdatedTeamId(jsonObjecta.get("updateTeamId").getAsInt());
                }
                if (jsonObjecta.get("updateDate") != null) {
                    mChildren.setLastUpdatedDate(dateFormat.parse(jsonObjecta.get("updateDate").getAsString()));
                }
                if (jsonObjecta.get("studyingClass") != null) {
                    mChildren.setClass1(jsonObjecta.get("studyingClass").getAsInt());
                }
                if (jsonObjecta.get("motherTounge") != null) {
                    mChildren.setMotherTongue(jsonObjecta.get("motherTounge").getAsString());
                }
                if (jsonObjecta.get("address") != null) {
                    //mChildren.setAddress(jsonObjecta.get("address").getAsString());
                    child_address.setAddress(jsonObjecta.get("address").getAsString());
                }
//                if (jsonObjecta.get("class") != null) {
//                    //mChildren.setClass1(jsonObjecta.get("class").getAsInt());
//                    child_academy.setClass1(jsonObjecta.get("class").getAsInt());
//                }
                System.out.println("setInsertedDate ::" + dateFormat1.parse(cuDatSt));
                mChildren.setInsertedDate(dateFormat1.parse(cuDatSt));
                DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
                String formattedDate = df.format(Calendar.getInstance().getTime());
                if (jsonObjecta.get("ucid") != null) {
                    mChildren.setUCId(jsonObjecta.get("ucid").getAsLong());

                } else {
                    MTeam mTeam = (MTeam) session.load(MTeam.class,
                            jsonObjecta.get("teamId").getAsInt());
                    String UIDCrea = mTeam.getCode();
                    Calendar now = Calendar.getInstance();
                    int year = now.get(Calendar.YEAR);
                    int month = (now.get(Calendar.MONTH) + 1);
                    System.out.println("Current Year is : " + now.get(Calendar.YEAR));
                    // month start from 0 to 11
                    System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
                    System.out.println("Current Date is : " + now.get(Calendar.DATE));
                    Criteria criteria = session.createCriteria(MChild.class);
                    if (month >= 04) {
                        criteria.add(Restrictions.ge("insertedDate", dateFormat1.parse(year + "-" + month + "-" + "01")));
                        criteria.add(Restrictions.eq("createdTeamId", jsonObjecta.get("teamId").getAsInt()));
                        //year = year;
                        List mcList = criteria.list();

                        if (mcList.size() > 0) {
                            String qury = "SELECT MAX(UCId) as UCId FROM m_child where InsertedDate<='" + cuDatSt + "' AND createdTeamId=" + jsonObjecta.get("teamId").getAsInt();
                            System.out.println("qury in else::" + (session.createSQLQuery(qury).list()).get(0));
                            if (((session.createSQLQuery(qury).list()).get(0)) != null) {
                                List valUcid = session.createSQLQuery(qury).list();
                                //if(valUcid>0){
                                String val = String.valueOf(valUcid.get(0));
                                String subVal = val.substring(val.length() - 5);
//                        Long valString = new Long(subVal);
//                        UIDCrea = UIDCrea+formattedDate+(valString+1);
                                System.out.println("subVal:::" + subVal);
                                Long valString = (new Long(subVal)) + 1;
                                System.out.println("valString:::" + valString);
                                String vak = String.valueOf(valString);
                                if (vak.length() == 1) {
                                    vak = "0000" + vak;
                                } else if (vak.length() == 2) {
                                    vak = "000" + vak;
                                } else if (vak.length() == 3) {
                                    vak = "00" + vak;
                                } else if (vak.length() == 4) {
                                    vak = "0" + vak;
                                } else if (vak.length() == 5) {
                                    vak = vak;
                                }
                                //UIDCrea = UIDCrea+formattedDate+(valString+1);
                                UIDCrea = UIDCrea + formattedDate + vak;
                                System.out.println("UIDCrea::" + UIDCrea);
                                mChildren.setUCId(new Long(UIDCrea));
                            } else {
                                UIDCrea = UIDCrea + formattedDate + "00001";
                                System.out.println("UIDCrea::" + UIDCrea);
                                mChildren.setUCId(new Long(UIDCrea));
                            }
                            System.out.println("UIDCrea::" + UIDCrea);
                            mChildren.setUCId(new Long(UIDCrea));
                        } else {
                            UIDCrea = UIDCrea + formattedDate + "00001";
                            System.out.println("UIDCrea::" + UIDCrea);
                            mChildren.setUCId(new Long(UIDCrea));
                        }
                    } else {
                        String qury = "SELECT MAX(UCId) as UCId FROM m_child where InsertedDate<='" + cuDatSt + "' AND createdTeamId=" + jsonObjecta.get("teamId").getAsInt();
                        System.out.println("qury in else::" + (session.createSQLQuery(qury).list()).get(0));
                        if (((session.createSQLQuery(qury).list()).get(0)) != null) {
                            List valUcid = session.createSQLQuery(qury).list();
                            //if(valUcid>0){
                            String val = String.valueOf(valUcid.get(0));
                            String subVal = val.substring(val.length() - 5);
//                      Long valString = new Long(subVal);
//                      UIDCrea = UIDCrea+formattedDate+(valString+1);
                            System.out.println("subVal:::" + subVal);
                            Long valString = (new Long(subVal)) + 1;
                            System.out.println("valString:::" + valString);
                            String vak = String.valueOf(valString);
                            if (vak.length() == 1) {
                                vak = "0000" + vak;
                            } else if (vak.length() == 2) {
                                vak = "000" + vak;
                            } else if (vak.length() == 3) {
                                vak = "00" + vak;
                            } else if (vak.length() == 4) {
                                vak = "0" + vak;
                            } else if (vak.length() == 5) {
                                vak = vak;
                            }
                            //UIDCrea = UIDCrea+formattedDate+(valString+1);
                            UIDCrea = UIDCrea + formattedDate + vak;
                            System.out.println("UIDCrea::" + UIDCrea);
                            mChildren.setUCId(new Long(UIDCrea));
                        } else {
                            UIDCrea = UIDCrea + formattedDate + "00001";
                            System.out.println("UIDCrea::" + UIDCrea);
                            mChildren.setUCId(new Long(UIDCrea));
                        }
                        System.out.println("UIDCrea::" + UIDCrea);
                        mChildren.setUCId(new Long(UIDCrea));
                    }
                    //criteria.add(Restrictions.eq("designationId", 1));      
                }
                /* if(jsonObjecta.get("schoolAcadamin")!=null)
                 mChildren.setSchoolAcademic(jsonObjecta.get("schoolAcadamin").getAsString());
                 if(jsonObjecta.get("schoolCode")!=null)
                 mChildren.setSchoolCode(jsonObjecta.get("schoolCode").getAsString());
                 if(jsonObjecta.get("childRefId")!=null)
                 mChildren.setChildReferId(jsonObjecta.get("childRefId").getAsString());*/
                //if(jsonObjecta.get("childId")!=null){
                if (jsonObjecta.get("isNew") != null && ((jsonObjecta.get("isNew").getAsString()).equalsIgnoreCase("YES"))) {
                    jsonObjecta.remove("childId");
                    csaveid = (Integer) session.save(mChildren);
                    System.out.println("csaveid ::" + csaveid);
                    
                    MChild mChild = (MChild) session.load(MChild.class, csaveid);
                    //child_address.setChildId(csaveid);
                    child_address.setChildId(mChild);
                    child_address.setIsActive(true);
                    child_address.setCreatedOn(cuDate);
                    child_address.setCreatedUserId(jsonObjecta.get("teamId").getAsInt());

                    if (jsonObjecta.get("districtId") != null) {
                        MDistrict district = (MDistrict) session.load(MDistrict.class, jsonObjecta.get("districtId").getAsInt());
                        //mChildren.setDistrictId(district);
                        //mChildren.setDistrictId(jsonObjecta.get("districtId").getAsInt());
                        child_address.setDistrictId(jsonObjecta.get("districtId").getAsInt());
                    }

                    if (jsonObjecta.get("mandalId") != null) {
                        MMandal mMandal = (MMandal) session.load(MMandal.class, jsonObjecta.get("mandalId").getAsInt());
                        //mChildren.setMandalId(mMandal);
                        //mChildren.setMandalId(jsonObjecta.get("mandalId").getAsInt());
                        //child_address.setMandalId(jsonObjecta.get("mandalId").getAsInt());
                        child_address.setMandalId(mMandal);
                    }
                    if (jsonObjecta.get("villageName") != null) {
                        MVillage mVillage = (MVillage) session.load(MVillage.class, jsonObjecta.get("villageName").getAsInt());
                        //mChildren.setVillageId(mVillage);
                        //mChildren.setVillageId(jsonObjecta.get("villageName").getAsInt());
                        child_address.setVillageId(jsonObjecta.get("villageName").getAsInt());
                    }
                    if (jsonObjecta.get("address") != null) {
                        //mChildren.setAddress(jsonObjecta.get("address").getAsString());
                        child_address.setAddress(jsonObjecta.get("address").getAsString());
                    }

                    //child_academy.setChildId(csaveid);
                    child_academy.setChildId(mChild);
                    MAcademicyear ayear = (MAcademicyear) session.load(MAcademicyear.class, 2);
                    //child_academy.setAcademicyearId(2);
                    child_academy.setAcademicyearId(ayear);
                    child_academy.setCreatedOn(cuDate);
                    child_academy.setCreatedUserId(jsonObjecta.get("teamId").getAsInt());

                    if (jsonObjecta.get("schoolId") != null) {
                        MSchool mSchool = (MSchool) session.load(MSchool.class, jsonObjecta.get("schoolId").getAsInt());
                        //mChildren.setSchoolId(mSchool);
                        schId = jsonObjecta.get("schoolId").getAsInt();
                        //child_academy.setSchoolID(schId);
                        child_academy.setSchoolID(mSchool);
                    }
                    if (jsonObjecta.get("class") != null) {
                        child_academy.setClass1(jsonObjecta.get("class").getAsInt());
                    }

                    session.save(child_address);
                    session.save(child_academy);
                    
                    // mChildren.setChildId(new Long(jsonObjecta.get("childId").getAsString()));
                    //session.saveOrUpdate(mChildren);
                    //session.update(mChildren);
                } else { //if(!(jsonObjecta.get("isNew").getAsString()).equalsIgnoreCase("YES")){
                    mChildren.setId(jsonObjecta.get("childId").getAsInt());
                    session.saveOrUpdate(mChildren);
                    //if(jsonObjecta.get("childId")==null){
                    // csaveid=(long) session.save(mChildren);
                    //System.out.println("csaveid ::"+csaveid);
                }
            }

            if (jo.get("childabsent") != null) {
                JsonObject jsonChildAbse = jo.get("childabsent").getAsJsonObject();
                TAnthropometry childabsent = new TAnthropometry();

                if (jsonChildAbse.get("childId") != null) {
                    MChild child = (MChild) session.load(MChild.class, jsonChildAbse.get("childId").getAsInt());
                    //childabsent.setChildId(jsonChildAbse.get("childId").getAsInt());
                    childabsent.setChildId(child);
                } else {
                    MChild child = (MChild) session.load(MChild.class, csaveid);
                    //childabsent.setChildId(csaveid);
                    childabsent.setChildId(child);
                }
                if (jsonChildAbse.get("createdDate") != null) {
                    childabsent.setCreatedDate(dateFormat.parse(jsonChildAbse.get("createdDate").getAsString()));
                }
                if (jsonChildAbse.get("teamId") != null) {
                    MTeam mTeam = (MTeam) session.load(MTeam.class, jsonChildAbse.get("teamId").getAsInt());
                    //childabsent.setTeamId(jsonChildAbse.get("teamId").getAsInt());
                    childabsent.setTeamId(mTeam);
                }
                /*if (jsonChildAbse.get("result") != null) {
                    childabsent.setRemarks(jsonChildAbse.get("result").getAsString());
                }*/
                if (jsonChildAbse.get("remarks") != null) {
                    childabsent.setRemarks(jsonChildAbse.get("remarks").getAsString());
                }
                childabsent.setCreatedUserId(jsonChildAbse.get("teamId").getAsInt());
                int id = (int) session.save(childabsent);
            }
            // session.getTransaction().commit();
            result = "{\"status\":\"Success\",\"statusMessage\":\"Data Saved\"}";
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Data Sync failed\"}";
//            result.put("status", "Failed");
//            result.put("statusMessage", "File not Uploaded To server due to failure in file creation");
            //result.put("serId", null);
            return result;
        }
    }

    @Override
    public String versionDetailsGet() {
        String result = "";
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            String query = " from AndroidVersionControl where id = 1";
            List temp = session.createQuery(query).list();

            if (temp != null && temp.size() > 0) {
                AndroidVersionControl user = (AndroidVersionControl) temp.get(0);
                JsonObject version_details = new JsonObject();

                String codefromdb = user.getVersionCode().trim();
                String namefromdb = user.getVersionName().trim();
                String linkfromdb = user.getLink().trim();

                version_details.addProperty("code", codefromdb);
                version_details.addProperty("name", namefromdb);
                version_details.addProperty("link", linkfromdb);

                result = "{\"status\":\"Success\",\"version_object\":" + version_details + "}";
                return result;

            } else {
                System.out.println("In else");
                result = "{\"status\":\"Failed\",\"statusMessage\":\"No available data\"}";
                return result;
            }
        } catch (Exception e) {
            if (session != null) {
                e.printStackTrace();
                //session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Request failed\"}";
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public String syncOtherFindingDtls(JsonObject jo) {
        String result = "";
        Session session = null;
        session = getSessionFactory().openSession();
        int id;
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
        String image, file_string, fileStream, textDate, filPathabs, locFile, filePath, fil;
        byte[] bytes = null;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            TotherFindings otherFindings = new TotherFindings();
            if (jo.get("childid") != null && !jo.get("childid").getAsString().equals("")) {
                if (jo.get("schoolid") != null && !jo.get("schoolid").getAsString().equals("")) {
                    try {
                        MSchool mSchool = (MSchool) session.load(MSchool.class, jo.get("schoolid").getAsInt());
                        otherFindings.setSchoolid(mSchool);
                    } catch (Exception e) {
                        result = "{\"status\":\"Failed\",\"statusMessage\":\"Check Schoolid\"}";
                        return result;
                    }
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Check Schoolid\"}";
                    return result;
                }
                if (jo.get("childid") != null && !jo.get("childid").getAsString().equals("")) {
                    try {
                        otherFindings.setChildid(jo.get("childid").getAsString());
                    } catch (Exception e) {
                        result = "{\"status\":\"Failed\",\"statusMessage\":\"Check childid\"}";
                        return result;
                    }
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Check childid\"}";
                    return result;
                }
                if (jo.get("description") != null && !jo.get("description").getAsString().equals("")) {
                    try {
                        otherFindings.setDescription(jo.get("description").getAsString());
                    } catch (Exception e) {
                        result = "{\"status\":\"Failed\",\"statusMessage\":\"Check description\"}";
                        return result;
                    }
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Check description\"}";
                    return result;
                }
                if (jo.get("filepath") != null && !jo.get("filepath").getAsString().equals("")) {
                    try {
                        image = timeStamp + ".png";
                        file_string = jo.get("filepath").getAsString();
                        fileStream = file_string;
                        textDate = format.format(sqlDate);
                        bytes = Base64.decode(fileStream);
                        //E:\Dotnet Publish\RBSKTG\Images\FindingImages
                        locFile = "E:\\Dotnet Publish\\RBSKTG\\Images\\FindingImages\\" + image;
                        System.out.println("LocFile" + locFile);
                        File file = new File(locFile);
                        filPathabs = file.getAbsolutePath();
                        filePath = filPathabs.substring(0, filPathabs.lastIndexOf(File.separator));
                        fil = file.getPath();
                        boolean val = file.getParentFile().mkdirs();
                        FileOutputStream fop = null;

                        fop = new FileOutputStream(file);
                        fop.write(bytes);
                        fop.flush();
                        fop.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        result = "{\"status\":\"Failed\",\"statusMessage\":\"File not uploaded to server due to the failure in file creation\"}";
                        return result;
                    }
                    if (filePath != null) {
                        otherFindings.setFilepath(image);
                    }
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Check filepath\"}";
                    return result;
                }
                if (jo.get("deficiency") != null && !jo.get("deficiency").getAsString().equals("")) {
                    try {
                        otherFindings.setDeficiency(jo.get("deficiency").getAsString());
                    } catch (Exception e) {
                        result = "{\"status\":\"Failed\",\"statusMessage\":\"Check deficiency\"}";
                        return result;
                    }
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Check deficiency\"}";
                    return result;
                }
                otherFindings.setCreateddate(new Date());
                id = (int) session.save(otherFindings);
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Childid is null\"}";
                return result;
            }
            result = "{\"status\":\"Success\",\"statusMessage\":\"Data Saved\",\"id\" :" + id + "}";
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Data Sync failed\"}";
            return result;
        }
    }

    @Override
    public String syncFindingImagesForYesDtls(JsonObject jo) {
        long startTime = System.currentTimeMillis();
        String result = "";
        Session session = null;
        session = getSessionFactory().openSession();
        int id;
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
        String image, file_string, fileStream, textDate, filPathabs, locFile, filePath, fil;
        byte[] bytes = null;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            TfindingImages findingImages = new TfindingImages();
            if (jo.get("childid") != null && !jo.get("childid").getAsString().equals("")) {
                if (jo.get("schoolid") != null && !jo.get("schoolid").getAsString().equals("")) {
                    try {
                        MSchool mSchool = (MSchool) session.load(MSchool.class, jo.get("schoolid").getAsInt());
                        //findingImages.setSchoolid(jo.get("schoolid").getAsInt());
                        findingImages.setSchoolid(mSchool);
                    } catch (Exception e) {
                        result = "{\"status\":\"Failed\",\"statusMessage\":\"Check Schoolid\"}";
                        return result;
                    }
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Check Schoolid\"}";
                    return result;
                }
                if (jo.get("childid") != null && !jo.get("childid").getAsString().equals("")) {
                    try {
                        MChild mChild = (MChild) session.load(MChild.class, jo.get("childid").getAsInt());
                        findingImages.setChildid(mChild);
                    } catch (Exception e) {
                        result = "{\"status\":\"Failed\",\"statusMessage\":\"Check childid\"}";
                        return result;
                    }
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Check childid\"}";
                    return result;
                }
                if (jo.get("findingid") != null && !jo.get("findingid").getAsString().equals("")) {
                    try {
                        MFinding mFinding = (MFinding) session.load(MFinding.class, jo.get("findingid").getAsInt());
                        //findingImages.setFindingid(jo.get("findingid").getAsInt());
                        findingImages.setFindingid(mFinding);
                    } catch (Exception e) {
                        result = "{\"status\":\"Failed\",\"statusMessage\":\"Check findingid\"}";
                        return result;
                    }
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Check findingid\"}";
                    return result;
                }
                if (jo.get("filepath") != null && !jo.get("filepath").getAsString().equals("")) {
                    try {
                        image = timeStamp + ".png";
                        file_string = jo.get("filepath").getAsString();
                        fileStream = file_string;
                        textDate = format.format(sqlDate);
                        bytes = Base64.decode(fileStream);
                        locFile = "E:\\Dotnet Publish\\RBSKTG\\Images\\FindingImages\\" + image;
                        System.out.println("LocFile" + locFile);
                        File file = new File(locFile);
                        filPathabs = file.getAbsolutePath();
                        filePath = filPathabs.substring(0, filPathabs.lastIndexOf(File.separator));
                        fil = file.getPath();
                        boolean val = file.getParentFile().mkdirs();
                        FileOutputStream fop = null;

                        fop = new FileOutputStream(file);
                        fop.write(bytes);
                        fop.flush();
                        fop.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        result = "{\"status\":\"Failed\",\"statusMessage\":\"File not uploaded to server due to the failure in file creation\"}";
                        return result;
                    }
                    if (filePath != null) {
                        findingImages.setFilepath(image);
                    }
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Check filepath\"}";
                    return result;
                }
                findingImages.setStatus("Before");
                findingImages.setCreateddate(new Date());
                id = (int) session.save(findingImages);
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Childid is null\"}";
                return result;
            }
            result = "{\"status\":\"Success\",\"statusMessage\":\"Data Saved\",\"id\" :" + id + "}";
            logger.info(result);
            long endTime = System.currentTimeMillis();
            System.out.println("Time for Execution :: " + (endTime - startTime));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Data Sync failed\"}";
            logger.debug(result);
            return result;
        }
    }

    @Override
    public String validateDEICUser(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonObject jso = new JsonObject();
        session = getSessionFactory().openSession();

        try {
            SQLQuery query = session.createSQLQuery("select * from m_user where UserName = '" + jo.get("username").getAsString() + "' and Password='" + jo.get("password").getAsString() + "' and IsActive=1");

            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {
                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);

                    jso.addProperty("userid", "" + os[0]);
                    jso.addProperty("username", "" + os[1]);
                    jso.addProperty("roleid", "" + os[3]);
                    jso.addProperty("districtid", "" + os[4]);
                    jso.addProperty("hospitalid", "" + os[5]);
                    jso.addProperty("isactive", "" + os[6]);

                    result = "{\"status\":\"Success\",\"responseobj\":" + jso + "}";
                }
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Wrong username and password\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\", \"statusMessage\":" + e + "}";
            if (session != null) {
                e.printStackTrace();
                session.close();
            }
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public String getStudentMaster(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonArray jsa = new JsonArray();
        session = getSessionFactory().openSession();

        try {
            SQLQuery query = session.createSQLQuery("select * from m_school where DistrictId = " + jo.get("districtid").getAsString() + " and "
                    + "MandalId = " + jo.get("mandalid").getAsString() + " and VillageId = " + jo.get("villageid").getAsString() + " "
                    + "and CategoryId = " + jo.get("schoolcattype").getAsString() + "");

            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {
                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);
                    JsonObject jso = new JsonObject();

                    jso.addProperty("id", "" + os[0]);
                    jso.addProperty("code", "" + os[1]);
                    jso.addProperty("name", "" + os[2]);
                    jso.addProperty("mediumid", "" + os[3]);
                    jso.addProperty("districtid", "" + os[4]);
                    jso.addProperty("mandalid", "" + os[5]);
                    jso.addProperty("villageid", "" + os[6]);
                    jso.addProperty("latitude", "" + os[7]);
                    jso.addProperty("longitude", "" + os[8]);
                    jso.addProperty("categoryid", "" + os[11]);
                    jso.addProperty("noofstudents", "" + os[12]);
                    jsa.add(jso);
                }
                result = "{\"status\":\"Success\", \"responseArray\":" + jsa + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Data not available\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\", \"statusMessage\":" + e + "}";
            if (session != null) {
                e.printStackTrace();
                session.close();
            }
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public String getChildMasterFromSchool(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonArray jsa = new JsonArray();
        session = getSessionFactory().openSession();

        try {
            SQLQuery query = session.createSQLQuery("select * from m_child where SchoolId "
                    + "= " + jo.get("schoolid").getAsString() + " and class = " + jo.get("classid").getAsString() + "");

            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {
                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);
                    JsonObject jso = new JsonObject();

                    jso.addProperty("id", "" + os[0]);
                    jso.addProperty("ucid", "" + os[1]);
                    jso.addProperty("name", "" + os[2]);
                    jso.addProperty("fathername", "" + os[3]);
                    jso.addProperty("mothername", "" + os[4]);
                    jso.addProperty("dob", "" + os[5]);
                    jso.addProperty("gender", "" + os[6]);
                    jso.addProperty("caste", "" + os[7]);
                    jso.addProperty("religion", "" + os[8]);
                    jso.addProperty("mothertongue", "" + os[9]);
                    jso.addProperty("disability", "" + os[10]);
                    jso.addProperty("mobileno", "" + os[11]);
                    jso.addProperty("aadhaarno", "" + os[12]);
                    jso.addProperty("class", "" + os[13]);
                    jso.addProperty("schoolid", "" + os[14]);
                    jso.addProperty("address", "" + os[15]);
                    jso.addProperty("districtid", "" + os[16]);
                    jso.addProperty("mandalid", "" + os[17]);
                    jso.addProperty("villageid", "" + os[18]);
                    jso.addProperty("createdteamid", "" + os[19]);
                    jso.addProperty("govtudic", "" + os[23]);
                    jsa.add(jso);
                }
                result = "{\"status\":\"Success\", \"responseArray\":" + jsa + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Data not available\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\", \"statusMessage\":" + e + "}";
            if (session != null) {
                e.printStackTrace();
                session.close();
            }
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public String getChildMasterFromAnthropometry(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonArray jsa = new JsonArray();
        session = getSessionFactory().openSession();

        try {
            SQLQuery query = session.createSQLQuery("select * from m_child where SchoolId = " + jo.get("schoolid").getAsString() + "");

            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {
                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);
                    JsonObject jso = new JsonObject();

                    jso.addProperty("id", "" + os[0]);
                    jso.addProperty("ucid", "" + os[1]);
                    jso.addProperty("name", "" + os[2]);
                    jso.addProperty("fathername", "" + os[3]);
                    jso.addProperty("mothername", "" + os[4]);
                    jso.addProperty("dob", "" + os[5]);
                    jso.addProperty("gender", "" + os[6]);
                    jso.addProperty("caste", "" + os[7]);
                    jso.addProperty("religion", "" + os[8]);
                    jso.addProperty("mothertongue", "" + os[9]);
                    jso.addProperty("disability", "" + os[10]);
                    jso.addProperty("mobileno", "" + os[11]);
                    jso.addProperty("aadhaarno", "" + os[12]);
                    jso.addProperty("class", "" + os[13]);
                    jso.addProperty("schoolid", "" + os[14]);
                    jso.addProperty("address", "" + os[15]);
                    jso.addProperty("districtid", "" + os[16]);
                    jso.addProperty("mandalid", "" + os[17]);
                    jso.addProperty("villageid", "" + os[18]);
                    jso.addProperty("createdteamid", "" + os[19]);
                    jso.addProperty("govtudic", "" + os[23]);
                    jsa.add(jso);
                }
                result = "{\"status\":\"Success\", \"responseArray\":" + jsa + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Data not available\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\", \"statusMessage\":" + e + "}";
            if (session != null) {
                e.printStackTrace();
                session.close();
            }
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public String getTreatmentCompletedChildList(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonArray jsa = new JsonArray();
        session = getSessionFactory().openSession();

        try {
            SQLQuery query = session.createSQLQuery("execute GetTreatmentCompletedChildList :param1");
            query.setString("param1", jo.get("deicloginid").getAsString());

            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {
                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);
                    JsonObject jso = new JsonObject();

                    jso.addProperty("childid", "" + os[0]);
                    jso.addProperty("childname", "" + os[1]);
                    jso.addProperty("schoolid", "" + os[2]);
                    jso.addProperty("findingid", "" + os[3]);
                    jso.addProperty("tranfindingid", "" + os[4]);
                    jso.addProperty("description", "" + os[5]);
                    jsa.add(jso);
                }
                result = "{\"status\":\"Success\", \"responseArray\":" + jsa + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Data not available\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\", \"statusMessage\":" + e + "}";
            if (session != null) {
                e.printStackTrace();
                session.close();
            }
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public String saveAfterScreeningImgDtls(JsonObject jo) {
        String result = "";
        Session session = null;
        int finid = 0;
        byte[] bytes = null;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
        String image, file_string, fileStream, textDate, filPathabs, locFile, filePath, fil;
        session = getSessionFactory().openSession();

        try {
            TfindingImages findingImgs = new TfindingImages();

            if (jo.get("schoolid") != null) {
                try {
                    MSchool mSchool = (MSchool) session.load(MSchool.class, jo.get("schoolid").getAsInt());
                    //findingImgs.setSchoolid(jo.get("schoolid").getAsInt());
                    findingImgs.setSchoolid(mSchool);
                } catch (Exception e) {
                    e.printStackTrace();
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Request failed for schoolid\"}";
                    return result;
                }
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Check schoolid\"}";
                return result;
            }
            if (jo.get("childid") != null) {
                try {
                    MChild mChild = (MChild) session.load(MChild.class, jo.get("childid").getAsInt());
                    //findingImgs.setChildid(jo.get("childid").getAsInt());
                    findingImgs.setChildid(mChild);
                } catch (Exception e) {
                    e.printStackTrace();
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Request failed for childid\"}";
                    return result;
                }
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Check childid\"}";
                return result;
            }
            if (jo.get("findingid") != null) {
                try {
                    MFinding mFinding = (MFinding) session.load(MFinding.class, jo.get("findingid").getAsInt());
                    //findingImgs.setFindingid(jo.get("findingid").getAsInt());
                    findingImgs.setFindingid(mFinding);
                } catch (Exception e) {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Request failed for findingid\"}";
                    return result;
                }
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Check findingid\"}";
                return result;
            }
            if (jo.get("tranfindingid") != null) {
                try {
                    findingImgs.setTranfindingid(jo.get("tranfindingid").getAsInt());
                } catch (Exception e) {
                    e.printStackTrace();
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Request failed for tranfindingid\"}";
                    return result;
                }
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Check tranfindingid\"}";
                return result;
            }
            if (jo.get("imagepath") != null) {
                try {
                    image = timeStamp + ".png";
                    file_string = jo.get("imagepath").getAsString();
                    fileStream = file_string;
                    textDate = df.format(sqlDate);
                    bytes = Base64.decode(fileStream);
                    //E:\DotnetPublish\RBSK\Images\FindingImages
                    locFile = "E:\\Dotnet Publish\\RBSKTG\\Images\\FindingImages\\" + image;
                    System.out.println("LocFile" + locFile);
                    File file = new File(locFile);
                    filPathabs = file.getAbsolutePath();
                    filePath = filPathabs.substring(0, filPathabs.lastIndexOf(File.separator));
                    fil = file.getPath();
                    boolean val = file.getParentFile().mkdirs();
                    FileOutputStream fop = null;

                    fop = new FileOutputStream(file);
                    fop.write(bytes);
                    fop.flush();
                    fop.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"File not uploaded to server due to the failure in file creation\"}";
                    return result;
                }
                if (filePath != null) {
                    findingImgs.setFilepath(image);
                }
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Check imagepath\"}";
                return result;
            }
            findingImgs.setStatus("After");
            findingImgs.setCreateddate(new Date());

            finid = (int) session.save(findingImgs);
            result = "{\"status\":\"Success\",\"statusMessage\":\"Data inserted Successfully\",\"finid\":\"" + finid + "\"}";
            logger.info(result);
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
            }
            result = "{\"status\":\"Failed\", \"statusMessage\":" + e + "}";
            logger.debug(result);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public String saveRescheduleDates(JsonObject jo) {
        String result = "";
        Session session = null;
        session = getSessionFactory().openSession();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        int id;
        try {
            TTeamschedule reschedule = new TTeamschedule();
            if (jo.get("teamId") != null) {
                try {
                    MTeam mTeam = (MTeam) session.load(MTeam.class, jo.get("teamId").getAsInt());
                    //reschedule.setTeamId(jo.get("teamId").getAsInt());
                    reschedule.setTeamId(mTeam);
                } catch (Exception e) {
                    e.printStackTrace();
                    result = "{\"status\":\"Failed\", \"statusMessage\":\"Check Teamid\"}";
                    return result;
                }
            } else {
                result = "{\"status\":\"Failed\", \"statusMessage\":\"Check Teamid\"}";
                return result;
            }
            if (jo.get("schoolId") != null) {
                try {
                    MSchool mSchool = (MSchool) session.load(MSchool.class, jo.get("schoolId").getAsInt());
                    //reschedule.setSchoolId(jo.get("schoolId").getAsInt());
                    reschedule.setSchoolId(mSchool);
                } catch (Exception e) {
                    e.printStackTrace();
                    result = "{\"status\":\"Failed\", \"statusMessage\":\"Check schoolid\"}";
                    return result;
                }
            } else {
                result = "{\"status\":\"Failed\", \"statusMessage\":\"Check schoolid\"}";
                return result;
            }

            if (jo.get("scheduledDate") != null) {
                try {
                    reschedule.setScheduledDate(dateformat.parse(jo.get("scheduledDate").getAsString()));
                } catch (Exception e) {
                    e.printStackTrace();
                    result = "{\"status\":\"Failed\", \"statusMessage\":\"Check scheduleddate\"}";
                    return result;
                }
            } else {
                result = "{\"status\":\"Failed\", \"statusMessage\":\"Check scheduleddate\"}";
                return result;
            }
            if (jo.get("remarks") != null) {
                try {
                    reschedule.setRemarks(jo.get("remarks").getAsString());
                } catch (Exception e) {
                    e.printStackTrace();
                    result = "{\"status\":\"Failed\", \"statusMessage\":\"Check remarks\"}";
                    return result;
                }
            } else {
                result = "{\"status\":\"Failed\", \"statusMessage\":\"Check remarks\"}";
                return result;
            }
            if (jo.get("targetStudents") != null) {
                try {
                    reschedule.setTargetStudents(jo.get("targetStudents").getAsInt());
                } catch (Exception e) {
                    e.printStackTrace();
                    result = "{\"status\":\"Failed\", \"statusMessage\":\"Check targetstudents\"}";
                    return result;
                }
            } else {
                result = "{\"status\":\"Failed\", \"statusMessage\":\"Check targetstudents\"}";
                return result;
            }
            reschedule.setDataSource("Tab");
            reschedule.setCreatedDate(new Date());
            reschedule.setScheduleType("Reschedule");
            reschedule.setIsDeleted(false);
//            if (jo.get("screeneddate") != null) {
//                try {
//                    reschedule.setScreenedDate(format.parse(jo.get("screeneddate").getAsString()));
//                } catch (Exception e) {
//                    result = "{\"status\":\"Failed\", \"statusMessage\":\"Check screeneddate\"}";
//                    return result;
//                }
//            } else {
//                result = "{\"status\":\"Failed\", \"statusMessage\":\"Check screeneddate\"}";
//                return result;
//            }
            id = (int) session.save(reschedule);
            result = "{\"status\":\"Success\",\"statusMessage\":\"Data inserted Successfully\",\"id\":\"" + id + "\"}";
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
            }
            result = "{\"status\":\"Failed\", \"statusMessage\":" + e + "}";
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public String getTabletMaster(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonArray jsa = new JsonArray();
        session = getSessionFactory().openSession();

        try {
            SQLQuery query = session.createSQLQuery("select * from m_tablet");

            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {
                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);
                    JsonObject jso = new JsonObject();

                    jso.addProperty("id", "" + os[0]);
                    jso.addProperty("name", "" + os[1]);
                    jso.addProperty("description", "" + os[2]);
                    jso.addProperty("type", "" + os[3]);
                    jsa.add(jso);
                }
                result = "{\"status\":\"Success\", \"responseArray\":" + jsa + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Data not available\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\", \"statusMessage\":" + e + "}";
            if (session != null) {
                e.printStackTrace();
                session.close();
            }
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
