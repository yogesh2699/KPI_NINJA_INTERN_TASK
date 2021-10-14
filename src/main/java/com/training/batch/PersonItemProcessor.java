package com.training.batch;

import com.training.validation.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.training.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonItemProcessor implements ItemProcessor<User, User> {

  private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
  public static HashMap<String, List<UserException>> hm = new HashMap<>();


  public static boolean isValidValue(String value) {
  /*  if(value == null || value.isEmpty()) {
      return false;
    }
    else {*/
      return value.length() > 20 ? true: false;
  //  }
  }


  public  static List<UserException> isValidate(User user)
  {
    List<UserException> list = new ArrayList<>();
     boolean testing = false;
    try{
      if(isValidValue(user.getUsername())) {
        testing = true;
        throw new UserException("Username is not valid");
      }
    }catch(UserException e) {
             System.out.println(e);
             list.add(e);
    }
    try{
      if(isValidValue(user.getPassword())) {
        testing = true;
        throw new UserException("Password is not valid");
      }
    }catch(UserException e) {
      list.add(e);

    }
    try{
      if(isValidValue(user.getEmail())) {
        testing = true;
        throw new UserException("Email is not valid");
      }
    }catch(UserException e) {
      list.add(e);
    }
    try{
      if(isValidValue(user.getContact())) {
        testing = true;
        throw new UserException("Contact is not valid");
      }
    }catch(UserException e) {
      list.add(e);
    }
    return list;
  }

  @Override
  public User process(final User user) throws Exception {
	  
	  log.info("Started processing the csv file..");
	  final String uniqueId = user.getUserId();
    final String username = user.getUsername();
    final String email = user.getEmail();
    final String contact = user.getContact();
    final String password = user.getPassword();
     User transformedUser = new User();

         if(uniqueId!="" && username!="" && email!="" && contact!="" && password!="")
         {
           List<UserException> exceptions = isValidate(user);
                if(exceptions.isEmpty())
                {
                   transformedUser = new User(uniqueId,username, email,contact,password);
                  log.info("Converting (" + user + ") into (" + transformedUser + ")");
                }
                else {
                  hm.put(uniqueId,exceptions);
                }
         }
    return transformedUser;
  }

}