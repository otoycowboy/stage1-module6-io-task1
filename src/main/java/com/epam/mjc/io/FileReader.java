package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            profile.setName(getClearInfo(fileInputStream));
            profile.setAge(Integer.valueOf(getClearInfo(fileInputStream)));
            profile.setEmail(getClearInfo(fileInputStream));
            profile.setPhone(Long.valueOf(getClearInfo(fileInputStream)));
        } catch (IOException | NumberFormatException e) {
            return null;
        }
        return profile;
    }

    private String getClearInfo(FileInputStream stream) throws IOException {
        StringBuilder info = new StringBuilder();
        int c;
        while ((c = stream.read()) !=  '\n') {
            info.append((char) c);
        }

        info = new StringBuilder(info.substring(info.toString().lastIndexOf(':') + 1).trim());
        return info.toString();
    }

}
