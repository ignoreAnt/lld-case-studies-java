package com.ignorant.carrentalsystem.platform;

import com.ignorant.carrentalsystem.model.Branch;
import com.ignorant.carrentalsystem.model.VehicleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRentalPlatform {

    private final Map<String, Branch> branchByName;

    public CarRentalPlatform(){
        branchByName = new HashMap<>();
    }
    public String addBranch(String branchName, List<VehicleType> supportedTypes){
        if (branchByName.containsKey(branchName)){
            return "FAILURE: Branch " + branchName + " already exists.";
        }

        try{
            Branch newBranch = new Branch(branchName, supportedTypes);
            branchByName.put(branchName, newBranch);
            return "SUCCESS: Branch " + branchName + " added.";
        }catch (NullPointerException | IllegalArgumentException e){
            return "FAILURE: Invalid branch data. " + e.getMessage();
        }
    }

    public Branch getBranch(String branchName){
        return branchByName.get(branchName);
    }

    public boolean hasBranch(String branchName){
        return branchByName.containsKey(branchName);
    }
}
