/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aashi
 */
public class GameResult {
    private String homeTeam;
    private String visitingTeam;
    private int homeTeamPoint;
    private int visitingTeamPoint;
    
    public GameResult(String hT,String vT,int hTP ,int vTP){
        this.homeTeam = hT;
        this.visitingTeam = vT;
        this.homeTeamPoint = hTP;
        this.visitingTeamPoint = vTP;
    }
    
    public String getHomeTeam(){
        return this.homeTeam;
    }
    
    public String getVisitingTeam(){
        return this.visitingTeam;
    }
    
    public int homeTeamPoint(){
        return this.homeTeamPoint;
    }
    
    public int visitingTeamPoint(){
       return this.visitingTeamPoint; 
    }
    
    public boolean didPlayGame(String team) {
        if(team.equals(this.homeTeam) || team.equals(this.visitingTeam)){
            return true;
        }
        return false;
        
    }
    
    public boolean didWinGame(String team) {
        if(this.homeTeam.equals(team)){
            if(this.homeTeamPoint  > this.visitingTeamPoint){
                return true;
            }else{
                return false;
            }
        }else if(this.visitingTeam.equals(team)){
            if(this.visitingTeamPoint > this.homeTeamPoint){
                return true;
            }else{
                return false;
            }
        } 
        return false;
        
    }
    
    public boolean didLoseGame(String team) {
        
        if(this.homeTeam.equals(team)){
            if(this.homeTeamPoint  < this.visitingTeamPoint){
                return true;
            }else{
                return false;
            }
        }else if(this.visitingTeam.equals(team)){
            if(this.visitingTeamPoint <  this.homeTeamPoint){
                return true;
            }else{
                return false;
            }
        } 
        return false;
        
    }
        
    
    
       
}
