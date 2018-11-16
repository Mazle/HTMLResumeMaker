package hello.repositories;

import hello.model.SeekerDescription;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface SeekerDescriptionRepository {
    public SeekerDescription getSeekerDescription(String ... sources);
    final String[] KEYS = {"FIO","BirthDate","TelNumber","E-Mail","Target","Experience","Education","AdditionalEducation",
            "Skills","CodeExample","ImageSrc"};

}
