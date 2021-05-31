/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.common.validators;

//import com.icesoft.faces.component.inputfile.FileInfo;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Pattern;
import org.icefaces.ace.component.fileentry.FileEntryResults;
import org.icefaces.ace.component.fileentry.FileEntryResults.FileInfo;


/**
 *
 * @author Padmasri
 */
public class CommonFileUploadValidation {   
    public static String validateFile(FileInfo results ,Long len) {
         final String WHITELIST = "([^|!`@#$%&*\\/.+=]+(\\.(?i)(jpg|jpeg|pdf))$)"; //while list character to be allowed in file name
        String ext = null;
        String fileFullName = null;
        String fileName = null;
        String errorMsg = "";
        String contentType = null;
        String bytestring;
        try {
            //System.out.println("in try");
            File uploadedFile = results.getFile();//get the uploaded file object
            if(uploadedFile!=null){
            //System.out.println("the file status LLL::::"+fileInfo.getStatus());
             if (results.getStatus()==results.getStatus()) {
            
            fileName = uploadedFile.getName();//complete file name
            ext = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length()); //Getting file extension
            fileFullName = fileName.substring(fileName.lastIndexOf('\\') + 1, fileName.length()); //Getting file name
            contentType = results.getContentType();
            FileInputStream fileInputStream = new FileInputStream(uploadedFile);
            byte[] bytes = new byte[(int) uploadedFile.length()];
            fileInputStream.read(bytes); //converting file content in byte
            bytestring = new String(bytes);//converting byte in string
//System.out.println("the byte streem:::::"+bytestring);
            //System.out.println("the values::: fileFullName"+fileFullName);
                 //System.out.println("contentType:::"+contentType);
                 //System.out.println("ext::::"+ext);
            if (Pattern.matches(WHITELIST, fileFullName) == false || ext == null || fileFullName == null) {
                errorMsg = "no special character allowed in the name of file only a-zA-Z0-9_~-:()- characters are allowed";
                if(!(ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("jpeg") || ext.equalsIgnoreCase("jpg")))
                {
                    errorMsg="Wrong File Type! Upload PDF or JPEG format file only";
                }
                return errorMsg;
            }
            else if ((contentType.equalsIgnoreCase("application/pdf") || contentType.equalsIgnoreCase("application/.pdf")
                    || contentType.equalsIgnoreCase("image/jpeg") || contentType.equalsIgnoreCase("image/pjpeg")
                   || contentType.equalsIgnoreCase("image/jpg") )&&
                    (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("jpeg") || ext.equalsIgnoreCase("jpg"))) {
                if(bytestring.indexOf("%PDF") == 0 && (contentType.equalsIgnoreCase("application/pdf") || contentType.equalsIgnoreCase("application/.pdf")))
                {
                   if(uploadedFile.length()>len)
                        return "File Size is Huge! Please upload a file of size less than 2mb.";
                }
                else if( bytestring.indexOf("JFIF") > 0 && (contentType.equalsIgnoreCase("image/jpeg")
                   || contentType.equalsIgnoreCase("image/pjpeg") || contentType.equalsIgnoreCase("image/jpg")))//checks the content of the file
                {
                    if(uploadedFile.length()>len)
                        return "File Size is Huge! Please upload a file of size less than 2mb.";
                    
                } else {
                    return "Upload failed,Malicious File";
                }
            } else {
                return "Wrong File Type! Upload PDF or JPEG format file only ";
            }
                 fileInputStream.close();
             }else{
                String  fileTypeMsg = "File upload Failed";
                 if (uploadedFile.length() == 0) {
                    fileTypeMsg = fileTypeMsg + ",it's size is Zero";
                }
//                 else if (results.getStatus() == FileInfo.INVALID_CONTENT_TYPE) {
//                    fileTypeMsg = fileTypeMsg + ",it's content type is unknown";
//                }
//                else if (results.getStatus() == FileInfo.INVALID_NAME_PATTERN) {
//                    fileTypeMsg = fileTypeMsg + ",it's name pattren is wrong";
//                }
                return fileTypeMsg;
             }
            }
            else
                return "Invalid file upload";
        } catch (Exception e) {
            errorMsg = "Failed to validate the uploaded File";
            e.printStackTrace();
        }finally{
            
        }
        return errorMsg;
    }


    public static String validateFile(FileEntryResults name, Long len) {
        System.out.println("name is::"+name);
//       final String WHITELIST = "([^|!`@#$%&*\\/.+=]+(\\.(?i)(jpg|jpeg|pdf))$)"; //while list character to be allowed in file name
//        String ext = null;
//        String fileFullName = null;
//        String fileName = null;
        String errorMsg = "";
//        String contentType = null;
//        String bytestring;
//        try {
//            //System.out.println("in try");
//            File uploadedFile = fileInfo.getFile();//get the uploaded file object
//            if(uploadedFile!=null){
//            //System.out.println("the file status LLL::::"+fileInfo.getStatus());
//             if (fileInfo.getStatus() == FileInfo.SAVED) {
//                 fileName = uploadedFile.getName();//complete file name
//            ext = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length()); //Getting file extension
//            fileFullName = fileName.substring(fileName.lastIndexOf('\\') + 1, fileName.length()); //Getting file name
//            contentType = fileInfo.getContentType();
//            FileInputStream fileInputStream = new FileInputStream(uploadedFile);
//            byte[] bytes = new byte[(int) uploadedFile.length()];
//            fileInputStream.read(bytes); //converting file content in byte
//            bytestring = new String(bytes);//converting byte in string
////System.out.println("the byte streem:::::"+bytestring);
//            //System.out.println("the values::: fileFullName"+fileFullName);
//                 //System.out.println("contentType:::"+contentType);
//                 //System.out.println("ext::::"+ext);
//            if (Pattern.matches(WHITELIST, fileFullName) == false || ext == null || fileFullName == null) {
//                errorMsg = "no special character allowed in the name of file only a-zA-Z0-9_~-:()- characters are allowed";
//                if(!(ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("jpeg") || ext.equalsIgnoreCase("jpg")))
//                {
//                    errorMsg="Wrong File Type! Upload PDF or JPEG format file only";
//                }
//                return errorMsg;
//            }
//            else if ((contentType.equalsIgnoreCase("application/pdf") || contentType.equalsIgnoreCase("application/.pdf")
//                    || contentType.equalsIgnoreCase("image/jpeg") || contentType.equalsIgnoreCase("image/pjpeg")
//                   || contentType.equalsIgnoreCase("image/jpg") )&&
//                    (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("jpeg") || ext.equalsIgnoreCase("jpg"))) {
//                if(bytestring.indexOf("%PDF") == 0 && (contentType.equalsIgnoreCase("application/pdf") || contentType.equalsIgnoreCase("application/.pdf")))
//                {
//                   if(uploadedFile.length()>len)
//                        return "File Size is Huge! Please upload a file of size less than 2mb.";
//                }
//                else if( bytestring.indexOf("JFIF") > 0 && (contentType.equalsIgnoreCase("image/jpeg")
//                   || contentType.equalsIgnoreCase("image/pjpeg") || contentType.equalsIgnoreCase("image/jpg")))//checks the content of the file
//                {
//                    if(uploadedFile.length()>len)
//                        return "File Size is Huge! Please upload a file of size less than 2mb.";
//                    
//                } else {
//                    return "Upload failed,Malicious File";
//                }
//            } else {
//                return "Wrong File Type! Upload PDF or JPEG format file only ";
//            }
//                 fileInputStream.close();
//             }else{
//                String  fileTypeMsg = "File upload Failed";
//                 if (uploadedFile.length() == 0) {
//                    fileTypeMsg = fileTypeMsg + ",it's size is Zero";
//                }
//                 else if (fileInfo.getStatus() == FileInfo.INVALID_CONTENT_TYPE) {
//                    fileTypeMsg = fileTypeMsg + ",it's content type is unknown";
//                }
//                else if (fileInfo.getStatus() == FileInfo.INVALID_NAME_PATTERN) {
//                    fileTypeMsg = fileTypeMsg + ",it's name pattren is wrong";
//                }
//                return fileTypeMsg;
//             }
//            }
//            else
//                return "Invalid file upload";
//        
//             }catch(Exception e){
//                  errorMsg = "Failed to validate the uploaded File";
//                  e.printStackTrace();
//             }
//                     
      return errorMsg;
    }

    
    
    
}
