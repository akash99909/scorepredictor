class CricketData 
{ 
    int runs, wickets; 
    float overs; 
    CurrentScoreDisplay currentScoreDisplay; 
    AverageScoreDisplay averageScoreDisplay; 
  
     
    public CricketData(CurrentScoreDisplay currentScoreDisplay, 
                       AverageScoreDisplay averageScoreDisplay) 
    { 
        this.currentScoreDisplay = currentScoreDisplay; 
        this.averageScoreDisplay = averageScoreDisplay; 
    } 
  
    
    private int getLatestRuns() 
    { 
         
         return  50; 
    } 
  
     
    private int getLatestWickets()  
    { 
        
        return 3; 
    } 
  
    
    private float getLatestOvers() 
    { 
        
        return (float)10; 
    } 
  
     
    public void dataChanged() 
    { 
        
        runs = getLatestRuns(); 
        wickets = getLatestWickets(); 
        overs = getLatestOvers(); 
  
        currentScoreDisplay.update(runs,wickets,overs); 
        averageScoreDisplay.update(runs,wickets,overs); 
    } 
} 
  
 
class AverageScoreDisplay 
{ 
    private float runRate; 
    private int predictedScore; 
  
    public void update(int runs, int wickets, float overs) 
    { 
        this.runRate = (float)runs/overs; 
        this.predictedScore = (int) (this.runRate * 50); 
        display(); 
    } 
  
    public void display() 
    { 
        System.out.println("\nAverage Score Display:\n" + 
                           "Run Rate: " + runRate + 
                           "\nPredictedScore: " + predictedScore); 
    } 
} 
  

class CurrentScoreDisplay 
{ 
    private int runs, wickets; 
    private float overs; 
  
    public void update(int runs,int wickets,float overs) 
    { 
        this.runs = runs; 
        this.wickets = wickets; 
        this.overs = overs; 
        display(); 
    } 
  
    public void display() 
    { 
        System.out.println("\nCurrent Score Display: \n" + 
                           "Runs: " + runs +"\nWickets:"
                           + wickets + "\nOvers: " + overs ); 
    } 
} 
  

class Main 
{ 
    public static void main(String args[]) 
    { 
        
        AverageScoreDisplay averageScoreDisplay = 
                                       new AverageScoreDisplay(); 
        CurrentScoreDisplay currentScoreDisplay = 
                                       new CurrentScoreDisplay(); 
  
         
        CricketData cricketData = new CricketData(currentScoreDisplay, 
                                                  averageScoreDisplay); 
  
        
        
        cricketData.dataChanged(); 
    } 
}