import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("File:");
        String file = scan.nextLine();
        ArrayList<GameResult> results = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get(file))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");
                String homeTeam = parts[0];
                String visitingTeam = parts[1];
                int homeTeamPoint = Integer.valueOf(parts[2]);
                int visitingTeamPoint = Integer.valueOf(parts[3]);

                GameResult game = new GameResult(homeTeam,visitingTeam,homeTeamPoint,visitingTeamPoint);
                results.add(game);
            }
        }catch(Exception e){
            System.out.println("File not found!!!");
        }
            
        int noOfGames = 0;
        int wins = 0;
        int losses = 0;

        while(true){

            System.out.println("Team:");
            String team = scan.nextLine();
            if(team.equals("stop")){
                break;
            }

            for( GameResult g:results){
                if(team.equals(g.getHomeTeam()) || team.equals(g.getVisitingTeam())){
                    noOfGames++;
                }
                if(g.getHomeTeam().equals(team)){
                    if(g.homeTeamPoint() > g.visitingTeamPoint()){
                        wins++;
                    }else{
                        losses++;
                    }
                }else if(g.getVisitingTeam().equals(team)){
                    if(g.homeTeamPoint() < g.visitingTeamPoint()){
                        wins++;
                    }else{
                        losses++;
                    }

            }


        }
        System.out.println("Games: "+noOfGames);
        System.out.println("Wins: "+wins);
        System.out.println("Losses: "+losses);
          
        }
        
    }

}
