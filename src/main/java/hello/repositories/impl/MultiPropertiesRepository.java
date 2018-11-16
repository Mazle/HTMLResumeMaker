package hello.repositories.impl;

import hello.model.SeekerDescription;
import hello.Service.SeekerDescriptionProvider;
import hello.repositories.SeekerDescriptionRepository;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

@Repository
public class MultiPropertiesRepository implements SeekerDescriptionRepository {
    private ArrayList<String> propertyFileSource = new ArrayList<>();
    private SeekerDescription seekerDescription = null;
    public SeekerDescription getSeekerDescription(String ... filePaths){

        if (filePaths.length>0) {
        propertyFileSource.addAll(Arrays.asList(filePaths));
        seekerDescription = new SeekerDescription();
            propertyFileSource.stream().forEach((filePath) -> {
                //вызов потоков
                new ReadingProperties(filePath,filePath);
            });
        }
        return seekerDescription;
    }
    private class ReadingProperties extends Thread{
        private String filePath;

        public ReadingProperties(String name, String filePath) {
            super(name);
            this.filePath = filePath;
        }

        @Override
        public void run() {
            try(FileInputStream fis = new FileInputStream(filePath)) {
                Properties property = new Properties();
                property.load(fis);
                Arrays.stream(KEYS).forEach((key)->{
                    //не самая лучшая реализация, но оставлю на рефакторинг, если будет время
                    if (property.containsKey(key)) {
                        switch (key){
                            case "FIO": seekerDescription.setFio(property.getProperty(key));
                            case "BirthDate": seekerDescription.setBirthDate(property.getProperty(key));
                            case "TelNumber": seekerDescription.setTelNumber(
                                    (ArrayList<String>) Arrays.asList(
                                            property.getProperty(key).split("\n")
                                    )
                            );
                            case "E-Mail": seekerDescription.seteMail(
                                    (ArrayList<String>) Arrays.asList(
                                            property.getProperty(key).split("\n")
                                    )
                            );
                            case "Target": seekerDescription.setTarget(
                                    (ArrayList<String>) Arrays.asList(
                                            property.getProperty(key).split("\n")
                                    )
                            );
                            case "Experience": seekerDescription.setExperience(
                                    (ArrayList<String>) Arrays.asList(
                                            property.getProperty(key).split("\n")
                                    )
                            );
                            case "Education": seekerDescription.setEducation(
                                    (ArrayList<String>) Arrays.asList(
                                            property.getProperty(key).split("\n")
                                    )
                            );
                            case "AdditionalEducation": seekerDescription.setAdditionalEducation(
                                    (ArrayList<String>) Arrays.asList(
                                            property.getProperty(key).split("\n")
                                    )
                            );
                            case "Skills": seekerDescription.setSkills(
                                    (ArrayList<String>) Arrays.asList(
                                            property.getProperty(key).split("\n")
                                    )
                            );
                            case "CodeExample": seekerDescription.setCodeExample(
                                    (ArrayList<String>) Arrays.asList(
                                            property.getProperty(key).split("\n")
                                    )
                            );
                            case "ImageSrc": seekerDescription.setImgSrc(
                                    (ArrayList<String>) Arrays.asList(
                                            property.getProperty(key).split("\n")
                                    )
                            );
                             default:

                        }

                    }
                });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Property File не найден");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
