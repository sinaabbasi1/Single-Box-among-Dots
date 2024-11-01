import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Dots {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		while (true) {
			System.out.println("Please choose an option:");
			System.out.println("1.Single Player");
			System.out.println("2.Multiplayer");
			int option = scanner.nextInt();// choose an option
			int rows;
			int columns;
			String player1;
			String player2;
			int player1NumberOfLines = 0;
			int player2NumberOfLines = 0;
			int usersTurn = 0;// for users turn
			int firstChosenRow = 0;
			int firstChosenColumn = 0;
			int secondChosenRow = 0;
			int secondChosenColumn = 0;
			int lineX = 0;
			int lineY = 0;
			int lineX1 = 0;
			int lineY1 = 0;
			int upOrDown;
			switch (option) {
			case 1:
				System.out.println("Please enter 2 numbers for the size of your game: ");
				rows = scanner.nextInt() * 2 + 1;// one space between each two vertical stars
				columns = scanner.nextInt() * 4 + 1;// 3 space between each two horizontal stars
				System.out.println("Please enter your name: ");
				String name = scanner.next();
				int whoStartFirst = random.nextInt(2);
				if (whoStartFirst == 0) {
					player1 = name;
					player2 = "PC";
				} else {
					player1 = "PC";
					player2 = name;
				}
				String[][] matrix1 = new String[rows][columns];
				for (int i = 0; i < rows; i++) {// making our game background using stars and spaces
					for (int j = 0; j < columns; j++) {
						if (i % 2 == 0 && j % 4 == 0) {
							matrix1[i][j] = "*";
						} else
							matrix1[i][j] = " ";
					}
				}
				if (whoStartFirst == 0) {
					while (true) {
						printMatrix(matrix1);
						System.out.println("***********************************************");
						if (usersTurn % 2 == 0) {
							System.out.println("Enter index of your first chosen star: ");
							firstChosenRow = scanner.nextInt() * 2;
							firstChosenColumn = scanner.nextInt() * 4;
							System.out.println("Enter index of your second chosen star: ");
							secondChosenRow = scanner.nextInt() * 2;
							secondChosenColumn = scanner.nextInt() * 4;
						} else {
							// agar user ghabli "|" ro zade bashe
							if (matrix1[lineX][lineY].equals("|") && lineY >= 4 && matrix1[lineX][lineY - 4].equals("|")
									&& !matrix1[lineX - 1][lineY - 2].equals("=")
									&& !matrix1[lineX + 1][lineY - 2].equals("=")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX - 1;
									secondChosenColumn = lineY;
								}
								if (upOrDown == 1 && matrix1[lineX + 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX + 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY;
								}
							} else if (matrix1[lineX][lineY].equals("|") && lineY >= 4
									&& matrix1[lineX - 1][lineY - 2].equals("-")
									&& !matrix1[lineX][lineY - 4].equals("!")
									&& !matrix1[lineX + 1][lineY - 2].equals("=")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX][lineY - 4].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY - 4;
								}
								if (upOrDown == 1 && matrix1[lineX + 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX + 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY;
								}
							} else if (matrix1[lineX][lineY].equals("|") && lineY >= 4
									&& matrix1[lineX + 1][lineY - 2].equals("-")
									&& !matrix1[lineX][lineY - 4].equals("!")
									&& !matrix1[lineX - 1][lineY - 2].equals("=")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX - 1;
									secondChosenColumn = lineY;
								}
								if (upOrDown == 1 && matrix1[lineX][lineY - 4].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY - 4;
								}
							} else if (matrix1[lineX][lineY].equals("|") && lineY <= columns - 4
									&& matrix1[lineX][lineY + 4].equals("|")
									&& !matrix1[lineX - 1][lineY + 2].equals("=")
									&& !matrix1[lineX + 1][lineY + 2].equals("=")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY;
									secondChosenRow = lineX - 1;
									secondChosenColumn = lineY + 4;
								}
								if (upOrDown == 1 && matrix1[lineX + 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX + 1;
									firstChosenColumn = lineY;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY + 4;
								}
							} else if (matrix1[lineX][lineY].equals("|") && lineY <= columns - 4
									&& matrix1[lineX - 1][lineY + 2].equals("-")
									&& !matrix1[lineX][lineY + 4].equals("!")
									&& !matrix1[lineX + 1][lineY + 2].equals("=")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX][lineY + 4].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY + 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY + 4;
								}
								if (upOrDown == 1 && matrix1[lineX + 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX + 1;
									firstChosenColumn = lineY;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY + 4;
								}
							} else if (matrix1[lineX][lineY].equals("|") && lineY <= columns - 4
									&& matrix1[lineX + 1][lineY + 2].equals("-")
									&& !matrix1[lineX][lineY + 4].equals("!")
									&& !matrix1[lineX - 1][lineY + 2].equals("=")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY;
									secondChosenRow = lineX - 1;
									secondChosenColumn = lineY + 4;
								}
								if (upOrDown == 1 && matrix1[lineX][lineY + 4].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY + 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY + 4;
								}
							} else if (matrix1[lineX][lineY].equals("-") && lineX >= 2
									&& matrix1[lineX - 2][lineY].equals("-")
									&& !matrix1[lineX - 1][lineY - 2].equals("!")
									&& !matrix1[lineX - 1][lineY + 2].equals("!")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY - 2;
								}
								if (upOrDown == 1 && matrix1[lineX - 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY + 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY + 2;
								}
							} else if (matrix1[lineX][lineY].equals("-") && lineX >= 2
									&& matrix1[lineX - 1][lineY + 2].equals("|")
									&& !matrix1[lineX - 1][lineY - 2].equals("!")
									&& !matrix1[lineX - 2][lineY].equals("=")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY - 2;
								}
								if (upOrDown == 1 && matrix1[lineX - 2][lineY].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX - 2;
									secondChosenColumn = lineY + 2;
								}
							} else if (matrix1[lineX][lineY].equals("-") && lineX >= 2
									&& matrix1[lineX - 1][lineY - 2].equals("|")
									&& !matrix1[lineX - 2][lineY].equals("=")
									&& !matrix1[lineX - 1][lineY + 2].equals("!")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 2][lineY].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX - 2;
									secondChosenColumn = lineY + 2;
								}
								if (upOrDown == 1 && matrix1[lineX - 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY + 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY + 2;
								}
							} else if (matrix1[lineX][lineY].equals("-") && lineX <= rows - 2
									&& matrix1[lineX + 2][lineY].equals("-")
									&& !matrix1[lineX + 1][lineY - 2].equals("!")
									&& !matrix1[lineX + 1][lineY + 2].equals("!")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX + 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY - 2;
								}
								if (upOrDown == 1 && matrix1[lineX - 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY + 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY + 2;
								}
							} else if (matrix1[lineX][lineY].equals("-") && lineX <= rows - 2
									&& matrix1[lineX + 1][lineY + 2].equals("|")
									&& !matrix1[lineX + 1][lineY - 2].equals("!")
									&& !matrix1[lineX + 2][lineY].equals("=")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX + 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY - 2;
								}
								if (upOrDown == 1 && matrix1[lineX + 2][lineY].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX + 2;
									secondChosenColumn = lineY + 2;
								}
							} else if (matrix1[lineX][lineY].equals("-") && lineX <= rows - 2
									&& matrix1[lineX + 1][lineY - 2].equals("|")
									&& !matrix1[lineX + 2][lineY].equals("=")
									&& !matrix1[lineX + 1][lineY + 2].equals("!")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX + 2][lineY].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX + 2;
									secondChosenColumn = lineY + 2;
								}
								if (upOrDown == 1 && matrix1[lineX + 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY + 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY + 2;
								}
							} else if (usersTurn != 1) {
								if (matrix1[lineX1][lineY1].equals("=")) {
									if (lineX1 >= 2 && !matrix1[lineX1 - 1][lineY1 - 2].equals("|")
											&& !matrix1[lineX1 - 2][lineY1].equals("-")
											&& !matrix1[lineX1 - 1][lineY1 + 2].equals("|")) {
										if (matrix1[lineX1 - 1][lineY1 - 2].equals(" ")) {
											firstChosenRow = lineX1 - 2;
											firstChosenColumn = lineY1 - 2;
											secondChosenRow = lineX1;
											secondChosenColumn = lineY1 - 2;
										} else if (matrix1[lineX1 - 2][lineY1].equals(" ")) {
											firstChosenRow = lineX1 - 2;
											firstChosenColumn = lineY1 - 2;
											secondChosenRow = lineX1 - 2;
											secondChosenColumn = lineY1 + 2;
										} else if (matrix1[lineX1 - 1][lineY1 + 2].equals(" ")) {
											firstChosenRow = lineX1 - 2;
											firstChosenColumn = lineY1 + 2;
											secondChosenRow = lineX1;
											secondChosenColumn = lineY1 + 2;
										}
									} else if (lineX1 <= rows - 2 && !matrix1[lineX1 + 1][lineY1 - 2].equals("|")
											&& !matrix1[lineX1 + 2][lineY1].equals("-")
											&& !matrix1[lineX1 + 1][lineY1 + 2].equals("|")) {
										if (matrix1[lineX1 + 1][lineY1 - 2].equals(" ")) {
											firstChosenRow = lineX1;
											firstChosenColumn = lineY1 - 2;
											secondChosenRow = lineX1 + 2;
											secondChosenColumn = lineY1 - 2;
										} else if (matrix1[lineX1 + 2][lineY1].equals(" ")) {
											firstChosenRow = lineX1 + 2;
											firstChosenColumn = lineY1 - 2;
											secondChosenRow = lineX1 + 2;
											secondChosenColumn = lineY1 + 2;
										} else if (matrix1[lineX1 + 1][lineY1 + 2].equals(" ")) {
											firstChosenRow = lineX1 + 2;
											firstChosenColumn = lineY1 + 2;
											secondChosenRow = lineX1;
											secondChosenColumn = lineY1 + 2;
										}
									} else {
										firstChosenRow = random.nextInt((rows - 1) / 2) * 2;
										firstChosenColumn = random.nextInt((columns - 1) / 4) * 4;
										// randomly choose between four position around of each star
										int secondChosenStarPosition = random.nextInt(4);
										switch (secondChosenStarPosition) {
										case 0:
											if (firstChosenRow >= 2) {
												secondChosenRow = firstChosenRow - 2;
												secondChosenColumn = firstChosenColumn;
												break;
											}
										case 1:
											if (firstChosenColumn <= columns - 4) {
												secondChosenRow = firstChosenRow;
												secondChosenColumn = firstChosenColumn + 4;
												break;
											}
										case 2:
											if (firstChosenRow <= rows - 2) {
												secondChosenRow = firstChosenRow + 2;
												secondChosenColumn = firstChosenColumn;
												break;
											}
										case 3:
											if (firstChosenColumn >= 4) {
												secondChosenRow = firstChosenRow;
												secondChosenColumn = firstChosenColumn - 4;
												break;
											}
										default:
											secondChosenRow = 0;
											secondChosenColumn = 0;
											break;
										}
										lineX1 = (firstChosenRow + secondChosenRow) / 2;
										lineY1 = (firstChosenColumn + secondChosenColumn) / 2;
									}
								}
								if (matrix1[lineX1][lineY1].equals("!")) {
									if (lineY1 >= 4 && !matrix1[lineX1 - 1][lineY1 - 2].equals("-")
											&& !matrix1[lineX1][lineY1 - 4].equals("|")
											&& !matrix1[lineX1 + 1][lineY1 - 2].equals("-")) {
										if (matrix1[lineX1 - 1][lineY1 - 2].equals(" ")) {
											firstChosenRow = lineX1 - 1;
											firstChosenColumn = lineY1 - 4;
											secondChosenRow = lineX1 - 1;
											secondChosenColumn = lineY1;
										} else if (matrix1[lineX1][lineY1 - 4].equals(" ")) {
											firstChosenRow = lineX1 - 1;
											firstChosenColumn = lineY1 - 4;
											secondChosenRow = lineX1 + 1;
											secondChosenColumn = lineY1 - 4;
										} else if (matrix1[lineX1 + 1][lineY1 - 2].equals(" ")) {
											firstChosenRow = lineX1 + 1;
											firstChosenColumn = lineY1 - 4;
											secondChosenRow = lineX1 + 1;
											secondChosenColumn = lineY1;
										}
									} else if (lineY1 <= columns - 4 && !matrix1[lineX1 - 1][lineY1 + 2].equals("-")
											&& !matrix1[lineX1][lineY1 + 4].equals("|")
											&& !matrix1[lineX1 + 1][lineY1 + 2].equals("-")) {
										if (matrix1[lineX1 - 1][lineY1 + 2].equals(" ")) {
											firstChosenRow = lineX1 - 1;
											firstChosenColumn = lineY1;
											secondChosenRow = lineX1 - 1;
											secondChosenColumn = lineY1 + 4;
										} else if (matrix1[lineX1][lineY1 + 4].equals(" ")) {
											firstChosenRow = lineX1 - 1;
											firstChosenColumn = lineY1 + 4;
											secondChosenRow = lineX1 + 1;
											secondChosenColumn = lineY1 + 4;
										} else if (matrix1[lineX1 + 1][lineY1 + 2].equals(" ")) {
											firstChosenRow = lineX1 + 1;
											firstChosenColumn = lineY1 + 4;
											secondChosenRow = lineX1 + 1;
											secondChosenColumn = lineY1;
										}
									} else {
										firstChosenRow = random.nextInt((rows - 1) / 2) * 2;
										firstChosenColumn = random.nextInt((columns - 1) / 4) * 4;
										// randomly choose between four position around of each star
										int secondChosenStarPosition = random.nextInt(4);
										switch (secondChosenStarPosition) {
										case 0:
											if (firstChosenRow >= 2) {
												secondChosenRow = firstChosenRow - 2;
												secondChosenColumn = firstChosenColumn;
												break;
											}
										case 1:
											if (firstChosenColumn <= columns - 4) {
												secondChosenRow = firstChosenRow;
												secondChosenColumn = firstChosenColumn + 4;
												break;
											}
										case 2:
											if (firstChosenRow <= rows - 2) {
												secondChosenRow = firstChosenRow + 2;
												secondChosenColumn = firstChosenColumn;
												break;
											}
										case 3:
											if (firstChosenColumn >= 4) {
												secondChosenRow = firstChosenRow;
												secondChosenColumn = firstChosenColumn - 4;
												break;
											}
										default:
											secondChosenRow = 0;
											secondChosenColumn = 0;
											break;
										}
										lineX1 = (firstChosenRow + secondChosenRow) / 2;
										lineY1 = (firstChosenColumn + secondChosenColumn) / 2;
									}
								}
							} else {
								firstChosenRow = random.nextInt((rows - 1) / 2) * 2;
								firstChosenColumn = random.nextInt((columns - 1) / 4) * 4;
								// randomly choose between four position around of each star
								int secondChosenStarPosition = random.nextInt(4);
								switch (secondChosenStarPosition) {
								case 0:
									if (firstChosenRow >= 2) {
										secondChosenRow = firstChosenRow - 2;
										secondChosenColumn = firstChosenColumn;
										break;
									}
								case 1:
									if (firstChosenColumn <= columns - 4) {
										secondChosenRow = firstChosenRow;
										secondChosenColumn = firstChosenColumn + 4;
										break;
									}
								case 2:
									if (firstChosenRow <= rows - 2) {
										secondChosenRow = firstChosenRow + 2;
										secondChosenColumn = firstChosenColumn;
										break;
									}
								case 3:
									if (firstChosenColumn >= 4) {
										secondChosenRow = firstChosenRow;
										secondChosenColumn = firstChosenColumn - 4;
										break;
									}
								default:
									secondChosenRow = 0;
									secondChosenColumn = 0;
									break;
								}
								lineX1 = (firstChosenRow + secondChosenRow) / 2;
								lineY1 = (firstChosenColumn + secondChosenColumn) / 2;
							}
						}
						// specified index of line that we want show between our two chosen stars
						lineX = (firstChosenRow + secondChosenRow) / 2;
						lineY = (firstChosenColumn + secondChosenColumn) / 2;
						// check if our two chosen stars in the consecutive state or not (vertical)
						if (((secondChosenRow == firstChosenRow - 2) || (secondChosenRow == firstChosenRow + 2))
								&& (secondChosenColumn == firstChosenColumn)) {
							// check if the line is empty or not
							if (matrix1[lineX][lineY].equals(" ")) {
								// check who's turn it is
								if (usersTurn % 2 == 0) {
									matrix1[lineX][lineY] = "|";
									player1NumberOfLines++;
									// check if this move leads to win or not
									if (lineY >= 4) {
										if (matrix1[lineX][lineY - 4].equals("|")
												&& matrix1[lineX - 1][lineY - 2].equals("-")
												&& matrix1[lineX + 1][lineY - 2].equals("-")) {
											printMatrix(matrix1);
											System.out
													.println(player1 + " win with " + player1NumberOfLines + " lines!");
											break;
										}
									}
									if (lineY <= columns - 4) {
										if (matrix1[lineX][lineY + 4].equals("|")
												&& matrix1[lineX - 1][lineY + 2].equals("-")
												&& matrix1[lineX + 1][lineY + 2].equals("-")) {
											printMatrix(matrix1);
											System.out
													.println(player1 + " win with " + player1NumberOfLines + " lines!");
											break;
										}
									}
								} else {
									matrix1[lineX][lineY] = "!";
									player2NumberOfLines++;
									// check if this move leads to win or not
									if (lineY >= 4) {
										if (matrix1[lineX][lineY - 4].equals("!")
												&& matrix1[lineX - 1][lineY - 2].equals("=")
												&& matrix1[lineX + 1][lineY - 2].equals("=")) {
											printMatrix(matrix1);
											System.out
													.println(player2 + " win with " + player2NumberOfLines + " lines!");
											break;
										}
									}
									if (lineY <= columns - 4) {
										if (matrix1[lineX][lineY + 4].equals("!")
												&& matrix1[lineX - 1][lineY + 2].equals("=")
												&& matrix1[lineX + 1][lineY + 2].equals("=")) {
											printMatrix(matrix1);
											System.out
													.println(player2 + " win with " + player2NumberOfLines + " lines!");
											break;
										}
									}
								}
								usersTurn++;
							}
						}
						// check if our two chosen stars in the consecutive state or not (horizontal)
						if (((secondChosenColumn == firstChosenColumn - 4)
								|| (secondChosenColumn == firstChosenColumn + 4))
								&& (secondChosenRow == firstChosenRow)) {
							// check if the line is empty or not
							if (matrix1[lineX][lineY].equals(" ")) {
								// check who's turn it is
								if (usersTurn % 2 == 0) {
									matrix1[lineX][lineY] = "-";
									player1NumberOfLines++;
									// check if this move leads to win or not
									if (lineX >= 2) {
										if (matrix1[lineX - 2][lineY].equals("-")
												&& matrix1[lineX - 1][lineY - 2].equals("|")
												&& matrix1[lineX - 1][lineY + 2].equals("|")) {
											printMatrix(matrix1);
											System.out
													.println(player1 + " win with " + player1NumberOfLines + " lines!");
											break;
										}
									}
									if (lineX <= rows - 2) {
										if (matrix1[lineX + 2][lineY].equals("-")
												&& matrix1[lineX + 1][lineY - 2].equals("|")
												&& matrix1[lineX + 1][lineY + 2].equals("|")) {
											printMatrix(matrix1);
											System.out
													.println(player1 + " win with " + player1NumberOfLines + " lines!");
											break;
										}
									}
								} else {
									matrix1[lineX][lineY] = "=";
									player2NumberOfLines++;
									// check if this move leads to win or not
									if (lineX >= 2) {
										if (matrix1[lineX - 2][lineY].equals("=")
												&& matrix1[lineX - 1][lineY - 2].equals("!")
												&& matrix1[lineX - 1][lineY + 2].equals("!")) {
											printMatrix(matrix1);
											System.out
													.println(player2 + " win with " + player2NumberOfLines + " lines!");
											break;
										}
									}
									if (lineX <= rows - 2) {
										if (matrix1[lineX + 2][lineY].equals("=")
												&& matrix1[lineX + 1][lineY - 2].equals("!")
												&& matrix1[lineX + 1][lineY + 2].equals("!")) {
											printMatrix(matrix1);
											System.out
													.println(player2 + " win with " + player2NumberOfLines + " lines!");
											break;
										}
									}
								}
								usersTurn++;
							}
						}
					}
				} else {

					while (true) {
						printMatrix(matrix1);
						System.out.println("***********************************************");
						if (usersTurn % 2 != 0) {
							System.out.println("Enter index of your first chosen star: ");
							firstChosenRow = scanner.nextInt() * 2;
							firstChosenColumn = scanner.nextInt() * 4;
							System.out.println("Enter index of your second chosen star: ");
							secondChosenRow = scanner.nextInt() * 2;
							secondChosenColumn = scanner.nextInt() * 4;
						} else {
							// agar user ghabli "!" ro zade bashe
							if (matrix1[lineX][lineY].equals("!") && lineY >= 4 && matrix1[lineX][lineY - 4].equals("!")
									&& !matrix1[lineX - 1][lineY - 2].equals("-")
									&& !matrix1[lineX + 1][lineY - 2].equals("-")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX - 1;
									secondChosenColumn = lineY;
								}
								if (upOrDown == 1 && matrix1[lineX + 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX + 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY;
								}
							} else if (matrix1[lineX][lineY].equals("!") && lineY >= 4
									&& matrix1[lineX - 1][lineY - 2].equals("=")
									&& !matrix1[lineX][lineY - 4].equals("|")
									&& !matrix1[lineX + 1][lineY - 2].equals("-")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX][lineY - 4].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY - 4;
								}
								if (upOrDown == 1 && matrix1[lineX + 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX + 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY;
								}
							} else if (matrix1[lineX][lineY].equals("!") && lineY >= 4
									&& matrix1[lineX + 1][lineY - 2].equals("=")
									&& !matrix1[lineX][lineY - 4].equals("|")
									&& !matrix1[lineX - 1][lineY - 2].equals("-")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX - 1;
									secondChosenColumn = lineY;
								}
								if (upOrDown == 1 && matrix1[lineX][lineY - 4].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY - 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY - 4;
								}
							} else if (matrix1[lineX][lineY].equals("!") && lineY <= columns - 4
									&& matrix1[lineX][lineY + 4].equals("!")
									&& !matrix1[lineX - 1][lineY + 2].equals("-")
									&& !matrix1[lineX + 1][lineY + 2].equals("-")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY;
									secondChosenRow = lineX - 1;
									secondChosenColumn = lineY + 4;
								}
								if (upOrDown == 1 && matrix1[lineX + 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX + 1;
									firstChosenColumn = lineY;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY + 4;
								}
							} else if (matrix1[lineX][lineY].equals("!") && lineY <= columns - 4
									&& matrix1[lineX - 1][lineY + 2].equals("=")
									&& !matrix1[lineX][lineY + 4].equals("|")
									&& !matrix1[lineX + 1][lineY + 2].equals("-")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX][lineY + 4].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY + 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY + 4;
								}
								if (upOrDown == 1 && matrix1[lineX + 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX + 1;
									firstChosenColumn = lineY;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY + 4;
								}
							} else if (matrix1[lineX][lineY].equals("!") && lineY <= columns - 4
									&& matrix1[lineX + 1][lineY + 2].equals("=")
									&& !matrix1[lineX][lineY + 4].equals("|")
									&& !matrix1[lineX - 1][lineY + 2].equals("-")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY;
									secondChosenRow = lineX - 1;
									secondChosenColumn = lineY + 4;
								}
								if (upOrDown == 1 && matrix1[lineX][lineY + 4].equals(" ")) {
									firstChosenRow = lineX - 1;
									firstChosenColumn = lineY + 4;
									secondChosenRow = lineX + 1;
									secondChosenColumn = lineY + 4;
								}
							} else if (matrix1[lineX][lineY].equals("=") && lineX >= 2
									&& matrix1[lineX - 2][lineY].equals("=")
									&& !matrix1[lineX - 1][lineY - 2].equals("|")
									&& !matrix1[lineX - 1][lineY + 2].equals("|")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY - 2;
								}
								if (upOrDown == 1 && matrix1[lineX - 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY + 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY + 2;
								}
							} else if (matrix1[lineX][lineY].equals("=") && lineX >= 2
									&& matrix1[lineX - 1][lineY + 2].equals("!")
									&& !matrix1[lineX - 1][lineY - 2].equals("|")
									&& !matrix1[lineX - 2][lineY].equals("-")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY - 2;
								}
								if (upOrDown == 1 && matrix1[lineX - 2][lineY].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX - 2;
									secondChosenColumn = lineY + 2;
								}
							} else if (matrix1[lineX][lineY].equals("=") && lineX >= 2
									&& matrix1[lineX - 1][lineY - 2].equals("!")
									&& !matrix1[lineX - 2][lineY].equals("-")
									&& !matrix1[lineX - 1][lineY + 2].equals("|")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX - 2][lineY].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX - 2;
									secondChosenColumn = lineY + 2;
								}
								if (upOrDown == 1 && matrix1[lineX - 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX - 2;
									firstChosenColumn = lineY + 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY + 2;
								}
							} else if (matrix1[lineX][lineY].equals("=") && lineX <= rows - 2
									&& matrix1[lineX + 2][lineY].equals("=")
									&& !matrix1[lineX + 1][lineY - 2].equals("|")
									&& !matrix1[lineX + 1][lineY + 2].equals("|")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX + 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY - 2;
								}
								if (upOrDown == 1 && matrix1[lineX - 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY + 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY + 2;
								}
							} else if (matrix1[lineX][lineY].equals("=") && lineX <= rows - 2
									&& matrix1[lineX + 1][lineY + 2].equals("!")
									&& !matrix1[lineX + 1][lineY - 2].equals("|")
									&& !matrix1[lineX + 2][lineY].equals("-")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX + 1][lineY - 2].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY - 2;
								}
								if (upOrDown == 1 && matrix1[lineX + 2][lineY].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX + 2;
									secondChosenColumn = lineY + 2;
								}
							} else if (matrix1[lineX][lineY].equals("=") && lineX <= rows - 2
									&& matrix1[lineX + 1][lineY - 2].equals("!")
									&& !matrix1[lineX + 2][lineY].equals("-")
									&& !matrix1[lineX + 1][lineY + 2].equals("|")) {
								upOrDown = random.nextInt(2);
								if (upOrDown == 0 && matrix1[lineX + 2][lineY].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY - 2;
									secondChosenRow = lineX + 2;
									secondChosenColumn = lineY + 2;
								}
								if (upOrDown == 1 && matrix1[lineX + 1][lineY + 2].equals(" ")) {
									firstChosenRow = lineX + 2;
									firstChosenColumn = lineY + 2;
									secondChosenRow = lineX;
									secondChosenColumn = lineY + 2;
								}
							} else if (usersTurn != 0) {
								if (matrix1[lineX1][lineY1].equals("-")) {
									if (lineX1 >= 2 && !matrix1[lineX1 - 1][lineY1 - 2].equals("!")
											&& !matrix1[lineX1 - 2][lineY1].equals("=")
											&& !matrix1[lineX1 - 1][lineY1 + 2].equals("!")) {
										if (matrix1[lineX1 - 1][lineY1 - 2].equals(" ")) {
											firstChosenRow = lineX1 - 2;
											firstChosenColumn = lineY1 - 2;
											secondChosenRow = lineX1;
											secondChosenColumn = lineY1 - 2;
										} else if (matrix1[lineX1 - 2][lineY1].equals(" ")) {
											firstChosenRow = lineX1 - 2;
											firstChosenColumn = lineY1 - 2;
											secondChosenRow = lineX1 - 2;
											secondChosenColumn = lineY1 + 2;
										} else if (matrix1[lineX1 - 1][lineY1 + 2].equals(" ")) {
											firstChosenRow = lineX1 - 2;
											firstChosenColumn = lineY1 + 2;
											secondChosenRow = lineX1;
											secondChosenColumn = lineY1 + 2;
										}
									} else if (lineX1 <= rows - 2 && !matrix1[lineX1 + 1][lineY1 - 2].equals("!")
											&& !matrix1[lineX1 + 2][lineY1].equals("=")
											&& !matrix1[lineX1 + 1][lineY1 + 2].equals("!")) {
										if (matrix1[lineX1 + 1][lineY1 - 2].equals(" ")) {
											firstChosenRow = lineX1;
											firstChosenColumn = lineY1 - 2;
											secondChosenRow = lineX1 + 2;
											secondChosenColumn = lineY1 - 2;
										} else if (matrix1[lineX1 + 2][lineY1].equals(" ")) {
											firstChosenRow = lineX1 + 2;
											firstChosenColumn = lineY1 - 2;
											secondChosenRow = lineX1 + 2;
											secondChosenColumn = lineY1 + 2;
										} else if (matrix1[lineX1 + 1][lineY1 + 2].equals(" ")) {
											firstChosenRow = lineX1 + 2;
											firstChosenColumn = lineY1 + 2;
											secondChosenRow = lineX1;
											secondChosenColumn = lineY1 + 2;
										}
									} else {
										firstChosenRow = random.nextInt((rows - 1) / 2) * 2;
										firstChosenColumn = random.nextInt((columns - 1) / 4) * 4;
										// randomly choose between four position around of each star
										int secondChosenStarPosition = random.nextInt(4);
										switch (secondChosenStarPosition) {
										case 0:
											if (firstChosenRow >= 2) {
												secondChosenRow = firstChosenRow - 2;
												secondChosenColumn = firstChosenColumn;
												break;
											}
										case 1:
											if (firstChosenColumn <= columns - 4) {
												secondChosenRow = firstChosenRow;
												secondChosenColumn = firstChosenColumn + 4;
												break;
											}
										case 2:
											if (firstChosenRow <= rows - 2) {
												secondChosenRow = firstChosenRow + 2;
												secondChosenColumn = firstChosenColumn;
												break;
											}
										case 3:
											if (firstChosenColumn >= 4) {
												secondChosenRow = firstChosenRow;
												secondChosenColumn = firstChosenColumn - 4;
												break;
											}
										default:
											secondChosenRow = 0;
											secondChosenColumn = 0;
											break;
										}
										lineX1 = (firstChosenRow + secondChosenRow) / 2;
										lineY1 = (firstChosenColumn + secondChosenColumn) / 2;
									}
								}
								if (matrix1[lineX1][lineY1].equals("|")) {
									if (lineY1 >= 4 && !matrix1[lineX1 - 1][lineY1 - 2].equals("=")
											&& !matrix1[lineX1][lineY1 - 4].equals("!")
											&& !matrix1[lineX1 + 1][lineY1 - 2].equals("=")) {
										if (matrix1[lineX1 - 1][lineY1 - 2].equals(" ")) {
											firstChosenRow = lineX1 - 1;
											firstChosenColumn = lineY1 - 4;
											secondChosenRow = lineX1 - 1;
											secondChosenColumn = lineY1;
										} else if (matrix1[lineX1][lineY1 - 4].equals(" ")) {
											firstChosenRow = lineX1 - 1;
											firstChosenColumn = lineY1 - 4;
											secondChosenRow = lineX1 + 1;
											secondChosenColumn = lineY1 - 4;
										} else if (matrix1[lineX1 + 1][lineY1 - 2].equals(" ")) {
											firstChosenRow = lineX1 + 1;
											firstChosenColumn = lineY1 - 4;
											secondChosenRow = lineX1 + 1;
											secondChosenColumn = lineY1;
										}
									} else if (lineY1 <= columns - 4 && !matrix1[lineX1 - 1][lineY1 + 2].equals("=")
											&& !matrix1[lineX1][lineY1 + 4].equals("!")
											&& !matrix1[lineX1 + 1][lineY1 + 2].equals("=")) {
										if (matrix1[lineX1 - 1][lineY1 + 2].equals(" ")) {
											firstChosenRow = lineX1 - 1;
											firstChosenColumn = lineY1;
											secondChosenRow = lineX1 - 1;
											secondChosenColumn = lineY1 + 4;
										} else if (matrix1[lineX1][lineY1 + 4].equals(" ")) {
											firstChosenRow = lineX1 - 1;
											firstChosenColumn = lineY1 + 4;
											secondChosenRow = lineX1 + 1;
											secondChosenColumn = lineY1 + 4;
										} else if (matrix1[lineX1 + 1][lineY1 + 2].equals(" ")) {
											firstChosenRow = lineX1 + 1;
											firstChosenColumn = lineY1 + 4;
											secondChosenRow = lineX1 + 1;
											secondChosenColumn = lineY1;
										}
									} else {
										firstChosenRow = random.nextInt((rows - 1) / 2) * 2;
										firstChosenColumn = random.nextInt((columns - 1) / 4) * 4;
										// randomly choose between four position around of each star
										int secondChosenStarPosition = random.nextInt(4);
										switch (secondChosenStarPosition) {
										case 0:
											if (firstChosenRow >= 2) {
												secondChosenRow = firstChosenRow - 2;
												secondChosenColumn = firstChosenColumn;
												break;
											}
										case 1:
											if (firstChosenColumn <= columns - 4) {
												secondChosenRow = firstChosenRow;
												secondChosenColumn = firstChosenColumn + 4;
												break;
											}
										case 2:
											if (firstChosenRow <= rows - 2) {
												secondChosenRow = firstChosenRow + 2;
												secondChosenColumn = firstChosenColumn;
												break;
											}
										case 3:
											if (firstChosenColumn >= 4) {
												secondChosenRow = firstChosenRow;
												secondChosenColumn = firstChosenColumn - 4;
												break;
											}
										default:
											secondChosenRow = 0;
											secondChosenColumn = 0;
											break;
										}
										lineX1 = (firstChosenRow + secondChosenRow) / 2;
										lineY1 = (firstChosenColumn + secondChosenColumn) / 2;
									}
								}
							} else {
								firstChosenRow = random.nextInt((rows - 1) / 2) * 2;
								firstChosenColumn = random.nextInt((columns - 1) / 4) * 4;
								// randomly choose between four position around of each star
								int secondChosenStarPosition = random.nextInt(4);
								switch (secondChosenStarPosition) {
								case 0:
									if (firstChosenRow >= 2) {
										secondChosenRow = firstChosenRow - 2;
										secondChosenColumn = firstChosenColumn;
										break;
									}
								case 1:
									if (firstChosenColumn <= columns - 4) {
										secondChosenRow = firstChosenRow;
										secondChosenColumn = firstChosenColumn + 4;
										break;
									}
								case 2:
									if (firstChosenRow <= rows - 2) {
										secondChosenRow = firstChosenRow + 2;
										secondChosenColumn = firstChosenColumn;
										break;
									}
								case 3:
									if (firstChosenColumn >= 4) {
										secondChosenRow = firstChosenRow;
										secondChosenColumn = firstChosenColumn - 4;
										break;
									}
								default:
									secondChosenRow = 0;
									secondChosenColumn = 0;
									break;
								}
								lineX1 = (firstChosenRow + secondChosenRow) / 2;
								lineY1 = (firstChosenColumn + secondChosenColumn) / 2;
							}
						}
						// specified index of line that we want show between our two chosen stars
						lineX = (firstChosenRow + secondChosenRow) / 2;
						lineY = (firstChosenColumn + secondChosenColumn) / 2;
						// check if our two chosen stars in the consecutive state or not (vertical)
						if (((secondChosenRow == firstChosenRow - 2) || (secondChosenRow == firstChosenRow + 2))
								&& (secondChosenColumn == firstChosenColumn)) {
							// check if the line is empty or not
							if (matrix1[lineX][lineY].equals(" ")) {
								// check who's turn it is
								if (usersTurn % 2 == 0) {
									matrix1[lineX][lineY] = "|";
									player1NumberOfLines++;
									// check if this move leads to win or not
									if (lineY >= 4) {
										if (matrix1[lineX][lineY - 4].equals("|")
												&& matrix1[lineX - 1][lineY - 2].equals("-")
												&& matrix1[lineX + 1][lineY - 2].equals("-")) {
											printMatrix(matrix1);
											System.out
													.println(player1 + " win with " + player1NumberOfLines + " lines!");
											break;
										}
									}
									if (lineY <= columns - 4) {
										if (matrix1[lineX][lineY + 4].equals("|")
												&& matrix1[lineX - 1][lineY + 2].equals("-")
												&& matrix1[lineX + 1][lineY + 2].equals("-")) {
											printMatrix(matrix1);
											System.out
													.println(player1 + " win with " + player1NumberOfLines + " lines!");
											break;
										}
									}
								} else {
									matrix1[lineX][lineY] = "!";
									player2NumberOfLines++;
									// check if this move leads to win or not
									if (lineY >= 4) {
										if (matrix1[lineX][lineY - 4].equals("!")
												&& matrix1[lineX - 1][lineY - 2].equals("=")
												&& matrix1[lineX + 1][lineY - 2].equals("=")) {
											printMatrix(matrix1);
											System.out
													.println(player2 + " win with " + player2NumberOfLines + " lines!");
											break;
										}
									}
									if (lineY <= columns - 4) {
										if (matrix1[lineX][lineY + 4].equals("!")
												&& matrix1[lineX - 1][lineY + 2].equals("=")
												&& matrix1[lineX + 1][lineY + 2].equals("=")) {
											printMatrix(matrix1);
											System.out
													.println(player2 + " win with " + player2NumberOfLines + " lines!");
											break;
										}
									}
								}
								usersTurn++;
							}
						}
						// check if our two chosen stars in the consecutive state or not (horizontal)
						if (((secondChosenColumn == firstChosenColumn - 4)
								|| (secondChosenColumn == firstChosenColumn + 4))
								&& (secondChosenRow == firstChosenRow)) {
							// check if the line is empty or not
							if (matrix1[lineX][lineY].equals(" ")) {
								// check who's turn it is
								if (usersTurn % 2 == 0) {
									matrix1[lineX][lineY] = "-";
									player1NumberOfLines++;
									// check if this move leads to win or not
									if (lineX >= 2) {
										if (matrix1[lineX - 2][lineY].equals("-")
												&& matrix1[lineX - 1][lineY - 2].equals("|")
												&& matrix1[lineX - 1][lineY + 2].equals("|")) {
											printMatrix(matrix1);
											System.out
													.println(player1 + " win with " + player1NumberOfLines + " lines!");
											break;
										}
									}
									if (lineX <= rows - 2) {
										if (matrix1[lineX + 2][lineY].equals("-")
												&& matrix1[lineX + 1][lineY - 2].equals("|")
												&& matrix1[lineX + 1][lineY + 2].equals("|")) {
											printMatrix(matrix1);
											System.out
													.println(player1 + " win with " + player1NumberOfLines + " lines!");
											break;
										}
									}
								} else {
									matrix1[lineX][lineY] = "=";
									player2NumberOfLines++;
									// check if this move leads to win or not
									if (lineX >= 2) {
										if (matrix1[lineX - 2][lineY].equals("=")
												&& matrix1[lineX - 1][lineY - 2].equals("!")
												&& matrix1[lineX - 1][lineY + 2].equals("!")) {
											printMatrix(matrix1);
											System.out
													.println(player2 + " win with " + player2NumberOfLines + " lines!");
											break;
										}
									}
									if (lineX <= rows - 2) {
										if (matrix1[lineX + 2][lineY].equals("=")
												&& matrix1[lineX + 1][lineY - 2].equals("!")
												&& matrix1[lineX + 1][lineY + 2].equals("!")) {
											printMatrix(matrix1);
											System.out
													.println(player2 + " win with " + player2NumberOfLines + " lines!");
											break;
										}
									}
								}
								usersTurn++;
							}
						}
					}
				
				}

				break;
			case 2:
				System.out.println("Please enter 2 numbers for the size of your game: ");
				rows = scanner.nextInt() * 2 + 1;// one space between each two vertical stars
				columns = scanner.nextInt() * 4 + 1;// 3 space between each two horizontal stars
				System.out.println("Please enter the name of first player: ");
				player1 = scanner.next();
				System.out.println("Please enter the name of second player: ");
				player2 = scanner.next();
				String[][] matrix2 = new String[rows][columns];
				for (int i = 0; i < rows; i++) {// making our game background using stars and spaces
					for (int j = 0; j < columns; j++) {
						if (i % 2 == 0 && j % 4 == 0) {
							matrix2[i][j] = "*";
						} else
							matrix2[i][j] = " ";
					}
				}
				while (true) {
					printMatrix(matrix2);
					System.out.println("Enter index of your first chosen star: ");
					firstChosenRow = scanner.nextInt() * 2;
					firstChosenColumn = scanner.nextInt() * 4;
					System.out.println("Enter index of your second chosen star: ");
					secondChosenRow = scanner.nextInt() * 2;
					secondChosenColumn = scanner.nextInt() * 4;
					// specified index of line that we want show between our two chosen stars
					lineX = (firstChosenRow + secondChosenRow) / 2;
					lineY = (firstChosenColumn + secondChosenColumn) / 2;
					// check if our two chosen stars in the consecutive state or not (vertical)
					if (((secondChosenRow == firstChosenRow - 2) || (secondChosenRow == firstChosenRow + 2))
							&& (secondChosenColumn == firstChosenColumn)) {
						// check if the line is empty or not
						if (matrix2[lineX][lineY].equals(" ")) {
							// check who's turn it is
							if (usersTurn % 2 == 0) {
								matrix2[lineX][lineY] = "|";
								player1NumberOfLines++;
								// check if this move leads to win or not
								if (lineY >= 4) {
									if (matrix2[lineX][lineY - 4].equals("|")
											&& matrix2[lineX - 1][lineY - 2].equals("-")
											&& matrix2[lineX + 1][lineY - 2].equals("-")) {
										printMatrix(matrix2);
										System.out.println(player1 + " win with " + player1NumberOfLines + " lines!");
										break;
									}
								}
								if (lineY <= columns - 4) {
									if (matrix2[lineX][lineY + 4].equals("|")
											&& matrix2[lineX - 1][lineY + 2].equals("-")
											&& matrix2[lineX + 1][lineY + 2].equals("-")) {
										printMatrix(matrix2);
										System.out.println(player1 + " win with " + player1NumberOfLines + " lines!");
										break;
									}
								}
							} else {
								matrix2[lineX][lineY] = "!";
								player2NumberOfLines++;
								// check if this move leads to win or not
								if (lineY >= 4) {
									if (matrix2[lineX][lineY - 4].equals("!")
											&& matrix2[lineX - 1][lineY - 2].equals("=")
											&& matrix2[lineX + 1][lineY - 2].equals("=")) {
										printMatrix(matrix2);
										System.out.println(player2 + " win with " + player2NumberOfLines + " lines!");
										break;
									}
								}
								if (lineY <= columns - 4) {
									if (matrix2[lineX][lineY + 4].equals("!")
											&& matrix2[lineX - 1][lineY + 2].equals("=")
											&& matrix2[lineX + 1][lineY + 2].equals("=")) {
										printMatrix(matrix2);
										System.out.println(player2 + " win with " + player2NumberOfLines + " lines!");
										break;
									}
								}
							}
							usersTurn++;
						}
					}
					// check if our two chosen stars in the consecutive state or not (horizontal)
					if (((secondChosenColumn == firstChosenColumn - 4) || (secondChosenColumn == firstChosenColumn + 4))
							&& (secondChosenRow == firstChosenRow)) {
						// check if the line is empty or not
						if (matrix2[lineX][lineY].equals(" ")) {
							// check who's turn it is
							if (usersTurn % 2 == 0) {
								matrix2[lineX][lineY] = "-";
								player1NumberOfLines++;
								// check if this move leads to win or not
								if (lineX >= 2) {
									if (matrix2[lineX - 2][lineY].equals("-")
											&& matrix2[lineX - 1][lineY - 2].equals("|")
											&& matrix2[lineX - 1][lineY + 2].equals("|")) {
										printMatrix(matrix2);
										System.out.println(player1 + " win with " + player1NumberOfLines + " lines!");
										break;
									}
								}
								if (lineX <= rows - 2) {
									if (matrix2[lineX + 2][lineY].equals("-")
											&& matrix2[lineX + 1][lineY - 2].equals("|")
											&& matrix2[lineX + 1][lineY + 2].equals("|")) {
										printMatrix(matrix2);
										System.out.println(player1 + " win with " + player1NumberOfLines + " lines!");
										break;
									}
								}
							} else {
								matrix2[lineX][lineY] = "=";
								player2NumberOfLines++;
								// check if this move leads to win or not
								if (lineX >= 2) {
									if (matrix2[lineX - 2][lineY].equals("=")
											&& matrix2[lineX - 1][lineY - 2].equals("!")
											&& matrix2[lineX - 1][lineY + 2].equals("!")) {
										printMatrix(matrix2);
										System.out.println(player2 + " win with " + player2NumberOfLines + " lines!");
										break;
									}
								}
								if (lineX <= rows - 2) {
									if (matrix2[lineX + 2][lineY].equals("=")
											&& matrix2[lineX + 1][lineY - 2].equals("!")
											&& matrix2[lineX + 1][lineY + 2].equals("!")) {
										printMatrix(matrix2);
										System.out.println(player2 + " win with " + player2NumberOfLines + " lines!");
										break;
									}
								}
							}
							usersTurn++;
						}
					}
				}
				break;
			default:

				break;
			}
		}
	}

	static void print(String s) {
		try {
			PrintWriter writer = new PrintWriter("the.txt");
			writer.write(s);
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	static void printMatrix(String[][] matrix) {// print our game background
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}