import java.util.ArrayList; 
import java.util.List;

public class Game {
	private String name;
	private List<Player> players;

	public Game(String identifier) {
		players = new ArrayList<Player>();
		name = identifier;
	}

	public Game(String identifier, List<Player> roster) {
		name = identifier;
		players = new ArrayList<Player>();
		players.addAll(roster);
	}

	public boolean confirmGame(String selectedDate) {
		if (selectedDate.equals(name))
			return true;
		return false;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return players.size();
	}

	public Player getPlayer(int num) {
		if (num >= 0 && num < players.size()) {
			return players.get(num);
		}
		return null;
	}

	public void setIdentifier(String identifier) {
		name = identifier;
	}

	public boolean addPlayer(String first, String last, int number) {
		for (Player player : players) {
			if (player.getNum() == number)
				return false;
		}
		Player new1 = new Player(first, last, number);
		players.add(new1);
		return true;
	}

	public boolean removePlayer(int num) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getNum() == num) {
				players.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean contains(Player temp) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).equals(temp))
				return true;
		}
		return false;
	}

	public int getTotalMade2Pointers() {
		int num = 0;
		for (Player p : players) {
			num += p.getMade2Pointer();
		}
		return num;
	}

	public int getTotal2PointerAttempts() {
		int num = 0;
		for (Player p : players) {
			num += p.get2PointerAttempts();
		}
		return num;
	}

	public int getTotalMade3Pointers() {
		int num = 0;
		for (Player p : players) {
			num += p.getMade3Pointer();
		}
		return num;
	}

	public int getTotal3PointerAttempts() {
		int num = 0;
		for (Player p : players) {
			num += p.get3PointerAttempts();
		}
		return num;
	}

	public int getTotalMadeFreeThrows() {
		int num = 0;
		for (Player p : players) {
			num += p.getMadeFreeThrows();
		}
		return num;
	}

	public int getTotalFreeThrowAttempts() {
		int num = 0;
		for (Player p : players) {
			num += p.getFreeThrowAttempts();
		}
		return num;
	}

	public int getTotalDRebounds() {
		int num = 0;
		for (Player p : players) {
			num += p.getDefensiveRebounds();
		}
		return num;
	}

	public int getTotalORebounds() {
		int num = 0;
		for (Player p : players) {
			num += p.getOffensiveRebounds();
		}
		return num;
	}

	public int getTotalRebounds() {
		int num = 0;
		for (Player p : players) {
			num += p.getTotalRebounds();
		}
		return num;
	}

	public int getTotalAssists() {
		int num = 0;
		for (Player p : players) {
			num += p.getAssists();
		}
		return num;
	}

	public int getTotalSteals() {
		int num = 0;
		for (Player p : players) {
			num += p.getSteals();
		}
		return num;
	}

	public int getTotalBlocks() {
		int num = 0;
		for (Player p : players) {
			num += p.getBlocks();
		}
		return num;
	}

	public int getTotalFouls() {
		int num = 0;
		for (Player p : players) {
			num += p.getFouls();
		}
		return num;
	}

	public int getTotalPoints() {
		int num = 0;
		for (Player p : players) {
			num += p.getTotalPoints();
		}
		return num;
	}

	public int getTotalTurnovers() {
		int num = 0;
		for (Player p : players) {
			num += p.getTurnovers();
		}
		return num;
	}

	public String[] getGameArr() {
		String[] game = new String[16];
		game[0] = "Total";
		game[1] = Integer.toString(getTotalMade2Pointers());
		game[2] = Integer.toString(getTotal2PointerAttempts());
		game[3] = Integer.toString(getTotalMade3Pointers());
		game[4] = Integer.toString(getTotal3PointerAttempts());
		game[5] = Integer.toString(getTotalMadeFreeThrows());
		game[6] = Integer.toString(getTotalFreeThrowAttempts());
		game[7] = Integer.toString(getTotalDRebounds());
		game[8] = Integer.toString(getTotalORebounds());
		game[9] = Integer.toString(getTotalRebounds());
		game[10] = Integer.toString(getTotalAssists());
		game[11] = Integer.toString(getTotalSteals());
		game[12] = Integer.toString(getTotalBlocks());
		game[13] = Integer.toString(getTotalTurnovers());
		game[14] = Integer.toString(getTotalFouls());
		game[15] = Integer.toString(getTotalPoints());
		return game;
	}

	public String[] getGamePercentages() {
		String[] playerArr = new String[5];
		playerArr[0] = "Total";
		if (getTotal3PointerAttempts() != 0)
			playerArr[1] = Double.toString(getTotalMade3Pointers() * 100 / getTotal3PointerAttempts());
		else
			playerArr[1] = Integer.toString(0);
		if (getTotalFreeThrowAttempts() != 0)
			playerArr[2] = Double.toString(getTotalMadeFreeThrows() * 100 / getTotalFreeThrowAttempts());
		else
			playerArr[2] = Integer.toString(0);
		if (getTotalTurnovers() != 0)
			playerArr[3] = Double.toString(getTotalAssists() / getTotalTurnovers());
		else
			playerArr[3] = Integer.toString(0);
		if (getTotal2PointerAttempts() != 0 || getTotal3PointerAttempts() != 0)
			playerArr[4] = Double.toString((getTotalMade2Pointers() + getTotalMade3Pointers()) * 100
					/ (getTotal2PointerAttempts() + getTotal3PointerAttempts()));
		else
			playerArr[4] = Integer.toString(0);
		return playerArr;
	}
}
