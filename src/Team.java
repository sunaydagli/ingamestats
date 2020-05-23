import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Team {
	private List<Game> games;
	private Game currentGame;
	private Game tempCurrent;
	private String name;

	public Team(String nameOfTeam) {
		name = nameOfTeam;
		games = new ArrayList<Game>();
	}

	public void newGame() {
		Game thisGame = new Game("");
		currentGame = thisGame;
	}

	public int getSize() {
		return games.size();
	}

	public void selectPreviousGame(String identifier) {
		tempCurrent = currentGame;
		for (Game g : games) {
			if (g.confirmGame(identifier)) {
				currentGame = g;
			}
		}
	}

	public void setCurrentGame() {
		currentGame = tempCurrent;
		tempCurrent = null;
	}

	public void deleteGame(String identifier) {
		for (int i = 0; i < games.size(); i++) {
			if ((games.get(i)).confirmGame(identifier)) {
				games.remove(i);
			}
		}
		File inputFile = new File(name + ".txt");
		File tempFile = new File("temp.txt");
		try {
			BufferedReader reader1 = new BufferedReader(new FileReader(inputFile));
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(":")) {
					String name = line.substring(0, line.length() - 1);
					if (!(name.equals(identifier))) {
						writer.write(line + System.getProperty("line.separator"));
						while (!(line = reader.readLine()).equals("#")) {
							writer.write(line + System.getProperty("line.separator"));
						}
						writer.write("#" + System.getProperty("line.separator"));
					}
				}
			}
			writer.close();
			reader.close();
			reader1.close();
			inputFile.delete();
			tempFile.renameTo(inputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	public boolean saveGame(String identifier) {
		boolean check = true;
		for (Game game : games) {
			if (game.getName().equals(identifier))
				check = false;
		}
		if (check) {
			try {
				FileWriter writer = new FileWriter(name + ".txt", true);
				int num = 0;
				writer.write(identifier + ":");
				writer.write("\r\n");
				while (num < currentGame.getSize()) {
					Player c = currentGame.getPlayer(num);
					writer.write(c.getFirstName() + " " + c.getLastName() + "," + c.getNum() + "," + c.getMade2Pointer()
							+ "," + c.get2PointerAttempts() + "," + c.getMade3Pointer() + "," + c.get3PointerAttempts()
							+ "," + c.getMadeFreeThrows() + "," + c.getFreeThrowAttempts() + ","
							+ c.getOffensiveRebounds() + "," + c.getDefensiveRebounds() + "," + c.getAssists() + ","
							+ c.getSteals() + "," + c.getBlocks() + "," + c.getTurnovers() + "," + c.getFouls());
					writer.write("\r\n");
					num++;
				}
				writer.write("#");
				writer.write("\r\n");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

	public void readFile() {
		try {
			games.clear();
			BufferedReader br = new BufferedReader(new FileReader(name + ".txt"));
			String line;
			String gameName = "";
			List<Player> players = new ArrayList<Player>();
			while ((line = br.readLine()) != null) {
				if (!(line.equals("#"))) {
					if (line.contains(":"))
						gameName = line.substring(0, line.lastIndexOf(":"));
					else {
						Player newP = new Player(line.split(","));
						players.add(newP);
					}
				} else {
					if (!(gameName.equals(""))) {
						Game game = new Game(gameName, players);
						games.add(game);
						gameName = "";
						players.clear();
					}
				}
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getAllGames() {
		String[] gameNames = new String[games.size()];
		for (int i = 0; i < games.size(); i++) {
			gameNames[i] = games.get(i).getName();
		}
		return gameNames;
	}

	public String getName() {
		return name;
	}
}
