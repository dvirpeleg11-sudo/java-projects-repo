package fireWallSimulation;

import java.util.ArrayList;
import java.util.List;

public class RuleSet {

    private List<Rule> rules;

    public RuleSet(){

        rules = new ArrayList<>();

    }

    // getters

    public List<Rule> getRuleSet(){

        return rules;

    }

    // setters

    public void addRule(Rule rule){

        rules.add(rule);

    }

}