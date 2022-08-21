
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("File:");
        String file = scan.nextLine();
        while(true){
            
        
            System.out.println("Team:");
            String team = scan.nextLine();
            if(team.equals("stop")){
                break;
            }
            try (Scanner fileReader = new Scanner(Paths.get(file))){
                int noOfGames = 0;
                int wins = 0;
                int losses = 0;
                while(fileReader.hasNextLine()){
                    String line = fileReader.nextLine();
                    String[] parts = line.split(",");
                    String homeTeam = parts[0];
                    String visitingTeam = parts[1];
                    int homeTeamPoint = Integer.valueOf(parts[2]);
                    int visitingTeamPoint = Integer.valueOf(parts[3]);
                    if(team.equals(homeTeam) || team.equals(visitingTeam)){
                        noOfGames++;
                    
                    } 
                    if(homeTeam.equals(team)){
                        if(homeTeamPoint > visitingTeamPoint){
                            wins++;
                        }else{
                            losses++;
                        }
                    }else if(visitingTeam.equals(team)){
                        if(homeTeamPoint < visitingTeamPoint){
                            wins++;
                        }else{
                            losses++;
                        }
                    }
           
            
            }
            System.out.println("Games: "+noOfGames);
            System.out.println("Wins: "+wins);
            System.out.println("Losses: "+losses);
        }catch(Exception e){
            System.out.println("File not found!!!");
        }    
        }
        
    }

}
