package com.Bykanov.Gleb.service;

import com.Bykanov.Gleb.domain.entity.Secondname;
import com.Bykanov.Gleb.domain.repo.SecondnameRepo;
import org.springframework.stereotype.Service;

@Service
public class SecondnameService {
    private SecondnameRepo secondnameRepo;

    public SecondnameService(SecondnameRepo secondnameRepo) {
        this.secondnameRepo = secondnameRepo;
    }

    public Secondname saveIntoSecondname(Secondname secondname){
        if (secondname == null) {
            return null;
        }
        Secondname fromDBsecondname= secondnameRepo.findByName(secondname.getName());
        if (fromDBsecondname == null)
        {
            fromDBsecondname = secondnameRepo.save( secondname );
        }
        return  fromDBsecondname;
    }

    public Secondname findSecondnameByName (String name)
    {
        return  secondnameRepo.findByName( name );
    }
}

