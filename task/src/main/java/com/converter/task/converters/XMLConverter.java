package com.converter.task.converters;

import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.math.BigInteger;
import java.util.List;

@Component
public class XMLConverter implements FileConverter{

    public class Persons{
        private List<Person> personList;

        public List<Person> getPersonList() {
            return personList;
        }

        public void setPersonList(List<Person> personList) {
            this.personList = personList;
        }
    }

    public class Person{
        private String name;
        private String surname;
        private Long age;
        private String city;
        private int contacts;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getContacts() {
            return contacts;
        }

        public void setContacts(int contacts) {
            this.contacts = contacts;
        }
    }

    public class Contacts{
        private int phone;
        private int email;
        private int icq;
        private int jabber;

        public int getPhone() {
            return phone;
        }

        public void setPhone(int phone) {
            this.phone = phone;
        }

        public int getEmail() {
            return email;
        }

        public void setEmail(int email) {
            this.email = email;
        }

        public int getIcq() {
            return icq;
        }

        public void setIcq(int icq) {
            this.icq = icq;
        }

        public int getJabber() {
            return jabber;
        }

        public void setJabber(int jabber) {
            this.jabber = jabber;
        }
    }

    public class PersonsHandler extends DefaultHandler{

        boolean bPerson = false;
        boolean bName = false;
        boolean bSurename = false;
        boolean bAge = false;
        boolean bCity = false;
        boolean bContacts = false;
        boolean bPhone = false;
        boolean bEmail = false;
        boolean bIcq = false;
        boolean bJabber = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
            if(qName.equalsIgnoreCase("person") && qName.equalsIgnoreCase("persons") && qName.equalsIgnoreCase("name")){
                bName = true;
            } else if (qName.equalsIgnoreCase("surename")) {
                bSurename = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
            else if (qName.equalsIgnoreCase("city")) {
                bCity = true;
            }
            else if (qName.equalsIgnoreCase("contacts") && qName.equalsIgnoreCase("phone")) {
                bPhone = true;
            }
            else if (qName.equalsIgnoreCase("contacts") && qName.equalsIgnoreCase("email")) {
                bEmail = true;
            }
            else if (qName.equalsIgnoreCase("contacts") && qName.equalsIgnoreCase("icq")) {
                bIcq = true;
            }
            else if (qName.equalsIgnoreCase("contacts") && qName.equalsIgnoreCase("jabber")) {
                bJabber = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException{
            if (qName.equalsIgnoreCase("person") ){
                System.out.println("PERSON");
            }else if(qName.equalsIgnoreCase("contacts")){
                System.out.println("CONTACTS");
            }

        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(bName){
                System.out.println(new String(ch,start,length));
                bName = false;
            }else if(bSurename){
                System.out.println(new String(ch,start,length));
                bSurename = false;
            }else if(bAge){
                System.out.println(new String(ch,start,length));
                bAge = false;
            }else if(bCity){
                System.out.println(new String(ch,start,length));
                bCity = false;
            }else if(bPhone){
                System.out.println(new String(ch,start,length));
                bPhone = false;
            }else if(bEmail){
                System.out.println(new String(ch,start,length));
                bEmail = false;
            }else if(bIcq){
                System.out.println(new String(ch,start,length));
                bIcq = false;
            }else if(bJabber){
                System.out.println(new String(ch,start,length));
                bJabber = false;
            }
        }


    }

    @Override
    public void parseData(File f) {
        Person person = new Person();
        System.out.println("data "+ person.getName());




    }


}
