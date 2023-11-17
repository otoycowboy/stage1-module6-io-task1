package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            profile.setName(getClearInfo(fileInputStream));
            profile.setAge(Integer.valueOf(getClearInfo(fileInputStream)));
            profile.setEmail(getClearInfo(fileInputStream));
            profile.setPhone(Long.valueOf(getClearInfo(fileInputStream)));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("In&Out don't work (only till 7pm))");
        } catch (NumberFormatException e) {
            System.out.println("Nope... Numbers with chars");
        }
        return profile;
    }

    private String getClearInfo(FileInputStream stream) throws IOException {
        String info = "";
        int c;
        while ((c = stream.read()) !=  '\n') {
            info += (char) c;
        }

        info = info.substring(info.lastIndexOf(':') + 1).trim();
        return info;
    }

}
