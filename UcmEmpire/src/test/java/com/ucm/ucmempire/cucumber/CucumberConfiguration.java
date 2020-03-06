package com.ucm.ucmempire.cucumber;

import com.ucm.ucmempire.models.Player;
import io.cucumber.java.ParameterType;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class CucumberConfiguration {

    @ParameterType("name:.*\\|id:.*")  // regexp
    public Player player(String playerRegex){  // type, name (from method)
        Player player = null;
        Pattern pattern = Pattern.compile("name:(.*)\\|id:(.*)");
        Matcher matcher = pattern.matcher(playerRegex);
        if (matcher.find()){
            String name = matcher.group(1);
            int id = Integer.parseInt(matcher.group(2));
            player = new Player(id , name);
        }
        else {
            System.out.println("CA MARCHE PASSSS : " + playerRegex);
        }
        return player;
    }
//    //And 3 Farmers pa:10|hp:10|idPlayer:1
//    @ParameterType("pa:[0-9]\\|hp:[0-9]\\|idPlayer:[0-9]")
//    public Farmer farmer(String farmerRegex)
//    {
//        Farmer farmer = null;
//    }
}
