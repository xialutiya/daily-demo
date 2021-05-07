package xilalu.test;

import org.springframework.util.IdGenerator;
import org.springframework.util.StringUtils;
import xilalu.enumtest.BackReasonEnum;
import xilalu.id.IdGenerateUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author lds
 * @date 2020/12/30 13:51
 */
public class FileTestThree {
    public static void main(String[] args) throws IOException {


        String backOrderSql = "INSERT INTO sales_crm_back_order (ID,REASON,CREATOR_ID,REMARK,CRM_ORDER_ID,LAST_UPDATOR,CREATOR,LAST_UPDATE_DT,LAST_UPDATOR_ID,CREATE_DT,DELETED) VALUES ('xialuBackId','xialuOne','crm','xialuTwo','xialuThree','crm','crm',NOW(),'crm',NOW(),0);";
        String updateCrmOrderSql = "UPDATE sales_crm_order_send SET `status` = '4' AND last_update_dt = NOW() WHERE crm_order_id = 'xialu' AND `status` IN ('1', '2', '3');";
        String attachmentSql = "INSERT INTO sales_attachment ( ID, CREATOR_ID, BUSINESS_ID, UPLOAD_DT, SUFFIX, ORG_ID, PATH, LAST_UPDATOR, CREATOR, LAST_UPDATE_DT, LAST_UPDATOR_ID, CREATE_DT, DELETED, SIZE, NAME, BUSINESS_TYPE ) VALUES ('attachmentId', 'admin', 'xialuId', 'xialuDt', 'xialuTwo', 'xialuOne', 'xialuPath', 'admin', 'admin', NOW(), 'admin', NOW(), 0, 187699, 'crm.jpg', 'back_order' );";


        String filePath = "E:\\work\\documentSpace\\电商春节期间退单数据刷入\\入参信息.txt";
        String filePathTwo = "E:\\work\\documentSpace\\电商春节期间退单数据刷入\\入参crmOrderId和crmId的关系.txt";
        String filePathThree = "E:\\work\\documentSpace\\电商春节期间退单数据刷入\\crmOrderId和商场的关系.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
        BufferedReader bufferedReaderTwo = new BufferedReader(new FileReader(new File(filePathTwo)));
        BufferedReader bufferedReaderThree = new BufferedReader(new FileReader(new File(filePathThree)));
        StringBuffer sb = new StringBuffer();
        List<String> list = new ArrayList<>();
        List<String> updateCrm = new ArrayList<>();
        List<String> insertBackSql = new ArrayList<>();
        List<String> attachArr = new ArrayList<>();
        String s;
        Map<String, String> map = new HashMap<>();
        while ((s = bufferedReaderTwo.readLine()) != null) {
            String[] s1 = s.split("\t");
            map.put(s1[0], s1[1]);
        }
        Map<String, String> mapOrg = new HashMap<>();
        while ((s = bufferedReaderThree.readLine()) != null) {
            String[] s1 = s.split("\t");
            mapOrg.put(s1[0], s1[1]);
        }
        while ((s = bufferedReader.readLine()) != null) {

            String attachmengId = IdGenerateUtil.generateId();
            String backOrderId = IdGenerateUtil.generateId();

            if (!StringUtils.isEmpty(s)) {
                String[] s1 = s.split("\t");
                if (s1.length < 4) {
                    list.add(s);
                    continue;
                }
                String crmOrderId = s1[0];
                String dt = s1[1];
                String crmId = map.get(crmOrderId);
                if (StringUtils.isEmpty(crmId)) continue;
                String type = s1[2];
                String nameByValue = BackReasonEnum.getNameByValue(type);
                String remark = s1[3];
                if (s1.length == 4) {
                    String xialu = updateCrmOrderSql.replace("xialu", crmId);
                    updateCrm.add(xialu);
                    String replace = backOrderSql.replace("xialuBackId", backOrderId)
                            .replace("xialuOne", nameByValue)
                            .replace("xialuTwo", remark).replace("xialuThree", crmId);
                    insertBackSql.add(replace);
                } else if (s1.length == 5) {

                    String urlOne = s1[4];
                    if (!StringUtils.isEmpty(urlOne) && urlOne.length() > 8) {
                        int i = urlOne.lastIndexOf(".");
                        String sub = urlOne.substring(++i);
                        String attachment = attachmentSql.replace("attachmentId", attachmengId)
                                .replace("xialuId", backOrderId)
                                .replace("xialuDt", dt).replace("xialuOne", mapOrg.get(crmOrderId))
                                .replace("xialuPath", urlOne).replace("xialuTwo", sub);
                        attachArr.add(attachment);
                    }

                    String xialu = updateCrmOrderSql.replace("xialu", crmId);
                    updateCrm.add(xialu);
                    String replace = backOrderSql.replace("xialuBackId", backOrderId)
                            .replace("xialuOne", nameByValue)
                            .replace("xialuTwo", remark).replace("xialuThree", crmId);
                    insertBackSql.add(replace);
                } else if (s1.length == 6) {

                    String urlOne = s1[4];
                    if (!StringUtils.isEmpty(urlOne) && urlOne.length() > 8) {
                        int i = urlOne.lastIndexOf(".");
                        String sub = urlOne.substring(++i);
                        String attachment = attachmentSql.replace("attachmentId", attachmengId)
                                .replace("xialuId", backOrderId)
                                .replace("xialuDt", dt).replace("xialuOne", mapOrg.get(crmOrderId))
                                .replace("xialuPath", urlOne).replace("xialuTwo", sub);
                        attachArr.add(attachment);
                    }

                    String urlTwo = s1[5];
                    if (!StringUtils.isEmpty(urlTwo) && urlTwo.length() > 8) {
                        int i = urlOne.lastIndexOf(".");
                        String sub = urlOne.substring(++i);
                        String attachment = attachmentSql.replace("attachmentId", attachmengId)
                                .replace("xialuId", backOrderId)
                                .replace("xialuDt", dt).replace("xialuOne", mapOrg.get(crmOrderId))
                                .replace("xialuPath", urlTwo).replace("xialuTwo", sub);
                        attachArr.add(attachment);
                    }

                    String xialu = updateCrmOrderSql.replace("xialu", crmId);
                    updateCrm.add(xialu);
                    String replace = backOrderSql.replace("xialuBackId", backOrderId)
                            .replace("xialuOne", nameByValue)
                            .replace("xialuTwo", remark).replace("xialuThree", crmId);
                    insertBackSql.add(replace);
                }
            }

        }
//        for (String crm : updateCrm) {
//            System.out.println(crm);
//        }
//        for (String back : insertBackSql) {
//            System.out.println(back);
//        }
        StringBuffer sbAtt = new StringBuffer();
        for (String atta : attachArr) {
//            System.out.println(atta);
            sbAtt.append(atta);
        }
        return;
    }
}
