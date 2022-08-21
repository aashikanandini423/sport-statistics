import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics2 {

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
            
        

        while(true){
            int noOfGames = 0;
            int wins = 0;
            int losses = 0;
            System.out.println("Team:");
            String team = scan.nextLine();
            if(team.equals("stop")){
                break;
            }
            for(GameResult g:results){
                if(g.didPlayGame(team)){
                    noOfGames++;
                }
                if (g.didWinGame(team)) {
                    wins++;
                }
                if (g.didLoseGame(team)) {
                    losses++;
                }
            }
        
            System.out.println("Games: "+noOfGames);
            System.out.println("Wins: "+wins);
            System.out.println("Losses: "+losses);   
        }
    }
}
