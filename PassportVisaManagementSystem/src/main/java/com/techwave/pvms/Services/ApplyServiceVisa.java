package com.techwave.pvms.Services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.pvms.model.ApplyVisa;
import com.techwave.pvms.repository.VisaRepo;
@Service
public class ApplyServiceVisa {


    @Autowired
    VisaRepo visaRepo;

//    public List<ApplyVisa> getall()
//    {
//        
//        return visaRepo.findAll();
//    }
//    
    public String applyVisa(ApplyVisa pass) {
    //    DateTimeFormatter D = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        Integer i=visaRepo.getSeqforapplyVisa();
        pass.setVisaId("VISA-"+i);

        String s[]= {"Student","Private Employee","Government Employee","Self Employed","Retire Employee"};

        if(pass.getEmployeeOccupation().equals(s[0].toString()))
        {
            pass.setDateOfExpiry(LocalDate.now().plusYears(2).toString());
        }
        else if(pass.getEmployeeOccupation().equals(s[1]))
        {
            pass.setDateOfExpiry(LocalDate.now().plusYears(3).toString());
        }
        else if(pass.getEmployeeOccupation().equals(s[2]))
        {
            pass.setDateOfExpiry(LocalDate.now().plusYears(4).toString());
        }
        else if(pass.getEmployeeOccupation().equals(s[3]))
        {
            pass.setDateOfExpiry(LocalDate.now().plusYears(1).toString());
        }
        else if(pass.getEmployeeOccupation().equals(s[4]))
        {
            pass.setDateOfExpiry(LocalDate.now().plusYears(1).plusMonths(6).toString());
        }
        else {
            return "Give correct input";
        }



        LocalDate curDate = LocalDate.now();
        pass.setDateOfApplication(curDate.toString());

        LocalDate IssuDate = LocalDate.now().plusDays(10);
        pass.setIssueDate(IssuDate.toString());

//        LocalDate ExpDate = LocalDate.now().plusYears(10);
//        pass.setDateOfExpiry(ExpDate.toString());

        System.out.println(pass);

        Optional<ApplyVisa> U = visaRepo.findById(pass.getUserId());
        if (U.isPresent()) {
        return "User already exists";
        }
        else {
            visaRepo.save(pass);
        }

        System.out.println(pass);

        String str1 = "Dear User your Visa request has been accepted successfully\n" + "Your VISA Id is"
                + " " + pass.getUserId()+"," + " " + "User Id" + pass.getUserId()+"\n"+" "+"Destination"+" "+pass.getDestination()+"\n"+" "+"Employee"+" "+pass.getEmployeeOccupation()
                +"\n"+" "+"Date of Application"+" "+pass.getDateOfApplication()+"\n"+" "+"Date of Issue"+" "+pass.getIssueDate()
                +"\n"+" "+"Date of Expiry"+" "+pass.getDateOfExpiry()+"\n"+" "+"Registration Cost"+" "+pass.getRegistrationCost();
        //System.out.println(str1);
        return str1;

        
    }

}