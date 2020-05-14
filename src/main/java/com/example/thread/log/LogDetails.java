package com.example.thread.log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class LogDetails {
    private String commitId;
    private String uniqueId;
    private String message;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public void incrementCount() {
        this.atomicInteger.set(2);
    }

    public void decrementCount(){
        this.atomicInteger.getAndDecrement();
    }

    public LogDetails(String commitId, String message, String consumerId) {
        this.commitId = commitId;
        this.uniqueId = uniqueIdGenerator(consumerId);
        this.message = message;
    }

    private String uniqueIdGenerator(String prefix){
        StringBuilder sb = new StringBuilder(prefix);
        return sb.append("_").append(getRandomString(10)).toString();
    }

    /**
     * getRandomString
     * @param stringLength
     * @return
     */
    public static String getRandomString(int stringLength){
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder builder = new StringBuilder();
        while (stringLength-- != 0) {
            int character = (int)(Math.random()*CHARACTERS.length());
            builder.append(CHARACTERS.charAt(character));
        }
        builder.append("_").append(currentDateTime());
        return builder.toString();
    }

    /**
     * currentDateTime
     * @return
     */
    private static String currentDateTime() {
        String DATE_FORMAT_NOW = "yyyyMMdd_HHmmss";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("commitId");
        sb.append(":").append(uniqueId).append(":").append(message).append("\n");
        return sb.toString();
    }
}
