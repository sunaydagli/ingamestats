
public class Player {
	private String firstName;
	private String lastName;
	private int number;
	// total points used by adding made two, three, and free throw shots
	// array keeps track of total attempts in slot 1 and shots made in slot 0
	private int[] twoPointers;
	private int[] threePointers;
	private int[] freethrows;
	private int assists;
	// total points adds defensive and offensive rebounds
	// defensive rebounds are slot 0, offensive rebounds are slot 1
	private int[] rebounds;
	private int steals;
	private int blocks;
	private int fouls;
	private int turnovers;
	final int MINIMUM = 0;

	public Player(String first, String last, int num) {
		firstName = first;
		lastName = last;
		number = num;
		twoPointers = new int[2];
		threePointers = new int[2];
		freethrows = new int[2];
		rebounds = new int[2];
		assists = 0;
		steals = 0;
		blocks = 0;
		turnovers = 0;
		fouls = 0;
	}

	public Player(String[] stats) {
		String[] fullName = stats[0].split(" ");
		firstName = fullName[0];
		lastName = fullName[1];
		number = Integer.parseInt(stats[1]);
		twoPointers = new int[2];
		twoPointers[0] = Integer.parseInt(stats[2]);
		twoPointers[1] = Integer.parseInt(stats[3]);
		threePointers = new int[2];
		threePointers[0] = Integer.parseInt(stats[4]);
		threePointers[1] = Integer.parseInt(stats[5]);
		freethrows = new int[2];
		freethrows[0] = Integer.parseInt(stats[6]);
		freethrows[1] = Integer.parseInt(stats[7]);
		rebounds = new int[2];
		rebounds[0] = Integer.parseInt(stats[8]);
		rebounds[1] = Integer.parseInt(stats[9]);
		assists = Integer.parseInt(stats[10]);
		steals = Integer.parseInt(stats[11]);
		blocks = Integer.parseInt(stats[12]);
		turnovers = Integer.parseInt(stats[13]);
		fouls = Integer.parseInt(stats[14]);
	}

	public boolean equals(Player temp) {
		if (firstName.equals(temp.getFirstName()) && lastName.equals(temp.getLastName()) && number == temp.getNum())
			return true;
		return false;
	}

	public int getNum() {
		return number;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getTotalPoints() {
		return (twoPointers[0] * 2) + (threePointers[0] * 3) + (freethrows[0]);
	}

	public int getMade2Pointer() {
		return twoPointers[0];
	}

	public int get2PointerAttempts() {
		return twoPointers[1];
	}

	public int getMade3Pointer() {
		return threePointers[0];
	}

	public int get3PointerAttempts() {
		return threePointers[1];
	}

	public int getMadeFreeThrows() {
		return freethrows[0];
	}

	public int getFreeThrowAttempts() {
		return freethrows[1];
	}

	public int getTotalRebounds() {
		return rebounds[0] + rebounds[1];
	}

	public int getDefensiveRebounds() {
		return rebounds[0];
	}

	public int getOffensiveRebounds() {
		return rebounds[1];
	}

	public int getAssists() {
		return assists;
	}

	public int getSteals() {
		return steals;
	}

	public int getBlocks() {
		return blocks;
	}

	public int getFouls() {
		return fouls;
	}

	public void add2Point(int num) {
		int made = twoPointers[0];
		int attempts = twoPointers[1];
		twoPointers[1] = attempts + 1;
		if (madeOrMissed(num))
			twoPointers[0] = made + 1;
	}

	public void add3Point(int num) {
		int made = threePointers[0];
		int attempts = threePointers[1];
		threePointers[1] = attempts + 1;
		if (madeOrMissed(num))
			threePointers[0] = made + 1;
	}

	public void addFreeThrow(int num) {
		int made = freethrows[0];
		int attempts = freethrows[1];
		freethrows[1] = attempts + 1;
		if (madeOrMissed(num))
			freethrows[0] = made + 1;
	}

	public boolean madeOrMissed(int num) {
		// Main menu --> pressing 'Made' outputs 1, pressing 'Missed' outputs 0
		if (num == 1)
			return true;
		else
			return false;
	}

	public void addRebound(int num) {
		int defense = rebounds[0];
		int offense = rebounds[1];
		if (offOrDef(num))
			rebounds[0] = defense + 1;
		else
			rebounds[1] = offense + 1;
	}

	public boolean subRebound(int num) {
		int defense = rebounds[0];
		int offense = rebounds[1];
		if (offOrDef(num)) {
			if (rebounds[0] > MINIMUM) {
				rebounds[0] = defense - 1;
				return true;
			}
		} else {
			if (rebounds[1] > MINIMUM) {
				rebounds[1] = offense - 1;
				return true;
			}
		}
		return false;
	}

	public boolean offOrDef(int num) {
		// Main menu --> pressing 'Offensive' outputs 0, pressing 'Defensive' outputs 1
		if (num == 1)
			return true;
		else
			return false;
	}

	public void addAssist() {
		assists++;
	}

	public boolean subAssist() {
		if (assists > MINIMUM) {
			assists--;
			return true;
		}
		return false;
	}

	public void addSteal() {
		steals++;
	}

	public boolean subSteal() {
		if (steals > MINIMUM) {
			steals--;
			return true;
		}
		return false;
	}

	public void addBlocks() {
		blocks++;
	}

	public boolean subBlocks() {
		if (blocks > MINIMUM) {
			blocks--;
			return true;
		}
		return false;
	}

	public int getTurnovers() {
		return turnovers;
	}

	public void addTurnover() {
		turnovers++;
	}

	public boolean subTurnover() {
		if (turnovers > MINIMUM) {
			turnovers--;
			return true;
		}
		return false;
	}

	public void addFoul() {
		fouls++;
	}

	public boolean subFoul() {
		if (fouls > MINIMUM) {
			fouls--;
			return true;
		}
		return false;
	}

	public String[] getPlayerArr() {
		String[] playerArr = new String[17];
		playerArr[0] = getFirstName() + " " + getLastName();
		playerArr[1] = Integer.toString(getNum());
		playerArr[2] = Integer.toString(getMade2Pointer());
		playerArr[3] = Integer.toString(get2PointerAttempts());
		playerArr[4] = Integer.toString(getMade3Pointer());
		playerArr[5] = Integer.toString(get3PointerAttempts());
		playerArr[6] = Integer.toString(getMadeFreeThrows());
		playerArr[7] = Integer.toString(getFreeThrowAttempts());
		playerArr[8] = Integer.toString(getOffensiveRebounds());
		playerArr[9] = Integer.toString(getDefensiveRebounds());
		playerArr[10] = Integer.toString(getTotalRebounds());
		playerArr[11] = Integer.toString(getAssists());
		playerArr[12] = Integer.toString(getSteals());
		playerArr[13] = Integer.toString(getBlocks());
		playerArr[14] = Integer.toString(getTurnovers());
		playerArr[15] = Integer.toString(getFouls());
		playerArr[16] = Integer.toString(getTotalPoints());
		return playerArr;
	}

	public String[] getPlayerPercents() {
		String[] playerArr = new String[6];
		playerArr[0] = getFirstName() + " " + getLastName();
		playerArr[1] = Integer.toString(getNum());
		if (get3PointerAttempts() != 0)
			playerArr[2] = Double.toString(getMade3Pointer() * 100 / get3PointerAttempts());
		else
			playerArr[2] = Double.toString(0);
		if (getFreeThrowAttempts() != 0)
			playerArr[3] = Double.toString(getMadeFreeThrows() * 100 / getFreeThrowAttempts());
		else
			playerArr[3] = Double.toString(0);
		if (getTurnovers() != 0)
			playerArr[4] = Double.toString(getAssists() / getTurnovers());
		else
			playerArr[4] = Double.toString(0);
		if (get2PointerAttempts() != 0 || get3PointerAttempts() != 0)
			playerArr[5] = Double.toString(
					(getMade2Pointer() + getMade3Pointer()) * 100 / (get2PointerAttempts() + get3PointerAttempts()));
		else
			playerArr[5] = Double.toString(0);
		return playerArr;
	}
}
