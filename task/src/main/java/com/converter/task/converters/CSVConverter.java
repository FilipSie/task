package com.converter.task.converters;

import com.converter.task.models.Contact;
import com.converter.task.models.Customer;
import com.converter.task.services.ContactRepositoryImpl;
import com.converter.task.services.CustomerRepositoryImpl;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class CSVConverter implements FileConverter{

//    public String getPath(File f){
//        f.pathSeparator(='\');
//        String pathFile = f.getAbsolutePath();
//        System.out.println("path "+pathFile);
//
//    }

    @Override
    public void parseData(File f){
        BigInteger age = BigInteger.valueOf(0);

        try{
            String line = "";

            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\filip\\Desktop\\Zadanie\\task\\text2.csv"));
            while ((line = bufferedReader.readLine()) != null){
                String[] values = line.split(",");
                // add customer
                CustomerRepositoryImpl repositoryCustomer = new CustomerRepositoryImpl();
                if(values[2].equals("")){
                    values[2] = null;
                }else {
                    age = age.add(BigInteger.valueOf(Long.parseLong(values[2])));
                }

                Customer customer = new Customer(values[0],values[1],age);
                repositoryCustomer.save(customer);
                BigInteger idCustomer = repositoryCustomer.getId(customer);
                // add contact
                if(idCustomer != null){
                for(int i = 4; i < 8; i++){
                    if(isEmail(values[i])){
                        Contact contact = new Contact(customer.getId(),1,values[i]); // email
                        ContactRepositoryImpl contactRepository = new ContactRepositoryImpl();
                        contactRepository.save(contact);
                    }else if(isPhone(values[i])){
                        Contact contact = new Contact(customer.getId(),2,values[i]); // phone
                        ContactRepositoryImpl contactRepository = new ContactRepositoryImpl();
                        contactRepository.save(contact);
                    }else if(values.equals("jbr")){
                        Contact contact = new Contact(customer.getId(),3,values[i]); // jabber
                        ContactRepositoryImpl contactRepository = new ContactRepositoryImpl();
                        contactRepository.save(contact);
                    }else{
                        Contact contact = new Contact(customer.getId(),0,values[i]); //unknown
                        ContactRepositoryImpl contactRepository = new ContactRepositoryImpl();
                        contactRepository.save(contact);
                    }
                }}



            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private boolean isEmail(String text){
        if(text.indexOf('@') == -1)
            return false;
        return true;

    }

    private boolean isPhone(String text){
        int count = 0;
        for(int i = 0; i < text.length(); i++){
            if(Character.isDigit(text.charAt(i))){
                count++;

            }
        }
        if(count == 9){
            return true;
        }else{
            return false;
        }
    }
}
