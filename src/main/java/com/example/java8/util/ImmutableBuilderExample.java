package com.example.java8.util;

import java.util.HashMap;

public class ImmutableBuilderExample {

    //required fields
    private int id;
    private String name;

    //optional fields
    private HashMap<String, String> properties;
    private String company;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getProperties() {
        //return cloned object to avoid changing it by the client application
        return (HashMap<String, String>) properties.clone();
    }

    public String getCompany() {
        return company;
    }

    private ImmutableBuilderExample(ImmutableBuilderExampleBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.properties = builder.properties;
        this.company = builder.company;
    }

    //Builder class
    public static class ImmutableBuilderExampleBuilder{
        //required fields
        private int id;
        private String name;

        //optional fields
        private HashMap<String, String> properties;
        private String company;

        public ImmutableBuilderExampleBuilder(int i, String nm){
            this.id=i;
            this.name=nm;
        }

        public ImmutableBuilderExampleBuilder setProperties(HashMap<String,String> hm){
            this.properties = (HashMap<String, String>) hm.clone();
            return this;
        }

        public ImmutableBuilderExampleBuilder setCompany(String comp){
            this.company = comp;
            return this;
        }

        public ImmutableBuilderExample build(){
            return new ImmutableBuilderExample(this);
        }
    }
}