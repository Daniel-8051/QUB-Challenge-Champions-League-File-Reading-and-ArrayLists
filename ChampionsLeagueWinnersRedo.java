/**
 * 
 */
package champions.league.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Daniel McAuley
 *
 */
public class ChampionsLeagueWinnersRedo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// vars
		String line;
		ArrayList<String> winningTeams = new ArrayList<>();

		try {
			// get file
			File file = new File("ECWinners.txt");

			// read file
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			// read line
			line = br.readLine();

			// while there is a next line
			while (line != null) {
				// store each winning team - array list
				winningTeams.add(line);
				
				// read next line
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// output (loop from 1956 onwards)
		outputAllTeams(winningTeams);

		// output winners with no duplicates - use .remove()
		outputTeamsNoDuplicates(winningTeams);

	}

	/**
	 * outputs all winning clubs (no duplicates of teams)
	 * @param winningTeams
	 */
	private static void outputTeamsNoDuplicates(ArrayList<String> winningTeams) {
		System.out.println("\nWinning clubs...");
		ArrayList<String> winningClubs = new ArrayList<>();
		for(int loop=0; loop<winningTeams.size(); loop++) {
			if(!winningClubs.contains(winningTeams.get(loop))) {
				winningClubs.add(winningTeams.get(loop));
			}
		}
		for(String club : winningClubs) {
			System.out.println(club.toString());
		}
		
	}

	/**
	 * outputs all teams to screen
	 * @param winningTeams list of teams
	 */
	private static void outputAllTeams(ArrayList<String> winningTeams) {
		int year = 1956;
		for (String team : winningTeams) {
			System.out.println(year++ + " " + team.toString());
		}

	}

}
