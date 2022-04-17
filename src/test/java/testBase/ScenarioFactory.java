package testBase;

public class ScenarioFactory {

    //Singleton design pattern.  Only one instance of DriverFactory, global access is provided via getInstance.
    private ScenarioFactory(){
    }

    private static final ScenarioFactory instance = new ScenarioFactory();

    public static ScenarioFactory getInstance(){
        return instance;
    }

    //Factory Design Pattern -- defines a separate factory method for creating objects
    ThreadLocal <String> scenarioName = new ThreadLocal<>();

    public void setScenarioName(String scenario){
        scenarioName.set(scenario);
    }

    public String getScenarioName(){
        return scenarioName.get();
    }
}
