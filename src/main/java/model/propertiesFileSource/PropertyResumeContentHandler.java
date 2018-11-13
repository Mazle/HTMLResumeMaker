package main.java.model.propertiesFileSource;

import main.java.model.beans.SeekerDescription;
import main.java.model.SeekerDescriptionHandler;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by PalibinFamily on 12.06.2018.
 * Данный класс описывает механику создания сущности на основании изъятой из properties file информации и по своей сути
 * является обработчиком.
 */
public class PropertyResumeContentHandler implements SeekerDescriptionHandler {
    private static final Logger log = Logger.getLogger(PropertyResumeContentHandler.class);
    private Properties property = new Properties();
    @Override

    public SeekerDescription getSeekerDescription(String fileName) {
        SeekerDescription seekerDescription = new SeekerDescription();
        loadPropertyByName(fileName);
        try {
            seekerDescription.setFio(getListFromField("FIO"))
                    .setBirthDate(getListFromField("BirthDate"))
                    .setTelNumber(getListFromField("TelNumber"))
                    .seteMail(getListFromField("E-Mail"))
                    .setTarget(getListFromField("Target"))
                    .setExperience(getListFromField("Experience"))
                    .setEducation(getListFromField("Education"))
                    .setAdditionalEducation(getListFromField("AdditionalEducation"))
                    .setSkills(getListFromField("Skills"))
                    .setCodeExample(getListFromField("CodeExample"))
                    .setImgSrc(getListFromField("ImageSrc"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("Data extracted for seeker" + seekerDescription.getFio());
        System.out.println(seekerDescription.getAdditionalEducation().get(0));
        return seekerDescription;
    }

    private void loadPropertyByName(String name) {
        try {
            FileInputStream fis = new FileInputStream(name);
            property.load(fis);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует! " + name);
        }

    }

    private ArrayList<String> getListFromField(String key) throws UnsupportedEncodingException {
        String propertyValueContent;
        try {
            propertyValueContent = new String(property.getProperty(key).getBytes("ISO8859-1"), "CP1251");
        } catch (NullPointerException e) {
            propertyValueContent = "Значение не задано";

        }
        ArrayList<String> listFromField = new ArrayList<>();
        for (String value: propertyValueContent.split("\n")) {
            listFromField.add(value);
        }
        if (listFromField.size()<2&&listFromField.get(0).contains(":")) {
            HashMap<String,String> fieldMap = new HashMap<>();
            for (String pair: listFromField.get(0).split(",")) {
                String[] kvArray = pair.split(":");
                fieldMap.put(kvArray[0],kvArray[1]);
            }
            fieldMap.entrySet()
                    .stream()
                    .sorted((a,b)->(Integer.parseInt(b.getValue()) - Integer.parseInt(a.getValue())))
                    .forEach(a->listFromField.add(a.getKey()+":"+a.getValue()));
            listFromField.remove(0);
        }
        return  listFromField;
    }

}


